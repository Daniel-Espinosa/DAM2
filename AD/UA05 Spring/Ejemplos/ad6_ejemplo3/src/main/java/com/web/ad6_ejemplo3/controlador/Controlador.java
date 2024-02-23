/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.ad6_ejemplo3.controlador;

import com.web.ad6_ejemplo3.entidades.Categoria;
import com.web.ad6_ejemplo3.entidades.Producto;
import com.web.ad6_ejemplo3.servicios.Servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author marina
 */
@Controller
public class Controlador {
    @Autowired
    private Servicios servicio;
    
    @RequestMapping(value="/") //http://localhost:8080
    public String index(Model modelo){
        //voy a jugar con Model para pasar el contenido de una variable
        modelo.addAttribute("variable", "Este mensaje viaja en la variable.");
        return "index";
    }
    
    @RequestMapping(value="/productos") //http://localhost:8080/productos
    public String productos(Model modelo){      
        List<Producto> lista = servicio.listProductos();
        //necesito un atributo para devolver a la vista una variable con lo que me pide
        modelo.addAttribute("listaprods", lista);
        return "productos";
    }
}
