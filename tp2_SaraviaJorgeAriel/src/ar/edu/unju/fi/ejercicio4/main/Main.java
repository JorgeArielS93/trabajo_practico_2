package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	private static List<Jugador> jugadores = new ArrayList<>();
	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;
		precargarJugadores();
		do {
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
		} while (opc != 8);

		entrada.close();

	}

	private static void eliminarJugador() {
		// TODO Auto-generated method stub

	}

	private static void modificarPosicionJugador() {
		// TODO Auto-generated method stub

	}

	private static void mostrarTodosLosJugadores() {
		// TODO Auto-generated method stub

	}

	private static void altaJugador() {
		// TODO Auto-generated method stub

	}

	public static void mostrarMenu() {
		System.out.println("\nMenú de opciones:");
		System.out.println("1 - Alta de jugador");
		System.out.println("2 - Mostrar todos los jugadores");
		System.out.println("3 - Modificar la posición de un jugador");
		System.out.println("4 - Eliminar un jugador");
		System.out.println("5 - Salir");
		System.out.print("Ingrese su opción: ");
	}

	private static void precargarJugadores() {
		jugadores.add(new Jugador("Lionel", "Messi", LocalDate.of(1987, 6, 24), "Argentina", 1.70, 72.5, Posicion.DELANTERO));
		jugadores.add(new Jugador("Cristiano", "Ronaldo", LocalDate.of(1985, 2, 5), "Portugal", 1.87, 83.0,Posicion.DELANTERO));
		jugadores.add(new Jugador("Neymar", "Jr", LocalDate.of(1992, 2, 5), "Brasil", 1.75, 68.0, Posicion.DELANTERO));
		jugadores.add(new Jugador("Luis", "Suárez", LocalDate.of(1987, 1, 24), "Uruguay", 1.82, 86.0, Posicion.DELANTERO));
		jugadores.add(new Jugador("Robert", "Lewandowski", LocalDate.of(1988, 8, 21), "Polonia", 1.84, 80.0,Posicion.DELANTERO));
	}
}
