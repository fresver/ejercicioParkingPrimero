package _collectionsparking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Parking {

	private String nombre;
	private int totalPlazas;
	private List <Coche>listaDeCoches= new ArrayList<>();
	private Map<Color,Integer>mapDeColores = new HashMap<>();
	private Map<Marca,Integer>mapDeMarcas = new HashMap<>();
	private Map<Coche,Integer>mapCochesRepetidos = new HashMap <> ();
	private Set <Coche> setCoches = new HashSet <> ();
	
	public Parking(String nombre, int totalPlazas) {
		this.nombre = nombre;
		this.totalPlazas = totalPlazas;
	}
	
	private boolean meterColorCoche(Coche cochecito) {
		if(!mapDeColores.containsKey(cochecito.getColor())) {
			mapDeColores.put(cochecito.getColor(), 1);
		}else {
			mapDeColores.put(cochecito.getColor(), mapDeColores.get(cochecito.getColor())+1);
		}return true;
	}
	
	private boolean meterMarcaCoche(Coche cochecito) {
		if(!mapDeMarcas.containsKey(cochecito.getMarca())) {
			mapDeMarcas.put(cochecito.getMarca(), 1);
		}else {
			mapDeMarcas.put(cochecito.getMarca(), mapDeMarcas.get(cochecito.getMarca())+1);
		}return true;
	}
	
	private boolean meterCocheRepetido(Coche cochecito) {
		if(mapCochesRepetidos.containsKey(cochecito)) {
			mapCochesRepetidos.put(cochecito, mapCochesRepetidos.get(cochecito)+1);
		}else {
			mapCochesRepetidos.put(cochecito, 1);
		}return true;
	}
	
	private boolean meterCocheSet (Coche cochecito) {
		if(setCoches.contains(cochecito)) {
			return false;
		}else {
			setCoches.add(cochecito);
			return true;
		}
	}
	
	public boolean entraCoche (Coche cochecito) {
		if(totalPlazas==listaDeCoches.size()) 
			return false;
		for(Coche coche:listaDeCoches) {
			if(cochecito==coche) 
				return false;
		}
		listaDeCoches.add(cochecito);
		meterColorCoche(cochecito);
		meterMarcaCoche(cochecito);
		meterCocheRepetido(cochecito);
		meterCocheSet(cochecito);
		return true;
	}
	
	private void saleColor(Coche cochecito) {
		if(mapDeColores.get(cochecito.getColor())-1==0) {
			mapDeColores.remove(cochecito.getColor());
		}else {
			mapDeColores.put(cochecito.getColor(), mapDeColores.get(cochecito.getColor())-1);
		}
	
	}
	
	private void saleMarca(Coche cochecito) {
		if(mapDeMarcas.get(cochecito.getMarca())-1==0) {
			mapDeMarcas.remove(cochecito.getMarca());
		}else {
			mapDeMarcas.put(cochecito.getMarca(), mapDeMarcas.get(cochecito.getMarca())-1);
		}
	}
	
	private void saleCocheRepetido(Coche cochecito) {
		if(mapCochesRepetidos.get(cochecito)-1==0) {
			mapCochesRepetidos.remove(cochecito);
		}else {
			mapCochesRepetidos.put(cochecito, mapCochesRepetidos.get(cochecito)-1);
		}
	}
	
	private boolean saleCocheSet (Coche cochecito) {
		if(listaDeCoches.contains(cochecito)) {
			return false;
		}else {
			setCoches.remove(cochecito);
			return true;
		}
	}
	
	public boolean saleCoche (Coche cochecito) {
		if(listaDeCoches.contains(cochecito)) {
			saleColor(cochecito);
			saleMarca(cochecito);
			saleCocheRepetido(cochecito);
			listaDeCoches.remove(cochecito);
			saleCocheSet(cochecito);
			return true;
		}
		if(!listaDeCoches.contains(cochecito)||listaDeCoches.size()==0) {
			return false;
		}
		return false;
	}
	
	public boolean saleCocheAleatorio() {
		if(listaDeCoches.size()==0) {
			return false;
		}
		Random ran = new Random();
		Coche cocheEliminado = listaDeCoches.remove(ran.nextInt(listaDeCoches.size()));
		saleColor(cocheEliminado);
		saleMarca(cocheEliminado);
		saleCocheRepetido(cocheEliminado);
		saleCocheSet(cocheEliminado);
		return true;
	}
	
	public boolean vaciaParking() { 
		if(listaDeCoches.size()==0) {
			return false;
		}
		for(int i=listaDeCoches.size(); i>0;i--) {
			listaDeCoches.remove(i-1);
		}
		mapDeColores.clear();
		mapDeMarcas.clear();
		mapCochesRepetidos.clear();
		setCoches.clear();
		return true;
	}
	
	public void reportParking() {
		System.out.println("LISTADO DE COCHES");
		System.out.println("-----------------");
		System.out.printf("%s: Mi primer parking%n",nombre);
		for(int i=0;i<listaDeCoches.size();i++) {
			System.out.println(listaDeCoches.get(i));
		}
		System.out.printf("Total coches: %d, plazas libres: %d%n",
		listaDeCoches.size(),totalPlazas-listaDeCoches.size());
	}
	
	public void reportColores() {
		System.out.println("REPORT DE COLORES");
		System.out.println("-----------------");
		System.out.printf("%s: Mi primer parking%n",nombre);
		for(Color color:mapDeColores.keySet()) {
			System.out.printf("El coche de color %s se repite %d %s.%n",
			color.getColor(),mapDeColores.get(color),mapDeColores.get(color)==1?"vez":"veces");
		}
		System.out.printf("Total coches: %d%n",
		listaDeCoches.size());
	}
	
	public void reportMarcas() {
		System.out.println("REPORT DE MARCAS");
		System.out.println("-----------------");
		System.out.printf("%s: Mi primer parking%n",nombre);
		for(Marca marca:mapDeMarcas.keySet()) {
			System.out.printf("El coche de marca %s se repite %d %s.%n",
			marca.getMarca(),mapDeMarcas.get(marca),mapDeMarcas.get(marca)==1?"vez":"veces");
		}
		System.out.printf("Total coches: %d%n",
		listaDeCoches.size());
	}
	
	public void reportCochesIguales() {
		System.out.println("REPORT DE COCHES IGUALES");
		System.out.println("------------------------");
		System.out.printf("%s: Mi primer parking%n",nombre);
		for(Coche coche:mapCochesRepetidos.keySet()) {
			System.out.printf("%s se repite %d %s.%n",
			coche,mapCochesRepetidos.get(coche),mapCochesRepetidos.get(coche)==1?"vez":"veces");
		}
		System.out.printf("Total coches: %d%n",
		listaDeCoches.size());
	}
	
	public void reportSetCoches() {
		System.out.println("REPORT SET DE COCHES");
		System.out.println("--------------------");
		System.out.printf("%s: Mi primer parking%n",nombre);
		for(Coche coche:setCoches) {
			System.out.printf("%s%n",coche);
		}
		System.out.printf("Total items: %d%n",
		setCoches.size());
	}
	
}