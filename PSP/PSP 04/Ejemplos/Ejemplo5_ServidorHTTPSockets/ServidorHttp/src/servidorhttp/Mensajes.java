/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorhttp;

/**
 *
 * @author jfranco
 */
public class Mensajes {

    public static final String lineaInicial_OK = "HTTP/1.1 200 OK";
    public static final String lineaInicial_NotFound
            = "HTTP/1.1 404 Not Found";
    public static final String lineaInicial_BadRequest =
          "HTTP/1.1 400 Bad Request";
}
