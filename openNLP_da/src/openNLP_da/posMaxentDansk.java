package openNLP_da;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
//import opennlp.tools.postag.POSSample; 

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;



public class posMaxentDansk {
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
     
  
   public static void main(String args[]) throws Exception{ 
		//String filePath = "LykkePer_FØRSTE KAPITEL.txt";
		String filePath = "avisartikel_da.txt";
	    String toto = readFile( filePath );
		
		//d'abord tokenizer	
		InputStream is = new FileInputStream("da-token.bin"); 
	    TokenizerModel model = new TokenizerModel(is);
	    Tokenizer tokenizer = new TokenizerME(model);
	    String tokens[] = tokenizer.tokenize(toto); 
    
      //importer le POS maxent model       
      InputStream inputStream = new FileInputStream("da-pos-maxent.bin"); 
      POSModel model1 = new POSModel(inputStream); 
       
      //instancier le POSTaggerME class 
      POSTaggerME tagger = new POSTaggerME(model1); 
       
      //on recherche les étiquettes :
      String[] tags = tagger.tag(tokens);
      int i=0;
      for(String str:tokens){
    	  
    		  System.out.println(str+" "+tags[i]);
    		  i++;
    		 
      }
}
}