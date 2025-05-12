package com.grey.rdv_manager_api.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.grey.rdv_manager_api.payload.request.CreateSlotRequest;
import com.grey.rdv_manager_api.payload.request.UpdateSlotRequest;
import com.grey.rdv_manager_api.payload.response.SlotResponse;
import com.grey.rdv_manager_api.service.SlotService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping
    public ResponseEntity<SlotResponse> createSlot(
            @Validated @RequestBody CreateSlotRequest request) {
        SlotResponse response = slotService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SlotResponse> getSlot(@PathVariable UUID id) {
        SlotResponse response = slotService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SlotResponse>> getAllSlots() {
        List<SlotResponse> list = slotService.getAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SlotResponse> updateSlot(
            @PathVariable UUID id,
            @Validated @RequestBody UpdateSlotRequest request) {
        SlotResponse response = slotService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSlot(@PathVariable UUID id) {
        slotService.delete(id);
    }
}