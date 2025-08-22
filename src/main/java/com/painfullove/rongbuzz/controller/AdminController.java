package com.painfullove.rongbuzz.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Admin Management", description = "Administrative operations and system management")
@SecurityRequirement(name = "Bearer Authentication")
public class AdminController {
    
    @Operation(summary = "Get admin dashboard", description = "Retrieve admin dashboard with system overview and management options")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dashboard retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @GetMapping("/dashboard")
    public String getAdminDashboard() {
        return "Admin Dashboard - Manage all users and system settings";
    }
    
    @Operation(summary = "Get all users", description = "Retrieve list of all users in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @GetMapping("/users")
    public String getAllUsers() {
        return "List of all users in the system";
    }
    
    @Operation(summary = "Get system statistics", description = "Retrieve system statistics and analytics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Statistics retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @GetMapping("/system-stats")
    public String getSystemStats() {
        return "System statistics and analytics";
    }
    
    @Operation(summary = "Disable user", description = "Disable a specific user account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User disabled successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PostMapping("/users/{userId}/disable")
    public String disableUser(@PathVariable Long userId) {
        return "User " + userId + " has been disabled";
    }
    
    @Operation(summary = "Enable user", description = "Enable a previously disabled user account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User enabled successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PostMapping("/users/{userId}/enable")
    public String enableUser(@PathVariable Long userId) {
        return "User " + userId + " has been enabled";
    }
}
