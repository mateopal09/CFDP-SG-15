package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.util.*;

public class ArchivoVentas {
    public static List<Vendedor> leerVentas(String carpetaVentas, Map<String, Vendedor> vendedoresMap, Map<String, Producto> productosMap) throws IOException {
        File carpeta = new File(carpetaVentas);
        for (File archivo : Objects.requireNonNull(carpeta.listFiles())) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                String idVendedor = null;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    if (partes.length == 2 && partes[0].equals("CC")) {
                        idVendedor = partes[1];
                    } else if (partes.length == 2 && idVendedor != null) {
                        String idProducto = partes[0];
                        int cantidad = Integer.parseInt(partes[1]);
                        Producto producto = productosMap.get(idProducto);
                        if (producto != null) {
                            double precio = producto.getPrecioPorUnidad();
                            double monto = cantidad * precio;
                            Vendedor vendedor = vendedoresMap.get(idVendedor);
                            if (vendedor != null) {
                                vendedor.agregarVenta(monto);
                            }
                            producto.agregarVenta(cantidad);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(vendedoresMap.values());
    }
}
