package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Crear Producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Modificar producto");
            System.out.println("4 - Salir");
            System.out.println("Seleccione una opción:");

            opcion = obtenerEntero(scanner);

            switch (opcion) {
                case 1:
                    crearProducto(scanner, productos);
                    break;
                case 2:
                    mostrarProductos(productos);
                    break;
                case 3:
                    modificarProducto(scanner, productos);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 4);
    }

    private static void crearProducto(Scanner scanner, ArrayList<Producto> productos) {
        System.out.println("Ingrese el código del producto:");
        String codigo = scanner.next();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese la descripción del producto:");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese el precio unitario del producto:");
        double precioUnitario = obtenerDouble(scanner);

        System.out.println("Seleccione el origen de fabricación:");
        mostrarOpcionesOrigenFabricacion();
        Producto.OrigenFabricacion origenFabricacion = obtenerOrigenFabricacion(scanner);

        System.out.println("Seleccione la categoría del producto:");
        mostrarOpcionesCategoria();
        Producto.Categoria categoria = obtenerCategoria(scanner);

        Producto producto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
        productos.add(producto);
        System.out.println("Producto creado exitosamente.");
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
            return;
        }

        System.out.println("Listado de productos:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    private static void modificarProducto(Scanner scanner, ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para modificar.");
            return;
        }

        System.out.println("Ingrese el código del producto que desea modificar:");
        String codigo = scanner.next();

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

                int opcion = obtenerEntero(scanner);
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la nueva descripción:");
                        String nuevaDescripcion = scanner.next();
                        producto.setDescripcion(nuevaDescripcion);
                        System.out.println("Descripción modificada exitosamente.");
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo precio unitario:");
                        double nuevoPrecioUnitario = obtenerDouble(scanner);
                        producto.setPrecioUnitario(nuevoPrecioUnitario);
                        System.out.println("Precio unitario modificado exitosamente.");
                        break;
                    case 3:
                        System.out.println("Seleccione el nuevo origen de fabricación:");
                        mostrarOpcionesOrigenFabricacion();
                        Producto.OrigenFabricacion nuevoOrigen = obtenerOrigenFabricacion(scanner);
                        producto.setOrigenFabricacion(nuevoOrigen);
                        System.out.println("Origen de fabricación modificado exitosamente.");
                        break;
                    case 4:
                        System.out.println("Seleccione la nueva categoría:");
                        mostrarOpcionesCategoria();
                        Producto.Categoria nuevaCategoria = obtenerCategoria(scanner);
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
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún producto con el código especificado.");
        }
    }

    private static int obtenerEntero(Scanner scanner) {
        int numero = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                numero = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
                scanner.next(); // Limpiar el buffer
            }
        }
        return numero;
    }

    private static double obtenerDouble(Scanner scanner) {
        double numero = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                numero = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número decimal válido.");
                scanner.next(); // Limpiar el buffer
            }
        }
        return numero;
    }

    private static void mostrarOpcionesOrigenFabricacion() {
        System.out.println("------ Origen de fabricación ------");
        System.out.println("1 - Argentina");
        System.out.println("2 - China");
        System.out.println("3 - Brasil");
        System.out.println("4 - Uruguay");
    }

    private static Producto.OrigenFabricacion obtenerOrigenFabricacion(Scanner scanner) {
        int opcion;
        do {
            opcion = obtenerEntero(scanner);
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
        } while (true);
    }

    private static void mostrarOpcionesCategoria() {
        System.out.println("------ Categoría ------");
        System.out.println("1 - Telefonía");
        System.out.println("2 - Informática");
        System.out.println("3 - Electro hogar");
        System.out.println("4 - Herramientas");
    }

    private static Producto.Categoria obtenerCategoria(Scanner scanner) {
        int opcion;
        do {
            opcion = obtenerEntero(scanner);
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
        } while (true);
    }
}

 