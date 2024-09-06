package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) {
        try {
            Map<String, Vendedor> vendedores = ArchivoVendedores.leerVendedores("data/vendedores.txt");
            Map<String, Producto> productos = ArchivoProductos.leerProductos("data/productos.txt");
            List<Vendedor> ventas = ArchivoVentas.leerVentas("data/ventas");

            GeneradorArchivos.generarReporteVendedores(ventas, "data/reporte_vendedores.csv");
            GeneradorArchivos.generarReporteProductos(productos, "data/reporte_productos.csv");

            System.out.println("Reportes generados exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al generar los reportes: " + e.getMessage());
        }
    }
}