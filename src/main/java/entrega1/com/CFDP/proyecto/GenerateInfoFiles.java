package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.util.*;

public class GenerateInfoFiles {
    public static void generateInfoFiles() {
        Scanner scanner = new Scanner(System.in);

        try {
            // Leer datos de vendedores desde la consola
            System.out.print("Ingrese el tipo de documento del vendedor (CC/TI): ");
            String tipoDocumento = scanner.nextLine();

            System.out.print("Ingrese el número de documento del vendedor: ");
            String numeroDocumento = scanner.nextLine();

            System.out.print("Ingrese el nombre del vendedor: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido del vendedor: ");
            String apellido = scanner.nextLine();

            // Preguntar cuántos productos se vendieron
            System.out.print("Ingrese la cantidad de productos vendidos: ");
            int cantidadProductos = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            // Leer datos de productos desde la consola
            List<String> productos = new ArrayList<>();
            Random rand = new Random();
            for (int i = 1; i <= cantidadProductos; i++) {
                int randomId = 100 + rand.nextInt(900); // Generar número aleatorio de 3 dígitos
                String idProducto = randomId + "P" + i;

                System.out.print("Ingrese el nombre del producto " + i + ": ");
                String nombreProducto = scanner.nextLine();

                System.out.print("Ingrese el precio del producto " + i + ": ");
                double precioProducto = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea

                int cantidadVendida = rand.nextInt(100); // Cantidad vendida aleatoria

                productos.add(idProducto + ";" + nombreProducto + ";" + String.format(Locale.US, "%.2f", precioProducto) + ";" + cantidadVendida);
            }

            // Crear archivos con la información proporcionada
            createSalesMenFile(tipoDocumento, numeroDocumento, nombre, apellido, productos);
            createProductsFile(productos);
            createSalesManInfoFile(tipoDocumento, numeroDocumento, nombre, apellido);

            System.out.println("Archivos generados exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al generar los archivos: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void createSalesMenFile(String tipoDocumento, String numeroDocumento, String nombre, String apellido, List<String> productos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/ventas/" + numeroDocumento + ".txt"))) {
            writer.write(tipoDocumento + ";" + numeroDocumento + "\n");
            for (String producto : productos) {
                String[] parts = producto.split(";");
                String idProducto = parts[0];
                int cantidadVendida = Integer.parseInt(parts[3]);
                writer.write(idProducto + ";" + cantidadVendida + "\n");
            }
        }
    }

    public static void createProductsFile(List<String> productos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/productos.txt", true))) {
            for (String producto : productos) {
                String[] parts = producto.split(";");
                String idProducto = parts[0];
                String nombreProducto = parts[1];
                double precioProducto = Double.parseDouble(parts[2]);
                writer.write(idProducto + ";" + nombreProducto + ";" + String.format(Locale.US, "%.2f", precioProducto) + "\n");
            }
        }
    }

    public static void createSalesManInfoFile(String tipoDocumento, String numeroDocumento, String nombre, String apellido) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/vendedores.txt", true))) {
            writer.write(tipoDocumento + ";" + numeroDocumento + ";" + nombre + ";" + apellido + "\n");
        }
    }
}
