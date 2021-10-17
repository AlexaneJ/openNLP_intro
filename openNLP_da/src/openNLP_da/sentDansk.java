package openNLP_da;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import opennlp.tools.sentdetect.SentenceDetectorME; 
import opennlp.tools.sentdetect.SentenceModel;  

public class sentDansk { 
	
	// on écrit d'abord une fonction qui permet de lire un fichier
    private static String readFile(String filePath) { 
        StringBuilder contentBuilder = new StringBuilder();
 
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return contentBuilder.toString();
    }

  
   // puis on utilise cette fonction pour lire le fichier et détecter les phrases dans le texte en danois. 
   public static void main(String args[]) throws Exception { 
	   
	  //String filePath = "LykkePer_FØRSTE KAPITEL.txt";
	  String filePath = "avisartikel_da.txt";
   
      String sentence = readFile( filePath );
       
      //On charge le modèle de reconnaissance des phrases 
      InputStream inputStream = new FileInputStream("da-sent.bin"); 
      SentenceModel model = new SentenceModel(inputStream); 
       
      //on instancie SentenceDetectorME class 
      SentenceDetectorME detector = new SentenceDetectorME(model);  
    
      //on recherche les phrases
      String sentences[] = detector.sentDetect(sentence); 
    
      //on les affiche
      for(String sent : sentences)        
         System.out.println(sent);  
   } 
}

// Rien de très fou jusque-là