package GOFO.UI;

import GOFO.System.GoFo;
import GOFO.User.Player;
import GOFO.User.PlaygroundOwner;
import GOFO.Utilities.Address;
import GOFO.Utilities.Ewallet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UI: Let a User interact with the system.
 * @author Ntajugumba Guy Cherubin
 *  @version 1.0
 */
public class UI {

    /**
     * Constructs a new UI object and calls a main menu.
     */
    public UI() {
        mainMenu();
    }

    /**
     * Show a User options to choose from.
     */
    private void mainMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("1. SignUp.\n" +
                "2. LogIn.\n" +
                "3. LogIn as Administrator.\n" +
                "4. Exit.");

        System.out.print("\nChoice (1 - 4): ");

        int choice = input.nextInt();

        while (choice < 1 || choice > 4) {
            System.out.println("\n==>Invalid input!");
            System.out.println("==>Choose between the presented options.");
            System.out.print("\nChoice (1 - 4): ");
            choice = input.nextInt();
        }

        switch (choice) {
            case 1 -> signUp();
            case 2 -> logIn();
            case 3 -> logAdmin();
            case 4 -> System.exit(0);
        }
    }

    /**
     * Log an administrator in
     * after checking if the password is correct.
     * <p>For an administrator, the id is "admin"
     * So, no need to ask the id.
     */
    private void logAdmin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Password: ");
        String password = input.nextLine();

        while(!GoFo.validAdminPassword(password)) {
            System.out.println("Invalid password\n" +
                    "==> Try again");
            System.out.print("Password: ");
            password = input.nextLine();
        }
        new AdministratorUI();
    }

    /**
     * Get user id and password,
     * After checking if they are correct, get the profile type, and
     * Initialize a UI corresponding to the user
     */
    private void logIn() {
        Scanner input = new Scanner(System.in);

        int profileType = getProfileType();

        System.out.print("ID: ");
        String id = input.nextLine();
        while(!GoFo.existID(id)) {
            System.out.println("The ID you entered is not found!\n" +
                    "==> Try again.");
            System.out.print("ID: ");
            id = input.nextLine();
        }
        System.out.print("Password: ");
        String password = input.nextLine();
        while(!GoFo.validPassword(id, password)) {
            System.out.println("The password you entered is not found!\n" +
                    "==> Try again.");
            System.out.print("Password: ");
            password = input.nextLine();
        }

        switch (profileType) {
            case 1 -> {
                Player player = (Player) GoFo.getUserInfo(id);
                new PlayerUI(id, player);
            }
            case 2 -> {
                PlaygroundOwner playgroundOwner = (PlaygroundOwner) GoFo.getUserInfo(id);
                new PlaygroundOwnerUI(id, playgroundOwner);
            }
        }
    }

    /**
     * Register a new user in the database.
     */
    private void signUp() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the below required information.");

        // Get first name and last name
        System.out.print("First Name: ");
        String fName = input.nextLine();
        System.out.print("Last Name: ");
        String lName = input.nextLine();

        // Get id and checks if it is valid
        System.out.print("Your Identification (14 Characters): ");
        String id = input.nextLine();
        while (!validateID(id)) {
            System.out.println("Wrong format.Your ID must be 14 long!");
            System.out.print("Your Identification (14 Characters): ");
            id = input.nextLine();
        }

        // Get email and checks if it is valid and not available in the database
        System.out.print("Email: ");
        String email = input.nextLine();
        while (!validateEmail(email)) {
            System.out.println("Wrong format. Your email must be in this format: ");
            System.out.println("==> characters@domain.com");
            System.out.print("Email: ");
            email = input.nextLine();
        }
        if (GoFo.existEmail(email)) {
            System.out.println("Your email exists already!");
            System.out.println("Sign In instead.");
            logIn();
        }

        // Get password and checks if it is strong
        System.out.print("Password: ");
        String password = input.nextLine();
        while(!validatePassword(password)) {
            System.out.println("\nA password must be at least 8 characters long!");
            System.out.print("Password: ");
            password = input.nextLine();
        }

        // Get telephone number information
        System.out.print("Phone Number: +2");
        String phoneNumber = input.nextLine();
        while(phoneNumber.length() !=11) {
            System.out.println("A telephone number must be contains 11 numbers");
            System.out.print("Phone Number: +2");
            phoneNumber = input.nextLine();
        }

        // Get address information
        System.out.print("Street Number: ");
        int streetNumber = input.nextInt();

        input = new Scanner(System.in);
        System.out.print("Street Name: ");
        String streetName = input.nextLine();
        System.out.print("City: ");
        String city = input.nextLine();

        Address address = new Address(streetNumber, streetName, city);

        int profileType = getProfileType();

        input = new Scanner(System.in);
        System.out.print("\nEnter actual balance for your eWallet: ");
        double balance = input.nextDouble();


        switch (profileType) {
            case 1 -> {
                Ewallet ewallet = new Ewallet(balance, id);
                Player player = new Player(fName, lName, id, email,
                        password, phoneNumber, address, ewallet);
                GoFo.adduser(id, player);
                new PlayerUI(id, player);
            }
            case 2 -> {
                Ewallet ewallet = new Ewallet(balance, id);
                PlaygroundOwner playgroundOwner = new PlaygroundOwner(
                        fName, lName, id, email, password, phoneNumber, address, ewallet
                );
                GoFo.adduser(id, playgroundOwner);
                new PlaygroundOwnerUI(id, playgroundOwner);
            }
        }
    }

    /**
     * Get the profile type of the user.
     * <p>It can be a Player or a Playground owner profile.
     * @return profile type
     */
    private int getProfileType() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nChoose your profile\n" +
                "1. Player.\n" +
                "2. Playground owner.");
        System.out.print("\nChoice (1 - 2): ");
        int profileType = input.nextInt();
        while (profileType < 1 || profileType > 2) {
            System.out.println("Invalid input");
            System.out.print("\nChoice (1 - 2): ");
            profileType = input.nextInt();
        }

        return profileType;
    }

    /**
     * Checks if a given email has a match with the passwordRegex(password pattern)
     * @param password to be checked
     * @return true if found match otherwise returns false
     */
    private boolean validatePassword(String password) {
        return !(password.length() < 8);
    }


    /**
     * Validate an identification which must be 14 characters long
     * @param id: id to be validate
     * @return true if the length is 14 otherwise returns false
     */
    private boolean validateID(String id) {
        return id.length() == 14;
    }

    /**
     * Checks if a given email has a match with the emailRegex(email pattern)
     * @param email to be checked
     * @return true if found match otherwise returns false
     */
    private boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
