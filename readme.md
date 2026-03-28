# Testing — Pruebas Unitarias con JUnit 5

**1º DAW – Entornos de Desarrollo | IES Mutxamel | Curso 2025/2026**  
**Autora:** Manuela Planelles Lucas

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

### [DiccionarioTest](https://github.com/manuelaplanelles/Testing/tree/main/DiccionarioTest)
Proyecto de pruebas unitarias sobre una clase `Diccionario` español-inglés con más de 1000 palabras. Se verifican casos normales y casos límite, incluyendo el comportamiento ante métodos sin implementar y diccionario vacío. Cobertura obtenida: 97% en líneas.

**Conceptos aplicados:** `@BeforeEach`, `assertNull`, `assertTrue`, `assertThrows`, cobertura de código.

---

### [MercadawTest](https://github.com/manuelaplanelles/Testing/tree/main/MercadawTest)
Pruebas unitarias sobre la aplicación Mercadaw, un sistema de compra online. Se valida la gestión de pedidos, cálculo de importes, aplicación de promociones (3x2 y 10%) y autenticación de usuarios. Durante el desarrollo se detectó y corrigió un bug real en el método `aplicarPromo3x2()`. Cobertura obtenida: 85% en líneas.

**Conceptos aplicados:** `@BeforeEach`, `assertEquals`, `assertTrue`, `assertDoesNotThrow`, detección de bugs mediante tests.

---

### [BancoTest](https://github.com/manuelaplanelles/Testing/tree/main/BancoTest)
Pruebas de integración sobre una aplicación bancaria simulada utilizando Mockito. Se sustituye la capa de acceso a datos por un mock, permitiendo testear la lógica de negocio de forma aislada. Cubre depósitos, retiradas, consulta de saldo y manejo de excepciones.

**Conceptos aplicados:** `@Mock`, `@InjectMocks`, `@Spy`, `verify`, `when/thenReturn`, `InOrder`, `assertThrows`, pruebas de integración con Mockito.

---

## Tecnologías

- Java 21
- JUnit 5
- Maven
- IntelliJ IDEA
