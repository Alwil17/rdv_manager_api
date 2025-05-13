package com.grey.rdv_manager_api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grey.rdv_manager_api.domain.model.Reminder;
import com.grey.rdv_manager_api.mapper.ReminderMapper;
import com.grey.rdv_manager_api.payload.request.CreateReminderRequest;
import com.grey.rdv_manager_api.payload.request.UpdateReminderRequest;
import com.grey.rdv_manager_api.payload.response.ReminderResponse;
import com.grey.rdv_manager_api.repository.ReminderRepository;
import com.grey.rdv_manager_api.service.ReminderService;

import java.util.List;
import java.util.UUID;

@Service
public class ReminderServiceImpl implements ReminderService {

    private final ReminderRepository repository;
    private final ReminderMapper mapper;

    public ReminderServiceImpl(ReminderRepository repository, ReminderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ReminderResponse create(CreateReminderRequest request) {
        Reminder entity = mapper.toEntity(request);
        entity.setId(UUID.randomUUID());
        Reminder saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    @Override
    public ReminderResponse getById(UUID id) {
        Reminder entity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reminder not found: " + id));
        return mapper.toResponse(entity);
    }

    @Override
    public List<ReminderResponse> getAll() {
        return mapper.toResponseList(repository.findAll());
    }

    @Override
    @Transactional
    public ReminderResponse update(UUID id, UpdateReminderRequest request) {
        Reminder entity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reminder not found: " + id));
        mapper.updateEntity(request, entity);
        Reminder updated = repository.save(entity);
        return mapper.toResponse(updated);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}