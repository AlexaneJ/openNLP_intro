package openNLP;

// détection de phrases avec un simple split

public class SentenceDetectionNoOpenNLP {  
	   public static void main(String args[]){ 
	     
		   // même exemple que pour le pos tagger : 
	      String example = "Down, down, down. Would the fall never come to an end! `I wonder how many miles I've fallen by this time?' she said aloud. `I must be getting somewhere near the centre of the earth. Let me see: that would be four thousand miles down, I think--' (for, you see, Alice had learnt several things of this sort in her lessons in the schoolroom, and though this was not a very good opportunity for showing off her knowledge, as there was no one to listen to her, still it was good practice to say it over) `--yes, that's about the right distance--but then I wonder what Latitude or Longitude I've got to?' (Alice had no idea what Latitude was, or Longitude either, but thought they were nice grand words to say.)"; 
	     
	      String simple = "[.?!]";      
	      String[] splitString = (example.split(simple));     
	      for (String string : splitString)   
	         System.out.println(string);      
	   } 
	}