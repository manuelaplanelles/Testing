package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiccionarioTest {

    @BeforeEach
    public void inicioPruebas() {
        Diccionario.map = Diccionario.getMap();
    }

    @Test
    public void testNuevoParNoImplementado() {
        int tamanyoAntes = Diccionario.map.size();
        Diccionario.nuevoPar();
        int tamanyoDespues = Diccionario.map.size();
        assertEquals(tamanyoAntes, tamanyoDespues);
    }

    @Test
    public void testTraducePalabraExistente() {
        String resultado = Diccionario.traduce("animal", "animal");
        assertEquals("animal", resultado);
    }

    @Test
    public void testTraducePalabraNoExistente() {
        String resultado = Diccionario.traduce("xyz", "anything");
        assertNull(resultado);
    }

    @Test
    public void testPalabraAleatoriaEstaEnDiccionario() {
        String palabra = Diccionario.palabrasAleatorias();
        assertTrue(Diccionario.map.containsKey(palabra));
    }

    @Test
    public void testPrimeraLetraTraduccion() {
        String letra = Diccionario.primeraLetraTraduccion("animal");
        assertEquals("a", letra);
    }

    @Test
    public void testPalabraAleatoriaConDiccionarioVacio() {
        Diccionario.map.clear();
        assertThrows(Exception.class, () -> {
            Diccionario.palabrasAleatorias();
        });
    }

    @Test
    public void testPrimeraLetraConDiccionarioVacio() {
        Diccionario.map.clear();
        assertThrows(Exception.class, () -> {
            Diccionario.primeraLetraTraduccion("animal");
        });
    }
}