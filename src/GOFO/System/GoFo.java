package GOFO.System;

import GOFO.UI.UI;
import GOFO.User.Player;
import GOFO.User.PlaygroundOwner;
import GOFO.User.User;
import GOFO.Utilities.*;

import java.util.*;

/**
 * Gofo: Stores the Users, playgrounds, and the bookings details
 * <p>In charge with functions that deals with the database.
 * @author Ntajugumba Guy Cherubin 20160379
 * @version 1.0
 */
public class GoFo {

    // Store all users and their ids
    private static Map<String, User> users = new HashMap<>();

    // Store all users type
    private static Map<String, String> userTypes = new HashMap<>();

    // Store all playgrounds and theirs ids
    private static Map<String, Playground> playgrounds = new HashMap<>();

    private static Map<String, Double> bookingCosts = new HashMap<>();

    private static Map<String, TimeSlot> bookingDetails = new HashMap<>();

    private static Map<String, Team> invitations = new HashMap<>();

    /**
     * Constructs a Gofo object
     * <p>add an administrator user
     * <p>Initialize an UI object
     */
    public GoFo() {
        users.put("admin", new User("admin123"));
        PlaygroundOwner user = new PlaygroundOwner("Jimmy","Hendrix", "12563254452369",
                "jimmy@gmail.com", "Jimmy1234", "01228331194",
                new Address(25, "Gizah", "Cairo"),
                new Ewallet(2500, "12563254452369"));

        Player player = new Player("Guy","Cherubin", "12563254452379",
                "gchrbn@gmail.com", "gchrbn1234", "01205601236",
                new Address(25, "Gizah", "Maadi"),
                new Ewallet(2500, "12563254452379"));

        Player player1 = new Player("Alain","Kangana", "45652589654725",
                "kanganaalain@gmail.com", "kangana1234", "01112225552",
                new Address(13, "Dokki", "Gizah"),
                new Ewallet(1450, "45652589654725"));
        Player player2 = new Player("Ibrahim","Mahamat", "14523652478595",
                "djiddo23@gmail.com", "Mahamat1234", "01145632589",
                new Address(5, "Behoos", "El Nasr"),
                new Ewallet(4200, "14523652478595"));

        Player player3 = new Player("John","Mac", "47856589654125",
                "john@gmail.com", "John1234", "01228331194",
                new Address(24, "Gizah", "Cairo"),
                new Ewallet(1230, "47856589654125"));

        users.put("12563254452369", user);
        userTypes.put("12563254452369", "PlaygroundOwner");

        users.put("12563254452379", player);
        userTypes.put("12563254452379", "Player");

        users.put("45652589654725", player1);
        userTypes.put("45652589654725", "Player");

        users.put("14523652478595", player2);
        userTypes.put("14523652478595", "Player");

        users.put("47856589654125", player3);
        userTypes.put("47856589654125", "Player");

        playgrounds.put("12563254452369", new Playground("Gofo",user,
                "12563254452369", 25, new Address(25, "Dooi", "Cairo"),
                "25-35", "14-22", 1));
        playgrounds.put("125632544523690", new Playground("El Masr",user,
                "125632544523690", 25, new Address(1, "Lewa", "El Nasr"),
                "15-25", "8-22", 1));
        playgrounds.put("125632544523691", new Playground("Newel",user,
                "125632544523691", 25, new Address(12, "Fethi", "Gizah"),
                "25-40", "10-22", 1));

        playgrounds.put("125632544523692", new Playground("Gama",user,
                "125632544523692", 25, new Address(13, "Shubham", "Shubra"),
                "25-25", "9-18", 1));
        new UI();
    }


