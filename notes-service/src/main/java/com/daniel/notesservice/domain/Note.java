package com.daniel.notesservice.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @Column(nullable = false)
    private Person person;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this== obj) return false;
        if(!(obj instanceof Note note)) return false;
        return id !=null && id.equals(note.id);
    }
}
