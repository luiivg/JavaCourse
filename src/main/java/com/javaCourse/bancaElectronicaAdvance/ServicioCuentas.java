package com.javaCourse.bancaElectronicaAdvance;


import java.util.List;

public interface ServicioCuentas {
    boolean agregarCuenta(Cuenta cuenta);
    boolean cancelarCuenta(int numeroCuenta);
    void abonarCuenta(int numeroCuenta, double abono);
    void retirar(int numeroCuenta, double retiro);
    List<Cuenta> obtenerCuentas();
}
