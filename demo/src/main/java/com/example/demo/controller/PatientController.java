package com.example.demo.controller;

import com.example.demo.dto.PatientRequestDTO;
import com.example.demo.dto.PatientResponseDTO;
import com.example.demo.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponseDTO> registerPatient(@RequestBody @Valid PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok(patientResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> list(@RequestParam(required = false) String status) {
        return ResponseEntity.ok(patientService.getAll(status));
    }

    @PutMapping("/{patientCpf}/status")
    public ResponseEntity<String> updateStatus(@PathVariable String patientCpf) {
        String status = patientService.updateStatus(patientCpf);
        return ResponseEntity.ok(status);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) {
        patientService.deletePatient(cpf);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{patientCpf}/historico")
    public ResponseEntity<Void> addHistory(@PathVariable String patientCpf, @RequestBody String entry) {
        patientService.addHistory(patientCpf, entry);
        return ResponseEntity.ok().build();
    }
}
