package com.javaCourse.bancaElectronica;

import java.util.ArrayList;

public interface ServicioClientes {
    public boolean agregarCliente(Cliente cliente);
    public boolean eliminarCliente(int numeroIdentificacion);
    public Cliente consultarCliente(int numeroIdentifia);
    public ArrayList<Cliente> obtenerClientes();
    public Cliente buscarClientePorRFC(String rfc);


}
