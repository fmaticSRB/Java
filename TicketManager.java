/************************************************************
* Author: Filip Matic
* Title: TicketManager.java
* Description: This program provides a welcome screen to the
* user for a movie theater. Then it prompts them for how
* many tickets they would like to buy and then displays
* the information about their purchase.
 ************************************************************/
import java.text.NumberFormat;
import java.util.*;

public class TicketManager
{
	public static void main(String[] args)
	{
	// Initialize the scanner and number format
	Scanner scan = new Scanner(System.in);
	NumberFormat fmt = NumberFormat.getCurrencyInstance();

	TicketCalc MovieTheater = new TicketCalc();

	// Declare needed variables
	int choice = 0;

	// Display the main menu as long at the user doesn't quit
	do {
		System.out.println("\nWelcome to the MovieTheater");
		System.out.println("1. View Available Seats");
		System.out.println("2. Request Tickets");
		System.out.println("3. Display Theater Sales Report");
		System.out.println("4. Exit the Program");

		choice = scan.nextInt();

		// Switch statement takes into account the users choice and acts accordingly
		switch (choice)
		{
			case 1: // Displays the seating chart
			MovieTheater.displaySeats();
			break;

			case 2: // Asks the user what tickets they wish to purchase
			System.out.print("\nNumber of tickets desired (1 - 30): ");
			int num = scan.nextInt();
			System.out.print("\nDesired row (1 - 15): ");
			int row = scan.nextInt();
			System.out.print("\nDesired starting seat number in the row (1 - 30): ");
			int seat = scan.nextInt();

			if(MovieTheater.requestTickets(num, row, seat) == true)
				{
					if(MovieTheater.purchaseTickets(num, row, seat) == true)
						{
							MovieTheater.printTickets(num, row, seat);
						}
					else
					System.out.println("Please come again.");
				}
			else
				System.out.println("Sorry, those seats are not available.");
			break;

			case 3: // Prints out the sales report for the theater at the current point
			System.out.println("MovieTheater Sales Report");
			System.out.println("____________________");
			System.out.println("Seats sold: " + MovieTheater.getSeatsSold());
			System.out.println("Seats available: " + MovieTheater.getSeatsAvailable());
			System.out.println("Total revenue to date: " + fmt.format(MovieTheater.getTotalRevenue()));
			break;

			case 4: // Quits the program
			System.out.println("Now exiting the program.");
			break;

			default:
			System.out.println("That is not a vaild choice, please choose again.");
			break;
		} // End of switch statement

		} while (choice !=4); // End of do loop
	} // End of main
} // End of class
