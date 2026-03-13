# Testing — Pruebas Unitarias con JUnit 5

Colección de proyectos prácticos sobre pruebas unitarias en Java desarrollados durante el módulo de Entornos de Desarrollo. Cada proyecto aplica JUnit 5 sobre una clase diferente, progresando en complejidad y técnicas de testing.

---

## Proyectos

### [AlienTest](https://github.com/manuelaplanelles/Testing/tree/main/AlienTest)
Introducción a las pruebas unitarias con JUnit 5. Se testea una clase `Alien` con 9 casos de prueba que cubren constructor, getters, setters, `toString()` y `equals()`. Incluye análisis de cobertura de código con Run with Coverage.

**Conceptos aplicados:** `@Test`, `assertEquals`, `assertTrue`, `assertFalse`, `assertNotNull`, análisis de cobertura.

---

### [CalculadoraTest](https://github.com/manuelaplanelles/Testing/tree/main/CalculadoraTest)
Proyecto progresivo que amplía las técnicas de testing sobre una clase `Calculadora`. Parte de tests básicos, incorpora manejo de excepciones, inicialización con ciclo de vida, tests parametrizados y suite de pruebas.

**Conceptos aplicados:** `@BeforeEach`, `@AfterEach`, `@ParameterizedTest`, `@ValueSource`, `@CsvSource`, `@Suite`.

---

## Tecnologías

- Java 21
- JUnit 5
- Maven
- IntelliJ IDEA
