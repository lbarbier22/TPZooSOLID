package org.example.service.impl;

import org.example.entities.Visite;
import org.example.entities.Zoo;
import org.example.exceptions.RemoveEnclosureToZooException;
import org.example.service.VisiteAssignementService;


public class VisiteAssignementServiceImpl implements VisiteAssignementService {

    Zoo zoo;

    public VisiteAssignementServiceImpl(Zoo zoo) {
        this.zoo = zoo;
    }


    public void assignVisiteToZoo(Visite visiteToAssign) {
          zoo.addVisiteToZoo(visiteToAssign);
    }

    public void removeVisiteToZoo(Visite visiteToRemove) throws RemoveEnclosureToZooException {
        zoo.removeVisiteToZoo(visiteToRemove);
    }
}

