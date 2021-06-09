package GOFO.Utilities;

import GOFO.User.User;

public class Ewallet {
    private double balance;
    private String ownerId;

    Ewallet(double balance, String ownerId) {

    }

    /**
     * Set an initial balance to the account
     * @param balance initial balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Set the owner of the eWallet
     * @param ownerId owner id
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Returns the balance in the eWallet
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns owner id of the eWallet
     * @return owner id
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Returns a representation of an eWallet
     * @return eWallet info
     */
    @Override
    public String toString() {
        return "EWallet owner: " + getOwnerId() +
                "EWallet balance: " + getBalance();
    }

    /**
     * Deposit an amount to the eWallet
     * @param amount amount to deposit
     */
    private void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    /**
     *  Withdraw an amount from the eWallet,
     *  after checking that it is not negative and not greater than
     *  actual balance.
     * @param amount amount to withdraw
     */
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("You can't withdraw negative amount!");
        }
        else if (amount > getBalance()) {
            System.out.println("Funds insufficient to withdraw!");
        }
        else {
            setBalance(getBalance() - amount);
            System.out.println("Balance " + amount
                    + " L.E has been withdrawn from your eWallet.");
        }
    }
}
