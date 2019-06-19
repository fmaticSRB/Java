/************************************************************
 * Author: fmaticSRB
 * Title: TempConverter.java
 * Description: The program askes what the user wants to convert, 
 * and converts the entered temperature to either C or F
 *
 ************************************************************/
import java.util.Scanner;	// Import Scanner Class

public class TempConverter
{
		public static void main (String[] args)
		{
			// Instantiate Variables
			int Choice;
			float Temp;

			Scanner scan = new Scanner (System.in);	// Create a Scanner Object

			// User input promt
			System.out.println ("Which do you wish to convert?");
			System.out.println ("1: Celcius to Fahrenheit");
			System.out.println ("2: Fahrenheit to Celcius");

			Choice = scan.nextInt();

			if (Choice < 1 || Choice > 2) {
				System.out.println ("Invalid Choice, please try again");
			} else {

			System.out.println ("Enter Value to Convert");

			Temp = scan.nextFloat();

			if (Choice == 1) {
				Temp = Temp * 9/5 + 32;
				System.out.println ("Temp in Fahrenheit is " + Temp);
			} else {
				Temp = (Temp - 32) * 5/9;
				System.out.println ("Temp in Celcius is " + Temp);
			}
		}
	}
}

