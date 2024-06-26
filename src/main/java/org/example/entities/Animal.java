package org.example.entities;

import org.example.utils.SpeciesEnum;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Animal {

    private UUID id;
    private String name;
    private SpeciesEnum specie;
    private LocalDate anniversaryDate;

    public Animal( String name, SpeciesEnum species, LocalDate anniversaryDate) {
        this.id = randomUUID();
        this.name = name;
        this.specie = species;
        this.anniversaryDate = anniversaryDate;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public SpeciesEnum getSpecie() {
        return specie;
    }

    public void changeSpecie(SpeciesEnum specie) {
        this.specie = specie;
    }

    public int getAge() {
        return Period.between(anniversaryDate, LocalDate.now()).getYears();
    }

    public void setAnniversaryDate(LocalDate anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }
}
