package org.example.service.impl;

import org.example.entities.Enclosure;
import org.example.entities.Visite;
import org.example.entities.Zoo;
import org.example.exceptions.RemoveEnclosureToZooException;
import org.example.exceptions.TooMuchEnclosuresInVisite;
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

    public void assignEnclosureToVisite(Visite visite, Enclosure enclosure) throws TooMuchEnclosuresInVisite {
        if (isVisiteAlreadyFullOfEnclosures(visite)){
            throw new TooMuchEnclosuresInVisite();
        } else {
            visite.addEnclosureToVisite(enclosure);
        }
    }

    public void removeEnclosureToVisite(Visite visite, Enclosure enclosure){
        visite.removeEnclosureToVisite(enclosure);
    }

    private static boolean isVisiteAlreadyFullOfEnclosures(Visite visite) {
        return visite.getEnclosuresVisited().size() >= 4;
    }

    private static boolean doesEnclosureCanBeRemove(Enclosure enclosureToRemove) {
        return enclosureToRemove.getAnimals() == null;
    }
}

