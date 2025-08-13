package io.university.gunadarma.repository;

import io.university.gunadarma.entity.Pendaftaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PendaftaranRepository extends JpaRepository<Pendaftaran, Long> {
    List<Pendaftaran> findTop10ByOrderByTanggalDaftarDesc();
} 