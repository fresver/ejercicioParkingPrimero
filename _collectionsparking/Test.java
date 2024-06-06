package _collectionsparking;

public class Test {

	public static void main(String[] args) {
		
		Coche c1 = new Coche(Marca.LA, Color.NA);
		Coche c2 = new Coche(Marca.AS,Color.AM);
		/*Coche c3 = new Coche(Marca.AS,Color.AM);
		Coche c4 = new Coche();
		Coche c5 = new Coche();
		Coche c6 = new Coche();
		Coche c7 = new Coche();
		Coche c8 = new Coche();*/
		
		Parking p1 = new Parking("Los Banderilleros",10);
		
		p1.entraCoche(c1);
		p1.entraCoche(c2);
		/*p1.entraCoche(c3);
		p1.entraCoche(c4);
		p1.entraCoche(c5);
		p1.entraCoche(c6);
		p1.entraCoche(c7);
		p1.entraCoche(c8);*/
		
		p1.saleCocheAleatorio();
		
		p1.reportSetCoches();
		
	}
	
}
