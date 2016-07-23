package words;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simona
 */
public class Worker extends Thread {

	private File file;
	private long mStart;
	private long mEnd;

	private byte seq[];
	private String fragment;
	private final String delimiters = " ;:/?~\\.,><_~`[{()}]!@#$%^&-+'=*\"|\t\n";

	// HashMap <Cuvant, Nr_aparitii> per fragment
	private HashMap<String, Integer> wordsFreq;

	public Worker(File f, long mStart, long mEnd) {
		super();
		this.file = f;
		this.mStart = mStart;
		this.mEnd = mEnd;
	}

	@Override
	public void run() {
		int ch, freq;
		this.wordsFreq = new HashMap<>();
		try {
			try (RandomAccessFile f = new RandomAccessFile(file, "r")) {
				long sizeFile = file.length();
				// daca primul caracter este litera si nu e inceput de document verific o pozitie inapoi
				// altfel e delimitator sau inceput de doc si nu modific pozitia de start
				f.seek(mStart);
				ch = f.read();
				if(mStart != 0 && Character.isLetterOrDigit(ch)) {
					f.seek(mStart - 1);
					ch = f.read();
					//daca anteriorul nu e delimitator, trec peste cuvant inainte
					while(mStart <= mEnd && Character.isLetterOrDigit(ch)) {
						mStart++;
						f.seek(mStart);
						ch = f.read();
					}
				}
				//verific sfarsit de fragment
				f.seek(mEnd);
				ch = f.read();
				while(mEnd != sizeFile - 1 && Character.isLetterOrDigit(ch)) {
					mEnd++;
					ch = f.read();
				}
				//daca nu am cuvinte in fragment nu mai parsez
				sizeFile = mEnd - mStart + 1;
				if(sizeFile < 1) {
					f.close();
					return;
				}
				// creez hashmap de cuvinte per fragment
				seq = new byte[(int) sizeFile];
				f.seek(mStart);
				f.read(seq);
				
				// parsez fragmentul de fisier
				fragment = new String(seq);
				StringTokenizer token = new StringTokenizer(fragment, delimiters);
				
				// daca am gasit numai delimitatori, nu mai creez hashMap
				boolean foundTokens = false;
				
				while(token.hasMoreTokens()) {
					String word = token.nextToken().toLowerCase();
					if(wordsFreq.get(word) == null) {
						wordsFreq.put(word, 1);
					} else {
						freq = wordsFreq.get(word);
						wordsFreq.put(word, ++freq);
					}
					foundTokens = true;
				}
				// adaug hashmapul in hashmap-ul necesar pentru reduce
				if(foundTokens) {
					WordsPercentage.addPartialResult(wordsFreq);
				}
			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
