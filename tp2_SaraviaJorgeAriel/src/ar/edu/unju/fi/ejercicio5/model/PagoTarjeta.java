package ar.edu.unju.fi.ejercicio5.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	String nmrTarjera;
	LocalDate fechaPago;
	double montoPagado;

	@Override
	public double realizarPago(double monto) {
		return montoPagado= monto + monto * 0.15;
	}

	@Override
	public void imprimirRecibo() {
		 // Definir el formato deseado como String
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        
     // Crear un objeto DecimalFormat con el formato deseado "String"
        DecimalFormat formatoNum = new DecimalFormat("#,##0.00");
        
		System.out.println("Número de tarjeta: "+ nmrTarjera);
		System.out.println("Fecha de pago: "+ fechaPago.format(formato));
		System.out.println("Monto pagado: "+ formatoNum.format(montoPagado) + "$");
	}

	// Constructor que acepta la fecha de pago como parámetro
    public PagoTarjeta(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

	public String getNmrTarjera() {
		return nmrTarjera;
	}

	public void setNmrTarjera(String nmrTarjera) {
		this.nmrTarjera = nmrTarjera;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
	
}
