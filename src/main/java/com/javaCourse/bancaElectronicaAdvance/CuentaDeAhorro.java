package com.javaCourse.bancaElectronicaAdvance;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CuentaDeAhorro extends Cuenta {

    private double tasaInteresMensual;

    public CuentaDeAhorro(int numero, LocalDate fechaApertura, double saldo, LocalDate fechaCancelacion, double tasaInteresMensual) {
        super(numero, fechaApertura, saldo, fechaCancelacion);
        this.tasaInteresMensual = tasaInteresMensual;
    }

    public double calcularInterses(){
        return 0;
    }

}
