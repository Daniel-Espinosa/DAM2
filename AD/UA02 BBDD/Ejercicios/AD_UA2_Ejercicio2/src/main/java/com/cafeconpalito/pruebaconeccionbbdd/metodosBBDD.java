/*
1. Lista el nombre de todos los productos que hay en la tabla producto.
2. Lista los nombres y los precios de todos los productos de la tabla producto.
3. Lista todas las columnas de la tabla producto.
4. Lista el nombre de los productos, el precio en euros y el precio en dólares
estadounidenses (USD).
5. Lista el nombre de los productos, el precio en euros y el precio en dólares
estadounidenses (USD). Utiliza los siguientes alias para las
columnas: nombre de producto, euros, dólares.
6. Lista los nombres y los precios de todos los productos de la tabla producto,
convirtiendo los nombres a mayúscula.
7. Lista los nombres y los precios de todos los productos de la tabla producto,
convirtiendo los nombres a minúscula.
8. Lista el nombre de todos los fabricantes en una columna, y en otra
columna obtenga en mayúsculas los dos primeros caracteres del nombre
del fabricante.
9. Lista los nombres y los precios de todos los productos de la tabla producto,
redondeando el valor del precio.
10. Lista los nombres y los precios de todos los productos de la tabla producto,
truncando el valor del precio para mostrarlo sin ninguna cifra decimal.
11. Lista el identificador de los fabricantes que tienen productos en la
tabla producto.
12. Lista el identificador de los fabricantes que tienen productos en la
tabla producto, eliminando los identificadores que aparecen repetidos.
13. Lista los nombres de los fabricantes ordenados de forma ascendente.
14. Lista los nombres de los fabricantes ordenados de forma descendente.
15. Lista los nombres de los productos ordenados en primer lugar por el
nombre de forma ascendente y en segundo lugar por el precio de forma
descendente.
16. Inserta tres nuevos productos a tu elección. Muestra la nueva tabla por
pantalla.
17. Inserta a dos fabricantes nuevos: Apple y Nvidia.
18. Modifica los productos de Seagate para que sean ahora de Lenovo.
19. Borra los fabricantes que empiezan por a.
20. Muestra las dos tablas diferenciándolas de alguna manera en la salida por
Netbeans.
 */
package com.cafeconpalito.pruebaconeccionbbdd;

import java.sql.*;

/**
 *
 * @author damt207
 */
public class metodosBBDD {

    private static Connection con;

    public static void setCon(Connection con) {
        metodosBBDD.con = con;
    }

    /**
     * 1. Lista el nombre de todos los productos que hay en la tabla producto.
     */
    public static void ProductosListarNombre() {

        System.out.println("\nListando Todos los nombres de productos ");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 2. Lista los nombres y los precios de todos los productos de la tabla
     * producto.
     */
    public static void ProductosListarNombrePrecio() {

        System.out.println("\nListando Nombre y Precio de Productos");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre,precio from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 3. Lista todas las columnas de la tabla producto.
     */
    public static void ProductosListarTodasColumnas() {

        System.out.println("\nListando Todo de productos (Select *)");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 4. Lista el nombre de los productos, el precio en euros y el precio en
     * dólares estadounidenses (USD)
     */
    public static void ProductosListarNombrePrecioEuDol() {

        System.out.println("\nLista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD)");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre ,precio ,precio*0.9451 from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 5. Lista el nombre de los productos, el precio en euros y el precio en
     * dólares estadounidenses (USD). Utiliza los siguientes alias para las
     * columnas: nombre de producto, euros, dólares
     */
    public static void ProductosListarNombrePrecioEuDol_ModNombreTabla() {

        System.out.println("\nLista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD)");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre as 'Nombre de Producto' ,precio as 'Euros' ,precio*0.9451 as 'Dolares' from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 6. Lista los nombres y los precios de todos los productos de la tabla
     * producto, convirtiendo los nombres a mayúscula
     */
    public static void ProductosListarNombreMayusPrecios() {

        System.out.println("\nLista el nombre de los productos en Mayusculas, el precio");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select UPPER(nombre),precio from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 7. Lista los nombres y los precios de todos los productos de la tabla
     * producto, convirtiendo los nombres a minúscula
     */
    public static void ProductorListarNombreMinusPrecios() {

        System.out.println("\nLista el nombre de los productos en Minuscula, el precio");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select LOWER(nombre),precio from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 8. Lista el nombre de todos los fabricantes en una columna, y en otra
     * columna obtenga en mayúsculas los dos primeros caracteres del nombre del
     * fabricante
     */
    public static void FabricantesNombreDosPrimerosCaracteres() {

        System.out.println("\nLista el nombre de los fabricantes, y los dos primeros caracteres del nombre en mayus");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre, upper(substring(nombre,1,2)) from fabricante";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * 9. Lista los nombres y los precios de todos los productos de la tabla producto,
    *redondeando el valor del precio.
     */
    public static void ProductosListarNombrePreciosRedondeado() {

        System.out.println("\nLista el nombre de los productos , el precio redondeado");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre, round(precio,0) from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }
    
    
    /**
    * 10. Lista los nombres y los precios de todos los productos de la tabla producto,
    *truncando el valor del precio para mostrarlo sin ninguna cifra decimal.
     */
    
    public static void ProductosListarNombrePreciosSinDecimal() {

        System.out.println("\nLista el nombre de los productos , el precio sin decimal");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre, format(precio,0) from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }
    
}
