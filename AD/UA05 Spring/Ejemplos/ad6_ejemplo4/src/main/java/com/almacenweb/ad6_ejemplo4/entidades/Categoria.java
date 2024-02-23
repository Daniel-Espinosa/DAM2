/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.almacenweb.ad6_ejemplo4.entidades;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author msola
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pkcategoria")
    private Integer pkcategoria;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akcategoria")
    private List<Producto> productoList;

    public Categoria() {
    }

    public Categoria(Integer pkcategoria) {
        this.pkcategoria = pkcategoria;
    }

    public Integer getPkcategoria() {
        return pkcategoria;
    }

    public void setPkcategoria(Integer pkcategoria) {
        this.pkcategoria = pkcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkcategoria != null ? pkcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.pkcategoria == null && other.pkcategoria != null) || (this.pkcategoria != null && !this.pkcategoria.equals(other.pkcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almacenweb.ad6_ejemplo3.entidades.Categoria[ pkcategoria=" + pkcategoria + " ]";
    }
    
}
