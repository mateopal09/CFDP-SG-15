package main.java.entrega1.com.CFDP.proyecto;

import java.io.Serializable;

/**
 * Clase que representa un producto.
 */
public class Producto implements Serializable {
    private String id;
    private String nombre;
    private double precioPorUnidad;
    private int cantidadVendida;

    /**
     * Constructor de la clase Producto.
     *
     * @param id              Identificador del producto.
     * @param nombre          Nombre del producto.
     * @param precioPorUnidad Precio por unidad del producto.
     */
    public Producto(String id, String nombre, double precioPorUnidad) {
        this.id = id;
        this.nombre = nombre;
        this.precioPorUnidad = precioPorUnidad;
        this.cantidadVendida = 0;
    }

    /**
     * Obtiene el identificador del producto.
     *
     * @return Identificador del producto.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio por unidad del producto.
     *
     * @return Precio por unidad del producto.
     */
    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    /**
     * Obtiene la cantidad vendida del producto.
     *
     * @return Cantidad vendida del producto.
     */
    public int getCantidadVendida() {
        return cantidadVendida;
    }

    /**
     * Agrega una venta al producto.
     *
     * @param cantidad Cantidad vendida.
     */
    public void agregarVenta(int cantidad) {
        this.cantidadVendida += cantidad;
    }
}
