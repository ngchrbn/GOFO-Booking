package GOFO.User;

import GOFO.Utilities.Address;

public class User {
    private String fName;
    private String lName;
    private String id;
    private String email;
    private String password;
    private String phoneNumber;
    private Address address;
    public User(){}

    public User(String fName, String lName, String id, String email, String password, String phoneNumber, Address address) {
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

    @Override
    public String toString() {
        return getFName() + " " + getLName();
    }
}
