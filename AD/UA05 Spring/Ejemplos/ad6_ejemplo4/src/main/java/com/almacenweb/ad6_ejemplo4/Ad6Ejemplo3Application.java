package com.almacenweb.ad6_ejemplo4;

import com.almacenweb.ad6_ejemplo4.entidades.Categoria;
import com.almacenweb.ad6_ejemplo4.entidades.Producto;
import com.almacenweb.ad6_ejemplo4.repositorios.CategoriaDao;
import com.almacenweb.ad6_ejemplo4.servicios.Servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Ad6Ejemplo3Application {

    @Autowired
    private Servicios servicio;
    
    
    public static void main(String[] args) {
        SpringApplication.run(Ad6Ejemplo3Application.class, args);
    }

    @EventListener({ApplicationReadyEvent.class})
    public void pruebaConsultas() {
        
//        Categoria cat = new Categoria();
//        cat.setPkcategoria(300);
//        cat.setNombre("La nueva");
//       Categoria nueva = servicio.nuevaCategoria(cat);
//        System.out.println(nueva.toString());
//        Categoria cat = servicio.getCategoria(300);
//        System.out.println(cat.getNombre());
//        List<Producto> lista = servicio.listProductsByCategoria(cat);
//        if(lista!=null){
//            for (Producto p : lista){
//                System.out.println(p.getNombre() + 
//                        " de categoria " + p.getAkcategoria().getNombre());
//            }
//        }
        
    }

}
