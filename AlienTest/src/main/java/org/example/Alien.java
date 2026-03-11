package org.example;

public class Alien {

    protected String name;
    protected String planetId;

    public Alien() {
        name = "";
        planetId = "";
    }

    public Alien(String name, String planetId) {
        this.name = name;
        this.planetId = planetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String planetId) {
        this.planetId = planetId;
    }

    @Override
    public boolean equals(Object a) {
        return this.planetId.equals(((Alien) a).planetId);
    }

    @Override
    public String toString() {
        return name + " " + planetId;
    }
}