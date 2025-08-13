package io.university.gunadarma;

import io.camunda.zeebe.client.ZeebeClient;
// import io.camunda.zeebe.spring.client.annotation.Deployment; // removed duplicate deployment
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
// @Deployment(resources = "classpath*:/bpmn/pendaftaran-mahasiswa-asing-gunadarma.bpmn") // handled by ZeebeConfig
public class PendaftaranMahasiswaAsingApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(PendaftaranMahasiswaAsingApplication.class);

    @Autowired
    private ZeebeClient zeebeClient;

    @Value("${app.autostart.enabled:false}")
    private boolean autostartEnabled;

    public static void main(String[] args) {
        SpringApplication.run(PendaftaranMahasiswaAsingApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        if (!autostartEnabled) {
            LOG.info("Autostart proses dinonaktifkan. Lewati pembuatan instance proses awal.");
            return;
        }
        var bpmnProcessId = "Pendaftaran_Mahasiswa_Asing";
        var event = zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(bpmnProcessId)
                .latestVersion()
                .variables(Map.of(
                    "registrationType", "INTERNATIONAL_STUDENT",
                    "initialStatus", "STARTED"
                ))
                .send()
                .join();
        
        LOG.info("Memulai instance proses pendaftaran mahasiswa asing: {}", event.getProcessInstanceKey());
        System.out.println("Aplikasi Pendaftaran Mahasiswa Asing telah berjalan.");
        System.out.println("Silakan akses aplikasi melalui browser Anda.");
        System.out.println("URL: http://localhost:8080");
        System.out.println("Selamat datang di aplikasi Pendaftaran Mahasiswa Asing Universitas Gunadarma!");
    }
}