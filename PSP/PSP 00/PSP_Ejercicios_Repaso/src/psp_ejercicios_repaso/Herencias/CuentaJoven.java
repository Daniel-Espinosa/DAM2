/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ejercicios_repaso.Herencias;

/**
 *
 * @author damt207
 */
public final class CuentaJoven extends Cuenta{



    public CuentaJoven(String numeroCuenta, double saldo, int contador) {
        super(numeroCuenta, saldo, contador);
        Cuenta.setContador(Cuenta.getContador()+1);
    }

    
    /*
    La clase CuentaJoven dispondrá del método pagarIntereses que
incrementará el saldo de la cuenta en un 5%. ¿Puedes modificar el saldo con la
información que tienes hasta ahora?
    */
    @Override
    public void pagarIntereses() {
        super.setSaldo(getSaldo()*1.05);
    }
    
    
    
}
