package com.aluracursos.conversordemonedas.logica;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarAPI {
    public Monedas conversorMoneda(){

        URI url = URI.create("https://v6.exchangerate-api.com/v6/2452d03efe8a2b644bb27aa3/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Gson gson = new Gson();
            Monedas moneda = gson.fromJson(json, Monedas.class);
            return moneda;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}