/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.almacenweb.ad6_ejemplo4.interfaces;

import com.almacenweb.ad6_ejemplo4.entidades.Categoria;
import com.almacenweb.ad6_ejemplo4.entidades.Producto;
import java.util.List;

/**
 *
 * @author msola
 */
public interface IServicios {

    public Categoria getCategoria(Integer idcategoria);

    public List<Producto> listProductos();

    public List<Producto> listProductsByCategoria(Categoria categoria);

    public void subePvpProducto(Producto producto, double incremento);
    
    public Categoria nuevaCategoria(Categoria categoria);

}
