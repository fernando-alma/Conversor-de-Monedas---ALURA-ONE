// Paquete donde se encuentra esta clase (estructura organizada por capas)
package com.aluracursos.conversordemonedas.principal;

// Importamos clases desde la carpeta lógica para utilizar sus métodos y objetos
import com.aluracursos.conversordemonedas.logica.ConsultarAPI;
import com.aluracursos.conversordemonedas.logica.Conversor;
import com.aluracursos.conversordemonedas.logica.Monedas;

import java.util.Scanner; // Clase que permite capturar datos del usuario por consola

public class Principal {

    // Metodo principal: punto de entrada del programa
    public static void main(String[] args) {
        int opcion = 1; // Inicializa la opción del menú
        Scanner lectura = new Scanner(System.in); // Crea un objeto Scanner para leer entrada por consola

        // Ciclo que se repite mientras el usuario no elija la opción 7 (salir)
        while(opcion != 7) {
            // Menú de opciones
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

            // Instancia del objeto que consulta la API (se hace dentro del loop para mantener actualizada la tasa)
            ConsultarAPI consulta = new ConsultarAPI();

            // Pide al usuario ingresar una opción
            System.out.println("Ingrese la opción que desea: ");
            System.out.println("--------------------------------------------");
            opcion = Integer.valueOf(lectura.nextLine()); // Se lee la opción como String y se convierte a int

            // Se realiza la solicitud a la API de tasas de cambio
            Monedas moneda = consulta.conversorMoneda();

            // Si la opción es válida (entre 1 y 6)
            if (opcion > 0 && opcion < 7) {
                // Pide ingresar el monto a convertir
                System.out.println("Ingrese la cantidad a convertir: ");
                System.out.println("--------------------------------------------");
                double cantidad = Double.parseDouble(lectura.nextLine()); // Lee y convierte a double

                // Instancia de la clase que hace la conversión
                Conversor resultado = new Conversor();

                double res = 0; // Variable donde se almacenará el resultado de la conversión

                // Estructura switch para determinar qué conversión realizar según la opción seleccionada
                switch (opcion) {
                    case 1:
                        // USD -> ARS
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getARS());
                        System.out.println(cantidad + " USD son " + res + " ARS" );
                        break;
                    case 2:
                        // ARS -> USD
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getARS());
                        System.out.println(cantidad + " ARS son " + res + " USD" );
                        break;
                    case 3:
                        // USD -> BRL
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getBRL());
                        System.out.println(cantidad + " USD son " + res + " BRL" );
                        break;
                    case 4:
                        // BRL -> USD
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getBRL());
                        System.out.println(cantidad + " BRL son " + res + " USD" );
                        break;
                    case 5:
                        // USD -> COP
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getCOP());
                        System.out.println(cantidad + " USD son " + res + " COP" );
                        break;
                    case 6:
                        // COP -> USD
                        res = resultado.convertir(opcion, cantidad, moneda.conversion_rates().getCOP());
                        System.out.println(cantidad + " COP son " + res + " USD" );
                        break;
                    default:
                        // No es necesario, pero se coloca por completitud
                        break;
                }

                // Si la opción no es válida y no eligió salir
            } else if (opcion != 7){
                System.out.println("Opción no válida, ingrese otra opción correcta");
                System.out.println("--------------------------------------------");

                // Si la opción es 7 (salir)
            } else {
                System.out.println("Muchas gracias por utilizar nuestra app de conversor de monedas!");
                System.out.println("--------------------------------------------");
            }
        }
    }
}
