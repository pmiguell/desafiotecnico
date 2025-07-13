package com.example.demo.dto;

import com.example.demo.entity.Patient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record PatientResponseDTO(
        Long id,
        String name,
        int age,
        String cpf,
        Patient.Status status,
        LocalDateTime createdAt,
        List<String> history
) {
}
