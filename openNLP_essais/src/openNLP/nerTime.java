package openNLP;

import java.io.FileInputStream; 
import java.io.InputStream;  

import opennlp.tools.namefind.NameFinderME; 
import opennlp.tools.namefind.TokenNameFinderModel; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel; 
import opennlp.tools.util.Span;  

public class nerTime {  
   public static void main(String args[]) throws Exception{        
      
      //On charge le modèle qui tokenize...
      InputStream inputStreamTokenizer = new 
         FileInputStream("en-token.bin");
      TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer); 
      TokenizerME tokenizer = new TokenizerME(tokenModel); //...et on instancie
       
      // On tokenize
      String example = "It's 7 am. Should we make an appointment for tonight? Let's say 7:30 pm?"; 
      String tokens[] = tokenizer.tokenize(example); 
       
      //On charge le modèle qui retrouve les heures ...
      InputStream inputStreamNameFinder = new 
         FileInputStream("en-ner-time.bin");       
      TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);
      NameFinderME nameFinder = new NameFinderME(model);       // ... et on instancie 
      
      // On cherche les matchs...
      Span nameSpans[] = nameFinder.find(tokens);        
      
      //...et on les affiche 
      for(Span s: nameSpans)        
         System.out.println(s.toString()+"  "+tokens[s.getStart()]);      
   }    
} 

// pas concluant