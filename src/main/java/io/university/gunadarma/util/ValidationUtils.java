package io.university.gunadarma.util;

import java.time.LocalDate;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Utilitas validasi untuk sistem pendaftaran mahasiswa asing.
 * Menyediakan metode validasi umum yang dapat digunakan di seluruh aplikasi.
 */
public class ValidationUtils {
    // Pola regex untuk validasi
    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    public static final String PHONE_REGEX = "^\\+?[1-9]\\d{1,14}$";
    public static final String PASSPORT_REGEX = "^[A-Z0-9]{6,12}$";
    public static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

    /**
     * Validasi format email
     * @param email Email yang akan divalidasi
     * @return true jika email valid, false jika tidak
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return Pattern.matches(EMAIL_REGEX, email);
    }

    /**
     * Validasi format nomor telepon
     * @param phoneNumber Nomor telepon yang akan divalidasi
     * @return true jika nomor telepon valid, false jika tidak
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return false;
        }
        return Pattern.matches(PHONE_REGEX, phoneNumber);
    }

    /**
     * Validasi format nomor paspor
     * @param passportNumber Nomor paspor yang akan divalidasi
     * @return true jika nomor paspor valid, false jika tidak
     */
    public static boolean isValidPassportNumber(String passportNumber) {
        if (passportNumber == null || passportNumber.trim().isEmpty()) {
            return false;
        }
        return Pattern.matches(PASSPORT_REGEX, passportNumber);
    }

    /**
     * Validasi format tanggal
     * @param dateString Tanggal dalam format YYYY-MM-DD
     * @return true jika tanggal valid, false jika tidak
     */
    public static boolean isValidDateFormat(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return false;
        }
        
        // Validasi format regex
        if (!Pattern.matches(DATE_REGEX, dateString)) {
            return false;
        }
        
        try {
            LocalDate date = LocalDate.parse(dateString);
            // Pastikan tanggal tidak di masa depan
            return !date.isAfter(LocalDate.now());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validasi keberadaan field wajib
     * @param variables Map variabel yang akan dicek
     * @param requiredFields Daftar field yang wajib ada
     * @return true jika semua field wajib ada, false jika tidak
     */
    public static boolean validateRequiredFields(Map<String, Object> variables, String... requiredFields) {
        for (String field : requiredFields) {
            if (!variables.containsKey(field) || variables.get(field) == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Membersihkan dan normalisasi input
     * @param input Input yang akan dibersihkan
     * @return Input yang sudah dibersihkan
     */
    public static String sanitizeInput(String input) {
        if (input == null) {
            return null;
        }
        return input.trim().replaceAll("\\s+", " ");
    }
} 