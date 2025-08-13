# Dashboard Analytics

## Arsitektur Dashboard

### Komponen Utama

- Backend: Spring Boot REST API
- Frontend: Chart.js
- Data Source: Pendaftaran Repository
- Metrik: Statistik Pendaftaran

## Endpoint API

### `/api/dashboard/stats`

#### Deskripsi

Menghasilkan statistik komprehensif untuk dashboard.

#### Response

```json
{
  "total": 150,
  "byStatus": {
    "DIPROSES": 50,
    "DITERIMA": 75,
    "DITOLAK": 25
  },
  "perMonth": {
    "2024-01": 30,
    "2024-02": 45,
    "2024-03": 75
  },
  "countries": {
    "INDONESIA": 100,
    "MALAYSIA": 25,
    "SINGAPURA": 25
  }
}
```

## Visualisasi Data

### Grafik yang Tersedia

1. **Pie Chart**: Distribusi Status Pendaftaran
2. **Bar Chart**: Pendaftaran per Bulan
3. **Geo Chart**: Sebaran Negara Asal

### Teknologi Visualisasi

- Chart.js
- Responsive Design
- Tema Dark Mode

## Fitur Lanjutan

### Rencana Pengembangan

- [ ] Filter dinamis
- [ ] Export data
- [ ] Real-time updates
- [ ] Prediksi trend

## Keamanan

### Otorisasi

- Hanya admin yang dapat mengakses
- Pembatasan akses berdasarkan peran

### Audit

- Log akses dashboard
- Pencatatan aktivitas pengguna

## Konfigurasi

### Konfigurasi Spring

```yaml
app:
  dashboard:
    cache-duration: 3600 # Cache 1 jam
    max-historical-data: 12 # Maks 12 bulan terakhir
```

## Panduan Kontribusi

### Prinsip

- Minimalis
- Informatif
- Cepat
- Aman

### Alat Pengembangan

- Chrome DevTools
- Lighthouse
- Performance Profiler

## Referensi

- [Chart.js Dokumentasi](https://www.chartjs.org/docs/)
- [Spring Boot Metrics](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
