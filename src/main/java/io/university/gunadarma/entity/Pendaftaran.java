package io.university.gunadarma.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pendaftaran")
public class Pendaftaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "email")
    private String email;

    @Column(name = "negara")
    private String negara;

    @Column(name = "status")
    private String status;

    @Column(name = "tanggal_daftar")
    private LocalDate tanggalDaftar;
} 