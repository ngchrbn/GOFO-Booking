package GOFO.UI;

import GOFO.System.GoFo;
import GOFO.User.PlaygroundOwner;
import GOFO.Utilities.Address;
import GOFO.Utilities.Playground;

import java.util.ArrayList;
import java.util.Scanner;

public class PlaygroundOwnerUI {
    private static int myPlaygrounds = 0;
    private final PlaygroundOwner playgroundOwner;
    private final String playgroundOwnerID;
    public PlaygroundOwnerUI(String id, PlaygroundOwner playgroundOwner) {
        this.playgroundOwner = playgroundOwner;
        playgroundOwnerID = id;
        System.out.println("\nWelcome " + playgroundOwner);
        mainMenu();
    }

    /**
     * Let a playgroundOwner add a playground, view his/her playgrounds,
     * and view the bookings
     */
    private void mainMenu() {
        System.out.println("\n\n1. Manage playgrounds.\n" +
                "2. view the bookings.\n" +
                "3. Log Out.");

        int choice = getChoice(3);

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
        System.out.println("\n\n1. Add a playground\n" +
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
        ArrayList<Playground> playgrounds = new ArrayList<>();
        System.out.print("1. A specific playground.\n" +
                "2. All playgrounds.");
        int choice = getChoice(2);
        switch (choice) {
            case 1 -> {
                Scanner input = new Scanner(System.in);
                System.out.print("Playground ID: ");
                String playgroundID = input.nextLine();
                playgrounds = GoFo.getPlaygrounds("", playgroundID);
            }
            case 2 -> {
                playgrounds = GoFo.getPlaygrounds(playgroundOwnerID, "");
            }
        }

        if (!playgrounds.isEmpty()) {
            for (Playground playground: playgrounds) {
                System.out.print("\n\n" + playground);
            }
        }
        else {
            System.out.print("\nYou don't have any playground yet or" +
                    " you provided a wrong ID!");
        }
        managePlaygrounds();
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
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the below required information: ");
        System.out.print("Playground Name: ");
        String playgroundName = input.nextLine();

        input = new Scanner(System.in);
        System.out.print("Price Per hour: ");
        double pricePerHour = input.nextDouble();

        System.out.println("Enter the address information: ");
        System.out.print("Street Number: ");
        int streetNumber = input.nextInt();

        input = new Scanner(System.in);

        System.out.print("Street Name: ");
        String streetName = input.nextLine();
        System.out.print("City: ");
        String city = input.nextLine();
        Address address = new Address(streetNumber, streetName, city);

        System.out.print("Enter size (separated by a -): ");
        String size = input.nextLine();

        System.out.print("Available Hours(separated by a -): ");
        String availableHours = input.nextLine();

        System.out.print("Cancellation period( in hours): ");
        int cancellationPeriod = input.nextInt();
        String playgroundID = playgroundOwnerID + myPlaygrounds;
        Playground playground = new Playground(playgroundName, playgroundOwner,
                playgroundID, pricePerHour, address, size,
                availableHours, cancellationPeriod);
        GoFo.addPlayground(playgroundID, playground);
        System.out.println("The playground has been added!");
        System.out.println("Wait until it is approved.");
        myPlaygrounds++;
        managePlaygrounds();
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
