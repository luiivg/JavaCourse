package com.javaCourse.bancaElectronicaAdvance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ServicioPractica8 {

    int numeroCliente;
    String tipoCuenta;
    int numeroCuenta;
    LocalDate fechaApertura;
    double saldo;
    double tasaInteresMensual;
    double costoManejoMensual;



    public List<String> leerArchivo(String rutaArchivo){
        try{
            List<String> listacuentas = Files.readAllLines(Paths.get(rutaArchivo));
            listacuentas.remove(listacuentas.size()-1);
            System.out.println("Archivo Leido...");
            listacuentas.forEach(System.out::println);
            return listacuentas;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Asignacion de cuentas a clientes
    public void asignarCuentasClientes(List<String> cuentasArchivo, Cliente cliente1, Cliente cliente2, Cliente cliente3){
        for(String cuentaArchivo: cuentasArchivo){
            validarDataArchivo(cuentaArchivo);

            Cuenta cuenta = validarTipoCuenta(tipoCuenta,numeroCuenta, fechaApertura,saldo,tasaInteresMensual,
                    costoManejoMensual);

            switch(numeroCliente){
                case 1: cliente1.agregarCuenta(cuenta); break;
                case 2: cliente2.agregarCuenta(cuenta); break;
                case 3: cliente3.agregarCuenta(cuenta); break;
            }
        }

        System.out.println("\nValidación de cuentas por Cliente:");
        validarCuentasxliente(cliente1,1);
        validarCuentasxliente(cliente2,2);
        validarCuentasxliente(cliente3,3);

        System.out.println("\nListar Clientes con Cuentas: ");
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        clientes.forEach(System.out::println);
    }


    /*Valida la Data que tiene el archivo, asignando valores a las variables/parametros de cuenta
        CA[1234  , 12-11-2021, 323333, 2 , 1]
        CA[123456, 10-01-2020, 54878 , 4 , 2]
        CA[7894  , 05-08-2021, 98745 , 5 , 3]
        CC[65478 , 08-02-2019, 98874 , 200,2]
        CC[65447 , 21-12-2019, 10000 , 300,3]

     Se toma cada linea y se separa por "," y se guarda cada datos como una posicion en una array de String
     de donde luego se toman para ser asignados a las variables con las que se crearan las cuentas de Ahorro y de Cheque
    */
    private void validarDataArchivo(String cuentaArchivo){
    String[] data = cuentaArchivo.trim().split(",");

        String cliente = data[data.length-1];
        numeroCliente = Integer.parseInt(String.valueOf(cliente.trim().charAt(0)));

        String infoCuenta = data[0];
        tipoCuenta = infoCuenta.trim().substring(0,2);

        numeroCuenta = Integer.parseInt(infoCuenta.trim().substring(3));

        //en caso de que la fecha llegue en formato diferente a dd/MM/yyyy
        if(validarFormatoFecha(data[1].trim())){
            fechaApertura = LocalDate.parse(data[1].trim(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }else{
            fechaApertura = LocalDate.parse(data[1].trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        saldo = Double.parseDouble(data[2]);
        tasaInteresMensual = Double.parseDouble(data[3]);
        costoManejoMensual = Double.parseDouble(data[3]);
    }

    /*Valida que tipo de cuenta debe crear de acuerdo a la informacion de archivo
    CA crea una Cuenta de Ahorros
    CC crea una cuenta de Cheque
     */
    private Cuenta validarTipoCuenta(String tipoCuenta, int numeroCuenta, LocalDate fechaApertura, double saldo,
                                     double tasaInteresMensual, double costoManejoMensual){
        if(tipoCuenta.contains("CA")){
            return(new CuentaDeAhorro(numeroCuenta,fechaApertura,saldo,null,tasaInteresMensual));
        }else{
            return(new CuentaDeCheque(numeroCuenta,fechaApertura,saldo,null,costoManejoMensual));
        }
    }

    private void validarCuentasxliente(Cliente clienteConCuentas,int cuentasxCliente){
        if (clienteConCuentas.getCuentas().size()==cuentasxCliente){
            System.out.println("El cliente " + clienteConCuentas.getNumero() + "-" + clienteConCuentas.getNombre() +
                    " cumple con la cantidad de cuentas que debe tener. Cantidad de cuentas: " +
                    clienteConCuentas.getCuentas().size());
        }else{
            System.out.println("El cliente " + clienteConCuentas.getNumero() + "-" + clienteConCuentas.getNombre() +
                    " No cumple con la cantidad de cuentas que debe tener. Cantidad de cuentas: " +
                    clienteConCuentas.getCuentas().size());
        }
    }

    private boolean validarFormatoFecha(String fechastr){
        try{
            LocalDate.parse(fechastr,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return true;
        }catch (DateTimeParseException e){
            return false;
        }

    }
}


