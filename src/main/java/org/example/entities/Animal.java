package org.example.entities;

public class Animal {

    private int id;
    private String name;
    private String species;
    private int age;
    private int enclosureId;

    public Animal(int id, String name, String species, int age) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public Animal(int id, String name, String species, int age, int enclosureId) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.enclosureId = enclosureId;
    }

    public int getEnclosureId() {
        return enclosureId;
    }

    public void setEnclosureId(int enclosureId) {
        this.enclosureId = enclosureId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
