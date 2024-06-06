package _collectionsparking;

public enum Marca {

	VO("Volkswagen"),SE("Seat"),
	LA("Lamborghini"),RE("Renault"),AS("Aston Martin");
	
	public String marca;

	private Marca(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}
	
}
