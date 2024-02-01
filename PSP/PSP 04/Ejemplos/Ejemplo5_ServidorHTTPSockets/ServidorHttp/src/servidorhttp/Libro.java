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
public class Libro {

    public static final String primeraCabecera
            = "Content-Type:text/html;charset=UTF-8";
    //contenido index
    public static final String html_index = "<html>"
            + "<head><title>index</title></head>"
            + "<body>"
            + "<h1>¡Enhorabuena!</h1>"
            + "<p>Tu servidor HTTP mínimo funciona correctamente</p>"
            + "</body>"
            + "</html>";
    //contenido quijote
    public static final String html_mendoza = "<html>"
            + "<head><title>Eduardo Mendoza</title></head>"
            + "<body>"
            + "<h1>Así comienza <i>El secreto de la modelo extraviada<i>:</h1>"
            + "<p>En términos generales, estaba bien. De salud, de memoria y pare usted de contar. En estas condiciones y \n"
            + "después de tantas aventuras, debería haber llevado una vida de sosiego, y en ello estaba cuando me mordió \n"
            + "un perro y lo echó todo a rodar. Yo iba caminando por la Ronda de San Pablo, diligente y sin meterme con \n"
            + "nadie, camino del autobús, a llevar una comanda. Desde hacía cierto tiempo trabajaba en un restaurante \n"
            + "chino y me habían confiado aquel cometido por mi doble condición de nativo, y por ende conocedor de la \n"
            + "intrincada trama urbana, y de ciudadano con papeles, por si me paraba la poli. Algunos de estos papeles \n"
            + "habría sido mejor no tenerlos, pero a ciertos efectos era mejor estar fichado que pertenecer al abultado \n"
            + "colectivo de los sin papeles, como le sucedía al resto de los trabajadores de la empresa así como a los \n"
            + "socios capitalistas, los proveedores y buena parte de la clientela....</p>"
            + "</body>"
            + "</html>";
    //contenido noEncontrado
    public static final String html_noEncontrado = "<html>"
            + "<head><title>noEncontrado</title></head>"
            + "<body>"
            + "<h1>¡ERROR! Página no encontrada</h1>"
            + "<p>La página que solicitaste no existe en nuestro "
            + "servidor</p>"
            + "</body>"
            + "</html>";
}
