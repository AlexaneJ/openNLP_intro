package openNLP;


import java.io.FileInputStream; 
import java.io.InputStream; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel; 
import opennlp.tools.util.Span; 
public class TokenDetectionProbabilities { 
   public static void main(String args[]) throws Exception{     
      String sent = "Hi Maria, how are you doing? Did you see Chengwanli and Julien? I guess they are with Morgann. Also I saw John earlier. "; 
       
      InputStream inputStream = new 
         FileInputStream("en-token.bin"); 
      TokenizerModel tokenModel = new TokenizerModel(inputStream); 
       
      TokenizerME tokenizer = new TokenizerME(tokenModel); 
       
      Span tokens[] = tokenizer.tokenizePos(sent); 
       
      double[] probs = tokenizer.getTokenProbabilities(); 
       
      for( Span token : tokens) 
         System.out.println(token +" "+sent.substring(token.getStart(), token.getEnd()));      
         System.out.println("  "); 
      for(int i = 0; i<probs.length; i++) 
         System.out.println(probs[i]);          
   } 
}