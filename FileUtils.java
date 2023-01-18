package Population;

/**
* file Utilites for reading and writing
* @author Justin Yaung
* @since Aug 25 2022
*/

import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class FileUtils{
	/**
	* Opens a file to read using the Scanner class
	* @paran filename name of the file to open
	* @return the Scanner object
	*/
	public static java.util.Scanner openToRead(String fileName) {
		java.util.Scanner input = null;
		try {
			input = new java.util.Scanner(new java.io.File(fileName));
		} 
		catch (java.io.FileNotFoundException e){
			System.err.println("Error: Cannot open" + fileName + "for write");
			System.exit(-1);
		}
		return input;
	}
	
	/**
	* Opens a file to write using the PrintWriter class
	* @paran filename 	name of file to open
	* @return 	the printwriter Object
	*/
	
	public static PrintWriter openToWrite(String fileName) {
		PrintWriter output = null;
		try {
			output = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("Error cannot open" + fileName + "for write");
			System.exit(-1);
		}
		return output;
	}
}
