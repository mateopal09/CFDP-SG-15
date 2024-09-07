package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.util.*;

/**
 * Clase para leer archivos de productos.
 */
public class ArchivoProductos {

    /**
     * Lee el archivo de productos y crea un mapa de productos.
     *
     * @param archivoProductos Ruta del archivo de productos.
     * @return Mapa de productos.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public static Map<String, Producto> leerProductos(String archivoProductos) throws IOException {
        Map<String, Producto> productos = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoProductos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    Producto producto = new Producto(partes[0], partes[1], Double.parseDouble(partes[2]));
                    productos.put(partes[0], producto);
                }
            }
        }
        return productos;
    }
}
