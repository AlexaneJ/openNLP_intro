package openNLP;

import java.io.FileInputStream; 
import java.io.InputStream;  

import opennlp.tools.namefind.NameFinderME; 
import opennlp.tools.namefind.TokenNameFinderModel; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel; 
import opennlp.tools.util.Span;  

public class NerLocationOpenNLP { 
   public static void main(String args[]) throws Exception{
   
	  // instanciation du modèle tokenizer (pour faire quoi que ce soit, il faut avant tout tokenizer) : 
      InputStream inputStreamTokenizer = new FileInputStream("en-token.bin"); // on importe le fichier du modèle que l'on souhaite utiliser, ici un tokenizer
      TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer); // on instancie le modèle
       
      String example = "Sorbonne Université is located in Paris, while Harvard is in Cambridge. I used to live in Japan, but now I live in Bercelona, Spain. " +
      " I wish I would travel to Villa Carlos Paz in Argentina because I love the Cordoba area. But I also love being in Bretagne, espacially near the south coast. There's Quimper, and Rédéné."; 
      
      // Villa Carlos Paz, Argentina, et d'autres ne sont pas reconnus
      // seuls les plus connus sont reconnus
        
      //On instancie la classe tokenizerME :
      TokenizerME tokenizer = new TokenizerME(tokenModel); 
      String tokens[] = tokenizer.tokenize(example); 
       
      //On importe le modèle de NER-location et on l'instancie :
      InputStream inputStreamLocFinder = new FileInputStream("en-ner-location.bin");       
      TokenNameFinderModel model = new TokenNameFinderModel(inputStreamLocFinder); 
      NameFinderME locFinder = new NameFinderME(model);      
        
      //On récupère les noms des locations qui ont été trouvées :
      Span nameSpans[] = locFinder.find(tokens); 
             
      //On les affiche 
      for(Span s: nameSpans)        
         System.out.println(s.toString()+"  "+tokens[s.getStart()]); 
   }    
}   