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
@RequestMapping("/api/vendor")
@PreAuthorize("hasRole('VENDOR')")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Vendor Management", description = "Vendor-specific operations and inventory management")
@SecurityRequirement(name = "Bearer Authentication")
public class VendorController {
    
    @Operation(summary = "Get vendor dashboard", description = "Retrieve vendor dashboard with inventory and order management")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dashboard retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @GetMapping("/dashboard")
    public String getVendorDashboard() {
        return "Vendor Dashboard - Manage inventory and orders";
    }
    
    @Operation(summary = "Get inventory", description = "Retrieve current inventory and stock levels")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inventory retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @GetMapping("/inventory")
    public String getInventory() {
        return "Current inventory and stock levels";
    }
    
    @Operation(summary = "Get vendor orders", description = "Retrieve list of all orders from customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @GetMapping("/orders")
    public String getOrders() {
        return "List of all orders from customers";
    }
    
    @Operation(summary = "Add to inventory", description = "Add new items to vendor inventory")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Items added successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges"),
            @ApiResponse(responseCode = "400", description = "Invalid inventory data")
    })
    @PostMapping("/inventory/add")
    public String addToInventory() {
        return "New items added to inventory";
    }
    
    @Operation(summary = "Ship order", description = "Mark a specific order as shipped")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order shipped successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    @PostMapping("/orders/{orderId}/ship")
    public String shipOrder(@PathVariable Long orderId) {
        return "Order " + orderId + " has been shipped";
    }
    
    @Operation(summary = "Get analytics", description = "Retrieve sales analytics and performance metrics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Analytics retrieved successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "403", description = "Insufficient privileges")
    })
    @GetMapping("/analytics")
    public String getAnalytics() {
        return "Sales analytics and performance metrics";
    }
}
