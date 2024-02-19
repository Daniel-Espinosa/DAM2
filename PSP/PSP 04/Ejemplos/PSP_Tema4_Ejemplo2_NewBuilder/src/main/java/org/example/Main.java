package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://es.wikipedia.org/wiki/Santo%C3%B1a"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            int responseStatusCode = response.statusCode();

            System.out.println("CABECERA");
            Map header = response.headers().map();
            System.out.println(header.get("content-type"));

            String cabecera = header.get("content-type").toString();

            if (cabecera.contains("text/html")) {
                System.out.println("es html");
            } else if (cabecera.contains("pdf")) {
                System.out.println("es PDF");
            } else {
                System.out.println("es otra cosa");
            }

            //System.out.println("httpGetRequest: " + responseBody);
            //System.out.println("httpGetRequest status code: " + responseStatusCode);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
