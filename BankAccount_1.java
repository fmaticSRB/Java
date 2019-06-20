 /***********************************************************
 * AUTHOR: Filip Matic
 * Title: BankAccount_1.java
 * SPECIFICATION: This program welcomes the user to a bank
 * and allows the user to perform basic functions on their 
 * account. 
 ************************************************************/

import java.util.Scanner;
import java.text.NumberFormat;


public class BankAccount_1
{
	public static void main(String[] args)
 	{
		// Declare interest rates based on account type
		final double BASICINTEREST = 0.025;
		final double PREMIUMINTEREST = 0.035;
		final double PLATINUMINTEREST = 0.045;

		double SavingsBalance = 0;		// Total balance in Savings account
		double CheckingBalance = 0;		// Total balance in Checking Account
		double Deposit = 0;				// Amount deposited by user
		double Withdrawl = 0;			// Amount withdrawn by user
		double Transfer = 0;			// Amount transerred between accounts by user
		double EndBalance = 0;			// Final balance of the user's account

		String name;					// Name of the user
		int choice = 0;					// First choice made by user
		int choice2 = 0;				// Second choice made by user

		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);

		// Welcomes user to bank and asks for their name
  		System.out.println("Welcome to your Bank Account.");
  		System.out.print("What is your name? ");
  		name = scan.nextLine();

		// Asks user for initial deposit into Savings. Promts user to enter again if amount is not valid
		do
		{
			System.out.print("Initial deposit into Savings: ");
  			SavingsBalance = scan.nextDouble();

  			if (SavingsBalance <= 0)
  			{
				System.out.println("Invalid amount. Number must be positive.");
			}
		} while (SavingsBalance <= 0);

		// Asks user for initial deposit into Checking. Promts user to enter again if amount is not valid
		do
		{
			System.out.print("Initial deposit into Checking: ");
  			CheckingBalance = scan.nextDouble();

  			if (CheckingBalance <= 0)
  			{
				System.out.println("Invalid amount. Number must be positive.");
			}
		} while (CheckingBalance <= 0);

		// Updates total balance of the user's account
  		EndBalance = CheckingBalance + SavingsBalance;

