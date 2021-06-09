package GOFO.System;

import GOFO.UI.UI;
import GOFO.User.User;
import GOFO.Utilities.Playground;

import java.util.*;

public class GoFo {

    // Store all users and their ids
    private Map<String, User> users = new HashMap<>();

    // Store all playgrounds and theirs ids
    private Map<String, Playground> playgrounds = new HashMap<>();

    /**
     * Constructs a Gofo object
     * <p>add an administrator user
     * <p>Initialize an UI object
     */
    public GoFo() {
        users.put("admin", new User());
        new UI();
    }


    /**
     * Checks if a given email exists in the User database
     * @param email to be checked
     * @return true if exists otherwise returns false
     */
    public static boolean existEmail(String email) {
        return false;
    }

    public static void adduser(String id, User user) {
        System.out.println("Your account has been created successfully.");
    }

    public static boolean existID(String id) {
        return false;
    }

    public static User getUserInfo(String id) {
        return null;
    }

    public static boolean validPassword(String id, String password) {
        return false;
    }

    public static boolean validAdminPassword(String password) {
        return false;
    }
}
