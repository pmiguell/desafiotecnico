package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record HistoryEntryDTO(
        @NotBlank(message = "history entry must not be blank")
        String entry
) {

}
