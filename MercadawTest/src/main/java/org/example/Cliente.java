package org.example;

import static org.example.P16_Mercadaw.AppZonaClientes.imprimirProductos;

public class Cliente {
    private String usuario;
    private String contrasenya;
    private String direccion;
    private Pedido pedido;
    private boolean promociones;
    public Cliente(String usuario, String contrasenya){
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.direccion = "Calle falsa, 123";
        this.pedido = null;
        this.promociones = false;
    }
    public void crearPedido(){
        this.pedido = new Pedido();
    }
    public void insertarProducto(String nombreProducto){
        //--
        try {
            Producto producto = Producto.valueOf(nombreProducto.toUpperCase());
            if (pedido.getPedido().containsKey(producto)) {
                pedido.getPedido().put(producto, pedido.getPedido().get(producto) + 1);
            } else {
                pedido.getPedido().put(producto, 1);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("El producto no existe! Elige otro.");
            imprimirProductos();
        }
    }
    public double importePedido(){
        //--
        double total = 0;
        for (java.util.Map.Entry<Producto, Integer> entry : pedido.getPedido().entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue();
        }
        return total;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public boolean isPromociones() {
        return promociones;
    }

    public void setPromociones(boolean promociones) {
        this.promociones = promociones;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "usuario='" + usuario + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", direccion='" + direccion + '\'' +
                ", pedido=" + pedido +
                ", promociones=" + promociones +
                '}';
    }
}
