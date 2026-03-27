package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mercadaw {

    private static List<Cliente> clientes = new ArrayList<>();

    public Mercadaw() {
    }

    public static void generarClientes() {
        String caracter = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        String contructorUsuario = "";
        String contructorContrasenya = "";
        for(int i = 0; i<8; i++){
            contructorContrasenya += caracter.charAt(random.nextInt(0,62));
            contructorUsuario += caracter.charAt(random.nextInt(0,62));
        }
        clientes.add(new Cliente(contructorUsuario, contructorContrasenya));
        System.out.println("Usuario creado: " + contructorUsuario);
        System.out.println("Contraseña creada: " + contructorContrasenya);
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(List<Cliente> clientes) {
        Mercadaw.clientes = clientes;
    }

}
