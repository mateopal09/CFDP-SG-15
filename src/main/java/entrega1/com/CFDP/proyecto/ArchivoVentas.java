package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.util.*;

/**
 * Clase para leer archivos de ventas.
 */
public class ArchivoVentas {

    /**
     * Lee los archivos de ventas desde una carpeta y actualiza la información de vendedores y productos.
     *
     * @param carpetaVentas  Ruta de la carpeta que contiene los archivos de ventas.
     * @param vendedoresMap  Mapa de vendedores.
     * @param productosMap   Mapa de productos.
     * @return Lista de vendedores con las ventas actualizadas.
     * @throws IOException Si ocurre un error al leer los archivos.
     */
    public static List<Vendedor> leerVentas(String carpetaVentas, Map<String, Vendedor> vendedoresMap, Map<String, Producto> productosMap) throws IOException {
        File carpeta = new File(carpetaVentas);
        for (File archivo : Objects.requireNonNull(carpeta.listFiles())) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                String idVendedor = null;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    if (partes.length == 2 && (partes[0].equalsIgnoreCase("CC") || partes[0].equalsIgnoreCase("TI"))) {
                        idVendedor = partes[1];
                    } else if (partes.length == 2 && idVendedor != null) {
                        String idProducto = partes[0];
                        int cantidad;
                        try {
                            cantidad = Integer.parseInt(partes[1]);
                        } catch (NumberFormatException e) {
                            System.err.println("Cantidad inválida en línea: " + linea);
                            continue;
                        }
    
                        Producto producto = productosMap.get(idProducto);
                        if (producto != null) {
                            double precio = producto.getPrecioPorUnidad();
                            double monto = cantidad * precio;
                            Vendedor vendedor = vendedoresMap.get(idVendedor);
                            if (vendedor != null) {
                                vendedor.agregarVenta(monto);
                            }
                            producto.agregarVenta(cantidad);
                        } else {
                            System.err.println("Producto no encontrado: " + idProducto);
                        }
                    } else {
                        System.err.println("Formato incorrecto en línea: " + linea);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + archivo.getName());
                e.printStackTrace();
            }
        }
        return new ArrayList<>(vendedoresMap.values());
    }
    
}
