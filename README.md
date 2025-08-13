# Pendaftaran Mahasiswa Asing Universitas Gunadarma

<div align="center">
    <img src="src/LogoGunadarma.jpg" alt="Universitas Gunadarma Logo" width="200"/>
</div>

<div align="center">
    <h1>International Student Registration System</h1>
    
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Camunda](https://img.shields.io/badge/Camunda-F2F4F9?style=for-the-badge&logo=camunda)](https://camunda.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven)](https://maven.apache.org/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github)](https://github.com)

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen?style=flat-square)](https://github.com/your-username/pendaftaran-mahasiswa-asing)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](LICENSE)
[![Version](https://img.shields.io/badge/Version-1.0.0-blue?style=flat-square)](https://github.com/your-username/pendaftaran-mahasiswa-asing/releases)

</div>

## 🌐 Project Overview

Pendaftaran Mahasiswa Asing is a comprehensive, cutting-edge web application designed to streamline the international student registration process at Universitas Gunadarma.

### 🚀 Key Features

- 🔐 Secure Authentication & Authorization
- 🤖 Automated Workflow Management
- 📋 Comprehensive Student Registration Process
- 📊 Advanced Logging and Monitoring
- 🌍 Internationalization Support

## 🛠 Technology Stack Deep Dive

### 1. Language & Core Framework

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.3-6DB33F?style=for-the-badge&logo=spring-boot)

- **Language**: Java 17 LTS
- **Framework**: Spring Boot 3.5.3
- **Key Libraries**:
  - Spring Web
  - Spring Security
  - Spring Mail
  - Lombok

### 2. Process Orchestration

![Camunda](https://img.shields.io/badge/Camunda_Zeebe-8.7.0-blue?style=for-the-badge&logo=camunda)

- Workflow Management
- Process Automation
- Event-Driven Architecture

### 3. Security

![Spring Security](https://img.shields.io/badge/Spring_Security-Latest-6DB33F?style=for-the-badge&logo=spring)

- Authentication
- Authorization
- Secure Configuration Management

### 4. Logging & Monitoring

![SLF4J](https://img.shields.io/badge/SLF4J-Logback-blue?style=for-the-badge)

- Comprehensive Logging
- Log File Management
- Performance Monitoring

### 5. Build & Dependency Management

![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge&logo=apache-maven)

- Dependency Resolution
- Build Lifecycle Management
- Plugin Ecosystem

## 🔍 Architectural Insights

### Workflow Architecture

```
[User Interface] → [Authentication] → [Registration Workflow]
    ↓                   ↓                   ↓
[Input Validation] → [Security Checks] → [Camunda Process Engine]
    ↓                   ↓                   ↓
[Data Persistence] → [Notification] → [Process Completion]
```

### Key Design Patterns

- Dependency Injection
- Service Layer Abstraction
- Repository Pattern
- Workflow State Management

## 📦 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── io/university/gunadarma/
│   │       ├── config/           # Configuration classes
│   │       ├── controller/       # REST API endpoints
│   │       ├── service/          # Business logic
│   │       ├── entity/           # Database models
│   │       └── util/             # Utility classes
│   └── resources/
│       ├── application.yml       # Application configuration
│       └── bpmn/                 # Workflow definitions
└── test/                         # Unit and integration tests
```

## 🚀 Quick Start

### Prerequisites

- Java Development Kit (JDK) 17
- Maven 3.8+
- Git

### Installation

```bash
# Clone the repository
git clone https://github.com/your-username/pendaftaran-mahasiswa-asing.git

# Navigate to project directory
cd pendaftaran-mahasiswa-asing

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

Distributed under the MIT License. See `LICENSE` for more information.

## 📞 Contact

**Universitas Gunadarma**

- Project Link: [GitHub Repository](https://github.com/your-username/pendaftaran-mahasiswa-asing)

---

<div align="center">
    <sub>Built with ❤️ by Universitas Gunadarma Team</sub>
</div>

## 🧪 Testing and Code Coverage

### Testing Strategy

Our project employs a comprehensive testing approach:

#### Types of Tests

- **Unit Tests**: Validate individual components and methods
- **Integration Tests**: Ensure different modules work together
- **Security Tests**: Check for potential vulnerabilities

#### Running Tests

```bash
# Run all tests
mvn test

# Run tests with coverage report
mvn test jacoco:report

# Skip tests during build
mvn package -DskipTests
```

### Code Coverage

We use JaCoCo for code coverage analysis:

[![Coverage](https://codecov.io/gh/your-username/pendaftaran-mahasiswa-asing/branch/main/graph/badge.svg)](https://codecov.io/gh/your-username/pendaftaran-mahasiswa-asing)

#### Coverage Goals

- Overall Coverage: 70%+
- Critical Paths: 90%+

#### Viewing Coverage Report

1. Local Report: `target/site/jacoco/index.html`
2. CI/CD Coverage: Available in GitHub Actions artifacts

### Best Practices

- Write tests before implementing features
- Use meaningful test names
- Test both positive and negative scenarios
- Mock external dependencies
- Aim for clear, concise test cases

### Continuous Integration

Our CI pipeline automatically:

- Runs all tests
- Generates coverage report
- Uploads coverage to CodeCov
- Performs security scans

---
