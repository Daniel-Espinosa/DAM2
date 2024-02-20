/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.iesaugustogonzalez.jfranco.ejemplo2._headers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jfrancoros
 */
public class Ejemplo22_Headers {

    public static void main(String[] args) {
         try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request= HttpRequest.newBuilder()
                    .uri(new URI("https://www.google.es"))
                    .GET()
                    .build();

            HttpResponse<String> response= client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            int responseStatusCode = response.statusCode();

            //System.out.println("httpGetRequest: " + responseBody);
            System.out.println("httpGetRequest status code: " + responseStatusCode);
            
             // Obtener los encabezados de la respuesta
            HttpHeaders headers = response.headers();
           
            
            
               // Imprimir los encabezados con programación funcional
            headers.map().forEach((key, value) ->
                    System.out.println(key + ": " + value));

            // Imprimir los encabezados sin programación funcional
//            Map<String, List<String>> headerMap = headers.map();
//            for (Map.Entry<String, List<String>> entry : headerMap.entrySet()) {
//                String key = entry.getKey();
//                List<String> values = entry.getValue();
//
//                System.out.print(key + ": ");
//                for (String value : values) {
//                    System.out.print(value + ", ");
//                }
//                System.out.println();
//            }


        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
