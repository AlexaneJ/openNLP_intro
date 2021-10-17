package openNLP;

import java.io.FileInputStream; 
import java.io.InputStream;  

import opennlp.tools.sentdetect.SentenceDetectorME; 
import opennlp.tools.sentdetect.SentenceModel; 
import opennlp.tools.util.Span; 
   
public class SentenceDetectionOpenNLPIndice { 
  
   public static void main(String args[]) throws Exception { 
     
	  // on créé un exemple (le même que précédemment, extrait de Alice's adventures in wonderland) : 
      String sen = "Down, down, down. Would the fall never come to an end! `I wonder how many miles I've fallen by this time?' she said aloud. `I must be getting somewhere near the centre of the earth. Let me see: that would be four thousand miles down, I think--' (for, you see, Alice had learnt several things of this sort in her lessons in the schoolroom, and though this was not a very good opportunity for showing off her knowledge, as there was no one to listen to her, still it was good practice to say it over) `--yes, that's about the right distance--but then I wonder what Latitude or Longitude I've got to?' (Alice had no idea what Latitude was, or Longitude either, but thought they were nice grand words to say.)"; 
	     
      //on charge le modèle et on l'instancie  
      InputStream inputStream = new FileInputStream("en-sent.bin"); 
      SentenceModel model = new SentenceModel(inputStream); 
      SentenceDetectorME detector = new SentenceDetectorME(model);  
       
      // on recherche la position des phrases :  
      Span[] spans = detector.sentPosDetect(sen);  
      
      //on affiche les phrases et leurs positions
      for (Span span : spans)         
         System.out.println(sen.substring(span.getStart(), span.getEnd())+" "+ span);  
   } 
}  