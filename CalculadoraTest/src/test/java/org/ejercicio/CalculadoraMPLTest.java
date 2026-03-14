package org.ejercicio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraMPLTest {

        private Calculadora calc;

        @BeforeEach
        public void inicioPruebas() {
            calc = new Calculadora(30, 10);
        }

        @AfterEach
        public void finPruebas() {
            calc = null;
        }

        @Test
        public void testSuma() {
            assertEquals(40, calc.suma());
        }

        @Test
        public void testResta() {
            assertEquals(20, calc.resta());
        }

        @Test
        public void testMultiplica() {
            assertEquals(300, calc.multiplica());
        }

        @Test
        public void testDivide() {
            assertEquals(3, calc.divide());
        }

        @Test
        public void testDivideExcepcion() {
            Calculadora calcCero = new Calculadora(30, 0);
            String valorEsperado = "División por 0";
            String valorDevuelto = "";
            try {
                calcCero.divide();
            } catch (ArithmeticException e) {
                valorDevuelto = e.getMessage();
            }
            assertEquals(valorEsperado, valorDevuelto);
        }
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5})
        public void testSumaConValueSource(int num) {
            Calculadora c = new Calculadora(num, 5);
            assertEquals(num + 5, c.suma());
        }

        @ParameterizedTest
        @CsvSource({
                "1, 2, 3",
                "4, 5, 9",
                "-1, -2, -3",
                "0, 0, 0"
        })
        public void testSumaConCsvSource(int a, int b, int valorEsperado) {
            Calculadora c = new Calculadora(a, b);
            assertEquals(valorEsperado, c.suma());
        }

        /*@Test
        public void testSuma() {
            Calculadora calc = new Calculadora(3, 5);
            int valorEsperado = 8;
            int valorObtenido = calc.suma();
            assertEquals(valorEsperado, valorObtenido);
        }

        @Test
        public void testResta() {
            Calculadora calc = new Calculadora(10, 4);
            int valorEsperado = 6;
            int valorObtenido = calc.resta();
            assertEquals(valorEsperado, valorObtenido);
        }

        @Test
        public void testMultiplica() {
            Calculadora calc = new Calculadora(3, 4);
            int valorEsperado = 12;
            int valorObtenido = calc.multiplica();
            assertEquals(valorEsperado, valorObtenido);
        }

        @Test
        public void testDivide() {
            Calculadora calc = new Calculadora(30, 10);
            int valorEsperado = 3;
            int valorObtenido = calc.divide();
            assertEquals(valorEsperado, valorObtenido);
        }

        @Test
        public void testDivideExcepcion() {
            Calculadora calc = new Calculadora(30, 0);
            String valorEsperado = "División por 0";
            String valorDevuelto = "";
            try {
                calc.divide();
            } catch (ArithmeticException e) {
                valorDevuelto = e.getMessage();
            }
            assertEquals(valorEsperado, valorDevuelto);
        }
     */
}