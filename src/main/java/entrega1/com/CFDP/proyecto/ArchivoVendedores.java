package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.util.*;

public class ArchivoVendedores {
    public static Map<String, Vendedor> leerVendedores(String archivoVendedores) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendedores;
    }
}
