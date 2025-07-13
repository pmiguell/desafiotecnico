package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record PatientRequestDTO(
        @NotBlank(message = "name must not be blank")
        String name,

        @Positive(message = "age must be a positive number")
        int age,

        List<@NotBlank(message = "history must not be blank") String> history,

        @NotBlank(message = "cpf must not be blank")
        String cpf
) {
}