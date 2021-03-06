//----------------------------------------------//
// Greg Paolo Violan, 011706641                 //
// CECS 424 Sec 01                              //
// Date: 09-05-17                               //
// Homework 1: Financial quantities             //
//----------------------------------------------//
import java.io.*;
import java.util.*;
// Scans file: arg[0] via MS-DOS
// checks equivalency to US dollars expression 
// e.g: $1.00, $1,234.00, $0, $123, $1,234,567.00, etc..
public class HW1 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// Regular expression - US dollars
		String regex = "^\\$([*]*)(([1-9]\\d{0,2}(,\\d{3})*)|(\\d))(\\.\\d\\d)?$";
		
		File file = new File(args[0]);
		
		// Scans file -> check each line matches regular expression
		Scanner file_scnr = new Scanner(file);
		while(file_scnr.hasNextLine())
		{
			String input = file_scnr.nextLine();
			
			boolean match = input.matches(regex);
			if(match)
				System.out.println("Matched: " + input);
			else
				System.out.println("Not Matched: " + input);
		}
		
		file_scnr.close();
	}
}
