package com.grey.rdv_manager_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.grey.rdv_manager_api.domain.enums.Weekday;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Weekly availability schedule for a Service on a specific day of week.
 */
@Document(collection = "service_availability")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceAvailability {
    @Id
    private UUID id;

    /** Reference to the Service */
    private UUID serviceId;

    private Weekday dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    // Getters
    public UUID getId() {
        return id;
    }
    public UUID getServiceId() {
        return serviceId;
    }
    public Weekday getDayOfWeek() {
        return dayOfWeek;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    // Setters
    public void setId(UUID id) {
        this.id = id;
    }
    public void setServiceId(UUID serviceId) {
        this.serviceId = serviceId;
    }
    public void setDayOfWeek(Weekday dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}

