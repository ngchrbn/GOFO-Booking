package GOFO.UI;

import GOFO.User.PlaygroundOwner;

import java.util.Scanner;

public class PlaygroundOwnerUI {
    private final PlaygroundOwner playgroundOwner;
    private final String playgroundOwnerID;
    public PlaygroundOwnerUI(String id, PlaygroundOwner playgroundOwner) {
        this.playgroundOwner = playgroundOwner;
        playgroundOwnerID = id;
        System.out.println("Welcome " + playgroundOwner);
        mainMenu();
    }

    /**
     * Let a playgroundOwner add a playground, view his/her playgrounds,
     * and view the bookings
     */
    private void mainMenu() {
        System.out.println("\n1. Manage playgrounds.\n" +
                "2. view the bookings.\n" +
                "3. Log Out.");

        int choice = getChoice(2);

        switch (choice) {
            case 1 -> managePlaygrounds();
            case 2 -> viewBookings();
            case 3 -> new UI();
        }
    }

    /**
     * View all the bookings of his/her playgrounds.
     */
    private void viewBookings() {
    }

    /**
     * Let a playground owner add a playground, remove it, update it
     * or view his/her playgrounds
     */
    private void managePlaygrounds() {
        System.out.println("\n1. Add a playground\n" +
                "2. Update a playground.\n" +
                "3. Remove a playground.\n" +
                "4. View my playgrounds.\n" +
                "5. Go to Main Menu.");

        int choice = getChoice(5);

        switch (choice) {
            case 1 -> addPlayground();
            case 2 -> updatePlayground();
            case 3 -> removePlayground();
            case 4 -> viewPlaygrounds();
            case 5 -> mainMenu();
        }
    }

    /**
     * View my playgrounds.
     */
    private void viewPlaygrounds() {

    }

    /**
     * Remove a playground.
     */
    private void removePlayground() {

    }

    /**
     * Update a playground.
     */
    private void updatePlayground() {

    }

    /**
     * Add a playground.
     */
    private void addPlayground() {

    }

    /**
     * Get the choice for the menu
     * @param max number of options
     * @return choice
     */
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
