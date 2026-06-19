package model;

public class Location {

    private final String zone;
    private final String rack;
    private final int shelf;

    public Location(String zone, String rack, int shelf) {
        this.zone = zone;
        this.rack = rack;
        this.shelf = shelf;
    }

    public String getZone() {
        return zone;
    }

    public String getRack() {
        return rack;
    }

    public int getShelf() {
        return shelf;
    }

    @Override
    public String toString() {
        return zone + " / " + rack + " / półka " + shelf;
    }
}
