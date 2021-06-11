package GOFO.User;

import GOFO.Utilities.Address;
import GOFO.Utilities.Ewallet;

/**
 * PlaygroundOwner: Represents a user and his/her properties and methods.
 * @author  Kangana Alain
 * @version 1.0
 */
public class PlaygroundOwner extends User{
    /**
     * Constructs a PlaygroundOwner object
     * @param fName first name
     * @param lName last name
     * @param id user id
     * @param email email
     * @param password password
     * @param phoneNumber phone number
     * @param address Address object
     * @param ewallet EWallet object
     */
    public PlaygroundOwner(String fName, String lName, String id, String email,
                           String password, String phoneNumber, Address address, Ewallet ewallet) {
        super(fName, lName, id, email, password, phoneNumber, address, ewallet);
    }
}
