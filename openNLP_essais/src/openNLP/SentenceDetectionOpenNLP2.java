package openNLP;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;

public class SentenceDetectionOpenNLP2 {
	public static void SentenceDetect() throws InvalidFormatException,
	IOException {
		//même exemple que précédemment
String exemple = "Down, down, down.\n"
		+ "Would the fall never come to an end! `I wonder how many miles I've fallen by this time?' she said aloud.\n"
		+ "`I must be getting somewhere near the centre of the earth.\n"
		+ "Let me see: that would be four thousand miles down, I think--' (for, you see, Alice had learnt several things of this sort in her lessons in the schoolroom, and though this was not a very good opportunity for showing off her knowledge, as there was no one to listen to her, still it was good practice to say it over) `--yes, that's about the right distance--but then I wonder what Latitude or Longitude I've got to?' (Alice had no idea what Latitude was, or Longitude either, but thought they were nice grand words to say.)\n"
		+ "";

// on charge le modèle qui permet de recueillir les phrases et on instancie
InputStream is = new FileInputStream("en-sent.bin");
SentenceModel model = new SentenceModel(is);
SentenceDetectorME sdetector = new SentenceDetectorME(model);


// on cherche les phrases
String sentences[] = sdetector.sentDetect(exemple);

// on les affiche
for (String sent: sentences) {
	System.out.println(sent);
}
is.close();
}	
	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		SentenceDetect(); // on utilise la fonction précédemment créée
	}
}