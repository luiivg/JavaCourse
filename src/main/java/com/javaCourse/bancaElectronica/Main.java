package com.javaCourse.bancaElectronica;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Domicilio domicilioBanco = new Domicilio("avenida",48,"Sur","Antioquia",
                50);

        Domicilio domicilioCliente = new Domicilio("calle", 43, "norte", "Antioquia",
                51);

        Cliente cliente1 = new Cliente(1,"Luisa",domicilioCliente,"RFC1","3008911155",
                "1994/10/11");

        Banco banco = new Banco ("Bancolombia",domicilioBanco,"RFC123-4", "6048715259");

        CuentaDeAhorro cuentaDeAhorro = new CuentaDeAhorro(1001,"2024/09/13",150.000,
                null, 1.5);

        CuentaDeCheque cuentaDeCheque = new CuentaDeCheque(2001,"2024/09/12",1.100,
                null, 0.4);

        cliente1.agregarCuenta(cuentaDeAhorro);
        cliente1.agregarCuenta(cuentaDeCheque);

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);

        banco.setClientes(clientes);

        for(Cliente cliente : clientes) {
            System.out.println("Señor/a " + cliente.getNombre() + ". Usted esta registrado en el banco: "+
                    banco.getNombre() + ", y acá tiene la siguiente cantidad de cuentas: " +
                    cliente.getCuentas().size() + "\nLa información de esas cuentas es la siguiente:");
            for (Cuenta cuenta : cliente.getCuentas()) {
                System.out.println("\nnumero: " + cuenta.getNumero() +
                        "\nFecha de apertura: " + cuenta.getFechaApertura() + "\nSaldo: " +
                        cuenta.getSaldo() +"\n--------------------------------------");
            }

        }
    }
}
