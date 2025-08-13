# Panduan Kontribusi Teknis

## Prasyarat

- Java Development Kit (JDK) 17
- Maven 3.8+
- Docker
- Git

## Alur Kontribusi

1. Fork repositori
2. Buat cabang fitur
3. Commit perubahan
4. Jalankan pengujian
5. Kirim Pull Request

## Standar Kode

- Ikuti Google Java Style Guide
- Gunakan meaningful variable names
- Tambahkan JavaDoc
- Tulis unit test

## Pengujian

```bash
# Jalankan unit test
mvn test

# Jalankan dengan coverage
mvn test jacoco:report

# Lakukan static code analysis
mvn spotbugs:check
```

## Panduan Commit

- Gunakan conventional commits
- Deskripsikan perubahan secara jelas
- Referensikan issue terkait

## Review Kode

- Minimal 1 reviewer
- Pastikan CI/CD lolos
- Periksa kualitas kode
- Verifikasi cakupan test

## Proses Deployment

- Setiap merge ke main akan men-trigger CI/CD
- Deployment otomatis ke staging
- Perlu approval untuk production

## Troubleshooting

- Periksa log di GitHub Actions
- Gunakan GitHub Discussions untuk pertanyaan
- Buka issue untuk bug
