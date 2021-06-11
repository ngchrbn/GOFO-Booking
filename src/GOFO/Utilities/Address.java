package GOFO.Utilities;

/**
 * Address: Represent an address with its attributes and methods.
 * @author Mahamat Ibrahim Mahamat
 * @version 1.0
 */
public class Address {
    private int streetNumber;
    private String streetName;
    private String city;

    /**
     * Constructs an Address object which has:
     * <p>A street number, A street name, A city name
     * @param streetNumber street number
     * @param streetName street name
     * @param city city name
     */
    public Address(int streetNumber, String streetName, String city) {
        setStreetNumber(streetNumber);
        setStreetName(streetName);
        setCity(city);
    }

    /**
     * Set street number
     * @param streetNumber street number
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * Set street name.
     * @param streetName street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Set city.
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns street number.
     * @return street number
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * Returns street name
     * @return street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Returns city.
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns a well formatted representation of an address object.
     * @return Address representation
     */
    @Override
    public String toString() {
        return getStreetNumber()
                + " " + getStreetName() + " " + getCity();
    }
}
