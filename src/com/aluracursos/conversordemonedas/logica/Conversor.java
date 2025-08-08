package com.aluracursos.conversordemonedas.logica;

// Clase encargada de realizar la conversión entre monedas
public class Conversor {
    // Variable para almacenar el resultado de la conversión
    private double resultado;

    /*
     * Metodo para convertir un valor de una moneda a otra
     * @param opcion: indica el tipo de conversión (multiplicar o dividir)
     * @param num: valor numérico que se quiere convertir
     * @param numConversor: tasa de conversión entre monedas
     * @return resultado de la conversión o 0 si la opción es inválida
     */
    public double convertir(int opcion, double num, double numConversor){
        // Si la opción es 1, 3 o 5, se multiplica num por la tasa de conversión
        if(opcion == 1 || opcion == 3 || opcion == 5){
            resultado = num * numConversor;
            return resultado;  // Devuelve el resultado de la multiplicación
        }
        // Si la opción es 2, 4 o 6, se divide num por la tasa de conversión
        else if (opcion == 2 || opcion == 4 || opcion == 6) {
            resultado = num / numConversor;
            return resultado;  // Devuelve el resultado de la división
        }
        // Si la opción no corresponde a ninguna de las anteriores, devuelve 0
        else {
            return 0;
        }
    }
}
