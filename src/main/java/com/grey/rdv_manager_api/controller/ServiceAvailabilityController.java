package com.grey.rdv_manager_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.grey.rdv_manager_api.payload.request.CreateServiceAvailabilityRequest;
import com.grey.rdv_manager_api.payload.request.UpdateServiceAvailabilityRequest;
import com.grey.rdv_manager_api.payload.response.ServiceAvailabilityResponse;
import com.grey.rdv_manager_api.service.ServiceAvailabilityService;

import java.util.List;
import java.util.UUID;

@RestController
public class ServiceAvailabilityController {

    private final ServiceAvailabilityService serviceAvailabilityService;

    public ServiceAvailabilityController(ServiceAvailabilityService serviceAvailabilityService) {
        this.serviceAvailabilityService = serviceAvailabilityService;
    }

    /**
     * Create a new availability slot for a service
     */
    @PostMapping("/api/services/{serviceId}/availability")
    public ResponseEntity<ServiceAvailabilityResponse> createAvailability(
            @PathVariable UUID serviceId,
            @Validated @RequestBody CreateServiceAvailabilityRequest request) {
        // Ensure DTO serviceId matches path
        ServiceAvailabilityResponse response = serviceAvailabilityService.create(serviceId, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Get all availability entries for a service
     */
    @GetMapping("/api/services/{serviceId}/availability")
    public ResponseEntity<List<ServiceAvailabilityResponse>> getByService(
            @PathVariable UUID serviceId) {
        List<ServiceAvailabilityResponse> list = serviceAvailabilityService.getByServiceId(serviceId);
        return ResponseEntity.ok(list);
    }

    /**
     * Get a specific availability by its id
     */
    @GetMapping("/api/service-availabilities/{id}")
    public ResponseEntity<ServiceAvailabilityResponse> getById(@PathVariable UUID id) {
        ServiceAvailabilityResponse response = serviceAvailabilityService.getById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Update an existing availability entry
     */
    @PutMapping("/api/service-availabilities/{id}")
    public ResponseEntity<ServiceAvailabilityResponse> updateAvailability(
            @PathVariable UUID id,
            @Validated @RequestBody UpdateServiceAvailabilityRequest request) {
        ServiceAvailabilityResponse response = serviceAvailabilityService.update(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * Delete an availability entry
     */
    @DeleteMapping("/api/service-availabilities/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAvailability(@PathVariable UUID id) {
        serviceAvailabilityService.delete(id);
    }
}