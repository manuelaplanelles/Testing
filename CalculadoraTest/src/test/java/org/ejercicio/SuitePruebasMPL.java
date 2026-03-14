package org.ejercicio;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CalculadoraMPLTest.class,
        OtraClaseDePruebasTest.class
})
public class SuitePruebasMPL {
    // No necesita métodos
}
