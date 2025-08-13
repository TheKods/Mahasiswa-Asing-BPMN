package io.university.gunadarma.entity;

import lombok.Data;

@Data
public class Registration {
    private String studentName;
    private String country;
    private String status;
    private boolean isFastTrack;
}