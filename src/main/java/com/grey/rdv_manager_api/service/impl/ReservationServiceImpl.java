package com.grey.rdv_manager_api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grey.rdv_manager_api.domain.enums.ReservationStatus;
import com.grey.rdv_manager_api.domain.model.Reservation;
import com.grey.rdv_manager_api.domain.model.Slot;
import com.grey.rdv_manager_api.mapper.ReservationMapper;
import com.grey.rdv_manager_api.payload.request.CreateReservationRequest;
import com.grey.rdv_manager_api.payload.request.UpdateReservationRequest;
import com.grey.rdv_manager_api.payload.response.ReservationResponse;
import com.grey.rdv_manager_api.repository.ReservationRepository;
import com.grey.rdv_manager_api.repository.SlotRepository;
import com.grey.rdv_manager_api.service.ReservationService;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final SlotRepository slotRepository;
    private final ReservationMapper mapper;

    public ReservationServiceImpl(ReservationRepository repository, ReservationMapper mapper, SlotRepository slotRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.slotRepository = slotRepository;
    }
    
    @Override
    @Transactional
    public ReservationResponse create(CreateReservationRequest request) {
        // Check slot availability
        Slot slot = slotRepository.findById(request.slotId())
            .orElseThrow(() -> new RuntimeException("Slot not found: " + request.slotId()));
        if (slot.getAvailable() <= 0) {
            throw new RuntimeException("No available places for this slot.");
        }

        // Proceed with reservation
        Reservation entity = mapper.toEntity(request);
        entity.setId(UUID.randomUUID());
        entity.setStatus(ReservationStatus.PENDING);

        // Decrement slot availability
        slot.setAvailable(slot.getAvailable() - 1);
        slotRepository.save(slot);

        Reservation saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    @Override
    public ReservationResponse getById(UUID id) {
        Reservation entity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reservation not found: " + id));
        return mapper.toResponse(entity);
    }

    @Override
    public List<ReservationResponse> getAll() {
        return mapper.toResponseList(repository.findAll());
    }

    @Override
    @Transactional
    public ReservationResponse update(UUID id, UpdateReservationRequest request) {
        Reservation entity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reservation not found: " + id));
        mapper.updateEntity(request, entity);
        Reservation updated = repository.save(entity);
        return mapper.toResponse(updated);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}