// Paquete en el que se encuentra esta clase (para organización del código)
package com.aluracursos.conversordemonedas.logica;

// Clase pública que representa las tasas de conversión de monedas
public class ConversionRates {

    // Campos privados que almacenan el valor de conversión desde la moneda base (USD)
    // hacia otras monedas. Ej: cuántos ARS hay por 1 USD.
    private double ARS; // Peso argentino
    private double BRL; // Real brasileño
    private double USD; // Dólar estadounidense (normalmente será 1.0, ya que es la base)
    private double COP; // Peso colombiano

    // Getter para obtener la tasa de conversión de USD a ARS
    public double getARS() {
        return ARS;
    }

    // Getter para obtener la tasa de conversión de USD a BRL
    public double getBRL() {
        return BRL;
    }

    // Getter para obtener la tasa de conversión de USD a USD (siempre 1.0)
    public double getUSD() {
        return USD;
    }

    // Getter para obtener la tasa de conversión de USD a COP
    public double getCOP() {
        return COP;
    }
}
