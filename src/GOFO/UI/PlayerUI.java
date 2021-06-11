package GOFO.UI;

import GOFO.System.GoFo;
import GOFO.User.Player;
import GOFO.Utilities.Playground;
import GOFO.Utilities.Team;
import GOFO.Utilities.TimeSlot;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * PlayerUI: Let a player interact with the system.
 * @author Ntajugumba Guy Cherubin
 * @version 1.0
 */
public class PlayerUI {
    private final Player player;
    private final String playerId;

    /**
     * Constructs a PlayerUI object.
     * @param id id of the player
     * @param player player object
     */
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
     * Let a player create a team, update a team or remove a team.
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
     * Send an invitation to a team
     */
    private void sendInvitation(String bookingID) {
        Scanner input = new Scanner(System.in);
        if (player.getTeam().isEmpty()) {
            System.out.println("You don't have a team yet.\n" +
                    "Would do you like to create it?");
            System.out.print("choice (Y/N): ");
            String choice = input.nextLine();
            while (choice.equalsIgnoreCase("Y") &&
            choice.equalsIgnoreCase("N")) {
                System.out.println("Invalid input. Try again.");
                System.out.print("choice (Y/N): ");
                choice = input.nextLine();
            }

            if (choice.equalsIgnoreCase("Y")) {
                createTeam();
            }
            else {
                mainMenu();
            }
        }
        else {
            System.out.print("Team name: ");
            String teamName = input.nextLine();
            if (player.hasTeam(teamName)) {
                GoFo.addInvitation(bookingID, player.getTeamInfo(teamName));
                System.out.println("Invitation sent successfully.");
            }
            else {
                System.out.println("Team " + teamName + "was not found!");
            }
        }
        mainMenu();
    }

    /**
     * Remove a team.
     */
    private void removeTeam() {
    }

    /**
     * Update a team
     */
    private void updateTeam() {
    }

    /**
     * Create a team.
     */
    private void createTeam() {
        int numberOfMembers = 0;

        ArrayList<Player> members = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        int nMembers;
        System.out.println("To create a team you will need to know the member's email\n" +
                "And they must be registered on the system.");

        System.out.print("\nTeam name: ");
        String teamName = input.nextLine();
        System.out.print("Number of members: ");
        nMembers = input.nextInt();

        input = new Scanner(System.in);

        for (int i=0; i<nMembers; ++i) {
            System.out.print("Team member email: ");
            String memberEmail = input.nextLine();
            if (GoFo.existEmail(memberEmail) && GoFo.profileType(memberEmail).equals("Player")) {
                Player tPlayer = GoFo.getUser(memberEmail);
                members.add(tPlayer);
                numberOfMembers++;
                System.out.println("==> " + memberEmail + "has been added.");
            }
            else {
                System.out.println("\nPlayer with that email is not found!");
            }
        }
        Team team = new Team(teamName, playerId, members);
        player.addTeam(team);
        System.out.println(numberOfMembers + " members has been added to " + teamName);
        mainMenu();
    }

    /**
     * Returns the choice of the player from menu choices
     * @return menu option
     * @param max max choice
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
        ArrayList<TimeSlot> bookings;
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
     * Book a playground.
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
                    System.out.println("\nNo playground found in " + city + "\n");
                    bookPlayground();
                }
            }
            case 2 -> playgrounds = GoFo.getAvailablePlaygrounds();
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
                System.out.println("\nEnter your chosen playground: ");
                System.out.print("Playground ID: ");
                String playgroundId = input.nextLine();

                while (GoFo.getPlaygroundInfo(playgroundId) == null) {
                    System.out.println("Playground with ID: " + playgroundId +
                            " is not found!");
                    System.out.println("Choose from the filtered results.");
                    System.out.print("Playground ID: ");
                    playgroundId = input.nextLine();
                }

                System.out.println("Fill in these required information");
                System.out.print("Day of booking: ");
                int day = input.nextInt();
                System.out.print("Month of Booking: ");
                int month = input.nextInt();
                System.out.print("Year of Booking: ");
                int year = input.nextInt();

                TimeSlot timeSlot = new TimeSlot(day, month, year,
                        startHour, endHour, playerId, playgroundId);

                if (GoFo.isBooked(timeSlot)) {
                    System.out.println("\nThe playground is booked for the timeslot given!");

                }
                else {
                    double price = calculatePrice(playgroundId, startHour, endHour);
                    System.out.println("Price is: " + price);

                    if(player.getEwallet().withdraw(price)) {
                        String bookingID = GoFo.addBooking(price, timeSlot);
                        System.out.println("Would you like to send an invitation?");
                        System.out.print("Choice(Y/N): ");
                        input = new Scanner(System.in);
                        String sendInvitation = input.nextLine();
                        while (!sendInvitation.equalsIgnoreCase("Y") &&
                                !sendInvitation.equalsIgnoreCase("N")) {
                            System.out.println("Invalid input. Try again.");
                            System.out.print("Choice(Y/N): ");
                            sendInvitation = input.nextLine();
                        }

                        if (sendInvitation.equalsIgnoreCase("Y")) {
                            sendInvitation(bookingID);
                        }
                    }
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
