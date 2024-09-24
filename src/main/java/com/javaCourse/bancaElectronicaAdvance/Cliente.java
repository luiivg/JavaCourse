package com.javaCourse.bancaElectronicaAdvance;


import com.javaCourse.bancaElectronica.Domicilio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor()
@NoArgsConstructor
public class Cliente implements ServicioCuentas {

    private int numero;
    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private List<Cuenta> cuentas;
    private LocalDate fechaNacimiento;


    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    public Cliente(int numero, String nombre, Domicilio domicilio, String rfc, String telefono,  String fechaNacimiento) {
        this.numero = numero;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.telefono = telefono;
        this.cuentas = new ArrayList<>();
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatter);
    }

    @Override
    public boolean agregarCuenta(Cuenta cuenta) {
        boolean respuesta = cuentas.stream()
                .noneMatch(t->t.getNumero() == cuenta.getNumero());
        if(!respuesta){
            System.out.println("La Cuenta ya existe");
            return false;
        }else{
            return cuentas.add(cuenta);
        }
    }

    @Override
    public boolean cancelarCuenta(int numeroCuenta) {
        Optional<Cuenta> c = cuentas.stream()
                .filter(e -> e.getNumero() ==numeroCuenta)
                .findFirst();
        if(c.isPresent()) {
            c.get().setFechaCancelacion(LocalDate.now());
            System.out.println("Cuenta cancelada: " + c.get());
            return true;
        }else{
            System.out.println("Cuenta no encontrado: " + numeroCuenta);
            return false;
        }
    }

    @Override
    public void abonarCuenta(int numeroCuenta, double abono) {
        cuentas.stream()
                .filter(c -> c.getNumero() == numeroCuenta)
                .findFirst()
                .ifPresentOrElse(cuenta -> {
                    cuenta.setSaldo(cuenta.getSaldo() + abono);
                    System.out.println("Se abonaron " + abono + " a la cuenta: " + numeroCuenta);
                }, () -> System.out.println("Cuenta no encontrada: " + numeroCuenta));
    }

    @Override
    public void retirar(int numeroCuenta, double retiro) {
        cuentas.stream()
                .filter(c -> c.getNumero() == numeroCuenta)
                .findFirst()
                .ifPresentOrElse(cuenta -> {
                    if (cuenta.getSaldo() >= retiro) {
                        cuenta.setSaldo(cuenta.getSaldo() - retiro);
                        System.out.println("Se retiraron " + retiro + " de la cuenta: " + numeroCuenta);
                    } else {
                        System.out.println("Saldo insuficiente en la cuenta: " + numeroCuenta);
                    }
                }, () -> System.out.println("Cuenta no encontrada: " + numeroCuenta));
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        System.out.println("Lista de Cuentas...");
        cuentas.forEach(System.out::println);
        return cuentas;
    }
}
