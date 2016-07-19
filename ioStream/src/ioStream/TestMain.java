package ioStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestMain {

	public static void main(String[] args) {

		System.out.println(count("file1.txt", 5, 'b'));
		reverseWords("file1.txt", "output_file.txt");
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
				if (dataChar == c)
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
		// int bufferSize = 8 * 1024;
		BufferedReader bufferedReader = null;
		RandomAccessFile randomAccessFile = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(readFile));
			randomAccessFile = new RandomAccessFile(writeFile, "rw");

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(" ");
				randomAccessFile.seek(0L);
				for (int i = words.length - 1; i >= 0; --i) {
					randomAccessFile.writeBytes(words[i] + " ");
				}
				randomAccessFile.writeBytes("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void listFiles(String dirName) {
		File folder = new File("D:/workspace/workE");
	}
}
