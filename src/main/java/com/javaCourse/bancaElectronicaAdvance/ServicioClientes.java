package com.javaCourse.bancaElectronicaAdvance;

import java.util.List;

public interface ServicioClientes {
    boolean agregarCliente(Cliente cliente);
    boolean eliminarCliente(int numeroIdentificacion);
    Cliente consultarCliente(int numeroIdentifia);
    List<Cliente> obtenerClientes();
    Cliente buscarClientePorRFC(String rfc);


}
