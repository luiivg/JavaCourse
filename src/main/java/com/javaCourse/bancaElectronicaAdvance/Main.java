package com.javaCourse.bancaElectronicaAdvance;

import com.javaCourse.bancaElectronica.CuentaDeAhorro;
import com.javaCourse.bancaElectronica.CuentaDeCheque;
import com.javaCourse.bancaElectronica.Domicilio;

public class Main {
    public static void main(String[] args) {

        Domicilio domicilioBanco = new Domicilio("avenida", 48, "Sur", "Antioquia",
                50);
        Domicilio domicilioCliente = new Domicilio("calle", 43, "norte", "Bello",
                51);
        Domicilio domicilioCliente1 = new Domicilio("carrera", 72, "centro", "Medellin",
                501021);

        Cliente cliente1 = new Cliente(1001, "Luisa", domicilioCliente, "RFC1", "300597124879",
                "1994/10/11");
        Cliente cliente2 = new Cliente(1001, "Andrea", domicilioCliente, "RFC12", "3204563148",
                "1994/10/11");
        Cliente cliente3 = new Cliente(2001, "Fernando", domicilioCliente, "RFC2", "3109754852",
                "1994/10/11");
        Cliente cliente4 = new Cliente(3001, "Paola", domicilioCliente, "RFC3", "314596897164",
                "1994/10/11");

        Banco banco = new Banco("Bancolombia", domicilioBanco, "RFC123-4", "6045109000");

        CuentaDeAhorro cuentaDeAhorro = new CuentaDeAhorro(1001, "2024/09/13", 180.000,
                null, 1.5);
        CuentaDeAhorro cuentaDeAhorro1 = new CuentaDeAhorro(1002, "2024/09/13", 15.000,
                null, 1.5);


        CuentaDeCheque cuentaDeCheque = new CuentaDeCheque(2001, "2024/09/12", 1.100,
                null, 0.4);
        CuentaDeCheque cuentaDeCheque1 = new CuentaDeCheque(2002, "2024/09/12", 1.100,
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
        Cliente cliente5 = new Cliente(1, "Lina", domicilioCliente1, "RFC001", "3005674896", "13/08/1989");
        Cliente cliente6 = new Cliente(2, "Cristian", domicilioCliente, "RFC002", "3508915496", "16/04/1986");
        Cliente cliente7 = new Cliente(3, "Cristina", domicilioCliente1, "RFC003", "35089415736", "26/12/1998");

        final String rutaArchivo = "../JavaCourse/src/main/resources/cuentas.txt";
        ServicioPractica8 servicioPractica8 = new ServicioPractica8();
        servicioPractica8.asignarCuentasClientes(
                servicioPractica8.leerArchivo(rutaArchivo),cliente5,cliente6,cliente7
        );

    }
}
