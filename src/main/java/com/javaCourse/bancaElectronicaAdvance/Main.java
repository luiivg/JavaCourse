package com.javaCourse.bancaElectronicaAdvance;

import com.javaCourse.bancaElectronica.Domicilio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Domicilio domicilioBanco = new Domicilio("avenida", 48, "Sur", "Antioquia",
                50);
        Domicilio domicilioCliente = new Domicilio("calle", 43, "norte", "Bello",
                51);
        Domicilio domicilioCliente1 = new Domicilio("carrera", 72, "centro", "Medellin",
                501021);

        Cliente cliente1 = new Cliente(1001, "Luisa", domicilioCliente, "RFC1", "300597124879",
                "1994/11/29");
        Cliente cliente2 = new Cliente(1001, "Andrea", domicilioCliente, "RFC12", "3204563148",
                "1989/01/06");
        Cliente cliente3 = new Cliente(2001, "Fernando", domicilioCliente, "RFC2", "3109754852",
                "1999/06/15");
        Cliente cliente4 = new Cliente(3001, "Paola", domicilioCliente, "RFC3", "314596897164",
                "2003/09/18");

        Banco banco = new Banco("Bancolombia", domicilioBanco, "RFC123-4", "6045109000");


        LocalDate fechaApertura =LocalDate.of(2023,10,15);
        LocalDate fechaApertura1 =LocalDate.of(2016,1,26);
        LocalDate fechaApertura2 =LocalDate.of(2023,4,30);
        CuentaDeAhorro cuentaDeAhorro = new CuentaDeAhorro(1001, fechaApertura, 180.000,
                null, 1.5);
        CuentaDeAhorro cuentaDeAhorro1 = new CuentaDeAhorro(1002, fechaApertura1, 15.000,
                null, 1.5);


        CuentaDeCheque cuentaDeCheque = new CuentaDeCheque(2001, fechaApertura, 1.100,
                null, 0.4);
        CuentaDeCheque cuentaDeCheque1 = new CuentaDeCheque(2002, fechaApertura2, 1.100,
                null, 0.4);

        /*PRACTICA 7*
         */
        ServicioPractica7 servicioPractica7 = new ServicioPractica7();
        servicioPractica7.practica7(cliente1, cliente2, cliente3, cliente4, banco, cuentaDeAhorro,
                cuentaDeAhorro1, cuentaDeCheque, cuentaDeCheque1);

        /* PRACTICA 8
         */
        System.out.println("\n---------------- PRACTICA 8 - Manejo de Archivos ----------------");

        //Creación de Clientes
        Cliente cliente5 = new Cliente(1, "Lina", domicilioCliente1, "RFC001", "3005674896", "1989/08/13");
        Cliente cliente6 = new Cliente(2, "Cristian", domicilioCliente, "RFC002", "3508915496", "1986/04/16");
        Cliente cliente7 = new Cliente(3, "Cristina", domicilioCliente1, "RFC003", "35089415736", "1998/12/26");

        final String rutaArchivo = "../JavaCourse/src/main/resources/cuentas.txt";
        ServicioPractica8 servicioPractica8 = new ServicioPractica8();
        servicioPractica8.asignarCuentasClientes(
                servicioPractica8.leerArchivo(rutaArchivo),cliente5,cliente6,cliente7
        );

    }
}
