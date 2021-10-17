package openNLP;

import java.io.FileInputStream; 
import java.io.InputStream;  

import opennlp.tools.postag.POSModel; 
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class TokenTagsOpenNLP { 
  
   public static void main(String args[]) throws Exception{ 
          
      InputStream inputStream = new FileInputStream("en-pos-maxent.bin"); 
      POSModel model = new POSModel(inputStream); 
       
      POSTaggerME tagger = new POSTaggerME(model); 
       
      String sentence = "Down, down, down.\n"
      		+ "Would the fall never come to an end! `I wonder how many miles I've fallen by this time?' she said aloud.\n"
      		+ "`I must be getting somewhere near the centre of the earth.\n"
      		+ "Let me see: that would be four thousand miles down, I think--' (for, you see, Alice had learnt several things of this sort in her lessons in the schoolroom, and though this was not a very good opportunity for showing off her knowledge, as there was no one to listen to her, still it was good practice to say it over) `--yes, that's about the right distance--but then I wonder what Latitude or Longitude I've got to?' (Alice had no idea what Latitude was, or Longitude either, but thought they were nice grand words to say.)\n"
      		+ ""; 
     
  	InputStream is = new FileInputStream("en-token.bin");
  	 
  	TokenizerModel model1 = new TokenizerModel(is);
  	 
  	Tokenizer tokenizer = new TokenizerME(model1);
  	
  	String[] tokens = tokenizer.tokenize(sentence); 
       
      String[] tags = tagger.tag(tokens);
      
      int i=0;
      for(String str:tokens){
    	  
    		  System.out.println(str+" "+tags[i]);
    		  i++;
    		 
      }
      
 /**     //Instantiating the POSSample class 
      POSSample sample = new POSSample(tokens, tags); 
      
      
      System.out.println(sample.toString()); **/
   
   } 
}  