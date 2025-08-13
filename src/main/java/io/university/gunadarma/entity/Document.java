package io.university.gunadarma.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Document {
    private String fileName;
    private String contentType;
    private byte[] data;
    private User user; // Simple reference to User object

    public Document(String fileName, String contentType, byte[] data, User user) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.data = data;
        this.user = user;
    }
}