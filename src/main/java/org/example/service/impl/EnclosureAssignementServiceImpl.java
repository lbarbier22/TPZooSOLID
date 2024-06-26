package org.example.service.impl;

import org.example.entities.Enclosure;
import org.example.entities.Zoo;
import org.example.exceptions.RemoveEnclosureToZooException;
import org.example.service.EnclosureAssignementService;


public class EnclosureAssignementServiceImpl implements EnclosureAssignementService {

    Zoo zoo;

    public EnclosureAssignementServiceImpl(Zoo zoo) {
        this.zoo = zoo;
    }


    public void assignEnclosureToZoo(Enclosure enclosureToAssign) {
          zoo.addEnclosureToZoo(enclosureToAssign);
    }

    public void removeEnclosureToZoo(Enclosure enclosureToRemove) throws RemoveEnclosureToZooException {
        boolean doesEnclosureCanBeRemove = doesEnclosureCanBeRemove(enclosureToRemove);
        if (doesEnclosureCanBeRemove){
            zoo.removeEnclosureToZoo(enclosureToRemove);
        } else {
            throw new RemoveEnclosureToZooException(enclosureToRemove.getName());
        }
    }

    private static boolean doesEnclosureCanBeRemove(Enclosure enclosureToRemove) {
        return enclosureToRemove.getAnimals() == null;
    }
}

