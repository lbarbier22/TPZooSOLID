package org.example.exceptions;

public class TooMuchEnclosuresInVisite extends Exception{

    public TooMuchEnclosuresInVisite() {
        super("There is too much enclosures to this visite, You need to remove some enclosures first!") ;
    }
}
