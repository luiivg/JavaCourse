package com.javaCourse.bancaElectronica;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CuentaDeAhorro extends Cuenta {

    private double tasaInteresMensual;

    public CuentaDeAhorro(int numero, String fechaApertura, double saldo, String fechaCancelacion, double tasaInteresMensual) {
        super(numero, fechaApertura, saldo, fechaCancelacion);
        this.tasaInteresMensual = tasaInteresMensual;
    }

    public double calcularInterses(){
        return 0;
    }

}
