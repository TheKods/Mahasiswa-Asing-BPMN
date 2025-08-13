# DevOps Workflow

## Arsitektur Kontainerisasi

### Komponen

- Docker
- Docker Compose
- Kubernetes
- Prometheus
- Grafana

## Konfigurasi Docker

### Dockerfile Multi-Stage

- Optimasi ukuran image
- Pemisahan build dan runtime
- Pengaturan environment

### Docker Compose

- Definisi layanan terintegrasi
- Konfigurasi environment
- Manajemen jaringan dan volume

## Deployment Kubernetes

### Manifest Deployment

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: mahasiswa-asing
spec:
  replicas: 3
  selector:
    matchLabels:
      app: mahasiswa-asing
  template:
    metadata:
      labels:
        app: mahasiswa-asing
    spec:
      containers:
        - name: app
          image: mahasiswa-asing-app:latest
          ports:
            - containerPort: 8080
```

### Helm Chart

- Templating deployment
- Konfigurasi dinamis
- Manajemen versi

## Continuous Integration/Deployment

### GitHub Actions

- Build otomatis
- Pengujian
- Deployment

### Alur Kerja

1. Commit code
2. Pemindaian keamanan
3. Build image
4. Pengujian
5. Deploy ke staging
6. Persetujuan manual
7. Deploy ke production

## Scaling & High Availability

### Horizontal Pod Autoscaler

- Skala otomatis berdasarkan beban
- Batasan minimum/maksimum instance

### Strategi Deployment

- Rolling Update
- Blue-Green Deployment
- Canary Releases

## Monitoring & Logging

### Alat

- ELK Stack
- Prometheus
- Grafana
- Jaeger Tracing

## Best Practices

### Keamanan

- Gunakan image resmi
- Minimalisasi hak akses
- Enkripsi rahasia
- Pembaruan berkala

### Optimasi

- Gunakan multi-stage build
- Hapus dependensi tidak perlu
- Gunakan .dockerignore
- Cache layer docker

## Troubleshooting

### Panduan Umum

1. Periksa log container
2. Validasi konfigurasi
3. Periksa resource
4. Gunakan debugging tools

## Referensi

- Docker Documentation
- Kubernetes Best Practices
- Cloud Native Computing Foundation
