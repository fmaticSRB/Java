/************************************************************
* Author: Filip Matic
* Title: Tutor.java
* Description: This is the Tutor program. It does the calculations
* asked by the Student, keeps track of questions asked, and 
* displays the answer. 
 ************************************************************/

public class Tutor
{
	// Instance variables
	private String name;
	private int NumQuestions;
	int sum;

	// Constructors
	// Sets the Tutors name, and number of questions asked.
	public Tutor()
	{
		name = "No name given";
		NumQuestions = 0;
	}

	public Tutor(String n, int NumQ)
	{
		name = n;
		NumQuestions = NumQ;
	}

	// Methods

	// Returns the Tutor's name
	public String getName()
	{
		return name;
	}

	// Returns the number of questions asked so far
	public int getNumberOfQuestions()
	{
		return NumQuestions;
	}

	// Takes three integers and returns if they are all the same
	public boolean allTheSame(int num1, int num2, int num3)
	{
		NumQuestions++;
		if (num1 == num2 && num1 == num3 && num2 == num3)
		{
			return true;
		}
		else
		return false;
	}

	//Tells the user if the number that was entered is prime
	public boolean isPrime(int number)
	{
		NumQuestions++;
		for (int i = 2; i < number; i++)
		{
			if (number % i == 0)
				return false;
		}
		return true;
	}

	//Returns the sum of all the numbers between two entered integers, including the entered integers
	public int sum(int num1, int num2)
	{
		int sum = 0;
		NumQuestions++;
		if (num1 < num2)
		{
			for (int i = num1; i <= num2; i++)
			{
				sum += i ;
			}
			return sum;
		}
		else
		if (num1 > num2)
		{
			for (int i = num2; i <= num1; i++)
			{
				sum += i;
			}
			return sum;
		}
		else
		return num1;
	}

	// Takes a String and repeats it the designated number of times
	public String repeat(String str, int n)
	{
		NumQuestions++;
		for (int i = 1; i < n; i++)
		{
			System.out.print(str);
		}
		return str;
	}

	// Tells the user if their entered word is a palindrome
	public boolean isPalindrome(String str)
	{
		NumQuestions++;
		int low = 0;
		int high = str.length() - 1;

		while (low < high) {
			if (str.charAt(low) != str.charAt(high))
			return false;

			low++;
			high--;
		}
		return true;
	}

}
