package com.javaCourse.bancaElectronica;

import java.util.ArrayList;

public interface ServicioClientes {
    public boolean agregarCliente(Cliente cliente);
    public boolean eliminarCliente(int numero);
    public Cliente consultarCliente(int numero);
    public ArrayList<Cliente> obtenerClientes();
    public Cliente bucarClientePorRFC(String rfc);


}
