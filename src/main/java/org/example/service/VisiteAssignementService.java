package org.example.service;

import org.example.entities.Visite;
import org.example.exceptions.RemoveEnclosureToZooException;

public interface VisiteAssignementService {

    void assignVisiteToZoo(Visite visiteToAssign);

    void removeVisiteToZoo(Visite visiteToRemove) throws RemoveEnclosureToZooException;

}

