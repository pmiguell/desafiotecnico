package com.example.demo.mapper;

import com.example.demo.dto.PatientRequestDTO;
import com.example.demo.dto.PatientResponseDTO;
import com.example.demo.entity.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PatientMapper {
    public Patient toEntity(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();

        patient.setName(patientRequestDTO.name());
        patient.setAge(patientRequestDTO.age());
        patient.setCpf(patientRequestDTO.cpf());
        patient.setHistory(patientRequestDTO.history());

        return patient;
    }

    public PatientResponseDTO toDto(Patient patient) {
        return new PatientResponseDTO(
                patient.getId(),
                patient.getName(),
                patient.getAge(),
                patient.getCpf(),
                patient.getStatus(),
                patient.getCreatedAt(),
                new ArrayList<>(patient.getHistory())
        );
    }
}
