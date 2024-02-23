package com.jpa.ad6_ejemplo2;

import com.jpa.ad6_ejemplo2.entidades.Categoria;
import com.jpa.ad6_ejemplo2.entidades.Producto;
import com.jpa.ad6_ejemplo2.interfaces.ICategoria;
import com.jpa.ad6_ejemplo2.interfaces.IProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Ad6Ejemplo2Application {

    @Autowired
    private ICategoria cdao;
    @Autowired
    private IProducto pdao;

    public static void main(String[] args) {
        SpringApplication.run(Ad6Ejemplo2Application.class, args);
    }

    @EventListener({ApplicationReadyEvent.class})
    public void pruebaConsultas() {
        
        //pruebo los métodos de CrudRepository de Categoria        
        pruebaCrudRepository();
       
        //pruebo los método de la extensión de CrudRepository, declarados en interfaz
        pruebaExtensRepository();
    }
    
    public void pruebaCrudRepository() {
        System.out.println("-------------Nueva categoria -----------------");
        Categoria cat = new Categoria();
        cat.setPkcategoria(101);
        cat.setNombre("Categoria 101");
        cdao.save(cat); // invoco directamente al método save(Objeto), está en CrudRepository

        System.out.println("----------------- Borrar categoria -------------------");
        Categoria borracat = cdao.findByNombre("Categoria 101");
        if (borracat != null) {
            cdao.delete(borracat);
        }

        System.out.println("------------------Listado de categorias´------------------");
        List<Categoria> listacat = (List<Categoria>) cdao.findAll(); //findAll() está en CrudRepository
        if (listacat != null) {
            for (Categoria c : listacat) {
                System.out.println(c.toString());
            }
        }

    }
    
    public void pruebaExtensRepository(){
        System.out.println("--------- Buscar categoria por nombre -------------");
        Categoria categoria = cdao.findByNombre("Categoria 100");
        if (categoria != null) {
            System.out.println("Categoria = " + categoria.getPkcategoria() + " - " + categoria.getNombre());
        } else {
            System.out.println("No encontrado");
        }
        System.out.println("------------Lista de productos de la categoria " + categoria);
        List<Producto> listaprods = pdao.findByCategoria(categoria);
        if (listaprods != null) {
            for (Producto p : listaprods) {
                System.out.println(p.toString());
            }
        }
        System.out.println("--------------------Lista de productos con un stock menor que");
        listaprods = pdao.stockMenorQue(101);
        if (listaprods != null) {
            for (Producto p : listaprods) {
                System.out.println("Producto= " + p.getNombre() + " - Sock= " + p.getStock());
            }
        }
    }

}
