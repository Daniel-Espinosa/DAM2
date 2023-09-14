/*
1. La cuenta tendrá tres atributos: numeroCuenta, saldo y contador. El
contador se utilizará para almacenar el número de cuentas que se han creado

2. La cuenta además tendrá un constructor por defecto y uno con tres
parámetros. No tendrá métodos get y set de los atributos correspondientes. ¿Son
necesarios?

3. Además, tendrá definido un método pagarIntereses que deberá ser
redefinido en

4. las clases derivadas.
5. No se podrán instanciar objetos de tipo Cuenta.
6. La clase CuentaCorriente será una clase derivada de la clase Cuenta y
no deberá implementar el método pagarIntereses. ¿Qué ocurre si no lo
implementas?
7. La clase CuentaJoven dispondrá del método pagarIntereses que
incrementará el saldo de la cuenta en un 5%. ¿Puedes modificar el saldo con la
información que tienes hasta ahora?
8. No podrán crearse clases derivadas de la clase CuentaJoven.
9. La clase CuentaMuyCorriente será una clase derivada de la clase
CuentaCorriente.
10. La clase CuentaMuyJoven será una clase derivada de la clase
CuentaJoven. ¿Qué ocurre cuando intentas crear esta clase?

*/
package psp_ejercicios_repaso.Herencias;

/**
 *
 * @author damt207
 */
public abstract class Cuenta {
    
    
    private String numeroCuenta;
    private double saldo;
    private static int contador;

    public Cuenta() {
    }
   

    public Cuenta(String numeroCuenta, double saldo, int contador) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        Cuenta.contador = contador;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Cuenta.contador = contador;
    }


    
    // metodo abstracto
    public abstract void pagarIntereses ();
    
    
}
