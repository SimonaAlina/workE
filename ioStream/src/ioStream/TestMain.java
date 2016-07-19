package ioStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestMain {

	public static void main(String[] args) {

		System.out.println(count("file1.txt", 5, 'b'));
	}

	public static int count(String fileName, long pos, char c) {
		int count = 0;
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile(fileName, "r");
			randomAccessFile.seek(pos);
			int data;
			while ((data = randomAccessFile.read()) != -1) {
				char dataChar = (char) data;
				if(dataChar == c)
					count++;
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File missing '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("I/O Exception:" + ex.getMessage());
		} finally {
			try {
				if (randomAccessFile != null) {
					randomAccessFile.close();
				}
			} catch (IOException ex) {
				System.out.println("I/O Exception:" + ex.getMessage());
			}
		}
		return count;
	}

	public static void reverseWords(String readFile, String writeFile) {

	}

	public static void listFiles(String dirName) {

	}
}
