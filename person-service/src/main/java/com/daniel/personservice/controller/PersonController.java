package com.daniel.personservice.controller;


import com.daniel.personservice.service.PersonService;
import com.daniel.personservice.domain.Person;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;


    @PutMapping("/{id}")
    public void updatePerson(@RequestBody Person person){
        personService.updatePerson(person);

    }

}
