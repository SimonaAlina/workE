package visitorDoc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class LineReader {

	public List<String> lines;

	public List<String> getLines() {
		return lines;
	}

	public void readFile(String fileName) {
		lines = new ArrayList<>();
		Reader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			String data;
			while ((data = bufferedReader.readLine()) != null) {
				lines.add(data);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File missing '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("I/O Exception:" + ex.getMessage());
		} finally {
			System.out.println("   ---");
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException ex) {
				System.out.println("I/O Exception:" + ex.getMessage());
			}
		}
	}
}
