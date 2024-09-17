package com.javaCourse.bancaElectronica;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Domicilio domicilioBanco = new Domicilio("avenida",48,"Sur","Antioquia",
                50);

        Domicilio domicilioCliente = new Domicilio("calle", 43, "norte", "Antioquia",
                51);

        Cliente cliente1 = new Cliente(1001,"Luisa",domicilioCliente,"RFC1","3008911155",
                "1994/10/11");
        Cliente cliente2 = new Cliente(1001,"Andrea",domicilioCliente,"RFC12","3008911155",
                "1994/10/11");
        Cliente cliente3 = new Cliente(2001,"Fernando",domicilioCliente,"RFC2","3008911155",
                "1994/10/11");
        Cliente cliente4 = new Cliente(3001,"Paola",domicilioCliente,"RFC3","3008911155",
                "1994/10/11");

        Banco banco = new Banco ("Bancolombia",domicilioBanco,"RFC123-4", "6048715259");

        CuentaDeAhorro cuentaDeAhorro = new CuentaDeAhorro(1001,"2024/09/13",150.000,
                null, 1.5);
        CuentaDeAhorro cuentaDeAhorro1 = new CuentaDeAhorro(1002,"2024/09/13",150.000,
                null, 1.5);


        CuentaDeCheque cuentaDeCheque = new CuentaDeCheque(2001,"2024/09/12",1.100,
                null, 0.4);
        CuentaDeCheque cuentaDeCheque1 = new CuentaDeCheque(2002,"2024/09/12",1.100,
                null, 0.4);

        //pruebas de cliente
        System.out.println("----------------------Obtener Clientes Error--------------------");
        banco.obtenerClientes();

        //Agregar Cliente
        System.out.println("----------------------Agregar Clientes Ok--------------------");
        banco.agregarCliente(cliente1);
        banco.agregarCliente(cliente3);
        banco.agregarCliente(cliente4);

        //prueba de no permitir clientes duplicados
        System.out.println("----------------------Agregar Clientes Error--------------------");
        banco.agregarCliente(cliente2);

        //consultar clientes
        System.out.println("----------------------Obtener Clientes Ok--------------------");
        banco.obtenerClientes();

        //Eliminar Cliente
        System.out.println("----------------------Eliminar Clientes Ok--------------------");
        banco.eliminarCliente(3001);

        //eliminar cliente que no existe
        System.out.println("----------------------Eliminar Clientes Error--------------------");
        banco.eliminarCliente(3002);

        //Obtener clientes despues de haber eliminado
        System.out.println("----------------------Obtener Clientes Ok--------------------");
        banco.obtenerClientes();

        //Consultar cliente eliminado
        System.out.println("----------------------Consultar Cliente Error--------------------");
        banco.consultarCliente(3001);

        //Consultar cliente
        System.out.println("----------------------Consultar Cliente Ok--------------------");
        banco.consultarCliente(2001);

        //Consultar cliente por RFC que no existe
        System.out.println("----------------------Buscar Cliente RFC Error--------------------");
        banco.buscarClientePorRFC("RFC5000");

        //Consultar cliente por RFC
        System.out.println("----------------------Buscar Cliente RFC Ok--------------------");
        banco.buscarClientePorRFC("RFC1");


        cliente1.agregarCuenta(cuentaDeAhorro);
        //Prueba que a un cliente no se le puede agregar una cuenta con el mismo numero
        cliente1.agregarCuenta(cuentaDeAhorro);
        //Prueba que una cuenta la puede tener mas de un cliente
        cliente3.agregarCuenta(cuentaDeAhorro);
        cliente3.agregarCuenta(cuentaDeAhorro1);
        cliente1.agregarCuenta(cuentaDeCheque);
        cliente1.agregarCuenta(cuentaDeCheque1);



    }
}
