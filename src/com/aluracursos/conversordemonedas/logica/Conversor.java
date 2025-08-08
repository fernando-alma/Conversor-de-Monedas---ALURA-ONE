package com.aluracursos.conversordemonedas.logica;

public class Conversor {
    private double resultado;

    public double convertir(int opcion, double num, double numConversor){
        if(opcion == 1 || opcion == 3 || opcion == 5){
            resultado = num * numConversor;
            return resultado;
        } else if (opcion == 2 || opcion == 4 || opcion == 6) {
            resultado = num / numConversor;
            return resultado;
        } else {
            return 0;
        }
    }
}
