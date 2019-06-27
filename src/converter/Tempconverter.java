package converter;

// Imported needed Java Utilities 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class Tempconverter {
	// Class variable to confirm method call for each line
	static int index = 0;
	
	public static void celsToFahr(int celsius) {
		// Assign text files to variables
		File celsTemp = new File("C:\\Myjava\\TempConverter\\src\\celstemp.txt");
		File fahrTemp = new File("C:\\Myjava\\TempConverter\\src\\fahrtemp.txt");
		
		// Reader and Writer
		BufferedReader reader;
		PrintWriter writer;
		
		// Variable to hold value from each line.
		String line;
		
		try{ 
			if(fahrTemp.createNewFile() || !fahrTemp.createNewFile()) {
				
				// Instantiate Reader to read and store from file 
				// and Writer to write to another file
				reader = new BufferedReader(new FileReader(celsTemp));
				writer = new PrintWriter(new FileWriter(fahrTemp));
				
				// Print titles with TAB spacing
				writer.println("Cels Temp \t \t Fahr Temp");
				
				while ((line = reader.readLine()) != null) {	
						// Instantiate StringTokenizer
						StringTokenizer strToken = new StringTokenizer(line);
						
						// Get each value in integer data type
						celsius = Integer.parseInt(strToken.nextToken());
						
						// Conversion formula
						double f = ((9.0/5) * celsius + 32);
						
						// Round up value to 2 d.p
						DecimalFormat df = new DecimalFormat("#.00");
						String fahrenheit = df.format(f); 
						// Print final result
						writer.println(celsius + "\t \t \t" + fahrenheit);
					}
					
					reader.close();
					writer.close();
					System.out.println("Line " + index + " converted successfully");
				}
			} catch (IOException ioEx) {
				// This will run only if there's an error
				System.err.println("Could not copy the file to a destination directory!");
		}
	}
	
	public static void main(String[] args) {
		// FOR LOOP confirms each line process.
		for(index = 1; index <= 10; index++) {
			celsToFahr(index);
		}
	}
}