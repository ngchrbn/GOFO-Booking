package GOFO.User;


/**
 * Administrator: Represents a administrator and his/her properties and methods.
 * @author  Kangana Alain
 * @version 1.0
 */
public class Administrator {
    private String id;
    private String password;

    /**
     * Construct a Administrator object.
     * @param id administrator id
     * @param password password
     */
    Administrator(String id, String password) {

    }

    /**
     * Set admin id
     * @param id admin id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set admin password
     * @param password admin password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns admin id
     * @return admin id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns admin password
     * @return admin password
     */
    public String getPassword() {
        return password;
    }

}
