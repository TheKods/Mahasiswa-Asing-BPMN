# Monitoring & Observability

## Arsitektur Monitoring

### Komponen Utama

- Spring Actuator
- Micrometer
- Prometheus
- Grafana

## Endpoint Monitoring

### Akses Endpoint

- Health: `/actuator/health`
- Metrics: `/actuator/metrics`
- Prometheus: `/actuator/prometheus`

### Contoh Endpoint Health

```json
{
  "status": "UP",
  "components": {
    "db": { "status": "UP" },
    "camunda": { "status": "UP" },
    "diskSpace": { "status": "UP" }
  }
}
```

## Metrik yang Tersedia

### Kategori Metrik

- JVM Metrics
- System Metrics
- HTTP Request Metrics
- Database Connection Metrics
- Camunda Workflow Metrics

### Contoh Metrik Prometheus

```
# HELP http_server_requests_seconds_count
http_server_requests_seconds_count{method="GET"} 1234
```

## Konfigurasi Prometheus

### `prometheus.yml`

```yaml
scrape_configs:
  - job_name: "mahasiswa-asing"
    metrics_path: "/actuator/prometheus"
    static_configs:
      - targets: ["localhost:8080"]
```

## Grafana Dashboard

### Panel Utama

- Request Rate
- Error Rate
- Response Time
- JVM Memory Usage
- CPU Utilization
- Workflow Performance

## Alerting

### Konfigurasi Alert

- Threshold CPU: > 80%
- Threshold Memory: > 90%
- Error Rate: > 5%
- Slow Requests: > 2s

## Best Practices

### Monitoring

- Pantau metrik kritis
- Atur ambang batas
- Konfigurasi notifikasi
- Rekam log untuk investigasi

### Optimasi

- Analisis metrik berkala
- Identifikasi bottleneck
- Lakukan tuning berkelanjutan

## Troubleshooting

### Panduan Umum

1. Periksa metrik
2. Analisis log
3. Identifikasi akar masalah
4. Lakukan mitigasi

## Tools Tambahan

- ELK Stack (Logging)
- Jaeger (Distributed Tracing)
- New Relic (APM)

## Keamanan

- Batasi akses endpoint
- Gunakan autentikasi
- Enkripsi komunikasi
