package com.example.demo;

import jakarta.validation.constraints.NotBlank;

public record DeviceRequest(
    @NotBlank String name,
    @NotBlank String status
) {
}
