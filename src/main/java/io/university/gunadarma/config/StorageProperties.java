package io.university.gunadarma.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@ConfigurationProperties(prefix = "storage")
@Data
public class StorageProperties {

    // Properti yang sudah ada
    private String baseDir;
    private String uploadDir;
    private String tempDir;
    private long maxFileSize;

    // --- TAMBAHKAN DUA FIELD DI BAWAH INI ---
    private String archiveDir;
    private String logsDir;
    private String databaseDir; // Jika Anda juga mendefinisikan ini
}