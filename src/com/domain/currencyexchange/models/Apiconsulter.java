package com.domain.currencyexchange.models;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

public class Apiconsulter {

    private ArrayList<String> currencies = new ArrayList<>(Arrays.asList(" ","ARS", "BRL", "CAD", "COP", "CLP", "EUR", "GBP", "JPY", "USD"));

    public Pair consult(int base, int target, double amount) {
        URI direction = URI.create("https://v6.exchangerate-api.com/v6/be958b06938814b2d4755bea/pair/" + currencies.get(base) + "/" + currencies.get(target) + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direction)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Pair.class);
        } catch (Exception e) {
            throw new RuntimeException("The consult can't be done");
        }
    }
}
