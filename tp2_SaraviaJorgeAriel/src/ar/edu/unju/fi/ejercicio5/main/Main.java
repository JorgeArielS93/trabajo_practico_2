package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {
	private static List<Producto> listaProductos = new ArrayList<>();
	private static Scanner entrada = new Scanner(System.in);
	private static List<Producto> productosComprados = new ArrayList<>();

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
        double total = 0;

        System.out.println("Seleccione los productos que desea comprar:");
        mostrarProductos();
        System.out.println("Ingrese el código del producto que desea comprar (0 para terminar):");
        String codigoProducto = entrada.nextLine();
        while (!codigoProducto.equals("0")) {
            Producto productoSeleccionado = buscarProductoPorCodigo(codigoProducto);
            if (productoSeleccionado != null) {
                productosComprados.add(productoSeleccionado);
                total += productoSeleccionado.getPrecioUnitario();
            } else {
                System.out.println("El código ingresado no corresponde a un producto válido.");
            }
            System.out.println("Ingrese el código del siguiente producto que desea comprar (0 para terminar):");
            codigoProducto = entrada.nextLine(); // Leer el siguiente código de producto
        }

        System.out.println("Productos seleccionados:");
        for (Producto producto : productosComprados) {
            System.out.println(producto);
        }

        System.out.println("Total a pagar: $" + total);

        System.out.println("Seleccione el método de pago:");
        System.out.println("1 - Pago en efectivo");
        System.out.println("2 - Pago con tarjeta");
        int metodoPago = entrada.nextInt();
        entrada.nextLine(); // Consumir la línea en blanco

        switch (metodoPago) {
        case 1:
            PagoEfectivo pagoEfectivo = new PagoEfectivo(LocalDate.now()); // Pasar la fecha actual
            pagoEfectivo.realizarPago(total);
            pagoEfectivo.imprimirRecibo();
            break;
        case 2:
            PagoTarjeta pagoTarjeta = new PagoTarjeta(LocalDate.now()); // Pasar la fecha actual
            pagoTarjeta.realizarPago(total);
            pagoTarjeta.imprimirRecibo();
            break;
            default:
                System.out.println("Opción no válida.");
        }
    }

	private static Producto buscarProductoPorCodigo(String codigo) {
		for (Producto producto : listaProductos) {
			if (producto.getCodigo().equalsIgnoreCase(codigo)) {
				return producto;
			}
		}
		return null;
	}

	private static void mostrarMenu() {
		// Menú de opciones
		System.out.println("\n1. – Mostrar productos");
		System.out.println("2. – Realizar compra");
		System.out.println("3. – Salir");
		System.out.print("Seleccione una opción:");
	}

	private static void precargarProductos() {
		listaProductos.add(new Producto("1", "Teléfono móvil", 299.99, Producto.OrigenFabricacion.CHINA,Producto.Categoria.TELEFONIA, true));
		listaProductos.add(new Producto("2", "Portátil", 699.99, Producto.OrigenFabricacion.ARGENTINA,Producto.Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("3", "Tablet", 199.99, Producto.OrigenFabricacion.BRASIL,Producto.Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("4", "Aspiradora", 149.99, Producto.OrigenFabricacion.URUGUAY,Producto.Categoria.ELECTROHOGAR, true));
		listaProductos.add(new Producto("5", "Taladro", 79.99, Producto.OrigenFabricacion.CHINA,Producto.Categoria.HERRAMIENTAS, true));
		listaProductos.add(new Producto("6", "Lavadora", 399.99, Producto.OrigenFabricacion.BRASIL,Producto.Categoria.ELECTROHOGAR, true));
		listaProductos.add(new Producto("7", "Smart TV", 499.99, Producto.OrigenFabricacion.ARGENTINA,Producto.Categoria.ELECTROHOGAR, true));
		listaProductos.add(new Producto("8", "Impresora", 129.99, Producto.OrigenFabricacion.URUGUAY,Producto.Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("9", "Secadora", 349.99, Producto.OrigenFabricacion.ARGENTINA,Producto.Categoria.ELECTROHOGAR, true));
		listaProductos.add(new Producto("10", "Martillo", 9.99, Producto.OrigenFabricacion.CHINA,Producto.Categoria.HERRAMIENTAS, true));
		listaProductos.add(new Producto("11", "Sierra circular", 59.99, Producto.OrigenFabricacion.URUGUAY,Producto.Categoria.HERRAMIENTAS, true));
		listaProductos.add(new Producto("12", "Teclado", 49.99, Producto.OrigenFabricacion.BRASIL,Producto.Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("13", "Mouse", 19.99, Producto.OrigenFabricacion.CHINA,Producto.Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("14", "Cámara de seguridad", 89.99, Producto.OrigenFabricacion.ARGENTINA,Producto.Categoria.ELECTROHOGAR, true));
		listaProductos.add(new Producto("15", "Bombillo inteligente", 29.99, Producto.OrigenFabricacion.BRASIL,Producto.Categoria.ELECTROHOGAR, true));
	}

}
