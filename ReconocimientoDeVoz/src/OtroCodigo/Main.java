package OtroCodigo;

import java.util.ArrayList;

public class Main {	
	
	
	public static void main (String[] args) {
		ArrayList<Palabra> palabras = new ArrayList<Palabra>();
		
		System.out.println("Bienvenido a la aplicaci�n.");
		//Escucha e = new Escucha();
		//e.escucha();
		StandfordDemo s = new StandfordDemo();
		palabras.addAll(s.identificarPalabras("naci�"/*"Joe Smith, naci�? en California."*/));
		System.out.println("ANALISIS DE PALABRAS");
		for(Palabra p : palabras) {
			System.out.println(p.getPalabra()+" , "+p.getParte());
		}
		
		//Normalizar palabras
		s.normalizar(palabras);
		
	}
}
