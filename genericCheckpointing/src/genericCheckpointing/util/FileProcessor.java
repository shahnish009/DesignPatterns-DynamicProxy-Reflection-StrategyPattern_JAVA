package genericCheckpointing.util;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
	
	private Scanner sc = null;
	private BufferedWriter bw = null;
	private String fileName = null;

	/**
	 * constructor for FileProcessor
	 * @param inputFile - file to be processed
	 */
	public FileProcessor(String inputFile) {
		fileName = inputFile;
	}

	/**
	 * @throws FileNotFoundException
	 */
	public void openRead() throws FileNotFoundException {
		try {
			if (bw != null) {
				bw.close();
				bw = null;
			}
			sc = new Scanner(new File(fileName));
		} catch(Exception e) {
			System.err.println(e + " occurred during openRead");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * @throws FileNotFoundException
	 */
	public void openWrite() throws FileNotFoundException {
		try {
			if (sc != null) {
				sc.close();
				sc = null;
			}
			bw = new BufferedWriter(new FileWriter(new File(fileName)));
		} catch(Exception e) {
			System.err.println(e + " occurred during openWrite");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * method to read line from file line by line
	 * @return one line at a time from the input file
	 */
	public String readLine() {
		
		try {
			if(sc != null) {
				if(sc.hasNextLine()) {
					return (sc.nextLine().trim());
				}
			}
			else {
				throw new RuntimeException("unable to open file");
			}
		}
		catch(Exception e) {
			System.err.println(e + " occurred during readLine");
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	/**
	 * @param s
	 * @throws IOException
	 */
	public void writeLine(String s) {
		try{
			bw.write(s);
			bw.flush();
		} catch(Exception e) {
			System.err.println(e + " occurred during writeLine");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * method to close file
	 */
	public void closeFile() throws FileNotFoundException {
		try {
			if (sc != null) {
				sc.close();
				sc = null;
			}
			if (bw != null) {
				bw.close();
				bw = null;
			}
		} catch(Exception e) {
			System.err.println(e + " occurred during closeFile");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
