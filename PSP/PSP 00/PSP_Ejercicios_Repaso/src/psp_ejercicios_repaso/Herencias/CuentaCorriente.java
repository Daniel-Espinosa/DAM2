/*
La clase CuentaCorriente será una clase derivada de la clase Cuenta y
no deberá implementar el método pagarIntereses. ¿Qué ocurre si no lo
implementas?
*/
package psp_ejercicios_repaso.Herencias;

/**
 *
 * @author damt207
 */
public class CuentaCorriente extends Cuenta {

    public CuentaCorriente(String numeroCuenta, double saldo, int contador) {
        super(numeroCuenta, saldo, contador);
        Cuenta.setContador(Cuenta.getContador()+1);
    }

    

    @Override
    public void pagarIntereses() {
    
    }

    
    
}
