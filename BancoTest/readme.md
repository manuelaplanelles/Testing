# BancoTest — Pruebas de Integración con Mockito

**1º DAW – Entornos de Desarrollo | IES Mutxamel | Curso 2025/2026**  
**Autora:** Manuela Planelles Lucas

Proyecto práctico sobre pruebas de integración en Java utilizando JUnit 5 y Mockito. Se simula una aplicación bancaria donde `BancoService` depende de `RepositorioBanco` para acceder a los datos. Mockito permite sustituir esa dependencia por un objeto falso, controlando los datos devueltos y verificando las interacciones entre clases.

---

## Índice

- [Clases](#clases)
- [Tests implementados](#tests-implementados)
- [Cobertura](#cobertura)
- [Código](#código)

---

## Clases

**`RepositorioBanco`** — interfaz que representa el acceso a datos del banco. Define dos métodos: `obtenerSaldo()` y `actualizarSaldo()`. En los tests es sustituida por un mock de Mockito.

**`BancoService`** — contiene la lógica de negocio. Depende de `RepositorioBanco` para operar sobre los saldos. Implementa `depositar()`, `retirar()` y `consultarSaldo()`.

---

## Tests implementados

| Test | Qué verifica | Técnica Mockito |
|------|-------------|-----------------|
| `testDepositar` | Depositar aumenta el saldo correctamente | `when` / `verify` |
| `testRetirar` | Retirar disminuye el saldo correctamente | `when` / `verify` |
| `testRetirarFondosInsuficientes` | Lanza excepción si no hay fondos | `assertThrows` |
| `testConsultarSaldo` | Devuelve el saldo correcto | `when` |
| `testRetornosMultiples` | Devuelve valores distintos en llamadas consecutivas | `thenReturn` múltiple |
| `testOrdenDeLlamadas` | Verifica que los métodos se llaman en el orden correcto | `InOrder` |
| `testSpy` | El espía mantiene el comportamiento real del objeto | `@Spy` |

---

## Cobertura

- **Method:** 80%
- **Line:** 75%

![Cobertura](img/cobertura.png)

---

## Código

<details>
<summary>Ver código completo — BancoServiceTest.java</summary>

  ```java
package org.ejemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BancoServiceTest {

    @Mock
    private RepositorioBanco repositorio;

    @InjectMocks
    private BancoService bancoService;

    @InjectMocks
    @Spy
    private BancoService bancoSpy;

    @Test
    void testDepositar() {
        when(repositorio.obtenerSaldo("cuenta1")).thenReturn(100.0);
        bancoService.depositar("cuenta1", 50.0);
        verify(repositorio).actualizarSaldo("cuenta1", 150.0);
    }

    @Test
    void testRetirar() {
        when(repositorio.obtenerSaldo("cuenta1")).thenReturn(200.0);
        bancoService.retirar("cuenta1", 80.0);
        verify(repositorio).actualizarSaldo("cuenta1", 120.0);
    }

    @Test
    void testRetirarFondosInsuficientes() {
        when(repositorio.obtenerSaldo("cuenta1")).thenReturn(50.0);
        assertThrows(IllegalArgumentException.class, () -> {
            bancoService.retirar("cuenta1", 100.0);
        });
    }

    @Test
    void testConsultarSaldo() {
        when(repositorio.obtenerSaldo("cuenta1")).thenReturn(300.0);
        double saldo = bancoService.consultarSaldo("cuenta1");
        assertEquals(300.0, saldo);
    }

    @Test
    void testRetornosMultiples() {
        when(repositorio.obtenerSaldo("cuenta1")).thenReturn(100.0, 150.0);
        assertEquals(100.0, bancoService.consultarSaldo("cuenta1"));
        assertEquals(150.0, bancoService.consultarSaldo("cuenta1"));
    }

    @Test
    void testOrdenDeLlamadas() {
        when(repositorio.obtenerSaldo("cuenta1")).thenReturn(100.0);
        bancoService.depositar("cuenta1", 50.0);
        InOrder inOrder = inOrder(repositorio);
        inOrder.verify(repositorio).obtenerSaldo("cuenta1");
        inOrder.verify(repositorio).actualizarSaldo("cuenta1", 150.0);
    }

    @Test
    void testSpy() {
        when(repositorio.obtenerSaldo("cuenta1")).thenReturn(500.0);
        double saldo = bancoSpy.consultarSaldo("cuenta1");
        assertEquals(500.0, saldo);
    }
}
```
</details>

---

## Tecnologías

- Java 21
- JUnit 5
- Mockito 5.12.0
- Maven
- IntelliJ IDEA
