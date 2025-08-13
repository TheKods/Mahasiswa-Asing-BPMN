# Deployment Cloud

## AWS (Amazon Web Services)

### Persiapan

1. Buat akun AWS
2. Install AWS CLI
3. Konfigurasikan kredensial

### Deployment EC2

```bash
# Buat instance EC2
aws ec2 run-instances \
    --image-id ami-0c55b159cbfafe1f0 \
    --count 1 \
    --instance-type t2.micro \
    --key-name MyKeyPair

# Deploy aplikasi
scp target/pendaftaran-mahasiswa-asing-1.0.0-SNAPSHOT.jar \
    ec2-user@your-instance-ip:/home/ec2-user/app/
```

### Konfigurasi Elastic Beanstalk

```yaml
# Dockerfile
FROM openjdk:17-jdk-slim
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# Elastic Beanstalk config
version: '3'
services:
  web:
    build: .
    ports:
      - "8080:8080"
```

## Azure

### App Service Deployment

```bash
# Login Azure
az login

# Buat App Service
az webapp create \
    --resource-group MyResourceGroup \
    --plan MyAppServicePlan \
    --name mahasiswa-asing-app \
    --runtime "JAVA|17-java17"

# Deploy JAR
az webapp deploy \
    --resource-group MyResourceGroup \
    --name mahasiswa-asing-app \
    --src-path target/pendaftaran-mahasiswa-asing-1.0.0-SNAPSHOT.jar
```

## Google Cloud Platform

### GKE Deployment

```bash
# Buat cluster Kubernetes
gcloud container clusters create mahasiswa-asing-cluster \
    --num-nodes 3 \
    --zone asia-southeast2-a

# Deploy aplikasi
kubectl apply -f k8s/deployment.yaml
```

## Environment Configuration

### Variabel Lingkungan

- `SPRING_PROFILES_ACTIVE`: Aktifkan profil
- `DATABASE_URL`: Koneksi basis data
- `JWT_SECRET`: Kunci rahasia
- `CAMUNDA_ZEEBE_ADDRESS`: Alamat Camunda

### Keamanan

- Gunakan Secret Manager
- Enkripsi variabel sensitif
- Rotasi kredensial berkala

## Monitoring Cloud

### AWS CloudWatch

- Aktifkan log group
- Buat alarm metrik
- Konfigurasi dashboard

### Azure Monitor

- Aktifkan Application Insights
- Konfigurasi alert

### GCP Monitoring

- Gunakan Cloud Monitoring
- Buat dashboard kustom

## Best Practices

- Gunakan VPC
- Implementasi security group
- Aktifkan logging komprehensif
- Gunakan load balancer
