package com.javaCourse;

public class Vector {

    public static void main(String[] args) {
        int[] vector = new int[6]; //Declaramos el vector

        //Seteamos los valores en cada una de las pocisiones
        vector[0] = 7;
        vector[1] = 18;
        vector[2] = 10;
        vector[3] = 1;
        vector[4] = 30;
        vector[5] = 24;

        //Mostramos el tamaño del vector
        System.out.println("The vector of size " + vector.length);

        //Mostramos el valor que tiene cada posicion del vector
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }

        int[] result = vectorSort(vector);
        System.out.println("\nvector ordenado");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
   }

   private static int[] vectorSort(int[] vector) {
        for (int i = 1; i < vector.length; i++) { //i empieza en 1 para evaluar con la posicion anterior
            int index = vector[i];//Index toma el valor que tenga el vector en la posicion i
            int j = i - 1; //j se inicia una posicion antes de i para comparar los valores del vector en la posicion i con la posicion i-1
            while (j >= 0 && vector[j] > index) { //siempre que j sea mayor a 0 y el valor de del vector en la posicion i-1 sea mayor a i entra
                vector[j + 1] = vector[j]; //asigna a la posicion i el valor de i-1(que es mayor que i)
                j -= 1; //devuelve una posicion a j para volver a evaluar con el valor inicial y ver si este es de nuevo mayor que el index
            }
            //hasta este punto el valor de index no se ha asignado
            vector[j + 1] = index; //se asigna el valor de index, signifa que index es el primero en el vector o menor que el siguiente y mayor que el anterior
        }
        return vector;
   }
}
