package org.example.service;

import org.example.entities.Enclosure;
import org.example.exceptions.RemoveEnclosureToZooException;

public interface EnclosureAssignementService {

    void assignEnclosureToZoo(Enclosure enclosureToAssign);

    void removeEnclosureToZoo(Enclosure enclosureToRemove) throws RemoveEnclosureToZooException;

}

