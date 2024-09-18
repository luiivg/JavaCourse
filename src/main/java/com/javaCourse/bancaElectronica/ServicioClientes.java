package com.javaCourse.bancaElectronica;

import java.util.TreeSet;

public interface ServicioClientes {
    boolean agregarCliente(Cliente cliente);
    boolean eliminarCliente(int numeroIdentificacion);
    Cliente consultarCliente(int numeroIdentifia);
    TreeSet<Cliente> obtenerClientes();
    Cliente buscarClientePorRFC(String rfc);


}
