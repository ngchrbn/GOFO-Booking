package GOFO.UI;

import GOFO.User.User;

import java.util.Scanner;

public class EwalletUI {
    EwalletUI(User user) {
        System.out.println("Welcome " + user);
        mainMenu();
    }

    /**
     * Let a user choose an option from the menu.
     */
    private void mainMenu() {
        System.out.println("1. View Balance.\n" +
                "2. Deposit.\n" +
                "3. Withdraw.\n" +
                "4. Transfer.\n");

        int choice = getChoice(4);

        switch (choice) {
            case 1 -> viewBalance();
            case 2 -> deposit();
            case 3 -> withdraw();
            case 4 -> transfer();
        }
    }

    /**
     * Transfer an amount to another user.
     */
    private void transfer() {

    }

    /**
     * Withdraw from the account.
     */
    private void withdraw() {

    }

    /**
     * Deposit to the account.
     */
    private void deposit() {

    }

    /**
     * View Balance
     */
    private void viewBalance() {

    }

    private int getChoice(int max) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nChoice (1 - " + max + "): ");
        int choice = input.nextInt();
        while (choice < 1 || choice > max) {
            System.out.println("Invalid input");
            System.out.print("\nChoice (1 - " + max + "): ");
            choice = input.nextInt();
        }

        return choice;
    }
}
