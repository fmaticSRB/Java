/************************************************************
* Author: Filip Matic
* Title: TicketClac.java
* Description: This program provides a welcome screen to the
* user for a movie theater. Then it prompts them for how
* many tickets they would like to buy and then displays
* the information about their purchase.
 ************************************************************/
//import java.io.IOException;
//import java.io.FileReader;
//import java.io.FileNotFoundException;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.text.NumberFormat;
import java.io.*;
import java.util.*;

public class TicketCalc
{
	// Initialize the scanner and number format
	Scanner in = new Scanner(System.in);
	NumberFormat fmt = NumberFormat.getCurrencyInstance();

	// Instance Variables
	public static int NUMROWS = 15;
	public static int NUMCOLUMNS = 30;
	private char[][] seats = new char[NUMROWS][NUMCOLUMNS];
	private double[] prices = new double[NUMROWS];
	public int seatsAvailable;
	private int seatsSold;
	private double totalRevenue;
	private double totalCost;

	// Constructors
	public TicketCalc()
	{
		try // This try reads in the seat availability file
		{
			FileReader fr = new FileReader("seatAvailability.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			for (int i = 0; i < NUMROWS; i++) {
				for(int j = 0; j < NUMCOLUMNS; j++)
				{
					seats[i] = line.toCharArray();
				}
				line = br.readLine();
			}
		}
		catch(FileNotFoundException e )
		{
			System.out.println( "Could not open the file: " + e );
		}
		catch(IOException e)
		{
			System.out.println("IO exception" + e);
		}

		try // This try reads in the seat prices file
			{
				FileReader fr = new FileReader("seatPrices.txt");
				BufferedReader br = new BufferedReader(fr);
				String temp = br.readLine();

				for(int k = 0; k < NUMROWS; k++) {
					prices[k] = Double.parseDouble(temp);
					System.out.println(prices[k]);
					temp = br.readLine();
				}
			}
			catch(FileNotFoundException e )
			{
				System.out.println( "Could not open the file: " + e );
			}
			catch(IOException e)
			{
				System.out.println("IO exception" + e);
			}

		seatsSold = 0;
		totalRevenue = 0;
		seatsAvailable = 0;
	}

	public void displaySeats() // Displays the seating chart for the theater, including which seats are available, and which are not
	{
		System.out.println("\t\tSeats\n");
		for (int i = 0; i < NUMROWS; i++)
		{
			System.out.print("\nRow " + (i + 1) + " ");
			for(int j = 0; j < NUMCOLUMNS; j++)
			System.out.print(seats[i][j]);
		}
		System.out.println("\n\t\tLegend:  * = Sold\n\t\t\t # = Available");
	}

	public boolean requestTickets(int num, int row, int start) // Checks to see if the desired seats are open
	{
		for(int i=0;i < num; i++)
		{
			if (seats[row-1][(start-1)+i] == '*')
			{
				return false;
			}
		}
			return true;
	}

	public boolean purchaseTickets(int num, int row, int start) // Purchases the desired seats by setting their status to "sold"
	{
		totalCost = (prices[row-1]) * num;
		System.out.println("The tickets you requested are available for purchase.");
		System.out.println("The total purchase price is " + num + " X " + prices[row-1] + " = " + totalCost);
		System.out.print("\nDo you wish to purchase these tickets?(y/n)?");
		String c1 = in.nextLine();
		if (c1.equals("y") || c1.equals("Y"))
			{
				for(int i = 0; i < num; i++)
				{
					seats[row-1][(start-1)+i] = '*';
				}
				seatsSold += num;
				totalRevenue += totalCost;
				return true;
			}

			return false;
	}

	public void printTickets(int seats, int row, int start) // Prints out a summary of the transaction that the user just had.
	{
		totalCost =(prices[row]) * seats;
		System.out.print("\nNum seats: " + seats);
		System.out.print("\nThe price for the requested tickets is :" + fmt.format(totalCost));
		System.out.print("\nPlease input amount paid: ");
		int paid = in.nextInt();
		for(int k = start; k < (start + seats); k++)
			{
				System.out.print("\n************************");
				System.out.print("\n*MovieTheater *");
				System.out.print("\n*row " + row + "seat " + k);
				System.out.println("\n*Price: " + fmt.format(prices[row]));
			}
		System.out.print("\nTickets purchased: " + seats);
		System.out.print("\nPayment: " + paid);
		System.out.print("\nTotal ticket price: " + fmt.format(totalCost));
		System.out.println("\nChange due: " + fmt.format(paid-totalCost));
	}

	public double getTotalRevenue() // Returns the total revenue made by the theater
	{
		return totalRevenue;
	}

	public int getSeatsSold() // Returns the number of seats sold so far
	{
		return seatsSold;
	}

	public int getSeatsAvailable() // Returns the number of seats still available
	{
		seatsAvailable = (NUMROWS*NUMCOLUMNS) - seatsSold;
		return seatsAvailable;
	}

} // End of main