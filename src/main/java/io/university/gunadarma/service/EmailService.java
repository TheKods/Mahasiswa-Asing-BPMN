package io.university.gunadarma.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendTemplatedEmail(String to, String subject, String templateName, Map<String, Object> templateModel) {
        try {
            Context context = new Context();
            context.setVariables(templateModel);
            String htmlBody = templateEngine.process(templateName, context);

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(
                message, 
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, 
                StandardCharsets.UTF_8.name()
            );

            helper.setTo(to);
            helper.setFrom("noreply@gunadarma.ac.id");
            helper.setSubject(subject);
            helper.setText(htmlBody, true);

            emailSender.send(message);
        } catch (MessagingException e) {
            // Log error
            throw new RuntimeException("Gagal mengirim email", e);
        }
    }

    // Template spesifik untuk berbagai skenario
    public void sendRegistrationConfirmation(String to, String nama, String nomorPendaftaran) {
        Map<String, Object> model = Map.of(
            "nama", nama,
            "nomorPendaftaran", nomorPendaftaran,
            "universitasNama", "Universitas Gunadarma"
        );

        sendTemplatedEmail(
            to, 
            "Konfirmasi Pendaftaran Mahasiswa Asing", 
            "email/registrasi-konfirmasi", 
            model
        );
    }

    public void sendRegistrationRejection(String to, String nama, String alasan) {
        Map<String, Object> model = Map.of(
            "nama", nama,
            "alasan", alasan,
            "universitasNama", "Universitas Gunadarma"
        );

        sendTemplatedEmail(
            to, 
            "Status Pendaftaran Mahasiswa Asing", 
            "email/registrasi-ditolak", 
            model
        );
    }

    public void sendSimpleEmail(String to, String subject, String textContent) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(
                message,
                MimeMessageHelper.MULTIPART_MODE_NO,
                StandardCharsets.UTF_8.name()
            );
            helper.setTo(to);
            helper.setFrom("noreply@gunadarma.ac.id");
            helper.setSubject(subject);
            helper.setText(textContent, false);
            emailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Gagal mengirim email sederhana", e);
        }
    }
} 