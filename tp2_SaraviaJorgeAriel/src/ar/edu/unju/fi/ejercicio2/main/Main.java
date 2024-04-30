package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	private static List<Efemeride> efemerides = new ArrayList<>();
	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		precargarEfemerides();
		int opcion;
		do {
			System.out.println("\nMenú de opciones:");
			System.out.println("1 - Crear Efemeride");
			System.out.println("2 - Mostrar Efemerides");
			System.out.println("3 - Eliminar Efemeride");
			System.out.println("4 - Modificar Efemeride");
			System.out.println("5 - Salir");
			System.out.println("Seleccione una opción:");
			try {
				opcion = entrada.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error: Por favor, ingrese un número entero válido.");
				entrada.next(); // Limpiar el buffer de residuos
				opcion = 0; // Asigno un valor por defecto para evitar un bucle infinito
			}
			switch (opcion) {
			case 1:
				crearEfemerida();
				break;
			case 2:
				mostrarEfemerides();
				break;
			case 3:
				eliminarEfemeride();
				break;
			case 4:

				break;
			case 5:
				System.out.println("Eligió la Opción 5, saliendo del programa...");
				break;

			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
				break;
			}

		} while (opcion != 5);
	}

	private static void crearEfemerida() {
		System.out.print("\nIngrese el codigo de la Efemeride: ");
		entrada.nextLine(); // Consumir el carácter de nueva línea
		String codigoEfemeride = entrada.nextLine();
		System.out.print("Ingrese el numero de mes: ");
		Mes mesEfemeride = obtenerMes();
		System.out.print("Ingrese Dia del Mes: ");
		Integer diaEfemeride = validarDia(mesEfemeride);
		entrada.nextLine(); // Consumir la bsaura del buffer
		System.out.print("Ingrese el detalle: ");
		String detalle = entrada.nextLine();
		Efemeride efemeride = new Efemeride(codigoEfemeride, mesEfemeride, diaEfemeride, detalle);
		efemerides.add(efemeride);
		System.out.println("\nefemeride creado exitosamente.");
	}

	private static Mes obtenerMes() {
		int mes;
		do {
			try {
				mes = entrada.nextInt();
				switch (mes) {
				case 1:
					return Mes.ENERO;
				case 2:
					return Mes.FEBRERO;
				case 3:
					return Mes.MARZO;
				case 4:
					return Mes.ABRIL;
				case 5:
					return Mes.MAYO;
				case 6:
					return Mes.JUNIO;
				case 7:
					return Mes.JULIO;
				case 8:
					return Mes.AGOSTO;
				case 9:
					return Mes.SEPTIEMBRE;
				case 10:
					return Mes.OCTUBRE;
				case 11:
					return Mes.NOVIEMBRE;
				case 12:
					return Mes.DICIEMBRE;
				default:
					System.out.println("Opción no válida. Inténtelo de nuevo.");
					break;
				}
			}

			catch (InputMismatchException e) {
				System.out.println("Error: Por favor, ingrese un número entero válido.");
				entrada.next(); // Limpiamos la basura del buffer
			}
		} while (true);
	}

	private static int validarDia(Mes mes) {
		int dia;
		if (mes == Mes.FEBRERO) {
			do {
				dia = entrada.nextInt();
				if (dia < 1 || dia > 29) {
					System.out.println("Error: Febrero tiene máximo 29 días. Inténtelo de nuevo.");
				}
			} while (dia < 1 || dia > 29);
		} else if (mes == Mes.ABRIL || mes == Mes.JUNIO || mes == Mes.SEPTIEMBRE || mes == Mes.NOVIEMBRE) {
			do {
				dia = entrada.nextInt();
				if (dia < 1 || dia > 30) {
					System.out.println("Error: Este mes tiene máximo 30 días. Inténtelo de nuevo.");
				}
			} while (dia < 1 || dia > 30);
		} else {
			do {
				dia = entrada.nextInt();
				if (dia < 1 || dia > 31) {
					System.out.println("Error: Este mes tiene máximo 31 días. Inténtelo de nuevo.");
				}
			} while (dia < 1 || dia > 31);
		}
		return dia;
	}

	private static void mostrarEfemerides() {
		if (efemerides.isEmpty()) {
			System.out.println("No hay Efemerides cargadas.");
		} else {
			for (Efemeride efemeride : efemerides) {
				System.out.println(efemeride);
			}
		}
	}
	
	private static void eliminarEfemeride() {
	    if (efemerides.isEmpty()) {
	        System.out.println("No se puede eliminar nada, no hay efemerides cargados");
	    } else {
	        System.out.print("Ingrese el codigo del efemeride que desea eliminar: ");
	        String codigo = entrada.nextLine();
	        Iterator<Efemeride> iterator = efemerides.iterator();
	        boolean encontrado = false;
	        while (iterator.hasNext()) {
	            Efemeride efemeride = iterator.next();
	            if (efemeride.getCodigo().equals(codigo)) {
	                iterator.remove();
	                encontrado = true;
	                System.out.println("Efemeride eliminado correctamente");
	                break; // Salir del bucle una vez que se elimina el efemeride
	            }
	        }
	        if (!encontrado) {
	            System.out.println("No se encuentra el efemeride con el codigo ingresado");
	        }
	    }
	}
	private static void modificarEfemeride() {
		
	}

	// Método para precargar la lista con efemérides
	private static void precargarEfemerides() {
		efemerides.add(new Efemeride("001", Mes.ENERO, 1, "Año Nuevo"));
		efemerides.add(new Efemeride("002", Mes.MAYO, 1, "Día del Trabajador"));
		efemerides.add(new Efemeride("003", Mes.JULIO, 9, "Día de la Independencia"));
		efemerides.add(new Efemeride("004", Mes.DICIEMBRE, 25, "Navidad"));
	}

}
