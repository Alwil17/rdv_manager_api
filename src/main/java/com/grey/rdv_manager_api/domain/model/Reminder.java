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

import com.grey.rdv_manager_api.domain.enums.ReminderMethod;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Reminder entity for reservation notifications.
 */
@Document(collection = "reminders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reminder {
    @Id
    private UUID id;

    /** Reference to the Reservation */
    private UUID reservationId;

    private LocalDateTime reminderTime;
    private ReminderMethod method;
    private boolean sent;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    // Getters
    public UUID getId() {
        return id;
    }
    public UUID getReservationId() {
        return reservationId;
    }
    public LocalDateTime getReminderTime() {
        return reminderTime;
    }
    public ReminderMethod getMethod() {
        return method;
    }
    public boolean isSent() {
        return sent;
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
    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }
    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }
    public void setMethod(ReminderMethod method) {
        this.method = method;
    }
    public void setSent(boolean sent) {
        this.sent = sent;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
