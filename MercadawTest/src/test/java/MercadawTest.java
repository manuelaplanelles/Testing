import org.example.Cliente;
import org.example.Mercadaw;
import org.example.Pedido;
import org.example.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MercadawTest {
    private Cliente cliente;
    private Pedido pedido;

    @BeforeEach
    public void inicioPruebas() {
        cliente = new Cliente("manuela", "1234");
        cliente.crearPedido();
        pedido = cliente.getPedido();
    }

    // Test 1 — Inserción de producto existente
    @Test
    public void testInsertarProductoExistente() {
        cliente.insertarProducto("manzanas");
        assertTrue(pedido.getPedido().containsKey(Producto.MANZANAS));
    }

    // Test 2 — Producto inexistente no se añade
    @Test
    public void testInsertarProductoInexistente() {
        cliente.insertarProducto("xyz");
        assertTrue(pedido.getPedido().isEmpty());
    }

    // Test 3 — Cálculo de importe
    @Test
    public void testCalculoImporte() {
        cliente.insertarProducto("manzanas"); // 2.30
        cliente.insertarProducto("pan");      // 1.00
        pedido.setImporte_total(cliente.importePedido());
        assertEquals(3.30, pedido.getImporte_total(), 0.01);
    }

    // Test 4 — Promoción 3x2
    @Test
    public void testPromo3x2() {
        cliente.insertarProducto("pan"); // 1.00
        cliente.insertarProducto("pan");
        cliente.insertarProducto("pan"); // 3 unidades → 1 gratis
        pedido.setImporte_total(cliente.importePedido()); // 3.00
        pedido.aplicarPromo3x2(); // descuento 1.00
        assertEquals(2.00, pedido.getImporte_total(), 0.01);
    }

    // Test 5 — Descuento 10%
    @Test
    public void testPromo10() {
        cliente.insertarProducto("arroz"); // 3.50
        pedido.setImporte_total(cliente.importePedido()); // 3.50
        pedido.aplicarPromo10(); // 10% descuento
        assertEquals(3.15, pedido.getImporte_total(), 0.01);
    }

    // Test 6 — Promociones combinadas 3x2 + 10%
    @Test
    public void testPromocionesCombinadas() {
        cliente.insertarProducto("pan");
        cliente.insertarProducto("pan");
        cliente.insertarProducto("pan"); // 3x2 → paga 2 = 2.00
        pedido.setImporte_total(cliente.importePedido()); // 3.00
        pedido.aplicarPromo3x2(); // 2.00
        pedido.aplicarPromo10(); // 1.80
        assertEquals(1.80, pedido.getImporte_total(), 0.01);
    }

    // Test 7 — Autenticación correcta
    @Test
    public void testAutenticacionCorrecta() {
        Mercadaw.setClientes(new java.util.ArrayList<>());
        Mercadaw.getClientes().add(new Cliente("manuela", "1234"));
        boolean encontrado = false;
        for (Cliente c : Mercadaw.getClientes()) {
            if (c.getUsuario().equals("manuela") && c.getContrasenya().equals("1234")) {
                encontrado = true;
            }
        }
        assertTrue(encontrado);
    }

    // Test 8 — Insertar mismo producto dos veces suma cantidad
    @Test
    public void testInsertarProductoRepetido() {
        cliente.insertarProducto("manzanas");
        cliente.insertarProducto("manzanas");
        assertEquals(2, pedido.getPedido().get(Producto.MANZANAS));
    }

    // Test 9 — Getters y setters de Cliente
    @Test
    public void testGettersSettersCliente() {
        cliente.setDireccion("Calle Nueva, 1");
        assertEquals("Calle Nueva, 1", cliente.getDireccion());
        cliente.setPromociones(true);
        assertTrue(cliente.isPromociones());
    }

    // Test 10 — Getters y setters de Pedido
    @Test
    public void testGettersSettersPedido() {
        pedido.setImporte_total(10.00);
        assertEquals(10.00, pedido.getImporte_total(), 0.01);
    }

    // Test 11 — mostrarResumen no lanza excepcion
    @Test
    public void testMostrarResumen() {
        cliente.insertarProducto("leche");
        pedido.setImporte_total(cliente.importePedido());
        assertDoesNotThrow(() -> pedido.mostrarResumen());
    }

    // Test 12 — mostrarResumenOrdenado no lanza excepcion
    @Test
    public void testMostrarResumenOrdenado() {
        cliente.insertarProducto("leche");
        cliente.insertarProducto("pan");
        pedido.setImporte_total(cliente.importePedido());
        assertDoesNotThrow(() -> pedido.mostrarResumenOrdenado());
    }

}