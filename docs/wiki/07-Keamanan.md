# Praktik Keamanan Sistem Pendaftaran Mahasiswa Asing

## Kerangka Keamanan

### 1. Autentikasi & Otorisasi

- Menggunakan Spring Security
- Stateless JWT Authentication
- Role-based Access Control (RBAC)

### 2. Perlindungan Input

- Validasi input sisi server
- Sanitasi data menggunakan OWASP Encoder
- Pencegahan SQL Injection
- Pembatasan panjang input

### 3. Keamanan Transaksi

- HTTPS/TLS untuk semua komunikasi
- CSRF Protection
- XSS Protection
- Strict Content Security Policy

### 4. Manajemen Kredensial

- Enkripsi password dengan bcrypt
- Penyimpanan token secara aman
- Rotasi kredensial berkala

## Konfigurasi Keamanan

### CORS Configuration

```java
@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowedOrigins(Arrays.asList(
        "https://mahasiswa-asing.gunadarma.ac.id"
    ));
    // Konfigurasi metode, header, dll.
}
```

### Content Security Policy

```
default-src 'self';
script-src 'self' 'unsafe-inline';
style-src 'self' 'unsafe-inline';
```

## Praktik Keamanan Lanjutan

### Input Validation

```java
@NotBlank(message = "Email tidak boleh kosong")
@Email(message = "Format email tidak valid")
private String email;
```

### Pencegahan Serangan

- Rate limiting pada endpoint
- Pembatasan percobaan login
- Deteksi aktivitas mencurigakan

## Monitoring Keamanan

### Log Keamanan

- Catat semua percobaan autentikasi
- Rekam aktivitas pengguna
- Pantau akses yang tidak sah

### Alat Keamanan

- OWASP Dependency Check
- SonarQube
- Dependency scanning berkala

## Incident Response

### Prosedur

1. Deteksi insiden
2. Isolasi sistem
3. Investigasi
4. Mitigasi
5. Pelaporan

### Kontak Keamanan

- Email: security@gunadarma.ac.id
- Hotline: +62 XXX-XXX-XXXX

## Rekomendasi Lanjutan

- Implementasi Multi-Factor Authentication
- Enkripsi data sensitif
- Audit keamanan berkala
