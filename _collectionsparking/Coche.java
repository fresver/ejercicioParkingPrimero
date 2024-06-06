package _collectionsparking;

import java.util.Objects;
import java.util.Random;

public class Coche {

	private Marca marca;
	private Color color;
	
	public Coche(Marca marca, Color color) {
		this.marca = marca;
		this.color = color;
	}
	
	public Coche() {
		Random ran = new Random();
		marca= Marca.values()[ran.nextInt(Marca.values().length)];
		color= Color.values()[ran.nextInt(Color.values().length)];
	}

	@Override
	public String toString() {
		return "  Coche: " + marca + " " + color;
	}

	public Marca getMarca() {
		return marca;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, marca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return color == other.color && marca == other.marca;
	}
	
}
