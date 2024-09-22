package com.javaCourse.bancaElectronicaAdvance;

import com.javaCourse.bancaElectronica.Domicilio;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Banco implements ServicioClientes {

    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private List<Cliente> clientes;

    public Banco(String nombre, Domicilio domicilio, String rfc, String telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.telefono = telefono;
        this.clientes = new ArrayList<>();
    }


    @Override
    public boolean agregarCliente(Cliente cliente) {
        boolean respuesta = clientes.stream()
                .noneMatch(t->t.getNumero() == cliente.getNumero());
        if(!respuesta){
            System.out.println("El cliente ya existe");
            return false;
        }else{
            return clientes.add(cliente);
        }
    }

    @Override
    public boolean eliminarCliente(int numeroIdentificacion) {
        Optional<Cliente> c = clientes.stream()
                .filter(e -> e.getNumero() ==numeroIdentificacion)
                .findFirst();
        if(c.isPresent()) {
            clientes.remove(c.get());
            System.out.println("Cliente eliminado: " + c.get());
            return true;
        }else{
            System.out.println("Cliente no encontrado: " + numeroIdentificacion);
            return false;
        }
    }

    @Override
    public Cliente consultarCliente(int numeroIdentificacion) {
        Optional<Cliente> c = clientes.stream()
                .filter(e -> e.getNumero() == numeroIdentificacion)
                .findAny();
        if (c.isPresent()) {
            System.out.println("Cliente encontrado " + c.get().getNumero() + " " + c.get().getNombre());
        }else{
            System.out.println("Cliente no encontrado " + numeroIdentificacion);
        }
        return c.get();

    }

    @Override
    public List<Cliente> obtenerClientes() {
        System.out.println("lista de clientes encontrados");
        clientes.forEach(System.out::println);
        return clientes;
    }

    @Override
    public Cliente buscarClientePorRFC(String rfc) {
        return clientes.stream()
                .filter(c -> c.getRfc().equals(rfc))
                .peek(c -> System.out.println("Cliente encontrado : " +c.getNombre()))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Cliente no encontrado por RFC: " + rfc);
                    return null;
                });
    }
}
