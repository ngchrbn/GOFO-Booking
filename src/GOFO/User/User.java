package GOFO.User;

import GOFO.Utilities.Address;
import GOFO.Utilities.Ewallet;

public class User {
    private String fName;
    private String lName;
    private String id;
    private String email;
    private String password;
    private String phoneNumber;
    private Address address;
    private Ewallet ewallet;
    public User(){}

    public User(String fName, String lName, String id, String email,
                String password, String phoneNumber, Address address,
                Ewallet ewallet) {
        setFName(fName);
        setlName(lName);
        setId(id);
        setEmail(email);
        setPassword(password);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Set user ewallet
     * @param ewallet user ewallet
     */
    public void setEwallet(Ewallet ewallet) {
        this.ewallet = ewallet;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns user ewallet
     * @return user ewallet
     */
    public Ewallet getEwallet() {
        return ewallet;
    }

    @Override
    public String toString() {
        return getFName() + " " + getLName();
    }
}
