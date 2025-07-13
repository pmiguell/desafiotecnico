package com.example.demo.repository;

import com.example.demo.entity.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PatientRepository {
    private final Map<String, Patient> patients = new HashMap<>();
    private Long nextId = 1L;

    public Patient save(Patient patient) {
        patient.setId(nextId++);
        patients.put(patient.getCpf(), patient);
        return patient;
    }

    public List<Patient> getPatients() {
        return patients.values().stream().toList();
    }

    public Patient getPatientByCpf(String patientCpf) {
        return patients.get(patientCpf);
    }

    public void deletePatient(String patientCpf) {
        patients.remove(patientCpf);
    }

    public boolean existsByCpf(String cpf) {
        return patients.containsKey(cpf);
    }
} 
