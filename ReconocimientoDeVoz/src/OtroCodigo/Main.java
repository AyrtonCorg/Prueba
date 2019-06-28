package OtroCodigo;

import java.util.ArrayList;

public class Main {	
	
	
	public static void main (String[] args) {
		ArrayList<Palabra> palabras = new ArrayList<Palabra>();
		/*EscribirArchivo e = new EscribirArchivo();
		e.escribir();
		System.out.println("Listo");*/
		
		//System.out.println("Bienvenido a la aplicaci�n.");
		/*Escucha e = new Escucha();
		e.escucha();*/
		StandfordDemo s = new StandfordDemo();
		palabras.addAll(s.identificarPalabras("Qu� celulares con android tenemos?"));
		System.out.println("ANALISIS DE PALABRAS");
		for(Palabra p : palabras) {
			System.out.println(p.getPalabra()+" , "+p.getParte());
		}
		
		//Normalizar palabras
		s.normalizar(palabras);
		
		System.out.println("Despu�s de normalizar");
		for(Palabra p : palabras) {
			System.out.println(p.getPalabra());
		}
		
	}
}
