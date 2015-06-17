package frameworkalgo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Testing {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File inFile = new File("/Users/muktharahmed/Data2/toDelete/test.txt");
		RegExCollection regEx = new RegExCollection();
		
		File backedup = new File( inFile + ".bak");
		BufferedReader reader = new BufferedReader(new FileReader(backedup));
		PrintWriter writer = new PrintWriter(new FileWriter(inFile));
		String line = null;
		
		while ((line = reader.readLine()) != null) {
			String regExReturn = regEx.matchImgSrcByIpPattern(line);
			System.out.println("+ Matched: " + regExReturn);
			writer.println(line.replaceAll("mukthar", "ING" ));
		}
		reader.close();
		writer.close();

	}

	
	
}
