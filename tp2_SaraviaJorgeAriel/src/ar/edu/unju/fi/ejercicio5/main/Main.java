package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {
	private static List<Producto> listaProductos = new ArrayList<>();
	private  static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		int opc = 0;
		precargarProductos();
		do {
			mostrarMenu();
            opc = entrada.nextInt();

            switch (opc) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    realizarCompra();
                    break;
                case 3:
                    System.out.println("Elijio Salir...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opc != 3);
		
	}
	
	private static void mostrarProductos() {
        System.out.println("Lista de productos:");
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }
    }
	private static void realizarCompra() {
		
	}
	private static void mostrarMenu() {
		// Menú de opciones
        System.out.println("\n1. – Mostrar productos");
        System.out.println("2. – Realizar compra");
        System.out.println("3. – Salir");
        System.out.print("Seleccione una opción:");
	}
	private static void precargarProductos() {
        listaProductos.add(new Producto("001", "Teléfono móvil", 299.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true));
        listaProductos.add(new Producto("002", "Portátil", 699.99, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, true));
        listaProductos.add(new Producto("003", "Tablet", 199.99, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
        listaProductos.add(new Producto("004", "Aspiradora", 149.99, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR, true));
        listaProductos.add(new Producto("005", "Taladro", 79.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.HERRAMIENTAS, true));
        listaProductos.add(new Producto("006", "Lavadora", 399.99, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
        listaProductos.add(new Producto("007", "Smart TV", 499.99, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
        listaProductos.add(new Producto("008", "Impresora", 129.99, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.INFORMATICA, true));
        listaProductos.add(new Producto("009", "Secadora", 349.99, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
        listaProductos.add(new Producto("010", "Martillo", 9.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.HERRAMIENTAS, true));
        listaProductos.add(new Producto("011", "Sierra circular", 59.99, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
        listaProductos.add(new Producto("012", "Teclado", 49.99, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
        listaProductos.add(new Producto("013", "Mouse", 19.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
        listaProductos.add(new Producto("014", "Cámara de seguridad", 89.99, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
        listaProductos.add(new Producto("015", "Bombillo inteligente", 29.99, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
    }
	
}
