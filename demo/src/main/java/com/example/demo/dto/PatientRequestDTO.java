package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record PatientRequestDTO(
        @NotBlank
        String name,

        @Positive
        int age,

        List<String> history,

        @NotBlank
        String cpf
) {
}