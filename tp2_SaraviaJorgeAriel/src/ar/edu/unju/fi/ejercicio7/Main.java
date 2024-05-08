package ar.edu.unju.fi.ejercicio7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {
	private static List<Producto> listaProductos = new ArrayList<>();
	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		precargarProductos();
		int opc = 0;
		do {
			mostrarMenu();
			try {
				
				opc = entrada.nextInt();
				Consumer<Producto> mostrarProductos = p -> System.out.println(p);//lambda que muestra la lista de productos
				
				switch (opc) {
				case 1:
					Consumer<Producto> mostrarProdcutosEnStock = p -> {
						if (p.isEstado())
							System.out.println(p);
					};
					listaProductos.forEach(mostrarProdcutosEnStock);
					break;
				case 2:
					Predicate<Producto> filtroProdcutosAgotados = p -> !p.isEstado();//declaramos un filtro solo retorna true o false

					List<Producto> productosAgotados = listaProductos.stream().filter(filtroProdcutosAgotados).collect(Collectors.toList());
					productosAgotados.forEach(mostrarProductos);
					
					break;
				case 3:
					Function<Producto, Producto> incrementarPrecio = p -> {
					    double nuevoPrecio = p.getPrecioUnitario() + (p.getPrecioUnitario() * 0.20);
					    nuevoPrecio = Math.round(nuevoPrecio * 100.0) / 100.0; // Redondear a dos decimales
					    p.setPrecioUnitario(nuevoPrecio);
					    return p;
					};
					List<Producto> productosIncrementados=listaProductos.stream().map(incrementarPrecio).collect(Collectors.toList());
					productosIncrementados.forEach(mostrarProductos);

					break;
				case 4:
					Predicate<Producto> filtroCatElectroHogar = p -> p.getCategoria().equals(Producto.Categoria.ELECTROHOGAR) && p.isEstado();
					List<Producto> catHelectroHogar = listaProductos.stream().filter(filtroCatElectroHogar).collect(Collectors.toList());
					catHelectroHogar.forEach(mostrarProductos);
					break;
				case 5:

					break;
				case 6:

					break;
				case 7:

					break;

				default:
					System.out.println("Opción no válida. Intente de nuevo.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Debe ingresar un número como opción.");
				entrada.next(); // Limpiar el búfer de entrada
			}

		} while (opc != 7);
	}
	
	private static void precargarProductos() {
		listaProductos.add(new Producto("1", "Teléfono móvil", 299.99, Producto.OrigenFabricacion.CHINA,Producto.Categoria.TELEFONIA, true));
		listaProductos.add(new Producto("2", "Portátil", 699.99, Producto.OrigenFabricacion.ARGENTINA,Producto.Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("3", "Tablet", 199.99, Producto.OrigenFabricacion.BRASIL,Producto.Categoria.INFORMATICA, false));
		listaProductos.add(new Producto("4", "Aspiradora", 149.99, Producto.OrigenFabricacion.URUGUAY,Producto.Categoria.ELECTROHOGAR, true));
		listaProductos.add(new Producto("5", "Taladro", 79.99, Producto.OrigenFabricacion.CHINA,Producto.Categoria.HERRAMIENTAS, false));
		listaProductos.add(new Producto("6", "Lavadora", 399.99, Producto.OrigenFabricacion.BRASIL,Producto.Categoria.ELECTROHOGAR, false));
		listaProductos.add(new Producto("7", "Smart TV", 499.99, Producto.OrigenFabricacion.ARGENTINA,Producto.Categoria.ELECTROHOGAR, true));
		listaProductos.add(new Producto("8", "Impresora", 129.99, Producto.OrigenFabricacion.URUGUAY,Producto.Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("9", "Secadora", 349.99, Producto.OrigenFabricacion.ARGENTINA,Producto.Categoria.ELECTROHOGAR, true));
		listaProductos.add(new Producto("10", "Martillo", 9.99, Producto.OrigenFabricacion.CHINA,Producto.Categoria.HERRAMIENTAS, false));
		listaProductos.add(new Producto("11", "Sierra circular", 59.99, Producto.OrigenFabricacion.URUGUAY,Producto.Categoria.HERRAMIENTAS, true));
		listaProductos.add(new Producto("12", "Teclado", 49.99, Producto.OrigenFabricacion.BRASIL,Producto.Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("13", "Mouse", 19.99, Producto.OrigenFabricacion.CHINA,Producto.Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("14", "Cámara de seguridad", 89.99, Producto.OrigenFabricacion.ARGENTINA,Producto.Categoria.ELECTROHOGAR, true));
		listaProductos.add(new Producto("15", "Bombillo inteligente", 29.99, Producto.OrigenFabricacion.BRASIL,Producto.Categoria.ELECTROHOGAR, false));
	}
	private static void mostrarMenu() {
		System.out.println("\n1. – Mostrar productos");
		System.out.println("2. – Mostrar los productos faltantes");
		System.out.println("3. – Incrementar los precios de los productos en un 20%");
		System.out.println("4. – Mostrar los productos disponibles de la categoría Electrohogar");
		System.out.println("5. – Ordenar los productos por precio de forma descendente");
		System.out.println("6. - Mostrar los productos con los nombres en mayúsculas");
		System.out.println("7. - Salir");
		System.out.print("Seleccione una opción:\n");
	}

}
