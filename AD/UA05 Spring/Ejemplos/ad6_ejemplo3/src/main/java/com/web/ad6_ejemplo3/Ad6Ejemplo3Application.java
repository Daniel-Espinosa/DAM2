package com.web.ad6_ejemplo3;

import com.web.ad6_ejemplo3.entidades.Categoria;
import com.web.ad6_ejemplo3.entidades.Producto;
import com.web.ad6_ejemplo3.servicios.Servicios;
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
        Categoria categoria = servicio.getCategoria(100);
       List<Producto> listap = servicio.listProductsByCategoria(categoria);
       for (Producto p: listap){
           System.out.println(p.getNombre());
       }
       Producto p = new Producto();
       p.setPkproducto(111);
       servicio.subePvpProducto(p, 11.11);
        
    }
}
