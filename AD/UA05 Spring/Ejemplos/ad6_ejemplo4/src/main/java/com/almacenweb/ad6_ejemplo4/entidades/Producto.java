/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.almacenweb.ad6_ejemplo4.entidades;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author msola
 */
@Entity
@Table(name = "producto")

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkproducto")
    private Integer pkproducto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "pvp")
    private double pvp;
    @Column(name = "stock")
    private Integer stock;
    @JoinColumn(name = "akcategoria", referencedColumnName = "pkcategoria")
    @ManyToOne(optional = false)
    private Categoria akcategoria;

    public Producto() {
    }

    public Producto(Integer pkproducto) {
        this.pkproducto = pkproducto;
    }

    public Producto(Integer pkproducto, String nombre, double pvp) {
        this.pkproducto = pkproducto;
        this.nombre = nombre;
        this.pvp = pvp;
    }

    public Integer getPkproducto() {
        return pkproducto;
    }

    public void setPkproducto(Integer pkproducto) {
        this.pkproducto = pkproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getAkcategoria() {
        return akcategoria;
    }

    public void setAkcategoria(Categoria akcategoria) {
        this.akcategoria = akcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkproducto != null ? pkproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.pkproducto == null && other.pkproducto != null) || (this.pkproducto != null && !this.pkproducto.equals(other.pkproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almacenweb.ad6_ejemplo3.entidades.Producto[ pkproducto=" + pkproducto + " ]";
    }
    
}
