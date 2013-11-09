/**
 *Matt Baker
 *Jake Leland
 */

import java.io.*;
import java.util.*;

public class Decrypter
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		// Reas in the encryped file (the code was tested with .dat files)
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the file to be decrypted: ");
		String fileName = kb.nextLine();

		// Ask for the encryption key (the one used to encrypt the file).
		// The key is only used if it is between 0 and 32, inclusive.
		// This will be used as the offset for the changeChars() method.
		int key = -1;
		boolean keySet = false;
		while(keySet!=true)
		{
			System.out.print("Enter the decryption key: ");
			key = kb.nextInt();
			kb.nextLine();
			if(key >= 0 && key <= 32)
			{
				keySet=true;
			}
			else
				System.out.println("Invalid key.");
		}

		// Decrypt the file:

		File mainFile = new File(fileName);

		// Convert the file into an array.
		String[][] fileArr = CryptTools.splice(mainFile);

		// Iterate through the array, calling the resetChars() method for each word.
		// The results are printed on screen as the decryption is taking place.
		System.out.println();
		for(int i=0; i<fileArr.length; i++)
		{
			for(int j=0; j<fileArr[i].length; j++)
			{
				fileArr[i][j] = CryptTools.resetChars(fileArr[i][j],key);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();

		// Output the encrypted file to a file.
		String s = fileName;

		// If the file ends with ".encrypted", remove the ".encrypted".
		if(fileName.lastIndexOf(".encrypted")!=-1)
		{

			s=s.substring(0,fileName.lastIndexOf(".encrypted"));
		}

		// This file's name will be exactly as it was before, with ".decrypted" appended.
		// If the file that was read in ended with ".encrypted", then ".decrypted" replaced it.
		CryptTools.printFile(fileArr, s + ".decrypted");
	}
}