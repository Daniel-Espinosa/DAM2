package com.cafeconpalito.cine_Examen;

import com.cafeconpalito.cine_Examen.controller.EntradaController;
import com.cafeconpalito.cine_Examen.controller.PeliculaController;
import com.cafeconpalito.cine_Examen.controller.SalaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class CineExamenApplication {

    public static void main(String[] args) {
        
        //EXAMEN DANIEL ESPINOSA GARCIA
        
        //SWAGGER para acceder a los EndPoints accede a esta URL
        
        //http://localhost:8080/swagger-ui/index.html
        
        //Made by Cafe Con Palito®
        //with love ♡

        ApplicationContext context = SpringApplication.run(CineExamenApplication.class, args);
  
        PeliculaController pc = new PeliculaController(context);
        EntradaController ec = new EntradaController(context);
        SalaController sc = new SalaController(context);
        
        
//        System.out.println("CONSULTA 1");
//        PeliculaService ps = new PeliculaService(context);
//        
//        for (Pelicula pelicula : ps.peliculasEnSala(101)) {
//            System.out.println(pelicula.toString());
//        }



//        System.out.println("CONSULTA 2");
//        SalaService ss = new SalaService(context);
//        for (Object[] objects : ss.numPeliculasSala()) {
//            for (Object object : objects) {
//                System.out.print(object.toString() + " | ");
//            }
//            System.out.println("");
//        }
//        






    }

}
