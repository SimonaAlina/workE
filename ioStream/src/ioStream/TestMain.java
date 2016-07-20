package ioStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestMain {

	public static void main(String[] args) {

		System.out.println("Number of b: " + count("file1.txt", 5, 'b'));
		reverseWords("file1.txt", "output_file1.txt");
		iterateFiles("output_file2.txt", "D:/workspace/workE");
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
		long pos = new File(readFile).length() - 1;
		BufferedReader bufferedReader = null;
		RandomAccessFile randomAccessFile = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(readFile));
			randomAccessFile = new RandomAccessFile(writeFile, "rw");

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(" ");
				String newLine = new String();
				for (int i = words.length - 1; i > 0; i--) {
					newLine += words[i] + " ";
				}
				newLine += words[0] + "\n";
				pos = pos - newLine.length();
				randomAccessFile.seek(pos);
				randomAccessFile.writeBytes(newLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void listFiles(FileOutputStream f, File folder, String tab) throws IOException {
		//System.setProperty("user.dir", folder.getAbsolutePath());
		//if (!folder.isDirectory())
		//return;
		
		String fileName = new String();
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			fileName = tab + file.getName() + "\n";
			byte[] bytes = fileName.getBytes();
			f.write(bytes);
			f.flush();
			if (file.isDirectory()) {
				listFiles(f, file, tab + "    ");
			}
		}
	}

	public static void iterateFiles(String writeFile, String dir) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(writeFile, true);
			File directory = new File(dir);
			if (directory.isDirectory())
				listFiles(fileOutputStream, directory, "");
		} catch (FileNotFoundException ex) {
			System.out.println("File missing '" + writeFile + "'");
		} catch (IOException ex) {
			System.out.println("I/O Exception:" + ex.getMessage());
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException ex) {
				System.out.println("I/O Exception:" + ex.getMessage());
			}
		}
	}
}
