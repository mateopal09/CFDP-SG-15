package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class GeneradorArchivos {
     public static void generarReporteVendedores(List<Vendedor> vendedores, String archivoSalida) {
        vendedores.sort(Comparator.comparingDouble(Vendedor::getTotalVentas).reversed());
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {
            for (Vendedor vendedor : vendedores) {
                String totalVentasFormateado = numberFormat.format(vendedor.getTotalVentas());
                writer.write(vendedor.getNombres() + " " + vendedor.getApellidos() + ";" + totalVentasFormateado + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generarReporteProductos(Map<String, Producto> productos, String archivoSalida) {
        List<Producto> listaProductos = new ArrayList<>(productos.values());
        listaProductos.sort(Comparator.comparingInt(Producto::getCantidadVendida).reversed());
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {
            for (Producto producto : listaProductos) {
                String precioFormateado = numberFormat.format(producto.getPrecioPorUnidad());
                writer.write(producto.getNombre() + ";" + precioFormateado  + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
