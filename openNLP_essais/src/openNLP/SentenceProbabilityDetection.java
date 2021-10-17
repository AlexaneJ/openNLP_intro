package openNLP;

import java.io.FileInputStream; 
import java.io.InputStream;  

import opennlp.tools.sentdetect.SentenceDetectorME; 
import opennlp.tools.sentdetect.SentenceModel;  

public class SentenceProbabilityDetection { 
  
   public static void main(String args[]) throws Exception { 
   
	  // toujours l'exemple extrait de Alice's adventures in wonderland :
      String sentence = "Down, down, down. Would the fall never come to an end! `I wonder how many miles I've fallen by this time?' she said aloud. `I must be getting somewhere near the centre of the earth. Let me see: that would be four thousand miles down, I think--' (for, you see, Alice had learnt several things of this sort in her lessons in the schoolroom, and though this was not a very good opportunity for showing off her knowledge, as there was no one to listen to her, still it was good practice to say it over) `--yes, that's about the right distance--but then I wonder what Latitude or Longitude I've got to?' (Alice had no idea what Latitude was, or Longitude either, but thought they were nice grand words to say.)"; 
	     
       
      //on charge le modèle et on l'instancie :  
      InputStream inputStream = new FileInputStream("en-sent.bin");
      SentenceModel model = new SentenceModel(inputStream); 
      SentenceDetectorME detector = new SentenceDetectorME(model);  
      
      //on cherche les phrases
      String sentences[] = detector.sentDetect(sentence); 
    
      //On les affiche :  
      for(String sent : sentences)        
         System.out.println(sent);   
         
      //On affiche la probabilité que de l'exactitude de la reconnaissances des phrases précédemment trouvées :     
      double[] probs = detector.getSentenceProbabilities(); 
       
      System.out.println("  "); 
       
      for(int i = 0; i<probs.length; i++) 
         System.out.println(probs[i]); 
   } 
}       