package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.util.*;

public class GeneradorArchivos {
    public static void generarReporteVendedores(List<Vendedor> vendedores, String archivoSalida) {
        vendedores.sort(Comparator.comparingDouble(Vendedor::getTotalVentas).reversed());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {
            for (Vendedor vendedor : vendedores) {
                writer.write(vendedor.getNombres() + " " + vendedor.getApellidos() + ";" + vendedor.getTotalVentas() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generarReporteProductos(Map<String, Producto> productos, String archivoSalida) {
        List<Producto> listaProductos = new ArrayList<>(productos.values());
        listaProductos.sort(Comparator.comparingInt(Producto::getCantidadVendida).reversed());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {
            for (Producto producto : listaProductos) {
                writer.write(producto.getNombre() + ";" + producto.getPrecioPorUnidad() + ";" + producto.getCantidadVendida() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
