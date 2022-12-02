package com.daniel.notesservice.config;

import com.daniel.notesservice.event.PersonUpdatedEvent;
import com.daniel.notesservice.service.PersonClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class RabbitConfig {
    private final PersonClientService personClientService;

    @Bean
    public Consumer<PersonUpdatedEvent> personUpdatedEventConsumer(){
        return event -> {
            log.info("Received an event: {}", event);
            personClientService.synchronizePersonId(event.personId());
        };

    }
}
