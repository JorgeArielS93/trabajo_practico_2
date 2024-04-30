package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(750000, 53.219), SALTA(1500000, 155.488), TUCUMAN(1500000, 22.524), CATAMARCA(400000, 102.602),
	LA_RIOJA(400000, 89.680), SANTIAGO_DEL_ESTERO(1200000, 136.351);

	private Integer cantidadHabitantes;
	private Double superficie;

	private Provincia(Integer cantidadHabitantes, Double superficie) {
		this.cantidadHabitantes = cantidadHabitantes;
		this.superficie = superficie;
	}

	public Integer getCantidadHabitantes() {
		return cantidadHabitantes;
	}

	public void setCantidadHabitantes(Integer cantidadHabitantes) {
		this.cantidadHabitantes = cantidadHabitantes;
	}

	public Double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}
	private double calcularDensidadPoblacional() {
		return cantidadHabitantes/superficie;
	}
}
