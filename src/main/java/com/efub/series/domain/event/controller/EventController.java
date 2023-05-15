package com.efub.series.domain.event.controller;

import com.efub.series.domain.event.domain.Event;
import com.efub.series.domain.event.dto.EventListResDto;
import com.efub.series.domain.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    @ResponseStatus(value= HttpStatus.OK)
    public EventListResDto getEventList(){
        List<Event> eventList = eventService.findAll();
        /*
        List<EventListResDto> eventResDtoList = new ArrayList<>();

        for(Event event : eventList){
            eventResDtoList.add(new EventListResDto(event));
        }
        */
        return EventListResDto.of(eventList);
    }
}
