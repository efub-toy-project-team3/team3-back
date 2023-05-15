package com.efub.series.domain.event.dto;

import com.efub.series.domain.event.domain.Event;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class EventListResDto {

    List<EventResDto> events;

    @Getter
    public static class EventResDto {
        private Long eventId;
        private String image;

        public EventResDto(Event event) {
            this.eventId = event.getEventId();
            this.image = event.getImage();
        }

        public static EventResDto of(Event event) {
            return new EventResDto(event);
        }
    }
    public static EventListResDto of(List<Event> eventList){
        return EventListResDto.builder()
                .events(eventList.stream().map(EventListResDto.EventResDto::of).collect(Collectors.toList()))
                .build();
    }

}
