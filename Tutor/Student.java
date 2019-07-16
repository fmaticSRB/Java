/************************************************************
* Author: Filip Matic
* Title: Student.java
* Description: This program acts as a student. The student
* finds a tutor and then asks questions for the tutor to 
* answer. 
 ************************************************************/
import java.util.Scanner;

public class Student
{
	public static void main(String[] args)
	{
		// Make a scanner object to get inputs
		Scanner scan = new Scanner(System.in);
		char choice;
		String input;

		// create a new Tutor
		Tutor Person1 = new Tutor("Tutor", 0);

		// Prints the main menu
		printMenu();
		do
		{
			// ask the user to choose a command
		   System.out.println("\nPlease enter a command or type ? to display Main Menu");
		   input = scan.next();
           choice = input.charAt(0);

		switch(choice)
		{
			case 'A': // Prints out the name of the Tutor
			case 'a': System.out.println(Person1.getName());
				  break;

			case 'B': // Displays the total number of questions asked
			case 'b': System.out.println(Person1.getNumberOfQuestions());
				  break;

			case 'C': // Dsplays if all entered vales are the same
			case 'c': System.out.println("Enter three integers");
					  System.out.println("Enter the first integer: ");
					  int num1 = scan.nextInt();
					  System.out.println("Enter the second integer: ");
					  int num2 = scan.nextInt();
					  System.out.println("Enter the third integer: ");
					  int num3 = scan.nextInt();

					  if (Person1.allTheSame(num1, num2, num3) == true)
					  {
						  System.out.println("All numbers are the same.");
					  }
					  else
					  System.out.println("The numbers are not all the same.");

				  break;

			case 'D': // Lets the user know if their entered number is prime
			case 'd': System.out.println("Enter a number: ");
					  int number = scan.nextInt();

					  if (Person1.isPrime(number) == true)
					  {
						  System.out.println("Your number is prime.");
					  }
					  else
					  System.out.println("Your number is not prime.");
				  break;

			case 'E': // Displays the sum of two entered integers
			case 'e': System.out.println("Enter the first number: ");
					  num1 = scan.nextInt();
					  System.out.println("Enter the second number: ");
					  num2 = scan.nextInt();
					  System.out.println("The sum between " + num1 + " and " + num2 + " is " + Person1.sum(num1, num2));
				  break;

			case 'F': // Repeats the entered string n number of times
			case 'f': System.out.print("Enter a string: ");
					  String str = scan.next();
					  System.out.print("\nEnter an integer: ");
					  int n = scan.nextInt();

					  System.out.println(Person1.repeat(str, n));
				  break;

			case 'G': //Tells the user if their string is a palindrome
			case 'g': System.out.print("Enter a string: ");
					  str = scan.next();
					  if (Person1.isPalindrome(str) == true)
					  	System.out.println("Your string is a palindrome.");
					  else
					  	System.out.println("Your string is not a palindrome.");
				  break;

			case '?': printMenu();
				  break;

			case 'Q': //Quits the program
			case 'q':
				  break;

			default:
					  System.out.println("Invalid choice!");
					  break;
		}
		} while (choice != 'q');
		}// end of main
		// This method prints the main menu for the user
		 public static void printMenu()
		   {
		    System.out.print("\nCommand Options\n"
		                   + "-----------------------------------\n"
		                   + "a: Tutor's name\n"
		                   + "b: Number of Questions asked\n"
		                   + "c: Are these numbers the same \n"
		                   + "d: Is this Prime\n"
		                   + "e: Sum between two integers\n"
		                   + "f: Repeat the string\n"
		                   + "g: Is it a palindrome\n"
		                   + "?: Display the menu\n"
		                   + "q: Quit\n\n");
    }

} // end of class
