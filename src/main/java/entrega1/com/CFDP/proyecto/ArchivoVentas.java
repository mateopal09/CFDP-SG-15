package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.util.*;

public class ArchivoVentas {
    public static List<Vendedor> leerVentas(String carpetaVentas, Map<String, Producto> productos) {
        Map<String, Vendedor> vendedoresMap = new HashMap<>();
        File carpeta = new File(carpetaVentas);
        for (File archivo : Objects.requireNonNull(carpeta.listFiles())) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                String idVendedor = null;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    if (partes.length == 2) {
                        idVendedor = partes[1];
                        vendedoresMap.putIfAbsent(idVendedor, new Vendedor(partes[0], partes[1], "", ""));
                    } else if (partes.length == 3 && idVendedor != null) {
                        Producto producto = productos.get(partes[0]);
                        if (producto != null) {
                            int cantidad = Integer.parseInt(partes[1]);
                            producto.agregarVenta(cantidad);
                            double monto = cantidad * producto.getPrecioPorUnidad();
                            vendedoresMap.get(idVendedor).agregarVenta(monto);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>(vendedoresMap.values());
    }
}
