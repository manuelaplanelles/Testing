package org.example;

import java.util.List;
import java.util.Scanner;

public class AppZonaClientes {

    private static Cliente cliente;
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Mercadaw.generarClientes();
        autenticacion(Mercadaw.getClientes());
    }

    public static void autenticacion(List<Cliente> clientes) {
        System.out.println("*** COMPRA ONLINE DE MERCADAW ***");
        boolean encontrado = false;
        for (int intentos = 0; intentos < 3; intentos++) {
            System.out.println("Usuario: ");
            String usuarioIntroducido = teclado.next();
            System.out.println("Contraseña: ");
            String contrasenyaIntroducido = teclado.next();

            for (Cliente clienteActual : clientes) {
                if (clienteActual.getUsuario().equals(usuarioIntroducido) &&
                        clienteActual.getContrasenya().equals(contrasenyaIntroducido)) {
                    encontrado = true;
                    cliente = clienteActual;
                }
            }
            if (encontrado) {
                iniciarCompra();
                break;
            } else {
                System.out.println("Algo no coincide o no existe! Vuelve a intentarlo...");
            }
        }
        if (!encontrado) {
            System.out.println("ERROR DE AUTENTICACION.");
        }
    }

    public static void imprimirProductos() {
        System.out.println("Añade productos a tu carrito de la compra...");
        for (Producto producto : Producto.values()) {
            System.out.println(producto + " precio (" + producto.getPrecio() + "€),");
        }
        System.out.println("============================================");
        System.out.println("Elige un producto: ");
    }

    public static void imprimirDespedida() {
        System.out.println("============================================");
        System.out.println("GRACIAS POR SU PEDIDO. Se lo mandaremos a la direccion " + cliente.getDireccion());
    }

    public static void iniciarCompra() {
        cliente.crearPedido();
        System.out.println("BIENVENID@ " + cliente.getUsuario() + "!");

        boolean seguir = true;
        while (seguir) {
            imprimirProductos();
            String productoElegido = teclado.next();
            System.out.println("============================================");

            cliente.insertarProducto(productoElegido);

            System.out.println("Has añadido " + productoElegido.toUpperCase() +
                    " con un precio de " + cliente.importePedido() +
                    "€. Importe total del carrito: " + cliente.importePedido() +
                    "€. ¿Quieres añadir mas productos a tu carrito de la compra? [S/N]: ");
            String respuesta = teclado.next();

            if (!respuesta.equalsIgnoreCase("S")) {
                seguir = false;
                cliente.getPedido().setImporte_total(cliente.importePedido());
                cliente.getPedido().mostrarResumen();

                boolean enMenu = true;
                while (enMenu) {
                    System.out.println("============================================");
                    System.out.println("¿QUE DESEA HACER?");
                    System.out.println("[1]. Aplicar promo.");
                    System.out.println("[2]. Mostrar resumen ordenado por uds.");
                    System.out.println("[3]. Terminar pedido.");
                    System.out.println("============================================");
                    System.out.println("Elige una opcion: ");
                    String opcion = teclado.next();
                    System.out.println("============================================");

                    switch (opcion) {
                        case "1":
                            if (cliente.isPromociones()) {
                                System.out.println("YA HAS APLICADO TUS PROMOS.");
                            } else {
                                cliente.getPedido().aplicarPromo3x2();
                                cliente.getPedido().aplicarPromo10();
                                cliente.setPromociones(true);
                                System.out.println("PROMO 3X2 y 10% APLICADAS.");
                            }
                            cliente.getPedido().mostrarResumen();
                            break;
                        case "2":
                            cliente.getPedido().mostrarResumenOrdenado();
                            break;
                        case "3":
                            enMenu = false;
                            imprimirDespedida();
                            break;
                    }
                }
            }
        }
    }
}