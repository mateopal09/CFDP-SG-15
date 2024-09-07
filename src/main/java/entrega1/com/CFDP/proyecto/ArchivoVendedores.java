package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.util.*;

/**
 * Clase para leer archivos de vendedores.
 */
public class ArchivoVendedores {

    /**
     * Lee el archivo de vendedores y crea un mapa de vendedores.
     *
     * @param archivoVendedores Ruta del archivo de vendedores.
     * @return Mapa de vendedores.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public static Map<String, Vendedor> leerVendedores(String archivoVendedores) throws IOException {
        Map<String, Vendedor> vendedores = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoVendedores))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    Vendedor vendedor = new Vendedor(partes[0], partes[1], partes[2], partes[3]);
                    vendedores.put(partes[1], vendedor);
                }
            }
        }
        return vendedores;
    }
}
