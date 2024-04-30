package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	private static List<Jugador> jugadores = new ArrayList<>();
	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
	    int opc = 0;
	    precargarJugadores();
	    do {
	        try {
	            mostrarMenu();
	            opc = entrada.nextInt();
	            entrada.nextLine(); // Limpiar la basura del buffer
	            switch (opc) {
	                case 1:
	                    altaJugador();
	                    break;
	                case 2:
	                    mostrarTodosLosJugadores();
	                    break;
	                case 3:
	                    modificarPosicionJugador();
	                    break;
	                case 4:
	                    eliminarJugador();
	                    break;
	                case 5:
	                    System.out.println("Eligio Salir, saliendo del programa...");
	                    break;
	                default:
	                    System.out.println("Opción no válida, por favor ingrese un número del 1 al 5.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Error: Entrada inválida. Por favor, asegúrese de ingresar un número entero.");
	            entrada.nextLine(); // Limpiar el buffer en caso de entrada inválida
	            opc = 0; // Asignar un valor por defecto para evitar un bucle infinito
	        } catch (Exception e) {
	            System.out.println("Error: Ocurrió un error inesperado. Por favor, inténtelo de nuevo.");
	        }
	    } while (opc != 5);

	    entrada.close();
	}


	private static void eliminarJugador() {
		System.out.println("\nEliminar un jugador:");
		System.out.print("Ingrese el nombre: ");
		String nombre = entrada.nextLine();
		System.out.print("Ingrese el apellido: ");
		String apellido = entrada.nextLine();
		
		boolean jugadorEncontrado = false;
		Iterator<Jugador> iterador = jugadores.iterator();
		while (iterador.hasNext()) {
			Jugador jugador = iterador.next();
			if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
				iterador.remove();
				System.out.println("Jugador eliminado correctamente.");
				jugadorEncontrado = true;
				break; // Salir del bucle una vez que se encuentra el jugador
			}
		}
		if (!jugadorEncontrado) {
		    System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
		}
	}

	private static void modificarPosicionJugador() {
		System.out.println("\nModificar la posicion de un jugador:");

		System.out.print("Ingrese el nombre: ");
		String nombre = entrada.nextLine();
		System.out.print("Ingrese el apellido: ");
		String apellido = entrada.nextLine();

		boolean jugadorEncontrado = false;
		for (Jugador jugador : jugadores) {
			if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
				System.out.print("\nSeleccione una posicion: ");
				mostrarPosiciones();
				Posicion posicion = obtenerPosicion();
				jugador.setPosicion(posicion);
				System.out.println("Datos modificados correctamente.");
				jugadorEncontrado = true;
				break; // Salir del bucle una vez que se encuentra y modifica el jugador
			}
		}
		if (!jugadorEncontrado) {
			System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
		}
	}

	private static void mostrarTodosLosJugadores() {
		if (jugadores.isEmpty()) {
			System.out.println("No hay jugadores, no se pueden mostrar");
		} else {
			for (Jugador jugador : jugadores) {
				System.out.println(jugador);
			}

		}
	}

	private static void altaJugador() {
	    System.out.println("\nAlta de jugador:");
	    boolean ingresoCorrecto;
	    do {
	        try {
	            ingresoCorrecto = true; // Establecer como verdadero por defecto
	            System.out.print("Ingrese el nombre: ");
	            String nombre = entrada.nextLine();
	            System.out.print("Ingrese el apellido: ");
	            String apellido = entrada.nextLine();
	            LocalDate fechaNacimiento;
	            do {
	                try {
	                    System.out.println("Ingrese la fecha de nacimiento d/M/yyyy :");
	                    String fechaNacimientoStr = entrada.nextLine();
	                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
	                    fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
	                    break; // Salir del bucle si la fecha se parsea correctamente
	                } catch (DateTimeParseException e) {
	                    System.out.println("Error: Formato de fecha incorrecto. Por favor, ingrese la fecha en el formato d/M/yyyy.");
	                }
	            } while (true); // Repetir hasta que la fecha se ingrese correctamente
	            
	            double estatura;
	            do {
	                try {
	                    System.out.print("Ingrese la estatura (en metros): ");
	                    estatura = entrada.nextDouble();
	                    entrada.nextLine(); // Limpiar basura del buffer
	                    if (estatura <= 0) {
	                        throw new IllegalArgumentException("La estatura debe ser un número positivo.");
	                    }
	                    break; // Salir del bucle si la estatura es válida
	                } catch (InputMismatchException e) {
	                    System.out.println("Error: Entrada inválida. Por favor, asegúrese de ingresar un número para la estatura.");
	                    entrada.nextLine(); // Limpiar basura del buffer
	                } catch (IllegalArgumentException e) {
	                    System.out.println(e.getMessage());
	                }
	            } while (true); // Repetir hasta que la estatura sea válida
	            
	            double peso;
	            do {
	                try {
	                    System.out.print("Ingrese el peso (en kilogramos): ");
	                    peso = entrada.nextDouble();
	                    entrada.nextLine(); // Limpiar basura del buffer
	                    if (peso <= 0) {
	                        throw new IllegalArgumentException("El peso debe ser un número positivo.");
	                    }
	                    break; // Salir del bucle si el peso es válido
	                } catch (InputMismatchException e) {
	                    System.out.println("Error: Entrada inválida. Por favor, asegúrese de ingresar un número para el peso.");
	                    entrada.nextLine(); // Limpiar basura del buffer
	                } catch (IllegalArgumentException e) {
	                    System.out.println(e.getMessage());
	                }
	            } while (true); // Repetir hasta que el peso sea válido
	            
	            System.out.print("Ingrese la nacionalidad: ");
	            String nacionalidad = entrada.nextLine();
	            System.out.print("Seleccione una posición: \n");
	            mostrarPosiciones();
	            Posicion posicion = obtenerPosicion();
	            Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
	            jugadores.add(jugador);
	            System.out.println("¡Jugador creado exitosamente!");
	        } catch (Exception e) {
	            ingresoCorrecto = false; // Establecer como falso si hay una excepción
	            System.out.println("Error: Ocurrió un error inesperado. Por favor, inténtelo de nuevo.");
	        }
	    } while (!ingresoCorrecto); // Repetir hasta que el ingreso sea correcto
	}




	private static void mostrarMenu() {
		System.out.println("\nMenú de opciones:");
		System.out.println("1 - Alta de jugador");
		System.out.println("2 - Mostrar todos los jugadores");
		System.out.println("3 - Modificar la posición de un jugador");
		System.out.println("4 - Eliminar un jugador");
		System.out.println("5 - Salir");
		System.out.print("\nIngrese su opción: ");
	}
	private static void mostrarPosiciones() {
		System.out.println("------ Posicion ------");
		System.out.println("1 - Delantero");
		System.out.println("2 - Medio");
		System.out.println("3 - Defensa");
		System.out.println("4 - Arquero");
		System.out.print("\nIngrese su opción: ");
	}
	private static Posicion obtenerPosicion() {
		int opc;
		do {
			try {
				opc=entrada.nextInt();
				switch (opc) {
				case 1:
					return Posicion.DELANTERO;
				case 2:
					return Posicion.MEDIO;
				case 3:
					return Posicion.DEFENSA;
				case 4:
					return Posicion.ARQUERO;
				default:
					System.out.println("Opción no válida. Inténtelo de nuevo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Por favor, ingrese un número entero válido.");
				entrada.next(); // Limpiamos la basura del buffer
			}
			
		} while (true);
	}
	private static void precargarJugadores() {
		jugadores.add(new Jugador("Lionel", "Messi", LocalDate.of(1987, 6, 24), "Argentina", 1.70, 72.5, Posicion.DELANTERO));
		jugadores.add(new Jugador("Cristiano", "Ronaldo", LocalDate.of(1985, 2, 5), "Portugal", 1.87, 83.0,Posicion.DELANTERO));
		jugadores.add(new Jugador("Neymar", "Jr", LocalDate.of(1992, 2, 5), "Brasil", 1.75, 68.0, Posicion.DELANTERO));
		jugadores.add(new Jugador("Luis", "Suárez", LocalDate.of(1987, 1, 24), "Uruguay", 1.82, 86.0, Posicion.DELANTERO));
		jugadores.add(new Jugador("Robert", "Lewandowski", LocalDate.of(1988, 8, 21), "Polonia", 1.84, 80.0,Posicion.DELANTERO));
	}
}
