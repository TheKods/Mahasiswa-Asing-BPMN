# Strategi Pengujian Komprehensif

## Tipe Pengujian

### 1. Unit Testing

- Fokus pada pengujian komponen individual
- Gunakan JUnit 5
- Target coverage: > 80%

### 2. Integration Testing

- Uji interaksi antar modul
- Gunakan Spring Boot Test
- Simulasi alur bisnis lengkap

### 3. Mutation Testing

- Gunakan Pitest
- Evaluasi kualitas test suite
- Identifikasi kode yang lemah

## Perintah Pengujian

```bash
# Jalankan unit test
mvn test

# Laporan coverage
mvn jacoco:report

# Mutation testing
mvn test pitest:mutationCoverage
```

## Kriteria Keberhasilan

### Coverage

- Line Coverage: > 80%
- Branch Coverage: > 75%
- Mutation Score: > 70%

## Alat Pengujian

- JUnit 5
- Mockito
- AssertJ
- JaCoCo
- Pitest

## Praktik Terbaik

- Tulis test sebelum implementasi
- Gunakan nama test yang bermakna
- Uji skenario positif dan negatif
- Mock dependensi eksternal
- Pertahankan test yang ringkas

## Contoh Struktur Test

```
src/test/java/
└── io/university/gunadarma/
    ├── controller/
    │   └── RegistrasiControllerTest.java
    ├── service/
    │   └── RegistrasiServiceTest.java
    └── repository/
        └── MahasiswaRepositoryTest.java
```

## Continuous Integration

- Jalankan test di setiap pull request
- Blokir merge jika coverage turun
- Kirim laporan ke tim pengembang
