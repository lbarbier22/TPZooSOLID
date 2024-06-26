package org.example.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class Visite {

    private UUID id;
    private LocalDate visiteDate;
    private LocalTime startOfVisiteTime;
    private LocalTime endOfVisiteTime;
    private List<Enclosure> enclosuresVisited;

    public Visite(LocalDate visiteDate, LocalTime startOfVisite, LocalTime endOfVisite, List<Enclosure> enclosuresVisited) {
        this.id = UUID.randomUUID();
        this.visiteDate = visiteDate;
        this.startOfVisiteTime = startOfVisite;
        this.endOfVisiteTime = endOfVisite;
        this.enclosuresVisited = enclosuresVisited;
    }

    public LocalDate getVisiteDate() {
        return visiteDate;
    }

    public LocalTime getStartOfVisiteTime() {
        return startOfVisiteTime;
    }

    public LocalTime getEndOfVisiteTime() {
        return endOfVisiteTime;
    }

    public List<Enclosure> getEnclosuresVisited() {
        return enclosuresVisited;
    }

    public void addEnclosureToVisite(Enclosure enclosure){
        enclosuresVisited.add(enclosure);
    }

    public void removeEnclosureToVisite(Enclosure enclosure){
        enclosuresVisited.remove(enclosure);
    }

    public void updateVisiteDate(LocalDate visiteDate) {
        this.visiteDate = visiteDate;
    }

    public void updateStartOfVisiteTime(LocalTime startOfVisiteTime) {
        this.startOfVisiteTime = startOfVisiteTime;
    }

    public void updateEndOfVisiteTime(LocalTime endOfVisiteTime) {
        this.endOfVisiteTime = endOfVisiteTime;
    }

    public void updateEnclosuresVisited(List<Enclosure> enclosuresVisited) {
        this.enclosuresVisited = enclosuresVisited;
    }
}
