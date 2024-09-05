package main.java.entrega1.com.CFDP.proyecto;

import java.io.*;
import java.util.Random;

public class GenerateInfoFiles {
    public static void main(String[] args) {
        try {
            createSalesMenFile(10, "Juan Perez", 123456789);
            createProductsFile(10);
            createSalesManInfoFile(10);
            System.out.println("Archivos generados exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al generar los archivos: " + e.getMessage());
        }
    }

    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/ventas/" + id + ".txt"))) {
            Random rand = new Random();
            for (int i = 0; i < randomSalesCount; i++) {
                writer.write("CC;" + id + "\n");
                writer.write("P" + (i + 1) + ";" + rand.nextInt(100) + "\n");
            }
        }
    }

    public static void createProductsFile(int productsCount) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/productos.txt"))) {
            Random rand = new Random();
            for (int i = 0; i < productsCount; i++) {
                writer.write("P" + (i + 1) + ";Producto" + (i + 1) + ";" + (rand.nextDouble() * 100) + "\n");
            }
        }
    }

    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/vendedores.txt"))) {
            for (int i = 0; i < salesmanCount; i++) {
                writer.write("CC;" + (123456789 + i) + ";Nombre" + (i + 1) + ";Apellido" + (i + 1) + "\n");
            }
        }
    }
}