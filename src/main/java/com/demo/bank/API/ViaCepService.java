package com.demo.bank.API;

import com.demo.bank.Model.Endereco;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


    /* FORMAT JSON
    {
        "cep": "48902-300",
            "logradouro": "Avenida Antônio Carlos Magalhães",
            "complemento": "",
            "unidade": "",
            "bairro": "Country Club",
            "localidade": "Juazeiro",
            "uf": "BA",
            "estado": "Bahia",
            "regiao": "Nordeste",
            "ibge": "2918407",
            "gia": "",
            "ddd": "74",
            "siafi": "3669"
    }
    */







public class ViaCepService {


    public static Endereco getEndereco(String cep, int number) throws Exception {
        Endereco endereco = new Endereco();
        cep = cep.replaceAll("\\D", ""); // mantém só números
        if (!cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP incorreto");
        }
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            endereco =  new Gson().fromJson(response.body(), Endereco.class);
            endereco.setNumber(number);
            return endereco;
        }catch (Exception e) {
            throw new RuntimeException("Finalizando o programa por IO ou Interrupted");
        }

    }

}
