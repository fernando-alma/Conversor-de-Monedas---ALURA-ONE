// Declaración del paquete donde se encuentra esta clase
package com.aluracursos.conversordemonedas.logica;

// Importamos la clase Gson para trabajar con JSON
import com.google.gson.Gson;

// Librerías necesarias para realizar solicitudes HTTP
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Clase encargada de consultar la API de conversión de monedas
public class ConsultarAPI {

    // Metodo público que devuelve un objeto Monedas (con las tasas de cambio)
    public Monedas conversorMoneda(){

        // 1️⃣ URL de la API con base USD (Hardcodeada por ahora)
        URI url = URI.create("https://v6.exchangerate-api.com/v6/2452d03efe8a2b644bb27aa3/latest/USD");
        // 🔸 Esta API devuelve las tasas de cambio tomando como base el dólar estadounidense (USD)

        // 2️⃣ Se crea un cliente HTTP con la clase HttpClient (disponible desde Java 11)
        HttpClient client = HttpClient.newHttpClient();

        // 3️⃣ Se construye la solicitud HTTP GET utilizando la URL creada anteriormente
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)            // Establece el destino
                .build();            // Cierra la configuración del request

        try {
            // 4️⃣ Se envía la solicitud y se espera una respuesta de tipo String
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // 5️⃣ Se obtiene el contenido del cuerpo de la respuesta (el JSON como String)
            String json = response.body();

            // 6️⃣ Se crea una instancia de Gson para convertir el JSON en un objeto Java
            Gson gson = new Gson();

            // 7️⃣ Se transforma el JSON a una instancia de la clase Monedas
            // 🔸 Monedas debe tener campos que coincidan con los nombres del JSON
            Monedas moneda = gson.fromJson(json, Monedas.class);

            // 8️⃣ Se retorna el objeto Monedas listo para usarse
            return moneda;

        } catch (Exception e) {
            // Si ocurre algún error durante la solicitud o el parseo, se lanza una excepción
            throw new RuntimeException(e);
        }
    }
}
