package OtroCodigo;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribirArchivo {
	FileWriter fichero = null;
	FileWriter fichero2 = null;
    PrintWriter pw = null;
    PrintWriter pw2 = null;
    String nombre = "";
	
	public EscribirArchivo() {
		
	}
	
	public void escribir(String autor,  String oracion, String nombreDocumento) {        
        try{
        	//Creo el fichero
        	nombre = nombreDocumento.concat(".txt");
        	//System.out.println("nombre: "+nombre);
            fichero = new FileWriter(nombre,true);
            
            pw = new PrintWriter(fichero);
            
            //Escribo en el archivo
            pw.println(autor+">> "+oracion);
            //pw.println(oracion+" |");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
           try {
        	   // finally para asegurarnos que se cierra el fichero.
        	   if (fichero != null) {
        		   fichero.close();
        	   }
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	public void escribir() {        
        try{
        	//Creo el fichero
        	//System.out.println("nombre: "+nombre);
            fichero = new FileWriter("datos.txt",true);
            fichero2 = new FileWriter("sentence.txt",true);
            
            pw = new PrintWriter(fichero);
            pw2 = new PrintWriter(fichero2);
            
            for (int i = 31; i<300 ; i++) {
            	//Escribo en el archivo
                pw.println("<dato"+i+">= ;");
                pw2.println("[<dato"+i+">]");
            }

        }catch (Exception e){
            e.printStackTrace();
        } finally {
           try {
        	   // finally para asegurarnos que se cierra el fichero.
        	   if (fichero != null) {
        		   fichero.close();
        		   fichero2.close();
        	   }
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	

}
