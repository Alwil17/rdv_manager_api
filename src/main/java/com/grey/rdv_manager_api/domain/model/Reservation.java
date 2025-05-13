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

import com.grey.rdv_manager_api.domain.enums.ReservationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Reservation entity representing a client's booking of a slot.
 */
@Document(collection = "reservations")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    private UUID id;

    /** Reference to the Client who made the reservation */
    private UUID clientId;

    /** Reference to the Slot being reserved */
    private UUID slotId;

    private ReservationStatus status;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    // Getters
    public UUID getId() {
        return id;
    }

    public UUID getClientId() {
        return clientId;
    }
    public UUID getSlotId() {
        return slotId;
    }
    public ReservationStatus getStatus() {
        return status;
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
    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }
    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}

