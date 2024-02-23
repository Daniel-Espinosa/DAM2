/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.almacenweb.ad6_ejemplo4.controlador;


import com.almacenweb.ad6_ejemplo4.entidades.Categoria;
import com.almacenweb.ad6_ejemplo4.entidades.Producto;
import com.almacenweb.ad6_ejemplo4.servicios.Servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author msola
 */
@Controller
public class Controlador {
    @Autowired
    private Servicios servicio;
    
    //http://localhost:8080
    @RequestMapping(value="/")
    public String index (Model modelo){
        modelo.addAttribute("variable", 
                "Mensaje del controlador.");
        return "index";
    }
    
    //http://localhost:8080/productos
    @RequestMapping(value="/productos")
    public String productos (Model modelo){
        List<Producto> lista = servicio.listProductos();
        modelo.addAttribute("listaprods", lista);
        return "productos";
    }
    
    //http://localhost:8080/formulario
    @GetMapping("/formulario")
    public String formulario(Model modelo){
        Categoria objeto = new Categoria();
        modelo.addAttribute("categoria", objeto);
        return "formulario";
    }
    
    @PostMapping("/formulario")
    public String submitForm(@ModelAttribute Categoria categoria){
        servicio.nuevaCategoria(categoria);
        return "resultado";
    }
}
