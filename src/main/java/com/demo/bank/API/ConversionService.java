package com.demo.bank.API;

import com.demo.bank.Model.FxRatesResponse;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionService {
    public static FxRatesResponse conversion() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.fxratesapi.com/latest?currencies=USD&base=BRL&amount=100"))
                .GET()
                .build();
            try {//Os nomes dos atributos da classe endereço e os da API devem ser iguais, para que o mapeamento dê certo
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            FxRatesResponse moeda =  new Gson().fromJson(response.body(), FxRatesResponse.class);
            return moeda;
        }catch (Exception e) {
            throw new RuntimeException("Finalizando o programa por IO ou Interrupted");
        }

    }

}
