package main.java.entrega1.com.CFDP.proyecto;

import java.io.Serializable;

/**
 * Clase que representa un vendedor.
 */
public class Vendedor implements Serializable {
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private double totalVentas;

    /**
     * Constructor de la clase Vendedor.
     *
     * @param tipoDocumento   Tipo de documento del vendedor.
     * @param numeroDocumento Número de documento del vendedor.
     * @param nombres         Nombres del vendedor.
     * @param apellidos       Apellidos del vendedor.
     */
    public Vendedor(String tipoDocumento, String numeroDocumento, String nombres, String apellidos) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.totalVentas = 0.0;
    }

    /**
     * Obtiene el tipo de documento del vendedor.
     *
     * @return Tipo de documento del vendedor.
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Obtiene el número de documento del vendedor.
     *
     * @return Número de documento del vendedor.
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Obtiene los nombres del vendedor.
     *
     * @return Nombres del vendedor.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Obtiene los apellidos del vendedor.
     *
     * @return Apellidos del vendedor.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Obtiene el total de ventas del vendedor.
     *
     * @return Total de ventas del vendedor.
     */
    public double getTotalVentas() {
        return totalVentas;
    }

    /**
     * Agrega una venta al total de ventas del vendedor.
     *
     * @param monto Monto de la venta.
     */
    public void agregarVenta(double monto) {
        this.totalVentas += monto;
    }
}
