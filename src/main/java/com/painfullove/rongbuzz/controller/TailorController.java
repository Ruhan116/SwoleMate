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
@RequestMapping("/api/tailor")
@PreAuthorize("hasRole('TAILOR')")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Tailor Management", description = "Tailor-specific operations and order management")
@SecurityRequirement(name = "Bearer Authentication")
public class TailorController {
    
    @Operation(summary = "Get tailor dashboard", description = "Retrieve tailor dashboard with orders and measurements")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dashboard retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @GetMapping("/dashboard")
    public String getTailorDashboard() {
        return "Tailor Dashboard - Manage orders and measurements";
    }
    
    @Operation(summary = "Get tailor orders", description = "Retrieve list of all orders assigned to this tailor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @GetMapping("/orders")
    public String getOrders() {
        return "List of all orders assigned to this tailor";
    }
    
    @Operation(summary = "Get measurements", description = "Retrieve customer measurements and specifications")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Measurements retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @GetMapping("/measurements")
    public String getMeasurements() {
        return "Customer measurements and specifications";
    }
    
    @Operation(summary = "Accept order", description = "Accept a specific order for processing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order accepted successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    @PostMapping("/orders/{orderId}/accept")
    public String acceptOrder(@PathVariable Long orderId) {
        return "Order " + orderId + " has been accepted";
    }
    
    @Operation(summary = "Complete order", description = "Mark a specific order as completed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order completed successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    @PostMapping("/orders/{orderId}/complete")
    public String completeOrder(@PathVariable Long orderId) {
        return "Order " + orderId + " has been completed";
    }
    
    @Operation(summary = "Get schedule", description = "Retrieve tailor's work schedule and appointments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Schedule retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @GetMapping("/schedule")
    public String getSchedule() {
        return "Tailor's work schedule and appointments";
    }
}
