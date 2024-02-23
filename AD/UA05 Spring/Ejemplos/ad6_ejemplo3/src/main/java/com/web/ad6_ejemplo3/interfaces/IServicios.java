/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.web.ad6_ejemplo3.interfaces;


import com.web.ad6_ejemplo3.entidades.Categoria;
import com.web.ad6_ejemplo3.entidades.Producto;
import java.util.List;

/**
 *
 * @author marina
 */
public interface IServicios {
    /**
     * Obtener la categoria
     * @param idcategoria
     * @return 
     */
    public Categoria getCategoria(Integer idcategoria);
    /**
     * Lista de todos los productos
     * @return 
     */    
    public List<Producto> listProductos();
    /**
     * Lista de productos de una categoria
     * @param categoria
     * @return 
     */
    public List<Producto> listProductsByCategoria (Categoria categoria);
    /**
     * Imcrementar el precio de un producto
     * @param producto 
     * @param nuevoprecio 
     */
    public void subePvpProducto (Producto producto, double nuevoprecio);    
    
}
