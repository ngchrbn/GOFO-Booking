package GOFO.UI;

import GOFO.System.GoFo;
import GOFO.User.Player;

import java.util.Scanner;

public class PlayerUI {
    private final Player player;
    private final String playerId;
    public PlayerUI(String id, Player player) {
        this.player = player;
        playerId = id;
        System.out.println("\nWelcome " + player);
        mainMenu();
    }

    private void mainMenu() {

        System.out.println("\n1. Manage Bookings.\n" +
                "2. Manage Teams.\n" +
                "3. Manage Complaints.\n" +
                "4. Log Out.");
        int choice = getChoice();

        switch (choice) {
            case 1 -> manageBookings();
            case 2 -> manageTeams();
            case 3 -> manageComplaints();
            case 4 -> new UI();
        }
    }

    /**
     * Let a player create a complaint against a playground,
     * view the status of a complaint, or  cancel a complaint.
     */
    private void manageComplaints() {
        System.out.println("\n1. Create a complaint.\n" +
                "2. View a complaint status\n" +
                "3. Cancel a complaint\n" +
                "4. Go to Main Menu");

        int choice = getChoice();

        switch (choice) {
            case 1 -> createComplaint();
            case 2 -> viewComplaintStatus();
            case 3 -> cancelComplaint();
            case 4 -> mainMenu();
        }
    }

    /**
     * Cancel a complaint.
     */
    private void cancelComplaint() {

    }

    /**
     * View the status of a complaint.
     */
    private void viewComplaintStatus() {

    }

    /**
     * Create a complaint.
     */
    private void createComplaint() {

    }

    /**
     * Let a player create a team, update a team or remove a team
     */
    private void manageTeams() {
        System.out.println("\n1. Create a team.\n" +
                "2. Update a team\n" +
                "3. Remove a team.\n" +
                "4. Go to Main Menu.");

        int choice = getChoice();

        switch (choice) {
            case 1 -> createTeam();
            case 2 -> updateTeam();
            case 3 -> removeTeam();
            case 4 -> mainMenu();
        }
    }

    /**
     * Remove a team
     */
    private void removeTeam() {
    }

    /**
     * Update a team
     */
    private void updateTeam() {
    }

    /**
     * Create a team
     */
    private void createTeam() {
    }

    /**
     * Returns the choice of the player from menu choices
     * @return menu option
     */
    private int getChoice() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nChoice (1 - 4): ");
        int choice = input.nextInt();
        while (choice < 1 || choice > 4) {
            System.out.println("Invalid input");
            System.out.print("\nChoice (1 - 4): ");
            choice = input.nextInt();
        }

        return choice;
    }

    /**
     * Let a player book a playground,
     * view his/her bookings, or cancel a booking.
     */
    private void manageBookings() {
        System.out.println("\n1. Book a playground.\n" +
                "2. View my bookings\n" +
                "3. Cancel a booking\n" +
                "4. Main Menu.");

        int choice = getChoice();

        switch (choice) {
            case 1 -> bookPlayground();
            case 2 -> viewBookings();
            case 3 -> cancelBooking();
            case 4 -> mainMenu();
        }
    }

    /**
     * Cancel a booking if within the cancellation period
     */
    private void cancelBooking() {

    }

    /**
     * Return the bookings of the player
     */
    private void viewBookings() {

    }

    /**
     * Book a playground
     */
    private void bookPlayground() {

    }
}
