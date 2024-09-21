package com.javaCourse.interfacesFuncionales;

import java.util.function.*;

public class Indoduccion {
    /*
    Reglas de las Interfaces Funcionales
        * Método Abstracto Único: Una interfaz funcional debe tener exactamente un método abstracto. Esto permite que
             se pueda implementar mediante una expresión lambda.
        * Anotación @FunctionalInterface: Aunque no es obligatorio, se recomienda usar esta anotación para indicar que
            la interfaz es funcional. El compilador verifica que cumpla con las reglas de las interfaces funcionales.
        * Métodos Default y Estáticos: Se pueden incluir métodos default y static en una interfaz funcional, ya que
            estos no cuentan como métodos abstractos.

        Las interfaces funcionales son esenciales para trabajar con programación funcional en Java. Entender su
        sintaxis y reglas te permitirá aprovechar al máximo las expresiones lambda y las características de Java 8
        y versiones posteriores.
    */

    /* Declaración Básica:
    @FunctionalInterface
    public interface MiInterface {
        void metodoUnico(); // Método abstracto
    }*/

    /* Implementación con Lambda:
    MiInterface miFuncion = () -> System.out.println("Método ejecutado");
    */

    public static void main(String[] args) {

        /*
        Predicate: la cuál mejora la capacidad de administración del código y ayuda a realizar pruebas dentro del mismo
            - Evalúa una condición (en este caso, si un número es par).
        Function: Toma un argumento y produce un resultado
            - Transforma un dato (de String a Integer, en este caso).
        Consumer: Se puede utilizar como destino de asignación para una expresión Lambda o referencia de método
            - Realiza una acción con un dato sin devolver nada.
        Supplier: Representa una función que no toma ningún argumento, pero produce un valor de tipo T.
            - Proporciona un dato (en este caso, un número aleatorio).
        BiFunction: Recibe dos parámetros de entrada de cualquier tipo de dato y retorna cualquier tipo de dato ((T,U)->R)
            - Opera sobre dos datos y devuelve un resultado.
        */

        // Predicate: representa una función que recibe un entero y devuelve un booleano.
        Predicate<Integer> esPar = n -> n % 2 == 0; // Verifica si un número es par
        int n=4;
        System.out.println("Evaluar si el numero " + n +" es par: "+ esPar.test(n)); // Imprime true porque 4 es par

        // Function: representa una función que toma un String y devuelve un Integer (su longitud).
        //Original: Function<String, Integer> longitud = s -> s.length();
        Function<String, Integer> longitud = String::length; // Calcula la longitud de una cadena - Con Lambda
        String t = "Hola";
        System.out.println("La Longitud de '" + t + "' es: " + longitud.apply(t)); // Imprime 4 porque "Hola" tiene 4 caracteres

        // Consumer: representa una operación que acepta un String y no devuelve ningún resultado.
        //original: Consumer<String> imprimir = s -> System.out.println(s); // Imprime el string recibido
        Consumer<String> imprimir = System.out::println; // Imprime el string recibido - Con Lambda
        imprimir.accept("Ejemplo de recibir un string y no devolver nada: "+"Imprimiendo"); // Llama al consumer para imprimir el texto

        // Supplier: representa una función que no toma argumentos y devuelve un resultado (un número aleatorio).
        //Original : Supplier<Double> random = () -> Math.random();
        Supplier<Double> random = Math::random; // Genera un número aleatorio entre 0.0 y 1.0 - Con Lambda
        System.out.println("Sin enviar argumentos devuelve un valor de cualquier clase: " + random.get()); // Imprime un número aleatorio

        // BiFunction: representa una función que toma dos enteros y devuelve su suma.
        //original: BiFunction<Integer, Integer, Integer> suma = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> suma = Integer::sum; //Suma dos números - Con Lambda
        System.out.println("Se envia dos tipos de datos cualquiera y devuelve " +
                "cualquier dato: " +suma.apply(5, 3)); // Imprime 8, que es la suma de 5 y 3
    }
}


