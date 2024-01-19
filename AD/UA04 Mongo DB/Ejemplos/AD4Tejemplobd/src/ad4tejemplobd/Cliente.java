/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad4tejemplobd;

import java.util.Date;

/**
 *
 * @author msola
 */
public class Cliente {
    
    private String nombre;
    private Date f_nac;
    private String calle;
    private Integer bono_regalo;
    
    public Cliente(){}

    public Cliente(String nombre, Date f_nac, String calle, int bono_regalo) {
        this.nombre = nombre;
        this.f_nac = f_nac;
        this.calle = calle;
        this.bono_regalo = bono_regalo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getF_nac() {
        return f_nac;
    }

    public void setF_nac(Date f_nac) {
        this.f_nac = f_nac;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getBono_regalo() {
        return bono_regalo;
    }

    public void setBono_regalo(int bono_regalo) {
        this.bono_regalo = bono_regalo;
    }
    
    
    
}
