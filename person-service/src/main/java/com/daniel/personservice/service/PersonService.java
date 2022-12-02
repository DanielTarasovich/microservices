package com.daniel.personservice.service;

import com.daniel.personservice.domain.Person;
import com.daniel.personservice.event.PersonUpdateEvent;
import com.daniel.personservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final StreamBridge streamBridge;

    public void updatePerson(Person person){
        personRepository.save(person); // update in local DB
        // publish even (message) that person with current id has been updated
        streamBridge.send("person-topic", new PersonUpdateEvent(person.getId()));
    }
}
