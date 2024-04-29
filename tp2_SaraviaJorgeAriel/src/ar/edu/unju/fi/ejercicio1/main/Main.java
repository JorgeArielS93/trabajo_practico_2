package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {
	private static Scanner entrada = new Scanner(System.in);
	private static List<Producto> productos = new ArrayList<>();

	public static void main(String[] args) {
		precargarProductos();
		int opcion;
		do {
			System.out.println("Menú de opciones:");
			System.out.println("1 - Crear Producto");
			System.out.println("2 - Mostrar productos");
			System.out.println("3 - Modificar producto");
			System.out.println("4 - Salir");
			System.out.println("Seleccione una opción:");

			try {
				opcion = entrada.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Por favor, ingrese un número entero válido.");
				entrada.next(); // Limpiar el buffer
				opcion = 0; // Asignar un valor por defecto para evitar un bucle infinito
			}

			switch (opcion) {
			case 1:
				crearProducto();
				break;
			case 2:
				mostrarProductos();
				break;
			case 3:
				modificarProducto();
				break;
			case 4:
				System.out.println("Eligió la Opción 4, saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}
		} while (opcion != 4);
	}

	private static void crearProducto() {
		try {
			System.out.println("Ingrese el código del producto:");
			String codigo = entrada.next();

			System.out.println("Ingrese la descripción del producto:");
			String descripcion = entrada.next();

			System.out.println("Ingrese el precio unitario del producto:");

			double precioUnitario = entrada.nextDouble();

			System.out.println("Seleccione el origen de fabricación:");
			mostrarOpcionesOrigenFabricacion();
			Producto.OrigenFabricacion origenFabricacion = obtenerOrigenFabricacion();

			System.out.println("Seleccione la categoría del producto:");
			mostrarOpcionesCategoria();
			Producto.Categoria categoria = obtenerCategoria();

			Producto producto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
			productos.add(producto);
			System.out.println("Producto creado exitosamente.");
		} catch (InputMismatchException e) {
			System.out.println("Error: Por favor, ingrese un precio válido.");
			entrada.next(); // Limpiamos la basura del buffer
		}
	}

	private static void mostrarProductos() {
		if (productos.isEmpty()) {
			System.out.println("No hay productos para mostrar.");
		} else {
			System.out.println("Listado de productos:");
			for (Producto producto : productos) {
				System.out.println(producto);
			}
		}
	}

	private static void modificarProducto() {
		if (productos.isEmpty()) {
			System.out.println("No hay productos para modificar.");
			return;
		}

		System.out.println("Ingrese el código del producto que desea modificar:");
		String codigo = entrada.next();

		boolean encontrado = false;
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(codigo)) {
				encontrado = true;

				System.out.println("Seleccione qué desea modificar:");
				System.out.println("1 - Descripción");
				System.out.println("2 - Precio unitario");
				System.out.println("3 - Origen de fabricación");
				System.out.println("4 - Categoría");
				System.out.println("5 - Cancelar");
				System.out.println("Seleccione una opción:");

				try {
					int opcion = entrada.nextInt();
					switch (opcion) {
					case 1:
						System.out.println("Ingrese la nueva descripción:");
						String nuevaDescripcion = entrada.next();
						producto.setDescripcion(nuevaDescripcion);
						System.out.println("Descripción modificada exitosamente.");
						break;
					case 2:
						System.out.println("Ingrese el nuevo precio unitario:");
						double nuevoPrecioUnitario = entrada.nextDouble();
						producto.setPrecioUnitario(nuevoPrecioUnitario);
						System.out.println("Precio unitario modificado exitosamente.");
						break;
					case 3:
						System.out.println("Seleccione el nuevo origen de fabricación:");
						mostrarOpcionesOrigenFabricacion();
						Producto.OrigenFabricacion nuevoOrigen = obtenerOrigenFabricacion();
						producto.setOrigenFabricacion(nuevoOrigen);
						System.out.println("Origen de fabricación modificado exitosamente.");
						break;
					case 4:
						System.out.println("Seleccione la nueva categoría:");
						mostrarOpcionesCategoria();
						Producto.Categoria nuevaCategoria = obtenerCategoria();
						producto.setCategoria(nuevaCategoria);
						System.out.println("Categoría modificada exitosamente.");
						break;
					case 5:
						System.out.println("Operación cancelada.");
						break;
					default:
						System.out.println("Opción no válida. Inténtelo de nuevo.");
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("Error: Por favor, ingrese un número entero válido.");
					entrada.next(); // Limpiamos la basura del buffer
				}
			}
		}
		if (!encontrado) {
			System.out.println("No se encontró ningún producto con el código especificado.");
		}
	}

	private static void mostrarOpcionesOrigenFabricacion() {
		System.out.println("------ Origen de fabricación ------");
		System.out.println("1 - Argentina");
		System.out.println("2 - China");
		System.out.println("3 - Brasil");
		System.out.println("4 - Uruguay");
	}

	private static Producto.OrigenFabricacion obtenerOrigenFabricacion() {
		int opcion;
		do {
			try {
				opcion = entrada.nextInt();
				switch (opcion) {
				case 1:
					return Producto.OrigenFabricacion.ARGENTINA;
				case 2:
					return Producto.OrigenFabricacion.CHINA;
				case 3:
					return Producto.OrigenFabricacion.BRASIL;
				case 4:
					return Producto.OrigenFabricacion.URUGUAY;
				default:
					System.out.println("Opción no válida. Inténtelo de nuevo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Por favor, ingrese un número entero válido.");
				entrada.next(); // Limpiamos la basura del buffer
			}
		} while (true);/**
						 * el while (true) indica que el bucle do-while se ejecutará indefinidamente, ya
						 * que la condición true es siempre verdadera. Sin embargo, el bucle se detendrá
						 * cuando se ejecute una instrucción de return dentro del bucle, ya que esto
						 * finaliza la ejecución del método y, por ende, el bucle.
						 */
	}

	private static void mostrarOpcionesCategoria() {
		System.out.println("------ Categoría ------");
		System.out.println("1 - Telefonía");
		System.out.println("2 - Informática");
		System.out.println("3 - Electro hogar");
		System.out.println("4 - Herramientas");
	}

	private static Producto.Categoria obtenerCategoria() {
		int opcion;
		do {
			try {
				opcion = entrada.nextInt();
				switch (opcion) {
				case 1:
					return Producto.Categoria.TELEFONIA;
				case 2:
					return Producto.Categoria.INFORMATICA;
				case 3:
					return Producto.Categoria.ELECTROHOGAR;
				case 4:
					return Producto.Categoria.HERRAMIENTAS;
				default:
					System.out.println("Opción no válida. Inténtelo de nuevo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Por favor, ingrese un número entero válido.");
				entrada.next(); // Limpiamos la basura del buffer
			}
		} while (true);
	}

	private static void precargarProductos() {
		productos.add(new Producto("001", "Teléfono móvil", 299.99, Producto.OrigenFabricacion.CHINA,
				Producto.Categoria.TELEFONIA));
		productos.add(new Producto("002", "Notebook", 899.99, Producto.OrigenFabricacion.ARGENTINA,
				Producto.Categoria.INFORMATICA));
		productos.add(new Producto("003", "Lavadora", 499.99, Producto.OrigenFabricacion.BRASIL,
				Producto.Categoria.ELECTROHOGAR));
		productos.add(new Producto("004", "Taladro", 59.99, Producto.OrigenFabricacion.URUGUAY,
				Producto.Categoria.HERRAMIENTAS));
	}
}
