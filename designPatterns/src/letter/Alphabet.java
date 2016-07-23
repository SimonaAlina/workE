package letter;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

	public static List<LetterMapping> mapping;
	
	public void generateAlphabetMapping() {
		mapping = new ArrayList<>();
		for(char ch = 'a'; ch <= 'z'; ++ch)
			mapping.add(new LetterMapping(ch, ch - 'a' + 1));
	}
}
