package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);
		// definición de expresión lambda que define el convertidor de FelinoDomestico a
		// FelinoSalvaje.
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(),
				x.getPeso());
		// se realiza la conversión
		FelinoSalvaje felino1 = converter.convert(gato);
		// mostramos los datos del objeto felino salvaje felino1
		converter.mostrarObjeto(felino1);
		
		//Convertir felino salvaje a Felino domestico
		FelinoSalvaje gatin = new FelinoSalvaje("Tanner", (byte) 20, 186f);

		// Verificar si el objeto a convertir no es nulo
		if (Converter.isNotNull(gatin)) {
			// Definir expresión lambda que define el convertidor de FelinoSalvaje a
			// FelinoDomestico
			Converter<FelinoSalvaje, FelinoDomestico> converter2 = x -> new FelinoDomestico(x.getNombre(), x.getEdad(),
					x.getPeso());

			// Realizar la conversión
			FelinoDomestico felino2 = converter2.convert(gatin);

			// Mostrar los datos del objeto felino doméstico felino2
			converter2.mostrarObjeto(felino2);
		} else {
			System.out.println("El objeto a convertir es nulo.");
		}
	}
}
