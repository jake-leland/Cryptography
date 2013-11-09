/**
 *Matt Baker
 *Jake Leland
 */

import java.io.*;
import java.util.*;

public class Encrypter
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		// Read in the file (the code was tested with .dat files)
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the file to be encrypted: ");
		String fileName = kb.nextLine();

		// Ask for an encryption key (you will need this to decrypt the file).
		// The key is only used if it is between 0 and 32, inclusive.
		// This will be used as the offset for the changeChars() method.
		int key = -1;
		boolean keySet = false;
		while(keySet!=true)
		{
			System.out.print("Enter an encryption key: ");
			key = kb.nextInt();
			kb.nextLine();
			if(key >= 0 && key <= 32)
			{
				keySet=true;
			}
			else
				System.out.println("Invalid key.");
		}

		// Encrypt the file:

		File mainFile = new File(fileName);

		// Convert the file into an array.
		String[][] fileArr = CryptTools.splice(mainFile);

		// Iterate through the array, calling the changeChars() method for each word.
		// The results are printed on screen as the encryption is taking place.
		System.out.println();
		for(int i=0; i<fileArr.length; i++)
		{
			for(int j=0; j<fileArr[i].length; j++)
			{
				fileArr[i][j] = CryptTools.changeChars(fileArr[i][j],key);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();

		// Output the encrypted file to a file.
		// This file's name will be exactly as it was before, with ".encrypted" appended.
		CryptTools.printFile(fileArr, fileName + ".encrypted");
	}
}