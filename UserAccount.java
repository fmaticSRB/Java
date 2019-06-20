 /***********************************************************
 * AUTHOR: Filip Matic
 * Title: UserAccount.java
 * SPECIFICATION: This program deals with the exact details
 * pertaining to the users bank acount. 
 ************************************************************/

import java.text.NumberFormat;

public class UserAccount
{
	NumberFormat fmt = NumberFormat.getCurrencyInstance();

	// Instance variables
	private String ID;
	private double Balance;

	// Constructors & Methods

	// Instantiates the values for ID and the Balacne
	public UserAccount()
	{
		ID = "???";
		Balance = 0;
	}

	// Sets the ID and Balance to initial values
	public UserAccount(String initID, double initBalance)
	{
		ID = initID;
		Balance = initBalance;
	}

	public UserAccount(String initID)
	{
		ID = initID;
	}

	// Returns the ID of the account
	public String getID()
	{
		return ID;
	}

	// Returns the balance of the account
	public double getBalance()
	{
		return Balance;
	}

	// Sets the ID of the account
	public void setID(String name)
	{
		ID = name;
	}

	// Credits the account with a deposit as long as the conditions are met
	public void deposit(double depositAmount)
	{
		if (depositAmount > 0)
		{
			Balance = depositAmount + Balance;
		}
	}

	// Credits the account with a withdrawl as long as the conditions are met
	public boolean withdraw(double withdrawAmount)
	{
		if (withdrawAmount >0 && withdrawAmount <= Balance)
		{
			Balance = Balance - withdrawAmount;
			return true;
		}
		else
		return false;
	}

	// Adds interest to the account based on the amount of money in the account
	public void addInterest()
	{
		if (Balance > 5000)
		{
			Balance = (Balance * .045) + Balance;
		}
		else if(Balance > 1000)
		{
			Balance = (Balance * .035) + Balance;
		}
		else
		{
			Balance = (Balance * .025) + Balance;
		}
	}

	// Checks to see if the ID's of two different accounts are the same
	public boolean equals(UserAccount otherAccount)
	{
		// local variables
		boolean flag = false;
		if(getID().equals(otherAccount.getID()))
		{
			flag = true;
		}
		return flag;
	}

	// Returns the information about the account (ID and Balance)
	public String toString()
	{
		return "ID: " + ID + "\nBalance: " + fmt.format(Balance);
	}
} // End Class
