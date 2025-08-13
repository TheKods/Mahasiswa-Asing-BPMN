package io.university.gunadarma.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class JobWorkerMetrics {
    private final Counter totalJobsProcessed;
    private final Counter totalJobsFailed;

    public JobWorkerMetrics(MeterRegistry registry) {
        this.totalJobsProcessed = Counter.builder("pendaftaran.jobs.processed")
                .description("Total jobs yang diproses")
                .register(registry);
        
        this.totalJobsFailed = Counter.builder("pendaftaran.jobs.failed")
                .description("Total jobs yang gagal")
                .register(registry);
    }

    public void incrementProcessedJobs() {
        totalJobsProcessed.increment();
    }

    public void incrementFailedJobs() {
        totalJobsFailed.increment();
    }
}
