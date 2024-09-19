package com.javaCourse.bancaElectronica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Domicilio {

    private String calle;
    private int numero;
    private String colonia;
    private String estado;
    private int codigoPostal;

}
