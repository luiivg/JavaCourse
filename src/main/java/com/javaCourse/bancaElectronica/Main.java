package com.javaCourse.bancaElectronica;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /* PRACTICA 1
        * Creacion e Instanciacion de entidades*/
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
        CuentaDeAhorro cuentaDeAhorro1 = new CuentaDeAhorro(1002,"2024/09/13",15.000,
                null, 1.5);


        CuentaDeCheque cuentaDeCheque = new CuentaDeCheque(2001,"2024/09/12",1.100,
                null, 0.4);
        CuentaDeCheque cuentaDeCheque1 = new CuentaDeCheque(2002,"2024/09/12",1.100,
                null, 0.4);


        /* PRACTICA 2
        * Creacion de interfaces y su respectiva implementación*/

        ServicioPractica2 servicioPractica2 = new ServicioPractica2();
        servicioPractica2.practica2(cliente1,cliente2,cliente3,cliente4,banco,cuentaDeAhorro,
                cuentaDeAhorro1,cuentaDeCheque,cuentaDeCheque1);


        /*PRACTICA 3
        * Ejercicio de ordenamiento
        * clientes ordenado por Numero
        * cuentas ordenado por saldo */
        System.out.println("\n---------------------- EJERCICIO DE ORDENAMIENTO :D ----------------------");

        //Creamos lista de clientes
        List<Cliente> clientes =  new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente4);
        clientes.add(cliente3);
        clientes.add(cliente2);

        //llamamos metodo
        ServicioPractica3 servicioPractica3 = new ServicioPractica3();
        servicioPractica3.practica3(clientes);


        /*PRACTICA 4*/
        //CREACION DE CLIENTE CON BUILDER
        ServicioPractica4 servicioPractica4 = new ServicioPractica4();
        servicioPractica4.practica4();



    }
}