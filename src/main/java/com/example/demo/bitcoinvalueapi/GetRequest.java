package com.example.demo.bitcoinvalueapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
public class GetRequest {
    private CryptoPrice cryptoPrice;

    public void get(String api) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api)).build();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).
                thenApply(HttpResponse::body).
                thenApply(this::read).
                join();
    }

    public String read(String responseBody) {
        Gson gson = new Gson();
        cryptoPrice = gson. fromJson(responseBody, CryptoPrice.class);

        return null;
    }

    public CryptoPrice getCryptoPrice() { return cryptoPrice; }
}
