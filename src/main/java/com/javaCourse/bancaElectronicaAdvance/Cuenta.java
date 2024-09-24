package com.javaCourse.bancaElectronicaAdvance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Cuenta implements Comparable<Cuenta>{

    private int numero;
    private LocalDate fechaApertura;
    private double saldo;
    private LocalDate fechaCancelacion;

    @Override
    public int compareTo(Cuenta cuenta) {
        return Double.compare(this.saldo, cuenta.getSaldo());
    }

}
