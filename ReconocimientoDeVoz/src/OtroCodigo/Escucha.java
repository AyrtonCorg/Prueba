package OtroCodigo;

import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;
 
public class Escucha extends ResultAdapter{
 
	private static Recognizer recognizer;
	private String respuesta = "";
	private Habla lee = new Habla();
	private EscribirArchivo escribir = new EscribirArchivo();
	
	public Escucha() {
		
	}
	
	@Override
	//ResultEvent se�ala cambios de estado y de datos de los resultados del reconocimiento
	// Recibe el evento RESULT_ACCEPTED: impr�melo, limpie, salga
 	public void resultAccepted(ResultEvent re) {
	 	try {
	 		Result res = (Result)(re.getSource());
	 		//Obtiene palabra por palabra (tambi�n guarda los espacios)
	 		ResultToken tokens[] = res.getBestTokens(); 		
	 		
	 		respuesta = "";
	 		//Almacena en la variable respuesta lo que se escuch�
	 		for (int i=0; i < tokens.length; i++){
	 			System.out.println("tokens: "+tokens[i].getSpokenText());
	 			respuesta+= tokens[i].getSpokenText()+" ";
	 		}
	 		
	 		System.out.println("Usuario>> "+respuesta);
	 		//Escribo en el txt
	 		escribir.escribir("Usuario", respuesta, "Prueba");
	 		
	 		//trim() elimina los espacios en blanco antes y despu�s de cada palabra
	 		if(respuesta.trim().equals("fin")){
	 			//Libera el recurso
	 			recognizer.deallocate(); 			
	 			lee.leer("Hasta la vista baby!");
	 			return;
	 		}else{
	 			if(respuesta.trim().equals("Faltan 5 pe")) {
	 				recognizer.suspend();
	 				lee.leer("pa comprar ese vi");
	 				recognizer.resume();
	 			}else {		 
	 				if(respuesta.trim().contentEquals("Union de Santa Fe")) {
	 					recognizer.suspend();
		 				lee.leer("El due�o de la ciudad");
		 				recognizer.resume();
	 				}else {
	 					//Suspende el reconocedor
		 				recognizer.suspend();	 					
		 				lee.leer(respuesta);
		 				//Activa el reconocedor
		 				recognizer.resume();
	 				}	 				
	 			}
	 		}
	 	}catch(Exception ex){
	 		System.out.println("Ha ocurrido algo inesperado " + ex);
	 	}
 	}
 
 	public void escucha(){
 		try{
 			//Crea el reconocedor para el Lcoale por defecto
 			recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
 			
 			//Pide el recurso
 			recognizer.allocate();
 			
 			//Lee el archivo donde se encuentra el diccionario (Misma ubicaci�n del proyecto)
 			FileReader grammar1 =new FileReader("SimpleGrammarES2.txt"); 			
 			//FileReader grammar1 =new FileReader("GramaticaNueva.txt");
 			
 			//Carga la gram�tica disponible.
 			RuleGrammar rg = recognizer.loadJSGF(grammar1);
 			
 			//Habilito la gram�tica
 			rg.setEnabled(true);
 			
 			//Agrega un listener al reconocedor para obtener los resultados
 			recognizer.addResultListener(new Escucha());
 
 			System.out.println("Empieze Dictado");
 			
 			//Guarda los cambios en el reconocedor
 			recognizer.commitChanges();
 			
 			//Pide el enfoque
 			recognizer.requestFocus();
 			
 			//Empieza a escuchar
 			recognizer.resume();
 			
 		}catch (Exception e){
 			System.out.println("Exception en " + e.toString());
 			e.printStackTrace();
 			System.exit(0);
 		}
 	}
	 	
}

