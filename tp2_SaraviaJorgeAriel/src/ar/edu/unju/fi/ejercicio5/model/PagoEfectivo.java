package ar.edu.unju.fi.ejercicio5.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	double montoPagado;
	LocalDate fechaPago;

	@Override
	public double realizarPago(double monto) {
		return monto - monto * 0.10;
	}

	@Override
	public void imprimirRecibo() {
		// Definir el formato deseado como String
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");

		// Crear un objeto DecimalFormat con el formato deseado "String"
		DecimalFormat formatoNum = new DecimalFormat("#,##0.00");

		System.out.println("Fecha de pago: " + fechaPago.format(formato));
		System.out.println("Monto pagado: " + formatoNum.format(montoPagado) + "$");
	}

}
