package com.javaCourse.bancaElectronicaAdvance;

import com.javaCourse.bancaElectronica.CuentaDeAhorro;
import com.javaCourse.bancaElectronica.CuentaDeCheque;


public class ServicioPractica7{

    public void practica7(Cliente cliente1, Cliente cliente2, Cliente cliente3, Cliente cliente4, Banco banco,
                          CuentaDeAhorro cuentaDeAhorro, CuentaDeAhorro cuentaDeAhorro1, CuentaDeCheque cuentaDeCheque,
                          CuentaDeCheque cuentaDeCheque1){


        System.out.println("\n------------------------- PRACTICA 7 -------------------------");
        //Agregar Cliente
        System.out.println("----------------------Agregar Clientes Ok--------------------");
        banco.agregarCliente(cliente1);
        banco.agregarCliente(cliente2);
        banco.agregarCliente(cliente3);
        banco.agregarCliente(cliente4);

        //Consultar cliente
        System.out.println("----------------------Consultar Cliente Ok--------------------");
        banco.consultarCliente(2001);

        //Obtener lista de clientes
        System.out.println("------------------- Lista de Clientes ------------------------");
        banco.obtenerClientes();

        System.out.println("------------------- Eliminar Cliente ------------------------");
        banco.eliminarCliente(3001);

        //Consultar cliente por RFC
        System.out.println("----------------------Buscar Cliente RFC--------------------");
        banco.buscarClientePorRFC("RFC1");


        System.out.println("\n--------------------------Cuentas--------------------------");
        //pruebas de Cuentas
        //Obtener cuentas:
        System.out.println("--------------------Obtener Cuentas Error-------------------");
        cliente4.obtenerCuentas();

        //Agregar Cliente
        System.out.println("---------------------Agregar Cuentas Ok--------------------");
        cliente1.agregarCuenta(cuentaDeAhorro);
        //Prueba que una cuenta la puede tener mas de un cliente
        cliente3.agregarCuenta(cuentaDeAhorro);
        cliente3.agregarCuenta(cuentaDeAhorro1);
        cliente1.agregarCuenta(cuentaDeCheque);
        cliente1.agregarCuenta(cuentaDeCheque1);

        System.out.println("----------------------Agregar Cuentas Error--------------------");
        //Prueba que a un cliente no se le puede agregar una cuenta con el mismo numero
        cliente1.agregarCuenta(cuentaDeAhorro);

        //Obtener cuentas existentes
        System.out.println("--------------------Obtener Cuentas Ok-------------------");
        cliente3.obtenerCuentas();

        //Cancelar cuenta que no existe para ese cliente
        System.out.println("----------------------Cancelar Cuenta Error--------------------");
        cliente1.cancelarCuenta(1002);
        //Cancelar cuenta existente
        System.out.println("----------------------Cancelar Cuenta Ok--------------------");
        cliente3.cancelarCuenta(1002);

        //Obtener cuentas despues de haber cancelado una
        System.out.println("--------------------Obtener cuentas ok-------------------");
        cliente3.obtenerCuentas();

        //Realizar abonos
        System.out.println("--------------------Abonar a cuentas ok-------------------");
        cliente1.abonarCuenta(2002,203.500);

        //Realizar abonos a cuenta no existente
        System.out.println("--------------------Abonar a cuentas Error-------------------");
        cliente1.abonarCuenta(1002,600.500);

        //Realizar retiros
        System.out.println("--------------------Retirar de cuentas Ok-------------------");
        cliente1.retirar(2002, 200);

        //Realizar retiros sin saldo suficiente
        System.out.println("--------------------Retirar de cuentas Error-------------------");
        cliente1.retirar(2002, 500);

        //Realizar retiros a cuenta que no existe
        System.out.println("--------------------Retirar de cuentas Error-------------------");
        cliente1.retirar(3002, 500);


    }
}
