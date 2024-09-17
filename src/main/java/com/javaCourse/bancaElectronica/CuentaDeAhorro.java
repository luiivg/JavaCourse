package com.javaCourse.bancaElectronica;

public class CuentaDeAhorro extends Cuenta {

    private double tasaInteresMensual;

    public CuentaDeAhorro(int numero, String fechaApertura, double saldo, String fechaCancelacion, double tasaInteresMensual) {
        super(numero, fechaApertura, saldo, fechaCancelacion);
        this.tasaInteresMensual = tasaInteresMensual;
    }

    public double getTasaInteresMensual() {
        return tasaInteresMensual;
    }

    public void setTasaInteresMensual(double tasaInteresMensual) {
        this.tasaInteresMensual = tasaInteresMensual;
    }
    public double calcularInterses(){
        return 0;
    }

    @Override
    public String toString() {
        return "CuentaDeAhorro{" +
                "tasaInteresMensual=" + tasaInteresMensual +
                '}';
    }
}
