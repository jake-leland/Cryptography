/**
 *Matt Baker
 *Jake Leland
 */

import java.io.*;
import java.util.*;

public class CryptTools
{

	//Requires you to send in a file object
	//Returns the number of lines in that file
	public static int countLines(File fileIn) throws FileNotFoundException, IOException
	{
		Scanner fileScanner = new Scanner(fileIn);
		int lineCount = 0;
		while(fileScanner.hasNext())
		{
			lineCount++;
			fileScanner.nextLine();
		}
		return lineCount;
	}

	//Requires you to send in a file object
	//Returns the words of the file in Array form
	public static String[][] splice(File fileIn) throws FileNotFoundException, IOException
	{
		Scanner fileScanner = new Scanner(fileIn);
		String[][] arrOut = new String[countLines(fileIn)][1];
		String tempLine = "";

		for(int i=0; i<countLines(fileIn); i++)
		{
			tempLine = fileScanner.nextLine();
			arrOut[i] = tempLine.split(" ");
		}
		return arrOut;
	}

	//Requires you to send in the Array of words and the name you want the output file to be
	//Prints to a file automatically (no return)
	public static void printFile(String[][] fileArr, String name) throws FileNotFoundException, IOException
	{
		PrintWriter fileOut = new PrintWriter(new FileWriter(name));

		for(int i=0; i<fileArr.length; i++)
		{
			for(int j=0; j<fileArr[i].length; j++)
			{
				fileOut.print(fileArr[i][j]+" ");
			}
			fileOut.println();
		}

		fileOut.close();
	}

	//Requires you to send in a String
	//Returns that String reversed
	public static String reverse(String in)
	{
		String out = "";
		for(int i=in.length()-1; i>=0; i--)
		{
			out += in.charAt(i);
		}
		return out;
	}

	//Requires you to send in an Array of Strings (String[])
	//Returns that String array reversed
	public static String[] reverse(String[] in)
	{
		String[] out = new String[in.length];
		for(int i=in.length-1; i>=0; i--)
		{
			out[in.length-1-i] = in[i];
		}
		return out;
	}


	//Requires you to send in a String
	//Returns that String with changed chars
	public static String changeChars(String in)
	{
		boolean plus1 = false;
		for(int i=0; i<in.length(); i++)
		{
			char c = in.charAt(i);
			String s = "";

			if(c>=33 && c<=64)
				s = (char)(c+158)+"";
			else if(c>=65 && c<=96)
				s = (char)(c-32)+"";
			else if(c>=97 && c<=126)
				s = (char)(c+64)+"";
			else if(c>=161 && c<=255)
			{
				s = (char)(255)+""+c;
				plus1 = true;
			}
			else
				s = c+"";

			System.out.print(s);

			in = in.substring(0,i) + s + in.substring(i+1);

			if(plus1 == true)
					i++;
		}
		return in;
	}

	//Requires you to send in a String with changed chars
	//Returns that String with reset chars
	public static String resetChars(String in)
	{
		boolean plus1 = false;
		for(int i=0; i<in.length(); i++)
		{
			char c = in.charAt(i);
			String s = "";

			if(c>=191 && c<=222)
				s = (char)(c-158)+"";
			else if(c>=33 && c<=64)
				s = (char)(c+32)+"";
			else if(c>=161 && c<=190)
				s = (char)(c-64)+"";
			else if(c==255)
			{
				plus1 = true;
				s = in.charAt(i+1)+"";
			}
			else if(c>=161 && c<=255)
				s = "THIS SHOULDN'T BE HAPPENEING - SOMETHING'S WRONG!";
			else
				s = c+"";

			System.out.print(s);

			if(plus1 == true)
					in = in.substring(0,i) + in.substring(i+1);
			else
				in = in.substring(0,i) + s + in.substring(i+1);
		}
		return in;
	}

	//Requires you to send in a String and an offset (int)
	//Returns that String with changed chars (with the offset)
	public static String changeChars(String in, int offset)
	{
		boolean plus1 = false;
		if(offset>=0 && offset<=32)
		{
			for(int i=0; i<in.length(); i++)
			{
				char c = in.charAt(i);
				String s = "";

				if(c>=33 && c<=64)
					s = (char)(c+(158+offset))+"";
				else if(c>=65 && c<=96)
					s = (char)(c-(32-offset))+"";
				else if(c>=97 && c<=126)
					s = (char)(c+(64+offset))+"";
				else if(c>=161 && c<=255)
				{
					s = (char)(255)+""+c;
					plus1 = true;
				}
				else
					s = c+"";

				System.out.print(s);

				in = in.substring(0,i) + s + in.substring(i+1);

				if(plus1 == true)
					i++;
			}
		}
		return in;
	}

	//Requires you to send in a String with changed chars with the offset used to encrypt it (int)
	//Returns that String with reset chars
	public static String resetChars(String in, int offset)
	{
		boolean plus1 = false;
		if(offset>=0 && offset<=32)
		{
			for(int i=0; i<in.length(); i++)
			{
				char c = in.charAt(i);
				String s = "";

				if(c>=(191+offset) && c<=(222+offset))
					s = (char)(c-(158+offset))+"";
				else if(c>=(33+offset) && c<=(64+offset))
					s = (char)(c+(32-offset))+"";
				else if(c>=(161+offset) && c<=(190+offset))
					s = (char)(c-(64+offset))+"";
				else if(c==255)
				{
					plus1 = true;
					s = in.charAt(i+1)+"";
				}
				else if(c>=161 && c<=255)
					s = "THIS SHOULDN'T BE HAPPENEING - SOMETHING'S WRONG!";
				else
					s = c+"";

				System.out.print(s);

				if(plus1 == true)
					in = in.substring(0,i) + in.substring(i+1);
				else
					in = in.substring(0,i) + s + in.substring(i+1);
			}
		}
		return in;
	}
}