package com.example.demo.service;

import com.example.demo.dto.PatientRequestDTO;
import com.example.demo.dto.PatientResponseDTO;
import com.example.demo.entity.Patient;
import com.example.demo.exception.CpfNotFoundException;
import com.example.demo.mapper.PatientMapper;
import com.example.demo.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepository.existsByCpf(patientRequestDTO.cpf())) {
            throw new RuntimeException("CPF already exists");
        }

        Patient patient = patientMapper.toEntity(patientRequestDTO);
        return patientMapper.toDto(patientRepository.save(patient));
    }

    public List<PatientResponseDTO> getAll(String status) {
        return patientRepository.getPatients().stream()
                .filter(p -> status == null || p.getStatus().name().equalsIgnoreCase(status))
                .map(patientMapper::toDto)
                .collect(Collectors.toList());
    }

    public String updateStatus(String patientCpf) {
        Patient patient = patientRepository.getPatientByCpf(patientCpf);

        if (patient == null) {
            throw new CpfNotFoundException("CPF not found");
        }

        if (patient.getStatus() == Patient.Status.ACTIVE) {
            patient.setStatus(Patient.Status.INACTIVE);
        } else {
            patient.setStatus(Patient.Status.ACTIVE);
        }

        return patient.getStatus().name();
    }

    public void deletePatient(String patientCpf) {
        if (!patientRepository.existsByCpf(patientCpf)) {
            throw new CpfNotFoundException("CPF not found");
        }

        patientRepository.deletePatient(patientCpf);
    }

    public void addHistory(String patientCpf, String entry) {
        if (entry == null || entry.trim().isEmpty()) {
            throw new RuntimeException("History cannot be blank");
        }

        Patient patient = patientRepository.getPatientByCpf(patientCpf);

        if (patient == null) {
            throw new CpfNotFoundException("CPF not found");
        }

        patient.getHistory().add(entry);
    }
}
