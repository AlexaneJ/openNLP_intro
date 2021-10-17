package openNLP;

import java.io.FileInputStream; 
import java.io.InputStream;  

import opennlp.tools.namefind.NameFinderME; 
import opennlp.tools.namefind.TokenNameFinderModel; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel; 
import opennlp.tools.util.Span;  

public class NerPercentageOpenNLP {  
   public static void main(String args[]) throws Exception{        
      
      //on importe le tokenizer, nécessaire pour toutes les opérations que l'on souhaite réaliser 
      InputStream inputStreamTokenizer = new FileInputStream("en-token.bin");
      TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);
       
      //On instancie le modèle précédemment importé 
      TokenizerME tokenizer = new TokenizerME(tokenModel); 
       
      //On créé une phrase lambda pour tester et on tokenize 
      String example = "There is a 100% probability for you to fail if you don't study. But if you do, you may have a 50% probability to succeed. "; 
      String tokens[] = tokenizer.tokenize(example); 
       
      //On charge le modèle permettant de trouver les pourcentages
      InputStream inputStreamPercFinder = new FileInputStream("en-ner-percentage.bin");       
      TokenNameFinderModel model = new TokenNameFinderModel(inputStreamPercFinder);
      NameFinderME locFinder = new NameFinderME(model);  // on instancie      
      
      //On recherche les résultats...
      Span locSpans[] = locFinder.find(tokens);        
      
      //...et on les affice
      for(Span s: locSpans)        
         System.out.println(s.toString()+"  "+tokens[s.getStart()]);      
   }    
} 