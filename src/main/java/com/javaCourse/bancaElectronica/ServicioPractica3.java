package com.javaCourse.bancaElectronica;

import java.util.Collections;
import java.util.List;

public class ServicioPractica3 {

    public void practica3(List<Cliente> clientes){
        Collections.sort(clientes); //ordeno clientes basados en el metodo creado en la clase cliente : compareTo

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            Collections.sort(cliente.getCuentas());
            for(Cuenta cuentasPorCliente : cliente.getCuentas()) {
                System.out.println("\t" + cuentasPorCliente);
            }
    }



    }
}
