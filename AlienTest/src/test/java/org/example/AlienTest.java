package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlienTest {

    @Test
    void testConstructorStoresName() {
        Alien a1 = new Alien("Zorg", "MARS01");
        assertEquals("Zorg", a1.getName());
    }

    @Test
    void testConstructorStoresPlanetId() {
        Alien a1 = new Alien("Zorg", "MARS01");
        assertEquals("MARS01", a1.getPlanetId());
    }

    @Test
    void testToString() {
        Alien a1 = new Alien("Zorg", "MARS01");
        assertEquals("Zorg MARS01", a1.toString());
    }

    @Test
    void testAliensWithSamePlanetIdAreEqual() {
        Alien a1 = new Alien("Zorg", "MARS01");
        Alien a3 = new Alien("Zorg", "MARS01");
        assertTrue(a1.equals(a3));
    }

    @Test
    void testAliensWithDifferentPlanetIdAreNotEqual() {
        Alien a1 = new Alien("Zorg", "MARS01");
        Alien a2 = new Alien("Xenomorph", "LV426");
        assertFalse(a1.equals(a2));
    }

    @Test
    void testConstructorNotNull() {
        Alien a1 = new Alien("Zorg", "MARS01");
        assertNotNull(a1);
    }

    @Test
    void testSetName() {
        Alien a1 = new Alien("Zorg", "MARS01");
        a1.setName("Xenomorph");
        assertEquals("Xenomorph", a1.getName());
    }

    @Test
    void testSetPlanetId() {
        Alien a1 = new Alien("Zorg", "MARS01");
        a1.setPlanetId("LV426");
        assertEquals("LV426", a1.getPlanetId());
    }
    @Test
    void testFallaIntencionadamente() {
        Alien alien = new Alien("Zorg", "MARS01");
        assertEquals("Zorg", alien.getName());
    }
}