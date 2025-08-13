package io.university.gunadarma.entity;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private String email;
    private String password; // In real world, this should be hashed
    private String fullName;
    private String country;
    private List<Document> documents = new ArrayList<>();
    
    public User() {}
}
