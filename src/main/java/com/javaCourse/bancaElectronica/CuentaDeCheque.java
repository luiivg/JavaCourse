package com.javaCourse.bancaElectronica;

public class CuentaDeCheque extends Cuenta{

    private double costoManejoMensual;

    public CuentaDeCheque(int numero, String fechaApertura, double saldo, String fechaCancelacion, double costoManejoMensual) {
        super(numero, fechaApertura, saldo, fechaCancelacion);
        this.costoManejoMensual = costoManejoMensual;
    }

    @Override
    public String toString() {
        return "CuentaDeCheque{" +
                "costoManejoMensual=" + costoManejoMensual +
                '}';
    }
}
