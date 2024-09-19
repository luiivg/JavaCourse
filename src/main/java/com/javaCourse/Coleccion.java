package com.javaCourse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Coleccion {
    public static void main(String[] args){
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        long inicio;
        int indice = 10;

        for(int i = 0; i < 1_000_000; i++)
        {
            arrayList.add("Cadena numero: " + i);
            linkedList.add("Cadena numero: " + i);
        }

        System.out.println("-------------------------------- Agregar elemento --------------------------------");
        System.out.println("Tiempo invertido en insertar una cadena usando ArrayList");
        inicio = System.nanoTime(); //Tiempo inicial
        //Linea 1
        arrayList.add(indice,"Otra cadena por agregar");//insertar en el indice especificado
        System.out.println(System.nanoTime() - inicio);//imprimeri tiempo de insercion

        System.out.println("Tiempo invertido en insertar una cadena usando LinkedList");
        inicio = System.nanoTime(); // Tiempo inicial
        //Linea 2
        linkedList.add(indice, "Otra cadena por agregar");
        System.out.println(System.nanoTime() - inicio);

        System.out.println("\n-------------------------------- Remover elemento --------------------------------");
        //remover un elemento
        System.out.println("Tiempo invertido en eliminar una cadena usando ArrayList");
        inicio = System.nanoTime();
        arrayList.remove(indice);
        System.out.println(System.nanoTime() - inicio);

        System.out.println("Tiempo invertido en eliminar una cadena usando LinkedList");
        inicio = System.nanoTime();
        linkedList.remove(indice);
        System.out.println(System.nanoTime() - inicio);

        System.out.println("\n-------------------------------- Recuperar elemento --------------------------------");
        //Recuperar un elemento
        System.out.println("Tiempo invertido en recuperar una cadena usando ArrayList");
        inicio = System.nanoTime();
        String elementoRecuperado = arrayList.get(indice);
        System.out.println(System.nanoTime() - inicio);

        System.out.println("Tiempo invertido en recuperar una cadena usando LinkedList");
        inicio = System.nanoTime();
        elementoRecuperado = linkedList.get(indice);
        System.out.println(System.nanoTime() - inicio);
    }
}
