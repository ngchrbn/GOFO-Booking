package GOFO.Utilities;

import GOFO.User.User;

/**
 * Ewallet: Represent an ewallet with its attributes and methods.
 * @author Mahamat Ibrahim Mahamat
 * @version 1.0
 */
public class Ewallet {
    private double balance;
    private String ownerId;

    /**
     * Constructs an Ewallet object.
     * @param balance ewallet balance
     * @param ownerId owner id
     */
    public Ewallet(double balance, String ownerId) {
        setBalance(balance);
        setOwnerId(ownerId);
    }

    /**
     * Set an initial balance to the account.
     * @param balance initial balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Set the owner of the eWallet.
     * @param ownerId owner id
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Returns the balance in the eWallet.
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns owner id of the eWallet.
     * @return owner id
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Deposit an amount to the eWallet.
     * @param amount amount to deposit
     */
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    /**
     *  Withdraw an amount from the eWallet,
     *  after checking that it is not negative and not greater than
     *  actual balance.
     * @param amount amount to withdraw
     * @return boolean true or false if insufficient fund or negative amount
     */
    public boolean withdraw(double amount) {
        if (amount < 0) {
            System.out.println("You can't withdraw negative amount!");
            return false;
        }
        else if (amount > getBalance()) {
            System.out.println("Funds insufficient to withdraw!");
            System.out.println("Your balance is: " + getBalance());
            return false;
        }
        else {
            setBalance(getBalance() - amount);
            System.out.println("Balance " + amount
                    + " L.E has been withdrawn from your eWallet.");
        }
        return true;
    }

    /**
     * Returns a representation of an eWallet.
     * @return eWallet info
     */
    @Override
    public String toString() {
        return "EWallet owner: " + getOwnerId() +
                "EWallet balance: " + getBalance();
    }
}
