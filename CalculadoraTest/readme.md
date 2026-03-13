# CalculadoraTest — Pruebas Unitarias con JUnit 5

Proyecto práctico sobre pruebas unitarias en Java utilizando JUnit 5. Se trabaja sobre una clase `Calculadora` que contiene errores introducidos intencionadamente, con el objetivo de aprender a detectarlos, analizarlos y corregirlos mediante tests automatizados. El proyecto progresa desde tests básicos hasta técnicas avanzadas como parametrización y suites de pruebas.

---

## Índice

- [Ejercicio 1 — Tests básicos y detección de errores](#ejercicio-1)
- [Ejercicio 2 — Diferencia entre fallo y error](#ejercicio-2)
- [Ejercicio 3 — Ciclo de vida con @BeforeEach y @AfterEach](#ejercicio-3)
- [Ejercicio 4 — Tests parametrizados](#ejercicio-4)
- [Ejercicio 5 — Suite de pruebas](#ejercicio-5)
- [Ejercicio 6 — Reflexión y pirámide de testing](#ejercicio-6)

---

## Ejercicio 1

**Enunciado**  
> _Crear una clase de pruebas `CalculadoraMPLTest` que verifique los cuatro métodos de la clase `Calculadora`: `suma()`, `resta()`, `multiplica()` y `divide()`. Los métodos `resta()` y `divide()` contienen errores intencionados que los tests deben detectar. Una vez detectados, corregir la clase y volver a pasar los tests hasta obtener todos en verde._

**Por qué es importante**  
Este ejercicio introduce el ciclo básico del testing: escribir un test, detectar un fallo, corregir el código y verificar. En un entorno profesional, este proceso evita que errores lleguen a producción y permite localizar exactamente dónde falla el código sin revisar el programa completo.

**Pasos realizados**

1. Creación de `CalculadoraMPLTest.java` en `src/test/java/org/ejercicio/`
2. Implementación de los 4 tests con `assertEquals`
3. Ejecución → `testResta` y `testDivide` fallan: los métodos están usando `+` en vez de `-` y `/`
4. Corrección de `Calculadora.java`
5. Segunda ejecución → 4 tests en verde

**Código — CalculadoraMPLTest.java**
```java
package org.ejercicio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraMPLTest {

    @Test
    public void testSuma() {
        Calculadora calc = new Calculadora(3, 5);
        assertEquals(8, calc.suma());
    }

    @Test
    public void testResta() {
        Calculadora calc = new Calculadora(10, 4);
        assertEquals(6, calc.resta());
    }

    @Test
    public void testMultiplica() {
        Calculadora calc = new Calculadora(3, 4);
        assertEquals(12, calc.multiplica());
    }

    @Test
    public void testDivide() {
        Calculadora calc = new Calculadora(10, 2);
        assertEquals(5, calc.divide());
    }
}
```

**Resultado — Tests fallando (errores detectados)**  
![Ejercicio 1 - tests fallando](screenshots/ej1_tests_fallando.png)

**Resultado — Tests corregidos**  
![Ejercicio 1 - tests en verde](screenshots/ej1_tests_verde.png)

---

## Ejercicio 2

*(pendiente)*

---

## Ejercicio 3

*(pendiente)*

---

## Ejercicio 4

*(pendiente)*

---

## Ejercicio 5

*(pendiente)*

---

## Ejercicio 6

*(pendiente)*

---

## Tecnologías

- Java 21
- JUnit 5
- Maven
- IntelliJ IDEA



**1º DAW – Entornos de Desarrollo | IES Mutxamel | Curso 2025/2026**  
**Autora:** Manuela Planelles Lucas
