package com.javaCourse.bancaElectronicaAdvance;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CuentaDeCheque extends Cuenta {

    private double costoManejoMensual;

    public CuentaDeCheque(int numero, LocalDate fechaApertura, double saldo, LocalDate fechaCancelacion, double costoManejoMensual) {
        super(numero, fechaApertura, saldo, fechaCancelacion);
        this.costoManejoMensual = costoManejoMensual;
    }

}
