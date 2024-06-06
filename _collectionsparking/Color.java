package _collectionsparking;

public enum Color {

	RO("Rojo"),NA("Naranja"),AM("Amarillo"),
	VE("Verde"),AZ("Azul"),IN("Índigo"),VI("Violeta");
	
	private String color;

	private Color(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
}
