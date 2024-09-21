package com.javaCourse.interfacesFuncionales;

public class InterfacesFuncionales  {
    public static void main(String[] args) {
        /*se implementa el método metodo, a travez de instanciar la funcion interfaz1
        donde:
        = (a,b,c) -> son los parametros de entrada
        -> indica que es una funcion lambda
        -> System.out.println("Interfaz1 : a=" + a + " b="+ b +" c=" +c); : Salida
         */
        Interfaz1 i1 = (a,b,c) -> System.out.println("Interfaz1 --------------> a=" + a + ", b="+ b +", c=" +c);
        i1.metodo(10,"luisa",10.58f);


        /*Interfaz generica
        * Se le define que tipo de datos va a recibir en la implementacion no en la declacion
        * (String a, Long b, Boolean c) -> Boolean d*/
        Interfaz2<String, Long, Integer, Boolean> i2 = (a,b,c) -> a.length() > b && a.length() > c;
        System.out.println("Interfaz2 --------------> a es mayor?: "+(i2.metodo("Ejercicio", 20L,6)));

        //preguntar por ::::
        Interfaz3 i3 = String::concat;
        System.out.println("Interfaz3 forma 1: -----> "+ i3.metodo("buenos ", "dias"));

        Interfaz3 i31 = (a, B) -> a.substring(0,4).concat(B);
        System.out.println("Interfaz3 forma 2: -----> " +i31.metodo("Hola1234", " mundo"));

        Interfaz4 i4 = () -> System.out.println("interfaz4 --------------> vacia");
        i4.metodo();

        Interfaz5 i5 = (a, b) -> ((long) a *b);
        System.out.println("Interfaz5 --------------> multimpliacación de enteros a long: " +i5.metodo(4,20));

        Interfaz6 i6 = Long::sum;
        System.out.println("Interfaz6 forma 1: -----> " + i6.metodo(5,50L));

        Interfaz6 i61 = (a, b) -> a+b-b;
        System.out.println("Interfaz6 forma 2: -----> " + i61.metodo(5,50L));

        Interfaz7 i7 = (a,b) -> a+b;
        System.out.println("Interfaz7 --------------> "+i7.metodo("Estamos ", new StringBuilder("Aprendiendo")));

        Interfaz8 i8 = () -> new Object().toString();
        System.out.println("Interfaz8 --------------> "+i8.metodo());

        Interfaz9 i9 = (a,b) -> a +" y "+ b;
        System.out.println("Interfaz9 --------------> " + i9.metodo(new Object(),new Object()));

        Interfaz10 i10 = (a, b, c) -> "valores: a="+a+", b="+b+", c="+c;
        System.out.println("Interfaz10 -------------> "+i10.metodo(19,'S',10.0f));
    }
}

@FunctionalInterface
interface Interfaz1{
    void metodo(int a, String b, float c);
}

/*Interfaz generica
 * Se le define que tipo de datos va a recibir en la implementacion no en la declacion*/
@FunctionalInterface
interface Interfaz2<A,B,C,D>{
    D metodo(A a, B b, C c);
}

@FunctionalInterface
interface Interfaz3{
    String metodo(String a, String B);
}

@FunctionalInterface
interface Interfaz4{
    void metodo();
}

@FunctionalInterface
interface Interfaz5{
    Long metodo(int a, int b);
}

@FunctionalInterface
interface Interfaz6{
    Number metodo(Integer a, Long b);
}

@FunctionalInterface
interface Interfaz7{
    CharSequence metodo(String a, StringBuilder b);
}

@FunctionalInterface
interface Interfaz8{
    Object metodo();
}

@FunctionalInterface
interface Interfaz9{
    String metodo(Object a, Object b);
}

@FunctionalInterface
interface Interfaz10{
    String metodo(int a, char b, float c);
}

