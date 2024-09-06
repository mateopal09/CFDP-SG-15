package main.java.entrega1.com.CFDP.proyecto;

import java.io.Serializable;

public class Vendedor implements Serializable {
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private double totalVentas;

    public Vendedor(String tipoDocumento, String numeroDocumento, String nombres, String apellidos) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.totalVentas = 0.0;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void agregarVenta(double monto) {
        this.totalVentas += monto;
    }
}
