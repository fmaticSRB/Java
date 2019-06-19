 /***********************************************************
 * AUTHOR: fmaticSRB
 * Title: BankAccount
 * SPECIFICATION: This program welcomes the user to a bank
 * and allows the user to perform basic functions on their 
 * account. 
 ************************************************************/
import java.text.NumberFormat;
import java.util.Scanner;

public class BankAccount
{
    public static void main(String[] args)
	{
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

		//Make a Scanner object to get the input
		Scanner scan = new Scanner(System.in);
		double enteredAmount;
		char command;
		boolean flag;
		String input;
		// print intro message
        System.out.println("Welcome to your Bank Account");

        // Ask for id
        System.out.print("What is your bank id? ");
		String enteredID = scan.nextLine();

       // Ask user for initial deposit
        do
        {
            System.out.print("Initial deposit into Checking: ");
            enteredAmount = scan.nextDouble();

            // make sure they enter a positive number
            if ( enteredAmount <= 0 )
            {
                System.out.println("Invalid choice (number must be positive).");
            }

        } while ( enteredAmount <= 0 );


		UserAccount account1= new UserAccount(enteredID, enteredAmount);


		// print the menu
        printMenu();
		do
		 {
           // ask a user to choose a command
		   System.out.println("\nPlease enter a command or type ?");
		   input = scan.next();
           command = input.charAt(0);

           switch (command)
            {
                 case 'a': // Ask user for initial deposit
       			 case 'A':
       			 			do
       						{
       						     System.out.print("Amount to deposit: ");
       						     enteredAmount = scan.nextDouble();
       						     // make sure they enter a positive number
       					     if ( enteredAmount <= 0 )
       					     {
       						         System.out.println("Invalid choice (number must be positive).");
       					     }

       						 } while ( enteredAmount <= 0 );

                            account1.deposit(enteredAmount);
                            System.out.println("You deposited " + fmt.format(enteredAmount) + " to Checking.");

			               //print a prompt after the deposit

                      break;

                 case 'b':
				 case 'B':
					        do
					        {
					          System.out.print("Amount to withdraw: ");
					          enteredAmount = scan.nextDouble();

					          // make sure amount is positive and less than current checking balance
					          if (enteredAmount <= 0)
					          		System.out.println("Invalid choice (number must be positive).");
					        } while (enteredAmount <= 0);

					       // update balance and display message
					       flag = account1.withdraw(enteredAmount);
					       if (flag)
					       			System.out.println("You withdrew " + fmt.format(enteredAmount));
					       	else
					       			System.out.println("Invalid choice (not sufficient fund)");


                      break;

                 case 'c': // print the info on each account
                 			System.out.println(account1.toString());

                      break;
                 case 'd':
                 case 'D': // ask for id and instantiate a new account using the entered id
					       // but same balance from account1
					       // then use the method equals to check to see if the ids are the same or not!

					       // Ask for id
						   System.out.print("What is your bank id? ");
						   enteredID = scan.next();

						    // Ask user for initial deposit
						   UserAccount account2= new UserAccount(enteredID, enteredAmount);
						   flag = account1.equals(account2);
						   if (flag)
						   		System.out.println("Same account");
						   	else
						   		System.out.println("Not the same account!");
                      break;
                 case 'e':
                 case 'E':
                            account1.addInterest();
                            System.out.println(account1.toString());
                            break;
                 case '?': // display the menu again
                             printMenu();

                      break;
                 case 'q':// quit the program

                      break;
				 default:
					  System.out.println("Invalid choice!");
					  break;


            }

        } while (command != 'q');
	} // end of main
	 // this method prints out the menu to a user
   public static void printMenu()
   {
    System.out.print("\nCommand Options\n"
                   + "-----------------------------------\n"
                   + "a: deposit\n"
                   + "b: withdraw\n"
                   + "c: display the balance \n"
                   + "d: Check the account\n"
                   + "e: add interest\n"
                   + "?: display the menu again\n"
                   + "q: quit this program\n\n");
    }

}  // end class

