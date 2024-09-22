package com.javaCourse.bancaElectronica;


import lombok.Data;

import java.util.TreeSet;

@Data
public class Banco implements ServicioClientes{

    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private TreeSet<Cliente> clientes;

    public Banco(String nombre, Domicilio domicilio, String rfc, String telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.telefono = telefono;
        this.clientes = new TreeSet<>();
    }


    @Override
    public boolean agregarCliente(Cliente cliente) {
        for (Cliente client : clientes) {
            if (client.getNumero() == cliente.getNumero()) {
                System.out.println("El cliente " + cliente.getNumero() + " ya esta en el banco");
                return false;
            }
        }
        clientes.add(cliente);
        System.out.println("El cliente " + cliente.getNumero() + " ha sido agregado exitosamente");
        return true;
    }

    @Override
    public boolean eliminarCliente(int numero) {
        for (Cliente cliente : clientes) {
            if (cliente.getNumero() == numero) {
                clientes.remove(cliente);
                System.out.println("Cliente " + cliente.getNumero() +" eliminado exitosamente");
                return true;
            }
        }
        System.out.println("El cliente " + numero + " no existe en el banco");
        return false;
    }

    @Override
    public Cliente consultarCliente(int numero) {

        for (Cliente cliente : clientes) {
            if (cliente.getNumero() == numero) {
                System.out.println("Cliente encontrado " + cliente.getNumero() + " " + cliente.getNombre());
                return cliente;
            }
        }
        System.out.println("Cliente no encontrado " + numero);
        return null;

    }

    @Override
    public TreeSet<Cliente> obtenerClientes() {
        System.out.println("LISTA DE CLIENTES:");
        if (clientes != null && clientes.size()>0) {
            for(Cliente cliente : clientes) {
                System.out.println("Documento: " + cliente.getNumero() + " Nombre: " + cliente.getNombre());
            }
            return clientes;
        }else {
            System.out.println("No hay clientes");
            return null;
        }
    }

    @Override
    public Cliente buscarClientePorRFC(String rfc) {
        for (Cliente cliente : clientes) {
            if (cliente.getRfc().equals(rfc)) {
                System.out.println("Cliente encontrado " + cliente.getNumero() + " " + cliente.getNombre() +" con RFC " + rfc);
                return cliente;
            }
        }
        System.out.println("Cliente no encontrado con RFC ingresado " + rfc);
        return null;
    }
}
