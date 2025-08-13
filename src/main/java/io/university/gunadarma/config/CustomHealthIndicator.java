package io.university.gunadarma.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Contoh pemeriksaan kondisi sistem
        boolean isHealthy = checkSystemHealth();
        
        if (isHealthy) {
            return Health.up()
                .withDetail("system_status", "All systems operational")
                .withDetail("database_connection", "Healthy")
                .withDetail("camunda_workflow", "Running")
                .build();
        } else {
            return Health.down()
                .withDetail("system_status", "Degraded performance")
                .withDetail("error", "One or more critical services are not responding")
                .build();
        }
    }

    private boolean checkSystemHealth() {
        // Implementasi pengecekan kesehatan sistem
        try {
            // Contoh: Periksa koneksi database
            // Periksa koneksi Camunda
            // Periksa resource system
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Metode tambahan untuk mendapatkan detail kesehatan sistem
    public Map<String, Object> getSystemHealthDetails() {
        Map<String, Object> healthDetails = new HashMap<>();
        healthDetails.put("cpu_usage", getCurrentCpuUsage());
        healthDetails.put("memory_usage", getCurrentMemoryUsage());
        healthDetails.put("disk_space", getDiskSpaceAvailable());
        return healthDetails;
    }

    private double getCurrentCpuUsage() {
        // Implementasi pengukuran penggunaan CPU
        return Runtime.getRuntime().availableProcessors();
    }

    private long getCurrentMemoryUsage() {
        // Implementasi pengukuran penggunaan memori
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
    }

    private long getDiskSpaceAvailable() {
        // Implementasi pengukuran ruang disk
        return new java.io.File("/").getFreeSpace() / (1024 * 1024 * 1024);
    }
} 