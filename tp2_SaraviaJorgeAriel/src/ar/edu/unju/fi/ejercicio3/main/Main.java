package ar.edu.unju.fi.ejercicio3.main;

import java.util.List;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		List<Provincia> provincias = new ArrayList<>();
		/**
		 * Paso el enum a un array y con el metodo asList clo comierto en un arraylist
		 */
		provincias.addAll(Arrays.asList(Provincia.values()));

		// Muestro las provincias almacenadas en la lista
		for (Provincia provincia : provincias) {
			System.out.println("Provincia: " + provincia + ", Población: " + provincia.getCantidadHabitantes()
					+ ", Superficie: " + provincia.getSuperficie() + " km²");
		}
	}
}
