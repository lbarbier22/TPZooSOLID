package org.example.exceptions;

public class RemoveEnclosureToZooException extends Exception{

    public RemoveEnclosureToZooException(String enclosure) {
        super("Cannot remove this enclosure '"+enclosure+"' from the zoo because it contains animals !") ;
    }

    public RemoveEnclosureToZooException() {
        super("Exception : Cannot remove an undefined enclosure from the zoo because it contains animals !") ;
    }
}
