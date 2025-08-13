# Panduan Deployment

## Metode Deployment

### 1. Deployment Lokal

```bash
# Clone repositori
git clone https://github.com/TheKods/Mahasiswa-Asing-BPMN.git

# Masuk direktori
cd Mahasiswa-Asing-BPMN

# Build proyek
mvn clean package

# Jalankan aplikasi
java -jar target/pendaftaran-mahasiswa-asing-1.0.0-SNAPSHOT.jar
```

### 2. Deployment Docker

```dockerfile
# Dockerfile
FROM openjdk:17-jdk-slim
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

```bash
# Build Docker image
docker build -t mahasiswa-asing-app .

# Jalankan container
docker run -p 8080:8080 mahasiswa-asing-app
```

### 3. Deployment Kubernetes

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: mahasiswa-asing-deployment
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
        - name: mahasiswa-asing
          image: mahasiswa-asing-app:latest
          ports:
            - containerPort: 8080
```

## Konfigurasi Environment

- Gunakan environment variables
- Simpan kredensial di Secret
- Konfigurasikan profile Spring

## Monitoring Deployment

- Gunakan Prometheus
- Integrasikan dengan Grafana
- Pantau metrik performa

## Rollback dan Scaling

- Gunakan strategi rolling update
- Konfigurasikan auto-scaling
- Siapkan mekanisme rollback cepat
