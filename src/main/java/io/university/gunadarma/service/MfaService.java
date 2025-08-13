package io.university.gunadarma.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MfaService {
	private static final long CODE_TTL_SECONDS = 300; // 5 menit
	private static final SecureRandom RANDOM = new SecureRandom();

	private final EmailService emailService;

	private static class OtpEntry {
		final String code;
		final Instant expiresAt;
		OtpEntry(String code, Instant expiresAt) { this.code = code; this.expiresAt = expiresAt; }
	}

	private final Map<String, OtpEntry> emailToCode = new ConcurrentHashMap<>();

	public MfaService(EmailService emailService) {
		this.emailService = emailService;
	}

	public String generateCode() {
		int code = 100000 + RANDOM.nextInt(900000);
		return Integer.toString(code);
	}

	public void sendOtp(String email, String displayName) {
		String code = generateCode();
		emailToCode.put(email.toLowerCase(), new OtpEntry(code, Instant.now().plusSeconds(CODE_TTL_SECONDS)));
		String subject = "Kode Verifikasi MFA";
		String content = "Halo " + (displayName == null ? "" : displayName) + ",\n\n" +
			"Kode verifikasi Anda: " + code + "\n" +
			"Berlaku selama 5 menit.";
		emailService.sendSimpleEmail(email, subject, content);
	}

	public boolean verify(String email, String inputCode) {
		if (email == null || inputCode == null) return false;
		OtpEntry entry = emailToCode.get(email.toLowerCase());
		if (entry == null) return false;
		if (Instant.now().isAfter(entry.expiresAt)) {
			emailToCode.remove(email.toLowerCase());
			return false;
		}
		boolean ok = Objects.equals(entry.code, inputCode.trim());
		if (ok) {
			emailToCode.remove(email.toLowerCase());
		}
		return ok;
	}
} 