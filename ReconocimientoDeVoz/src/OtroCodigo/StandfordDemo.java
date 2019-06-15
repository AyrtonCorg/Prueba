package OtroCodigo;

import java.io.*;
import java.util.*;

import edu.stanford.nlp.coref.CorefCoreAnnotations;

import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.io.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.util.*;

/** This class demonstrates building and using a Stanford CoreNLP pipeline. */
public class StandfordDemo {	
	

	public StandfordDemo() { 		
	}
	
	public ArrayList<Palabra> identificarPalabras(String texto){
		ArrayList<Palabra> palabras = new ArrayList<>();
		String sampleSpanishText = texto;
		//Creo la anotaci�n y las propiedades.
		Annotation spanishAnnotation = new Annotation(sampleSpanishText);
		Properties spanishProperties = StringUtils.argsToProperties(new String[]{"-props", "StanfordCoreNLP-spanish.properties"});
		spanishProperties.setProperty("annotators",  "tokenize, ssplit, pos, lemma, ner, depparse, kbp");
		//Creo un pipeline.
		StanfordCoreNLP pipeline = new StanfordCoreNLP(spanishProperties);
		pipeline.annotate(spanishAnnotation);
		
		// Una anotaci�n es un mapa con claves de clase para los tipos de an�lisis ling��stico.
		// Puedes obtener y usar los distintos an�lisis individualmente.
		List<CoreMap> sentences = spanishAnnotation.get(CoreAnnotations.SentencesAnnotation.class);	
		//Verifico que haya sentencia y que la misma no est� vac�a. 
		if (sentences != null && ! sentences.isEmpty()) {
			//Obtengo la primera sentencia/oraci�n 
		    CoreMap sentence = sentences.get(0);
		    //Por cada palabra identificada la agrego  
		    for (CoreMap token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {	    	  
		      palabras.add(new Palabra(token.get(CoreAnnotations.TextAnnotation.class) , token.get(CoreAnnotations.PartOfSpeechAnnotation.class)));	    	  
		    }
		}
		
		return palabras;
	}
	
	/*public static void main(String[] args) throws IOException {  
	  //String sampleSpanishText = "Kosgi Santosh envi� un correo electr�nico a la Universidad de Stanford. No recibi� respuesta.";
	  String sampleSpanishText = "Joe Smith, naci�? en California.";
	  //Creo la anotaci�n y las propiedades.
	  Annotation spanishAnnotation = new Annotation(sampleSpanishText);
	  Properties spanishProperties = StringUtils.argsToProperties(new String[]{"-props", "StanfordCoreNLP-spanish.properties"});
	  spanishProperties.setProperty("annotators",  "tokenize, ssplit, pos, lemma, ner, depparse, kbp");
	  //Creo un pipeline.
	  StanfordCoreNLP pipeline = new StanfordCoreNLP(spanishProperties);
	  pipeline.annotate(spanishAnnotation);
	  
	  

	    // An Annotation is a Map with Class keys for the linguistic analysis types.
	    // You can get and use the various analyses individually.
	    // For instance, this gets the parse tree of the first sentence in the text.
	    List<CoreMap> sentences = spanishAnnotation.get(CoreAnnotations.SentencesAnnotation.class);	  
	       
	    if (sentences != null && ! sentences.isEmpty()) {
	      CoreMap sentence = sentences.get(0);
	      
	      for (CoreMap token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {	    	  
	    	  palabras.add(new Palabra(token.get(CoreAnnotations.TextAnnotation.class) , token.get(CoreAnnotations.PartOfSpeechAnnotation.class)));	    	  
	      }
	    }
}*/

}



