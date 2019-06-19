/************************************************************
* Author: fmaticSRB
* Title: MovieTix.java
* Description: This program provides a welcome screen to the
* user for a movie theater. Then it prompts them for how
* many tickets they would like to buy and then displays
* the information about their purchase.
 ************************************************************/

import java.util.Scanner;
import java.text.NumberFormat;
public class MovieTix
{
 public static void main (String[] args)
 {
  // Formats the numbers as a currency
  NumberFormat fmt = NumberFormat.getCurrencyInstance();

  // Declaring variables
  /* Note: We are declaring arbitrary values
   * for the ticket prices. These can be changed, or we
   * can even promt the user to enter their own prices */
  double matinee = 5;
  double normal = 7.5;
  double rushhour = 3.5;
  double matineeTix;
  double normalTix;
  double rushhourTix;

  // Allows us to scan in user input
  Scanner in = new Scanner(System.in);

  //Print out the main welcome screen for the theater
  System.out.println("Welcome to the Movie Theater!");
  System.out.println("------------------------------\n");
  System.out.println("The cost of movie tickets:");
  System.out.println("Matinee:\t" + fmt.format(matinee));
  System.out.println("Normal: \t" + fmt.format(normal));
  System.out.println("Rush Hour:\t" + fmt.format(rushhour));

  //Ask the user for information about the ticket purchase
  System.out.println("\nHow many Matinee tickets would you like to buy? ");
  int NumMatinee = in.nextInt();
  System.out.println("How many Normal tickets would you like to buy? ");
  int NumNormal = in.nextInt();
  System.out.println("How many Rush Hour tickets would you like to buy? ");
  int NumRushhour = in.nextInt();

  //Equations to calculate the totals costs involved:
  matineeTix = NumMatinee * matinee;
  normalTix = NumNormal * normal;
  rushhourTix = NumRushhour * rushhour;

  // Print out all the necessary information about the specific purchase
  System.out.println("\nThe cost for the Matinee tickets: " + fmt.format(matineeTix));
  System.out.println("The cost for the Normal tickets: " + fmt.format(normalTix));
  System.out.println("The cost for the Rush Hour tickets: " + fmt.format(rushhourTix));
  System.out.println("The cost for all tickets: " + fmt.format((matineeTix + normalTix + rushhourTix)));
  System.out.println("The total number of tickets: " + (NumMatinee + NumNormal + NumRushhour));
  System.out.println("The average cost per ticket for this purchase: " + fmt.format((matineeTix + normalTix + rushhourTix)/(NumMatinee + NumNormal + NumRushhour)));
 }
}


