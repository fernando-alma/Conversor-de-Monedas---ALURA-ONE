package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.logica.ConsultarAPI;
import com.aluracursos.conversordemonedas.logica.Conversor;
import com.aluracursos.conversordemonedas.logica.Monedas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcion = 1;
        Scanner lectura = new Scanner(System.in);
        while( opcion != 7) {
            System.out.println("--------------------------------------------");
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar ");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar ");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("--------------------------------------------");
            ConsultarAPI consulta = new ConsultarAPI();
            System.out.println("Ingrese la opción que desea: ");
            System.out.println("--------------------------------------------");
            opcion = Integer.valueOf(lectura.nextLine());
            Monedas moneda = consulta.conversorMoneda();
            if ( opcion > 0 && opcion < 7) {
                System.out.println("Ingrese la cantidad a convertir: ");
                System.out.println("--------------------------------------------");
                double cantidad = Double.parseDouble(lectura.nextLine());
                Conversor resultado = new Conversor();
                double res = 0;
                switch (opcion) {
                    case 1:
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getARS());
                        System.out.println(cantidad + " USD son " + res + " ARS" );
                        break;
                    case 2:
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getARS());
                        System.out.println(cantidad + " ARS son " + res + " USD" );
                        break;
                    case 3:
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getBRL());
                        System.out.println(cantidad + " USD son " + res + " BRL" );
                        break;
                    case 4:
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getBRL());
                        System.out.println(cantidad + " BRL son " + res + " USD" );
                        break;
                    case 5:
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getCOP());
                        System.out.println(cantidad + " USD son " + res + " COP" );
                        break;
                    case 6:
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getCOP());
                        System.out.println(cantidad + " COP son " + res + " USD" );
                        break;
                    default:
                        break;
                }
            } else if (opcion != 7){
                System.out.println("Opción no válida, ingrese otra opcion correcta");
                System.out.println("--------------------------------------------");
            } else {
                System.out.println("Muchas gracias por utilizar nuestra app de conversor de monedas!");
                System.out.println("--------------------------------------------");
            }
        }
    }
}
