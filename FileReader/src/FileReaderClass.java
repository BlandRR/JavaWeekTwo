import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.DataTruncation;
import java.util.ArrayList;

import javax.annotation.processing.Filer;

public class FileReaderClass {

	public void writeToFile(String file, ArrayList<Person> arr) {

		final String filename = "C:\\Users\\Admin\\File\\src\\" + "FileArray" + ".txt";
		BufferedWriter out = null;
		FileWriter writer = null;

		try {

			writer = new FileWriter(filename);
			out = new BufferedWriter(writer);

			for (Person i : arr)
				out.write(i.toString() + "\r\n");

		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	ArrayList<Person> outprint = new ArrayList<Person>();
	
	public void readfromFile() {

		final String filename = "C:\\Users\\Admin\\File\\src\\" + "FileArray" + ".txt";
	

		FileReader bufout = null;
		BufferedReader bufin = null;
		try {

			bufout = new FileReader(filename);
			bufin = new BufferedReader(bufout);
			String line = "";
			String[] tester = new String[3];
			while ((line = bufin.readLine()) != null) {
				
				tester = line.split(",");
				for (int i = 0; i < tester.length; i++) {
					tester[i] = tester[i].substring(tester[i].indexOf('=') + 1);
				}
				Person p1 = new Person(tester[0], tester[1], Integer.parseInt(tester[2]));
				
				outprint.add(p1);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (bufout != null) {
					bufout.close();
				}
				if (bufin != null) {
					bufin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	
	
	public void printoutprint() {
		for (Person i : outprint)
			System.out.println(i);
	}
	
	
	

}
