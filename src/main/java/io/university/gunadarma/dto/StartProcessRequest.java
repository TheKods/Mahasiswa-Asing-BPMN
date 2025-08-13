package io.university.gunadarma.dto;

import lombok.Data;
import java.util.Map;

@Data
public class StartProcessRequest {
    // Variabel yang dibutuhkan saat memulai proses
    private boolean isFastTrack = false;
    
    // Untuk menampung variabel lain jika diperlukan
    private Map<String, Object> otherVariables; 
}