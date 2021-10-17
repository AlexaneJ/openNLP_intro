package openNLP;

import java.io.FileInputStream; 
import java.io.InputStream;  

import opennlp.tools.namefind.NameFinderME; 
import opennlp.tools.namefind.TokenNameFinderModel; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel; 
import opennlp.tools.util.Span;  

public class NerPersonOpenNLP {  
   public static void main(String args[]) throws Exception{        
      
      //on charge le modèle qui tokenize...
      InputStream inputStreamTokenizer = new 
         FileInputStream("en-token.bin");
      TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);  
      TokenizerME tokenizer = new TokenizerME(tokenModel); //...et on instancie
       
      //On tokenize
      String example = "Hi Charles, how are you doing? Did you see Mary and Peter? I guess they are with Emily. Also I saw John earlier. ";  
      System.out.println(example);
      String tokens[] = tokenizer.tokenize(example); 
       
      //On charge le NER-person model ...
      InputStream inputStreamNameFinder = new FileInputStream("en-ner-person.bin");       
      TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder); 
      NameFinderME nameFinder = new NameFinderME(model);     // ... et on instancie  
      
      //On récupère les matchs....
      Span nameSpans[] = nameFinder.find(tokens);        
      
      //...et on les affiche
      for(Span s: nameSpans)        
         System.out.println(s.toString()+"  "+tokens[s.getStart()]);      
   }    
} 