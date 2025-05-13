package com.grey.rdv_manager_api.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Service entity offered by a Structure.
 */
@Document(collection = "services")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntity {
    @Id
    private UUID id;

    /** Reference to the owning Structure */
    private UUID structureId;

    private String name;
    private String description;
    private String timezone;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    // Getters
    public UUID getId() {
        return id;
    }
    public UUID getStructureId() {
        return structureId;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getTimezone() {
        return timezone;
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
    public void setStructureId(UUID structureId) {
        this.structureId = structureId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
