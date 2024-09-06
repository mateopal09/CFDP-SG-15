package main.java.entrega1.com.CFDP.proyecto;

import java.io.Serializable;

public class Producto implements Serializable {
    private String id;
    private String nombre;
    private double precioPorUnidad;
    private int cantidadVendida;

    public Producto(String id, String nombre, double precioPorUnidad) {
        this.id = id;
        this.nombre = nombre;
        this.precioPorUnidad = precioPorUnidad;
        this.cantidadVendida = 0;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void agregarVenta(int cantidad) {
        this.cantidadVendida += cantidad;
    }
}
