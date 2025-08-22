package com.painfullove.rongbuzz.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Login request model")
public class LoginRequest {
    
    @Schema(description = "User's username", example = "john_doe")
    @NotBlank(message = "Username is required")
    private String username;
    
    @Schema(description = "User's password", example = "password123")
    @NotBlank(message = "Password is required")
    private String password;
}
