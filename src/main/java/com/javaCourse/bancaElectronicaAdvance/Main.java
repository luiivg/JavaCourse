package com.javaCourse.bancaElectronicaAdvance;

import com.javaCourse.bancaElectronica.CuentaDeAhorro;
import com.javaCourse.bancaElectronica.CuentaDeCheque;
import com.javaCourse.bancaElectronica.Domicilio;

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
        CuentaDeAhorro cuentaDeAhorro1 = new CuentaDeAhorro(1002,"2024/09/13",15.000,
                null, 1.5);


        CuentaDeCheque cuentaDeCheque = new CuentaDeCheque(2001,"2024/09/12",1.100,
                null, 0.4);
        CuentaDeCheque cuentaDeCheque1 = new CuentaDeCheque(2002,"2024/09/12",1.100,
                null, 0.4);

        /*PRACTICA 7*
         */
        ServicioPractica7 servicioPractica7 = new ServicioPractica7();
        servicioPractica7.practica7(cliente1,cliente2,cliente3,cliente4,banco,cuentaDeAhorro,
                cuentaDeAhorro1,cuentaDeCheque,cuentaDeCheque1);
    }
}
