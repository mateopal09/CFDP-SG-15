package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.util.*;

public class ArchivoProductos {
    public static Map<String, Producto> leerProductos(String archivoProductos) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
