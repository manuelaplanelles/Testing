package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Pedido {
    private HashMap<Producto, Integer> pedido;
    private double importe_total;

    public Pedido() {
        this.pedido = new HashMap<>();
        this.importe_total = 0;
    }


    public void aplicarPromo3x2() {
        for (Map.Entry<Producto, Integer> entry : pedido.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();

            if (cantidad % 3 == 0) {
                int unidadesGratis = cantidad / 3;
                double descuento = unidadesGratis * producto.getPrecio();
                importe_total = importe_total - descuento;
            }
        }
    }

    public void aplicarPromo10() {
        double descuento = importe_total * 0.10;
        importe_total = importe_total - descuento;
    }

    public void mostrarResumen() {
        System.out.println("RESUMEN DE TU CARRITO DE LA COMPRA:");
        System.out.println("Productos:");
        for (Map.Entry<Producto, Integer> entry : pedido.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey() + " " + entry.getKey().getPrecio());
        }
        System.out.println("IMPORTE TOTAL: " + importe_total + "€");;
    }
    public void mostrarResumenOrdenado() {
        System.out.println("RESUMEN DE TU CARRITO DE LA COMPRA:");
        System.out.println("Productos ordenados por uds:");
        List<Map.Entry<Producto, Integer>> lista = new ArrayList<>(pedido.entrySet());
        lista.sort((e1, e2) -> e2.getValue() - e1.getValue());
        for (Map.Entry<Producto, Integer> entry : lista) {
            System.out.println(entry.getValue() + " " + entry.getKey() + "\t" + entry.getKey().getPrecio());
        }
        System.out.printf("IMPORTE TOTAL: %.2f€%n", importe_total);
    }


    public HashMap<Producto, Integer> getPedido() {
        return pedido;
    }

    public void setPedido(HashMap<Producto, Integer> pedido) {
        this.pedido = pedido;
    }

    public double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "pedido=" + pedido +
                ", importe_total=" + importe_total +
                '}';
    }
}
