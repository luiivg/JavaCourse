package com.javaCourse.bancaElectronica;

public class ServicioPractica4 {

    public void practica4() {
        /*Si quiero crear un objeto sin todos los parametros debo agregar en la clase que define el objeto (Cliente) las
        anotaciones de los constructores*/
        Cliente clienteBuilder = Cliente.builder()
                .numero(1020464)
                .nombre("Cristian")
                .build();


        System.out.println("\n------------------------------------ PRACTICA 4 ------------------------------------\n" +
                "Cliente Creado con Builder: "+clienteBuilder);
    }
}
