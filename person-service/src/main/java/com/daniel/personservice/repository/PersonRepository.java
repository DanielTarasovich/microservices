package com.daniel.personservice.repository;

import com.daniel.personservice.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
