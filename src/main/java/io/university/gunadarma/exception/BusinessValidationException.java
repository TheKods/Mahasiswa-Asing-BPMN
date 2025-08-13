package io.university.gunadarma.exception;

import io.university.gunadarma.common.BusinessErrorCode;

/**
 * Exception khusus untuk kesalahan validasi bisnis dalam sistem pendaftaran.
 * Memungkinkan pengiriman kode kesalahan spesifik untuk penanganan di tingkat proses.
 */
public class BusinessValidationException extends RuntimeException {
    private final BusinessErrorCode errorCode;
    private final transient Object[] details;

    /**
     * Konstruktor dengan kode kesalahan dan pesan
     * @param errorCode Kode kesalahan bisnis
     * @param message Pesan kesalahan
     */
    public BusinessValidationException(BusinessErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.details = null;
    }

    /**
     * Konstruktor dengan kode kesalahan, pesan, dan detail tambahan
     * @param errorCode Kode kesalahan bisnis
     * @param message Pesan kesalahan
     * @param details Detail tambahan terkait kesalahan
     */
    public BusinessValidationException(BusinessErrorCode errorCode, String message, Object... details) {
        super(message);
        this.errorCode = errorCode;
        this.details = details;
    }

    /**
     * Dapatkan kode kesalahan
     * @return Kode kesalahan bisnis
     */
    public BusinessErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * Dapatkan detail tambahan kesalahan
     * @return Array objek detail
     */
    public Object[] getDetails() {
        return details != null ? details.clone() : new Object[0];
    }

    @Override
    public String toString() {
        return String.format("BusinessValidationException: [%s] %s", 
                             errorCode.getCode(), 
                             getMessage());
    }
} 