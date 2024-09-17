package com.javaCourse.bancaElectronica;

import java.util.ArrayList;

public interface ServicioCuentas {
    public boolean agregarCuenta(Cuenta cuenta);
    public boolean cancelarCuenta(int numero);
    public void abonarCuenta(int numero, double abono);
    public void retirar(int numero, double retiro);
    public ArrayList<Cuenta> obetenerCuentas();
}
