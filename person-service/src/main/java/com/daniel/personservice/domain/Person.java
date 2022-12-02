package com.daniel.personservice.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name = "persons")
public class Person {


    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Override
    public int hashCode() {
    return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this== obj) return false;
        if(!(obj instanceof Person person)) return false;
        return id!=null && id.equals(person.id);
    }
}
