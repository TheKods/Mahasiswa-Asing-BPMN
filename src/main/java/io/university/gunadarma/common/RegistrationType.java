package io.university.gunadarma.common;

/**
 * Enum untuk tipe pendaftaran mahasiswa asing.
 * Mendefinisikan berbagai tipe pendaftaran yang mungkin.
 */
public enum RegistrationType {
    // Tipe pendaftaran berdasarkan status
    LOCAL_REGULAR("REGULER_LOKAL"),
    LOCAL_SCHOLARSHIP("BEASISWA_LOKAL"),
    INTERNATIONAL_REGULAR("REGULER_INTERNASIONAL"),
    INTERNATIONAL_SCHOLARSHIP("BEASISWA_INTERNASIONAL"),
    
    // Tipe khusus
    EXCHANGE_STUDENT("PERTUKARAN_PELAJAR"),
    SPECIAL_PROGRAM("PROGRAM_KHUSUS");

    private final String code;

    RegistrationType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    /**
     * Konversi string ke enum
     * @param code Kode tipe pendaftaran
     * @return RegistrationType yang sesuai
     */
    public static RegistrationType fromCode(String code) {
        for (RegistrationType type : values()) {
            if (type.code.equalsIgnoreCase(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipe pendaftaran tidak valid: " + code);
    }

    /**
     * Cek apakah tipe pendaftaran adalah beasiswa
     * @return true jika beasiswa, false jika tidak
     */
    public boolean isScholarship() {
        return this == LOCAL_SCHOLARSHIP || this == INTERNATIONAL_SCHOLARSHIP;
    }

    /**
     * Cek apakah tipe pendaftaran internasional
     * @return true jika internasional, false jika lokal
     */
    public boolean isInternational() {
        return this == INTERNATIONAL_REGULAR || this == INTERNATIONAL_SCHOLARSHIP;
    }
} 