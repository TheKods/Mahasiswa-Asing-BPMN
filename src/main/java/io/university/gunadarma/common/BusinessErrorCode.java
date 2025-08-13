package io.university.gunadarma.common;

/**
 * Enum untuk kode kesalahan bisnis dalam sistem pendaftaran mahasiswa asing.
 * Mendefinisikan berbagai jenis kesalahan yang mungkin terjadi selama proses pendaftaran.
 */
public enum BusinessErrorCode {
    // Kesalahan Validasi
    VALIDATION_ERROR("VALIDATION_ERROR", "Data tidak memenuhi persyaratan validasi"),
    INCOMPLETE_DATA("INCOMPLETE_DATA", "Data pendaftaran tidak lengkap"),
    
    // Kesalahan Akun
    ACCOUNT_BLOCKED("ACCOUNT_BLOCKED", "Akun diblokir"),
    DUPLICATE_ACCOUNT("DUPLICATE_ACCOUNT", "Akun sudah terdaftar"),
    
    // Kesalahan Dokumen
    INVALID_DOCUMENT("INVALID_DOCUMENT", "Dokumen tidak valid"),
    EXPIRED_DOCUMENT("EXPIRED_DOCUMENT", "Dokumen sudah kadaluarsa"),
    
    // Kesalahan Registrasi
    REGISTRATION_CLOSED("REGISTRATION_CLOSED", "Pendaftaran sudah ditutup"),
    INELIGIBLE_REGISTRATION("INELIGIBLE_REGISTRATION", "Tidak memenuhi syarat pendaftaran"),
    
    // Kesalahan Umum
    SYSTEM_ERROR("SYSTEM_ERROR", "Kesalahan sistem yang tidak terduga");

    private final String code;
    private final String description;

    BusinessErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Konversi kode kesalahan ke enum
     * @param code Kode kesalahan
     * @return BusinessErrorCode yang sesuai
     */
    public static BusinessErrorCode fromCode(String code) {
        for (BusinessErrorCode errorCode : values()) {
            if (errorCode.code.equalsIgnoreCase(code)) {
                return errorCode;
            }
        }
        return SYSTEM_ERROR;
    }
} 