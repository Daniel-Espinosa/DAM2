/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.almacenweb.ad6_ejemplo4.servicios;

import com.almacenweb.ad6_ejemplo4.entidades.Categoria;
import com.almacenweb.ad6_ejemplo4.entidades.Producto;
import com.almacenweb.ad6_ejemplo4.interfaces.IServicios;
import com.almacenweb.ad6_ejemplo4.repositorios.CategoriaDao;
import com.almacenweb.ad6_ejemplo4.repositorios.ProductoDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author msola
 */
@Service
public class Servicios implements IServicios {

    @Autowired
    private CategoriaDao catdao;
    @Autowired
    private ProductoDao pdao;

    @Override
    public Categoria getCategoria(Integer idcategoria) {
        Categoria categoria = new Categoria();
        Optional<Categoria> cat = catdao.findById(idcategoria);
        if (cat.isPresent()) {
            categoria = cat.get();
        }
        return categoria;
    }

    @Override
    public List<Producto> listProductos() {
        List<Producto> lista = (List<Producto>) pdao.findAll();
        if(lista==null){
            lista= new ArrayList<>();
        }        
        return lista;
    }

    @Override
    public List<Producto> listProductsByCategoria(Categoria categoria) {
        List<Producto> lista = pdao.findByCategoria(categoria);
        return lista;
    }

    @Override
    public void subePvpProducto(Producto producto, double incremento) {
        Integer pk = producto.getPkproducto();
        Optional<Producto> prod = pdao.findById(pk);
        //si está en la BD es cuando subo precio
        if(prod.isPresent()){
            producto.setPvp(incremento);
            pdao.save(producto);
        }else{
            System.out.println("No encuentro el producto.");
        }
    }

    @Override
    public Categoria nuevaCategoria(Categoria categoria) {
        Integer pkcategoria = catdao.maximaPkCategoria()+1;
        categoria.setPkcategoria(pkcategoria);
        catdao.save(categoria);
        return categoria;
    }

}
