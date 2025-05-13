package com.grey.rdv_manager_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Audit log for tracking create/update/delete actions on entities.
 */
@Document(collection = "audit_logs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog {
    @Id
    private UUID id;

    private String entityName;
    private UUID entityId;
    private String action;
    private String performedBy;
    private LocalDateTime timestamp;
    private String details;

    // Getters
    public UUID getId() {
        return id;
    }
    public String getEntityName() {
        return entityName;
    }
    public UUID getEntityId() {
        return entityId;
    }
    public String getAction() {
        return action;
    }
    public String getPerformedBy() {
        return performedBy;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getDetails() {
        return details;
    }
    // Setters
    public void setId(UUID id) {
        this.id = id;
    }
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    public void setEntityId(UUID entityId) {
        this.entityId = entityId;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    
}
