package com.efub.series.domain.event.service;

import com.efub.series.domain.event.domain.Event;
import com.efub.series.domain.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    @Transactional(readOnly = true)
    public List<Event> findAll(){
        return eventRepository.findAll();
    }
}
