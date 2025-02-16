package openNLP;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;



public class TokenDetectionOpenNLP {

public static void main(String[]args) throws InvalidFormatException, IOException {
	
	
	InputStream is = new FileInputStream("en-token.bin");
 
	TokenizerModel model = new TokenizerModel(is);
 
	Tokenizer tokenizer = new TokenizerME(model);
 
	String tokens[] = tokenizer.tokenize("Down, down, down. Would the fall never come to an end! `I wonder how many miles I've fallen by this time?' she said aloud. `I must be getting somewhere near the centre of the earth. Let me see: that would be four thousand miles down, I think--' (for, you see, Alice had learnt several things of this sort in her lessons in the schoolroom, and though this was not a very good opportunity for showing off her knowledge, as there was no one to listen to her, still it was good practice to say it over) `--yes, that's about the right distance--but then I wonder what Latitude or Longitude I've got to?' (Alice had no idea what Latitude was, or Longitude either, but thought they were nice grand words to say.)");
 
	for (String a : tokens) 
		System.out.println(a);
 
	is.close();
}

}
