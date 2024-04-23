package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	private String codigo;
	private String descripcion;
	private double precioUnitario;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;

	// Enum para origen de fabricación
	public enum OrigenFabricacion {
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}

	// Enum para categoría
	public enum Categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public Producto(String codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}

	// Getters y setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// Método toString para representar el objeto como cadena de texto
	@Override
	public String toString() {
		return "Producto{" + "codigo='" + codigo + '\'' + ", descripcion='" + descripcion + '\'' + ", precioUnitario="
				+ precioUnitario + ", origenFabricacion=" + origenFabricacion + ", categoria=" + categoria + '}';
	}
}
