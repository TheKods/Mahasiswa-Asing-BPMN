package io.university.gunadarma.service;

import io.university.gunadarma.entity.Pendaftaran;
import io.university.gunadarma.repository.PendaftaranRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final PendaftaranRepository pendaftaranRepository;

    public DashboardService(PendaftaranRepository pendaftaranRepository) {
        this.pendaftaranRepository = pendaftaranRepository;
    }

    public List<Pendaftaran> getAllPendaftaran() {
        return pendaftaranRepository.findAll();
    }

    public Map<String, Long> getPendaftaranByStatus() {
        return getAllPendaftaran().stream()
            .collect(Collectors.groupingBy(Pendaftaran::getStatus, Collectors.counting()));
    }
} 