# Dokumentasi API Pendaftaran Mahasiswa Asing

## Akses Dokumentasi

### Swagger UI

- URL Lokal: `http://localhost:8080/swagger-ui.html`
- URL Produksi: `https://mahasiswa-asing.gunadarma.ac.id/swagger-ui.html`

### OpenAPI Specification

- JSON: `/v3/api-docs`
- YAML: `/v3/api-docs.yaml`

## Autentikasi API

### OAuth2

- Gunakan bearer token
- Dapatkan token melalui endpoint autentikasi

### Contoh Header

```http
Authorization: Bearer {access_token}
```

## Endpoint Utama

### Registrasi Mahasiswa

- `POST /api/registrasi`
- Kirim data pendaftaran
- Membutuhkan autentikasi

### Status Pendaftaran

- `GET /api/registrasi/{id}`
- Dapatkan status pendaftaran
- Membutuhkan autentikasi

## Kode Respons

- `200 OK`: Berhasil
- `400 Bad Request`: Kesalahan input
- `401 Unauthorized`: Autentikasi gagal
- `404 Not Found`: Sumber tidak ditemukan
- `500 Internal Server Error`: Kesalahan server

## Validasi

- Semua input akan divalidasi
- Periksa pesan kesalahan untuk detail
