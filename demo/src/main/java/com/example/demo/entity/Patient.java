package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Patient {
    private Long id;
    private String name;
    private int age;
    private String cpf;
    private Status status = Status.ACTIVE;
    private LocalDateTime createdAt = LocalDateTime.now();
    private List<String> history = new ArrayList<>();

    public enum Status {
        ACTIVE,
        INACTIVE
    }
}
