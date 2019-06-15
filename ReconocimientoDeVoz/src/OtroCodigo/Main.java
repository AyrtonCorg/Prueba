package OtroCodigo;

import java.util.ArrayList;

public class Main {	
	
	
	public static void main (String[] args) {
		ArrayList<Palabra> palabras = new ArrayList<Palabra>();
		
		System.out.println("Bienvenido a la aplicación.");
		//Escucha e = new Escucha();
		//e.escucha();
		StandfordDemo s = new StandfordDemo();
		palabras.addAll(s.identificarPalabras("Joe Smith, nació? en California."));
		/*for(Palabra p : s.identificarPalabras("Joe Smith, nació? en California.")) {
			System.out.println(p.getPalabra()+" , "+p.getParte());
		}*/
		
		//Normalizar palabras
		//s.normalizar(palabras)
		
	}
}
