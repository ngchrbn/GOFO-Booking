package GOFO.User;

import GOFO.Utilities.Address;
import GOFO.Utilities.Ewallet;

/**
 * User: Represents a user and his/her properties and methods.
 * @author  Kangana Alain
 * @version 1.0
 */
public class User {
    private String fName;
    private String lName;
    private String id;
    private String email;
    private String password;
    private String phoneNumber;
    private Address address;
    private Ewallet ewallet;

    /**
     * Constructs a User object.
     */
    public User(){}

    /**
     * Constructs a user object just for the admin.
     * @param password identification for the admin
     */
    public User(String password) {
        setFName("");
        setlName("");
        setId("admin");
        setEmail("admin@gmail.com");
        setPassword(password);
        setPhoneNumber("");
        setAddress(null);
        setEwallet(null);
    }

    /**
     * Constructs a User object.
     * @param fName first name
     * @param lName last name
     * @param id user id
     * @param email email
     * @param password password
     * @param phoneNumber phone number
     * @param address Address object
     * @param ewallet EWallet object
     */
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
        setEwallet(ewallet);
    }

    /**
     * Set a user first name.
     * @param fName first name
     */
    public void setFName(String fName) {
        this.fName = fName;
    }

    /**
     * Set a user last name.
     * @param lName last name
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Set a user id.
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set a user email.
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set a user password.
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set a user phone number.
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Set a user address
     * @param address Address object
     */
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

    /**
     * Returns first name.
     * @return first name
     */
    public String getFName() {
        return fName;
    }

    /**
     * Returns last name.
     * @return last name
     */
    public String getLName() {
        return lName;
    }

    /**
     * Returns email.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns user id.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns password.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns phone number.
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns Address object.
     * @return Address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Returns user ewallet.
     * @return user ewallet
     */
    public Ewallet getEwallet() {
        return ewallet;
    }

    /**
     * Returns a well formatted representation of a User object
     * @return String describing a user
     */
    @Override
    public String toString() {
        return getFName() + " " + getLName();
    }
}
