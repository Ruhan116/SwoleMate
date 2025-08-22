package com.painfullove.rongbuzz.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@Tag(name = "Test Endpoints", description = "Test endpoints for role-based access verification")
public class TestController {
    
    @Operation(summary = "Public access test", description = "Test endpoint accessible to all users without authentication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Public content accessed successfully")
    })
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }
    
    @Operation(summary = "User access test", description = "Test endpoint accessible to authenticated users with any role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User content accessed successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access")
    })
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TAILOR') or hasRole('VENDOR')")
    public String userAccess() {
        return "User Content.";
    }
    
    @Operation(summary = "Admin access test", description = "Test endpoint accessible only to users with ADMIN role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admin content accessed successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Content.";
    }
    
    @Operation(summary = "Tailor access test", description = "Test endpoint accessible only to users with TAILOR role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tailor content accessed successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/tailor")
    @PreAuthorize("hasRole('TAILOR')")
    public String tailorAccess() {
        return "Tailor Content.";
    }
    
    @Operation(summary = "Vendor access test", description = "Test endpoint accessible only to users with VENDOR role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vendor content accessed successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/vendor")
    @PreAuthorize("hasRole('VENDOR')")
    public String vendorAccess() {
        return "Vendor Content.";
    }
}
