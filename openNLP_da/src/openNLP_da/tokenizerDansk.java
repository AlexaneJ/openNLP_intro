package openNLP_da;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

public class tokenizerDansk {
	
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

public static void main(String args[]) throws InvalidFormatException, IOException { 
	   
	  //String filePath = "LykkePer_FØRSTE KAPITEL.txt";
	  String filePath = "avisartikel_da.txt";
   
      String token = readFile( filePath );
       
      //on charge le tokenizer model
      InputStream is = new FileInputStream("da-token.bin"); 
      TokenizerModel model = new TokenizerModel(is);
      Tokenizer tokenizer = new TokenizerME(model);
      
    
      //on recherche les phrases
      String tokens[] = tokenizer.tokenize(token); 
    
      //on les affiche
      for(String tok : tokens)        
         System.out.println(tok);  
   } 
}
