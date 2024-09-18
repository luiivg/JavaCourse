package com.javaCourse.bancaElectronica;

import java.util.ArrayList;
import java.util.Date;

public class Cliente implements ServicioCuentas{

    private int numero;
    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private ArrayList<Cuenta> cuentas;
    private String fechaNacimiento;

    public Cliente(int numero, String nombre, Domicilio domicilio, String rfc, String telefono,  String fechaNacimiento) {
        this.numero = numero;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.telefono = telefono;
        this.cuentas = new ArrayList<>();
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    @Override
    public boolean agregarCuenta(Cuenta cuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumero() == cuenta.getNumero()) {
                System.out.println(cuenta.getNumero() + " Cuenta ya existe");
                return false;
            }
        }
        cuentas.add(cuenta);
        System.out.println("Cuenta Agregada: " + cuenta.getNumero());
        return true;
    }

    @Override
    public boolean cancelarCuenta(int numeroCuenta) {
        for (Cuenta cuenta: this.cuentas){
            if (cuenta.getNumero() == numeroCuenta){
                cuenta.setFechaCancelacion(new Date().toString());
                System.out.println("Cuenta Cancelada: " + cuenta.getNumero() + " con fecha de cancelacion " +
                        cuenta.getFechaCancelacion());
                return true;
            }
        }
        System.out.println("No se encontro la cuenta: " + numeroCuenta);
        return false;
    }

    @Override
    public void abonarCuenta(int numeroCuenta, double abono) {
        boolean abonado = false;
        for (Cuenta cuenta: cuentas){
            if (cuenta.getNumero() == numeroCuenta) {
                cuenta.setSaldo(cuenta.getSaldo() + abono);
                System.out.println("Se realizó un abono a la cuenta: " + cuenta.getNumero() + " por un monto de: "+ abono +
                        "  su saldo actual es: " + cuenta.getSaldo());
                abonado =true;
            }
        }
        if(!abonado) {
            System.out.println("No se encontro la cuenta: " + numeroCuenta);
        }
    }

    @Override
    public void retirar(int numeroCuenta, double retiro) {
        boolean cuentaEncontrada = false;
        for (Cuenta cuenta: cuentas){
            if (cuenta.getNumero() == numeroCuenta){
                if (cuenta.getSaldo() >= retiro){
                    cuenta.setSaldo(cuenta.getSaldo() - retiro);
                    System.out.println("Se realizó un retiro de la cuenta: " + cuenta.getNumero() +
                            " por un monto de: "+ retiro + " su saldo actual es: " + cuenta.getSaldo());
                    cuentaEncontrada = true;
                }else{
                    System.out.println("No cuenta con saldo suficiente para hacer el retiro de: " + retiro +
                            " en la cuenta : " + numeroCuenta);
                    cuentaEncontrada = true;
                }
            }
        }
        if(!cuentaEncontrada) {
            System.out.println("No se encontro la cuenta: " + numeroCuenta);
        }
    }

    @Override
    public ArrayList<Cuenta> obetenerCuentas() {
        System.out.println("LISTA DE CUENTAS:");
        if (cuentas != null && cuentas.size()>0) {
            for(Cuenta cuenta : cuentas) {
                System.out.println("Numero de cuenta: " + cuenta.getNumero() + " | Fecha de apertura: " +
                        cuenta.getFechaApertura() + " | Fecha de cancelación " + cuenta.getFechaCancelacion() +
                        " | Saldo: " + cuenta.getSaldo());
            }
            return cuentas;
        }else {
            System.out.println("No hay Cuentas");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", domicilio=" + domicilio +
                ", rfc='" + rfc + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cuentas=" + cuentas +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }

}
