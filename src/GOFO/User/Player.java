package GOFO.User;

import GOFO.Utilities.Address;
import GOFO.Utilities.Ewallet;

/**
 * Player: Represents a Player and his/her properties and methods.
 * @author  Kangana Alain
 * @version 1.0
 */
public class Player extends User{

    /**
     * Construct a Player object.
     * @param fName first name
     * @param lName last name
     * @param id user id
     * @param email email
     * @param password password
     * @param phoneNumber phone number
     * @param address Address object
     * @param ewallet EWallet object
     */
    public Player(String fName, String lName, String id, String email,
                  String password, String phoneNumber, Address address, Ewallet ewallet) {
        super(fName, lName, id, email, password, phoneNumber, address, ewallet);
    }


}