    /**
     * Checks if a given email exists in the User database
     * @param email to be checked
     * @return true if exists otherwise returns false
     */
    public static boolean existEmail(String email) {
        for (User user: users.values()) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add a new user object to the users database
     * @param id user id
     * @param user user to add
     * @param profileType user profile
     */
    public static void adduser(String id, User user, String profileType) {
        users.put(id, user);
        userTypes.put(id, profileType);
        System.out.println("Your account has been created successfully.");
    }

    /**
     * Checks if a given id exists in the users database
     * @param id to be checked
     * @return true if exists otherwise false
     */
    public static boolean existID(String id) {

        return users.containsKey(id);
    }

    /**
     * Returns a user info given his/her id
     * @param id user's identification
     * @return user object if id exists otherwise returns null
     */
    public static User getUserInfo(String id) {

        if (users.containsKey(id)) {
            return users.get(id);
        }

        return null;
    }


    /**
     * Validate a password
     * @param id user id
     * @param password to be checked
     * @return true if equals otherwise returns false
     */
    public static boolean validPassword(String id, String password) {
        if (users.containsKey(id)) {
            return users.get(id).getPassword().equals(password);
        }
        return false;
    }

    /**
     * Validate a password in the database
     * @param password to be validated
     * @return true if equals otherwise false
     */
    public static boolean validAdminPassword(String password) {

        return users.get("admin").getPassword().equals(password);
    }

    /**
     * Add a playground to the playground database
     * @param playgroundID playground id
     * @param playground playground to be added
     */
    public static void addPlayground(String playgroundID, Playground playground) {
        playgrounds.put(playgroundID, playground);
    }

    /**
     * Returns the playgrounds of an owner if given playgroundOwnerID
     * <p>Or returns all playgrounds if given empty string.
     * @param playgroundOwnerID playground owner id or empty String.
     * @return playgrounds if found otherwise empty ArrayList.
     */
    public static ArrayList<Playground> getPlaygrounds(String playgroundOwnerID, boolean activated) {
        ArrayList<Playground> ownerPlaygrounds = new ArrayList<>();
        if (playgroundOwnerID.equals("")) {
            for (Playground playground: playgrounds.values()) {
                if (!playground.isActivated() && !activated) {
                    ownerPlaygrounds.add(playground);
                }
                else if (playground.isActivated() &&  activated) {
                    ownerPlaygrounds.add(playground);
                }
            }
        }
        else {
            for (Playground playground: playgrounds.values()) {
                if (playground.getPlaygroundOwner().getId().equals(playgroundOwnerID)) {
                    ownerPlaygrounds.add(playground);
                }
            }
        }
        return ownerPlaygrounds;
    }

    /**
     * Activate a playground.
     * @param playgroundID playground id
     */
    public static void activatePlayground(String playgroundID) {
        playgrounds.get(playgroundID).setActivated(true);
    }

    /**
     * Filter the playgrounds by city name
     * @param city city name
     * @return playgrounds if found otherwise empty ArrayList of Playgrounds
     */
    public static ArrayList<Playground> filterByCity(String city) {
        ArrayList<Playground> filteredPlaygrounds = new ArrayList<>();
        for (Playground playground: playgrounds.values()) {
            if (playground.getPlaygroundAddress().getCity().equals(city) &&
                    playground.isActivated()) {
                filteredPlaygrounds.add(playground);
            }
        }
        return filteredPlaygrounds;
    }

    /**
     * Calculate the price for a booking
     * @param playgroundId playground id
     * @return price
     */
    public static double getPlaygroundPricePerHour(String playgroundId) {
        return playgrounds.get(playgroundId).getPricePerHour();
    }

    /**
     * Add a new booking to the database
     * @param price price of the booking
     * @param timeSlot timeSlot object
     */
    public static String addBooking(double price, TimeSlot timeSlot) {
        String bookingID = extractBookingID(timeSlot);
        timeSlot.setBooked(true);
        bookingCosts.put(bookingID, price);
        bookingDetails.put(bookingID, timeSlot);
        timeSlot.setBooked(true);
        System.out.println("Playground booked successfully");
        return bookingID;
    }

    /**
     * Build a bookingID in the format:
     * playgroundID+day+month+year+startHour+endHour.
     * @param timeSlot timeslot
     * @return booking id
     */
    private static String extractBookingID(TimeSlot timeSlot) {
        return timeSlot.getPlaygroundID() +
                timeSlot.getDay() + timeSlot.getMonth() +
                timeSlot.getYear() + timeSlot.getStartHour() +
                timeSlot.getEndHour();
    }


    /**
     * Get a booking info
     * @param playerId player id
     * @return ArrayList of timeslots
     */
    public static ArrayList<TimeSlot> getBookingInfo(String playerId) {
        ArrayList<TimeSlot> timeSlots = new ArrayList<>();
        for (TimeSlot timeSlot: bookingDetails.values()) {
            if (timeSlot.getBookedTo().equals(playerId))
                timeSlots.add(timeSlot);
        }
        return timeSlots;
    }

    /**
     * Returns playground info
     * @param playgroundID playground id
     * @return playground object or null if not found.
     */
    public static Playground getPlaygroundInfo(String playgroundID) {
        if (playgrounds.containsKey(playgroundID)) {
            if (!playgrounds.get(playgroundID).isActivated())
                return null;
            return playgrounds.get(playgroundID);
        }
        return null;
    }

    /**
     * Checks if for a given timeslot the playground is booked.
     * @param timeSlot timeslot
     * @return true if booked and false otherwise
     */
    public static boolean isBooked(TimeSlot timeSlot) {
        String bookingID = extractBookingID(timeSlot);
        return bookingDetails.containsKey(bookingID);
    }

    /**
     * Add a new invitation to the database linked with the booking id
     * @param bookingID booking id
     * @param teamInfo team object
     */
    public static void addInvitation(String bookingID, Team teamInfo) {
        invitations.put(bookingID, teamInfo);
    }

    /**
     * Returns User type if found, otherwise return empty String
     * @param memberEmail member email
     * @return User type as a String
     */
    public static String profileType(String memberEmail) {
        for (User user: users.values()) {
            if (user.getEmail().equals(memberEmail)) {
                return userTypes.get(user.getId());
            }
        }
        return "";
    }

    /**
     * Returns User information given the email
     * @param email email of the user
     * @return Player object
     */
    public static Player getUser(String email) {
        for (User user: users.values()) {
            if (user.getEmail().equals(email)) {
                return (Player) user;
            }
        }
        return null;
    }

    /**
     * Returns playgrounds that are activated and not booked
     * @return Arraylist or playgrounds
     */
    public static ArrayList<Playground> getAvailablePlaygrounds() {
        ArrayList<Playground> availPlaygrounds = new ArrayList<>();
        for (Playground playground: playgrounds.values()) {
            if (playground.isActivated()) {
                    availPlaygrounds.add(playground);
            }
        }
        return availPlaygrounds;
    }
}
