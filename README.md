# 🛸 AlienTest — Misión NASA: Pruebas Unitarias con JUnit 5

**UP05 – Entornos de Desarrollo | IES Mutxamel | Curso 2025/2026**  
**Alumna:** Manuela Planelles Lucas

---

## 📋 Descripción

Proyecto de pruebas unitarias desarrollado como parte de la práctica UP05 de la asignatura Entornos de Desarrollo. El objetivo ha sido verificar el correcto funcionamiento de la clase `Alien`, encargada de registrar especies biológicas externas detectadas por sondas espaciales, utilizando JUnit 5 dentro del entorno IntelliJ IDEA.

---

## 🗂️ Estructura del proyecto
```
AlienTest/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org.example/
│   │           └── Alien.java
│   └── test/
│       └── java/
│           └── org.example/
│               └── AlienTest.java
└── pom.xml
```

---

## 🧪 Tests implementados

| Test | Assertion | Descripción |
|------|-----------|-------------|
| `testConstructorStoresName()` | `assertEquals` | Verifica que el constructor almacena correctamente el nombre |
| `testConstructorStoresPlanetId()` | `assertEquals` | Verifica que el constructor almacena correctamente el planetId |
| `testToString()` | `assertEquals` | Verifica que toString() devuelve el formato correcto |
| `testAliensWithSamePlanetIdAreEqual()` | `assertTrue` | Verifica que dos aliens con el mismo planetId son iguales |
| `testAliensWithDifferentPlanetIdAreNotEqual()` | `assertFalse` | Verifica que dos aliens con distinto planetId no son iguales |
| `testConstructorNotNull()` | `assertNotNull` | Verifica que el objeto creado no es nulo |
| `testSetName()` | `assertEquals` | Verifica que setName() actualiza el nombre correctamente |
| `testSetPlanetId()` | `assertEquals` | Verifica que setPlanetId() actualiza el planetId correctamente |
| `testFallaIntencionadamente()` | `assertEquals` | Test creado a propósito para analizar el comportamiento ante un fallo |

---

## ⚙️ Tecnologías

- Java 21
- JUnit 5.8.1
- Maven
- IntelliJ IDEA

---

## 🚀 Cómo ejecutar los tests

1. Clona el repositorio
2. Abre el proyecto en IntelliJ IDEA
3. Haz clic derecho sobre `AlienTest.java`
4. Selecciona **Run 'AlienTest'**

---

## 📊 Cobertura

Ejecutado con **Run with Coverage**:

- Métodos: **77%**
- Líneas: **60%**
- Ramas: **0%**
