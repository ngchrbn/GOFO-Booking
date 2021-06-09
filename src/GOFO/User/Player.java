package GOFO.User;

import GOFO.Utilities.Address;
import GOFO.Utilities.Ewallet;

public class Player extends User{

    public Player(String fName, String lName, String id, String email,
                  String password, String phoneNumber, Address address, Ewallet ewallet) {
        super(fName, lName, id, email, password, phoneNumber, address, ewallet);
    }


}
