package io.university.gunadarma.common;

/**
 * Enum untuk status pendaftaran mahasiswa asing.
 * Mendefinisikan status yang mungkin dalam proses pendaftaran.
 */
public enum RegistrationStatus {
    // Status akun
    PENDING("MENUNGGU"),
    ACTIVE("AKTIF"),
    BLOCKED("DIBLOKIR"),
    INCOMPLETE("BELUM_LENGKAP"),
    COMPLETE("SELESAI"),
    
    // Status verifikasi
    VERIFICATION_PENDING("VERIFIKASI_MENUNGGU"),
    VERIFICATION_APPROVED("VERIFIKASI_DISETUJUI"),
    VERIFICATION_REJECTED("VERIFIKASI_DITOLAK");

    private final String code;

    RegistrationStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    /**
     * Konversi string ke enum
     * @param code Kode status
     * @return RegistrationStatus yang sesuai
     */
    public static RegistrationStatus fromCode(String code) {
        for (RegistrationStatus status : values()) {
            if (status.code.equalsIgnoreCase(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status tidak valid: " + code);
    }
} 