		// Determine the type of account and display account information on screen
		if(EndBalance > 0 && EndBalance <= 1000)
   		{
			System.out.println("\n" + name + "'s Basic Account Balance: " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
   		}
   		else if (EndBalance > 1000 && EndBalance <= 5000)
   		{
    		System.out.println("\n" + name + "'s Premium Account Balance: " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
		}
   		else if (EndBalance > 5000)
   		{
   			System.out.println("\n" + name + "'s Platinum Account Balance: " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
   		}

		// Display bank's main menu
		do
		{
			System.out.println("Bank Options:");
   			System.out.println("\t1. Deposit Money");
   			System.out.println("\t2. Withdraw Money");
   			System.out.println("\t3. Transfer Money");
   			System.out.println("\t4. Quit");
   			choice = scan.nextInt();

   			if (choice < 1 || choice > 4 )
   			{
				System.out.println("Not a valid choice. Please choose again.");
			}

			// Display menu options based on user's choice
   			switch (choice) {
				case 1:
				// Display deposit options
				do
				{
					System.out.println("\nDeposit Money Options:");
    				System.out.println("\t1. Deposit to Checking");
    				System.out.println("\t2. Deposit to Savings");
    				System.out.println("\t3. Cancel");
    				choice2 = scan.nextInt();

    				if (choice2 < 1 || choice2 > 3)
    				{
						System.out.println("Not a valid choice. Please choose again.");
					}
				} while (choice2 < 1 || choice2 > 3);

				// Display promts based on user's secondary choice
    			switch (choice2) {
					case 1:
					// Promt user for deposit into checking
					do
					{
						System.out.print("\nAmount to deposit into Checking: ");
     					Deposit = scan.nextDouble();

						if (Deposit <= 0)
						{
							System.out.println("Invalid Amount. Please enter again.");
						}
					} while (Deposit <= 0);
     				System.out.println("You deposited " + fmt.format(Deposit) + " to Checking");

					// Update account balance after deposit
     				CheckingBalance = CheckingBalance + Deposit;
     				EndBalance = CheckingBalance + SavingsBalance;

					// Display account information after latest transaction
     				System.out.println("\nAfter this transaction your balance is " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
     				break;

     				case 2:
     				// Promt user for deposit into savings
     				do
     				{
						System.out.print("\nAmount to deposit into Savings: ");
     					Deposit = scan.nextDouble();

     					if (Deposit <= 0)
						{
							System.out.println("Invalid Amount. Please enter again.");
						}
					} while (Deposit <= 0);
     				System.out.println("You deposited " + fmt.format(Deposit) + " to Savings");

					// Update account balance after deposit
     				SavingsBalance = SavingsBalance + Deposit;
     				EndBalance = CheckingBalance + SavingsBalance;

					// Display account information after latest transaction
					System.out.println("\nAfter this transaction your balance is " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
					break;

     				case 3:
     				System.out.println("Cancelling Deposit.");
     				break;
     				}
				break; // End of case 1

    			case 2:
    			// Display Withdraw options
    			do
    			{
					System.out.println("\nWithdraw Money Options:");
    				System.out.println("\t1. Withdraw from Checking");
    				System.out.println("\t2. Withdraw from Savings");
    				System.out.println("\t3. Cancel");
    				choice2 = scan.nextInt();

					if (choice2 < 1 || choice2 > 3)
					{
						System.out.println("Not a valid choice. Please choose again.");
					}
				} while (choice2 < 1 || choice2 > 3);

				// Display promts based on user's secondary choice
    			switch (choice2) {
					case 1:
					do
					{
						System.out.print("\nAmount to withdraw from checking: ");
     					Withdrawl = scan.nextDouble();

						if (Withdrawl > CheckingBalance || Withdrawl <= 0)
						{
							System.out.println("Invalid choice. Please enter again.");
						}
					} while (Withdrawl > CheckingBalance || Withdrawl <= 0);
     				System.out.println("You withdrew " + fmt.format(Withdrawl) + " from checking");

					// Update account balance after withdrawl
					CheckingBalance = CheckingBalance - Withdrawl;
     				EndBalance = CheckingBalance + SavingsBalance;

					// Display account information after latest transaction
     				System.out.println("\nAfter this transaction your balance is " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
     				break;

     				case 2:
     				do
     				{
						System.out.print("\nAmount to withdraw from Savings: ");
     					Withdrawl = scan.nextDouble();

     					if (Withdrawl > SavingsBalance || Withdrawl <= 0)
     					{
							System.out.println("Invalid choice. Please enter again.");
						}
					} while (Withdrawl > SavingsBalance || Withdrawl <= 0);
					System.out.println("You withdrew " + fmt.format(Withdrawl) + " from savings");

					// Update account balance after withdrawl
					SavingsBalance = SavingsBalance - Withdrawl;
     				EndBalance = CheckingBalance + SavingsBalance;

					// Display account information after latest transaction
     				System.out.println("\nAfter this transaction your balance is " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
     				break;

     				case 3:
     				System.out.println("Cancelling withdrawl.");
     				break;
     				}
     			break; // End of case 2

     			case 3:
     			// Display Transfer options
     			do
     			{
					System.out.println("Transfer Money Options:");
     				System.out.println("\t1. Transfer from Checking to Savings");
     				System.out.println("\t2. Transfer from Savings to Checking");
     				System.out.println("\t3. Cancel");
     				choice2 = scan.nextInt();

					if (choice2 < 1 || choice2 > 3)
    				{
						System.out.println("Not a valid choice. Please choose again.");
					}
				} while (choice2 < 1 || choice2 > 3);

				// Display promts based on user's secondary choice
     			switch (choice2) {
					case 1:
					do
					{
						System.out.print("\nAmount to transfer from Checking to Savings: ");
						Transfer = scan.nextDouble();

						if (Transfer > CheckingBalance || Transfer <= 0)
						{
							System.out.println("Invalid choice. Please enter again.");
						}
					} while (Transfer > CheckingBalance || Transfer <= 0);

					System.out.println("You transferred " + fmt.format(Transfer) + " from Checking to Savings");

					// Update account balance after transfer
					SavingsBalance = SavingsBalance + Transfer;
					CheckingBalance = CheckingBalance - Transfer;
					EndBalance = SavingsBalance + CheckingBalance;

					// Display account information after latest transaction
					System.out.println("\nAfter this transaction your balance is: " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
					break;

					case 2:
					do
					{
						System.out.print("\nAmount to transfer from Savings to Checking: ");
						Transfer = scan.nextDouble();

						if (Transfer > SavingsBalance || Transfer <= 0)
						{
							System.out.println("Invalid choice. Please enter again.");
						}
					} while (Transfer > SavingsBalance || Transfer <= 0);

					System.out.println("You transferred " + fmt.format(Transfer) + " from Savings to Checking");

				    // Update account balance after transfer
				    SavingsBalance = SavingsBalance - Transfer;
					CheckingBalance = CheckingBalance + Transfer;
					EndBalance = SavingsBalance + CheckingBalance;

					// Display account information after latest transaction
					System.out.println("\nAfter this transaction your balance is: " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
					break;

					case 3:
					System.out.println("Cancelling transfer.");
     				break;
					}
				break; // End of case 3

				case 4:
				System.out.println("You have chosen to quit. Quitting the program");

				// Determine interest rate,account type,and display final account information.
				if(EndBalance > 0 && EndBalance <= 1000)
				{
					SavingsBalance = (SavingsBalance * BASICINTEREST) + SavingsBalance;
					CheckingBalance = (CheckingBalance * BASICINTEREST) + CheckingBalance;
					EndBalance = SavingsBalance + CheckingBalance;
					System.out.println("\nWe have added interest to your account.\n" + name + "'s Basic Account Balance: " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
				}
				else if (EndBalance > 1000 && EndBalance <= 5000)
				{
					SavingsBalance = (SavingsBalance * PREMIUMINTEREST) + SavingsBalance;
					CheckingBalance = (CheckingBalance * PREMIUMINTEREST) + CheckingBalance;
					EndBalance = SavingsBalance + CheckingBalance;
					System.out.println("\nWe have added interest to your account.\n" + name + "'s Premium Account Balance: " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
				}
				else if (EndBalance > 5000)
				{
					SavingsBalance = (SavingsBalance * PLATINUMINTEREST) + SavingsBalance;
					CheckingBalance = (CheckingBalance * PLATINUMINTEREST) + CheckingBalance;
					EndBalance = SavingsBalance + CheckingBalance;
					System.out.println("\nWe have added interest to your account.\n" + name + "'s Platinum Account Balance: " + fmt.format(EndBalance) + " (S: " + fmt.format(SavingsBalance) + ", C: " + fmt.format(CheckingBalance) + ")");
   				}
				break; // End of case 4
			} // End of initial switch statement
		} while (choice != 4); // End of original do loop
	} // End of Method
} // End of Class