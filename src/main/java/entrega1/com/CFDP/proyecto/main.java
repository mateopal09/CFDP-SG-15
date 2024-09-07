package main.java.entrega1.com.CFDP.proyecto;

import java.util.*;

/**
 * Clase principal que ejecuta la generación de reportes.
 */
public class main {
    /**
     * Método principal que ejecuta la generación de reportes de vendedores y productos.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        try {
            GenerateInfoFiles.generateInfoFiles();

            Map<String, Vendedor> vendedores = ArchivoVendedores.leerVendedores("data/vendedores.txt");
            Map<String, Producto> productos = ArchivoProductos.leerProductos("data/productos.txt");
            List<Vendedor> ventas = ArchivoVentas.leerVentas("data/ventas", vendedores, productos);

            GeneradorArchivos.generarReporteVendedores(ventas, "data/reporte_vendedores.csv");
            GeneradorArchivos.generarReporteProductos(productos, "data/reporte_productos.csv");

            System.out.println("Reportes generados exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al generar los reportes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
