package com.painfullove.rongbuzz.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Generic message response model")
public class MessageResponse {
    
    @Schema(description = "Response message", example = "User registered successfully!")
    private String message;
}
