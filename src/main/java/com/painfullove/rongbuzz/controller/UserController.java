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
@RequestMapping("/api/user")
@PreAuthorize("hasRole('USER')")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "User Management", description = "User-specific operations and profile management")
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {
    
    @Operation(summary = "Get user dashboard", description = "Retrieve user dashboard with orders and profile information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dashboard retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access")
    })
    @GetMapping("/dashboard")
    public String getUserDashboard() {
        return "User Dashboard - View orders and profile";
    }
    
    @Operation(summary = "Get user profile", description = "Retrieve current user's profile information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access")
    })
    @GetMapping("/profile")
    public String getUserProfile() {
        return "User profile information";
    }
    
    @Operation(summary = "Get user orders", description = "Retrieve list of orders for the current user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access")
    })
    @GetMapping("/orders")
    public String getUserOrders() {
        return "List of user's orders";
    }
    
    @Operation(summary = "Create new order", description = "Create a new order for the current user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order created successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "400", description = "Invalid order data")
    })
    @PostMapping("/orders/create")
    public String createOrder() {
        return "New order created successfully";
    }
    
    @Operation(summary = "Get user measurements", description = "Retrieve user's measurements and preferences")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Measurements retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access")
    })
    @GetMapping("/measurements")
    public String getUserMeasurements() {
        return "User's measurements and preferences";
    }
    
    @Operation(summary = "Update user profile", description = "Update current user's profile information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile updated successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "400", description = "Invalid profile data")
    })
    @PutMapping("/profile/update")
    public String updateProfile() {
        return "Profile updated successfully";
    }
}
