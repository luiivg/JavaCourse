package com.javaCourse.bancaElectronica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Cuenta implements Comparable<Cuenta>{

    private int numero;
    private String fechaApertura;
    private double saldo;
    private String fechaCancelacion;

    @Override
    public int compareTo(Cuenta cuenta) {
        return Double.compare(this.saldo, cuenta.getSaldo());
    }

}
