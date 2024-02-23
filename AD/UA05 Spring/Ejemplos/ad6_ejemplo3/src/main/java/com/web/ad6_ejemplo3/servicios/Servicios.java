/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.ad6_ejemplo3.servicios;

import com.web.ad6_ejemplo3.entidades.Categoria;
import com.web.ad6_ejemplo3.entidades.Producto;
import com.web.ad6_ejemplo3.interfaces.IServicios;
import com.web.ad6_ejemplo3.repositorios.CategoriaDao;
import com.web.ad6_ejemplo3.repositorios.ProductoDao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marina
 */
@Service
public class Servicios implements IServicios {
    @Autowired
    private CategoriaDao catdao;
    @Autowired
    private ProductoDao pdao;
    
    @Override
    public Categoria getCategoria(Integer idcategoria) {
        Categoria cat = catdao.findById(idcategoria).get();
        return cat;
    }
    
    @Override
    public List<Producto> listProductos() {
        List<Producto> lista = (List<Producto>) pdao.findAll();
        return lista;
    }

    @Override
    public List<Producto> listProductsByCategoria(Categoria categoria) {
        List<Producto> lista = pdao.findByCategoria(categoria);
        return lista;
    }

    @Override
    public void subePvpProducto(Producto producto, double nuevoprecio) {
        Integer pk = producto.getPkproducto();
        //compruebo que exista el producto en la base de datos.
        Optional<Producto> p = pdao.findById(pk);
        if (p.isPresent()) {
            Producto product = p.get(); //le recupero
            product.setPvp(nuevoprecio);
            pdao.save(product);
        } else {
            System.out.println("No se puede actualizar el precio. No se encuentra el producto.");
        }
    }
}
