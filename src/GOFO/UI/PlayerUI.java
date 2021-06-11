package GOFO.UI;

import GOFO.System.GoFo;
import GOFO.User.Player;
import GOFO.Utilities.Playground;
import GOFO.Utilities.TimeSlot;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerUI {
    private static int myBookings = 0;
    private final Player player;
    private final String playerId;
    public PlayerUI(String id, Player player) {
        this.player = player;
        playerId = id;
        System.out.println("\nWelcome " + player);
        mainMenu();
    }

    /**
     * Intended for the player to choose an option.
     */
    private void mainMenu() {

        System.out.println("\n1. View a playground info.\n" +
                "2. Manage Bookings.\n" +
                "3. Manage Teams.\n" +
                "4. Manage Complaints.\n" +
                "5. Log Out.");
        int choice = getChoice(5);

        switch (choice) {
            case 1 -> viewPlaygroundInfo();
            case 2 -> manageBookings();
            case 3 -> manageTeams();
            case 4 -> manageComplaints();
            case 5 -> new UI();
        }
    }

    /**
     * Show a playground info given its id.
     */
    private void viewPlaygroundInfo() {
        Scanner input = new Scanner(System.in);
        Playground playground;
        String playgroundID;
        System.out.println("\nTo view a playground info, enter its ID.");
        System.out.print("Playground ID: ");
        playgroundID = input.nextLine();

        playground = GoFo.getPlaygroundInfo(playgroundID);

        if (playground == null) {
            System.out.println("\n==>No playground found with ID: " + playgroundID);
            System.out.print("Would you like to try again?(Y/N): ");
            String tryAgain = input.nextLine();
            while (!tryAgain.equalsIgnoreCase("Y") && !tryAgain.equalsIgnoreCase("N")) {
                System.out.println("Invalid input!");
                System.out.print("Enter Y or N: ");
                tryAgain = input.nextLine();
            }
            if (tryAgain.equalsIgnoreCase("N")) {
                mainMenu();
            }
            else {
                viewPlaygroundInfo();
            }
        }
        else {
            System.out.println("\n" + playground);
            mainMenu();
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

        int choice = getChoice(4);

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

        int choice = getChoice(4);

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
    private int getChoice(int max) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nChoice (1 - " + max + " ): ");
        int choice = input.nextInt();
        while (choice < 1 || choice > max) {
            System.out.println("Invalid input");
            System.out.print("\nChoice (1 - " + max + " ): ");
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

        int choice = getChoice(4);

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
        ArrayList<TimeSlot> bookings = new ArrayList<>();
        bookings = GoFo.getBookingInfo(playerId);
        if (!bookings.isEmpty()) {
            for (TimeSlot timeSlot: bookings) {
                System.out.println("\n" + timeSlot);
                System.out.println("\n->Cost: " + calculatePrice(timeSlot.getPlaygroundID(), timeSlot.getStartHour(),
                        timeSlot.getEndHour()));
            }

        }
        else
            System.out.println("No booking with your ID found in our system.");
        manageBookings();
    }

    /**
     * Book a playground
     */
    private void bookPlayground() {
        ArrayList<Playground> playgrounds = new ArrayList<>();
        System.out.println("1. Show playgrounds by address.\n" +
                "2. Show all playgrounds.");
        int choice = getChoice(2);

        switch (choice) {
            case 1 -> {
                Scanner input = new Scanner(System.in);
                System.out.print("City: ");
                String city = input.nextLine();
                playgrounds = GoFo.filterByCity(city);
                if (playgrounds.isEmpty()) {
                    System.out.println("No playground found in " + city);
                    bookPlayground();
                }
            }
            case 2 -> playgrounds = GoFo.getPlaygrounds("");
        }


        if (!playgrounds.isEmpty()) {
            System.out.println("These are the playgrounds I found");
            int i=0;
            for (Playground playground: playgrounds) {
                System.out.println("\n Playground " + (i+1));
                System.out.println(playground);
                i++;
            }

            int startHour, endHour;

            Scanner input = new Scanner(System.in);
            System.out.println("\n\nEnter time slots: ");
            System.out.print("\nStart Hour: ");
            startHour = input.nextInt();
            System.out.print("End hour: ");
            endHour = input.nextInt();
            playgrounds = filterByTimeSlot(playgrounds, startHour, endHour);


            if (!playgrounds.isEmpty()) {
                System.out.println("After applying time slots, here the remaining playgrounds\n");
                i=0;
                for (Playground playground: playgrounds) {
                    System.out.println("\n Playground " + (i+1));
                    System.out.println(playground);
                    i++;
                }

                input = new Scanner(System.in);
                System.out.println("Enter your chosen playground: ");
                System.out.print("Playground ID: ");
                String playgroundId = input.nextLine();

                System.out.println("Fill in these required information");
                System.out.print("Day of booking: ");
                int day = input.nextInt();
                System.out.print("Month of Booking: ");
                int month = input.nextInt();
                System.out.print("Year of Booking: ");
                int year = input.nextInt();

                TimeSlot timeSlot = new TimeSlot(day, month, year,
                        startHour, endHour, playerId, playgroundId);

                double price = calculatePrice(playgroundId, startHour, endHour);
                System.out.println("Price is: " + price);

                if(player.getEwallet().withdraw(price)) {
                    GoFo.addBooking(playerId+myBookings, price, timeSlot);
                    myBookings++;
                }
            }
            else {
                System.out.println("No playground was found within those time slots.");
            }
        }
        else {
            System.out.println("No playground was found!");
        }


        manageBookings();
    }

    /**
     * Calculate and returns the price for the booking
     * @param playgroundId playground id
     * @param startHour start hour
     * @param endHour end hour
     * @return price (endHour-startHour) * pricePerHour of the playground.
     */
    private double calculatePrice(String playgroundId, int startHour, int endHour) {
        double pricePerHour = GoFo.getPlaygroundPricePerHour(playgroundId);
        return (endHour - startHour) * pricePerHour;
    }

    /**
     * Filter playgrounds by time slots
     * @param playgrounds playgrounds in which to apply filter
     * @param startHour start hour
     * @param endHour end hour
     * @return ArrayList of Playgrounds if found otherwise empty ArrayList of Playgrounds
     */
    private ArrayList<Playground> filterByTimeSlot(ArrayList<Playground> playgrounds, int startHour, int endHour) {
        ArrayList<Playground> filteredPlaygrounds = new ArrayList<>();
        for (Playground playground: playgrounds) {
            String[] availability = playground.getAvailableHours().split("-");
            if ((Integer.parseInt(availability[0]) <= startHour) && (Integer.parseInt(availability[1]) >= endHour)) {
                filteredPlaygrounds.add(playground);
            }
        }
        return filteredPlaygrounds;
    }


}
