package _collectionsparking;

public enum GeneroLiterario {

	FICCION("Representa una historia basada en hechos imaginarios"),
	NO_FICCION("Representa una historia basada en hechos reales o que podrían serlo"),
	POESIA("Representa una historia contada a través del verso o la prosa"),
	BIOGRAFIA("Representa una historia que cuenta la vida de una persona");
	
	private String descripcion;

	private GeneroLiterario(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public static boolean esFiccion(GeneroLiterario genero) {
		if(genero.equals(FICCION)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		GeneroLiterario g1 = FICCION;
		System.out.println(esFiccion(g1));
	}
	
}
