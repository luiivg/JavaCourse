package com.javaCourse.bancaElectronica;

import java.util.ArrayList;

public interface ServicioCuentas {
    public boolean agregarCuenta(Cuenta cuenta);
    public boolean cancelarCuenta(int numeroCuenta);
    public void abonarCuenta(int numeroCuenta, double abono);
    public void retirar(int numeroCuenta, double retiro);
    public ArrayList<Cuenta> obetenerCuentas();
}
