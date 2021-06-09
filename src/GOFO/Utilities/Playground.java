package GOFO.Utilities;


import GOFO.User.PlaygroundOwner;

public class Playground {
    private String playgroundName;
    private PlaygroundOwner playgroundOwner;
    private String playgroundID;
    private double pricePerHour;
    private Address playgroundAddress;
    private String size;
    private String availableHours;
    private int cancellationPeriod;
    private boolean activated;

    public Playground(String playgroundName, PlaygroundOwner playgroundOwner,
                      String playgroundID, double pricePerHour, Address playgroundAddress,
                      String size, String availableHours, int cancellationPeriod) {
        setPlaygroundName(playgroundName);
        setPlaygroundOwner(playgroundOwner);
        setPlaygroundID(playgroundID);
        setPricePerHour(pricePerHour);
        setPlaygroundAddress(playgroundAddress);
        setSize(size);
        setAvailableHours(availableHours);
        setCancellationPeriod(cancellationPeriod);
        setActivated(false);
    }

    /**
     * Set the playground name
     * @param playgroundName playground name
     */
    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    /**
     * Set the playground owner
     * @param playgroundOwner playground owner
     */
    public void setPlaygroundOwner(PlaygroundOwner playgroundOwner) {
        this.playgroundOwner = playgroundOwner;
    }

    /**
     * Set the playground id
     * @param playgroundID playground id
     */
    public void setPlaygroundID(String playgroundID) {
        this.playgroundID = playgroundID;
    }

    /**
     * Set the price per hour
     * @param pricePerHour price per hour
     */
    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    /**
     * Set playground address
     * @param playgroundAddress playground address
     */
    public void setPlaygroundAddress(Address playgroundAddress) {
        this.playgroundAddress = playgroundAddress;
    }

    /**
     * Set available hours
     * @param availableHours available hours
     */
    public void setAvailableHours(String availableHours) {
        this.availableHours = availableHours;
    }

    /**
     * Set playground size
     * @param size playground size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Set the cancellation period
     * @param cancellationPeriod cancellation period
     */
    public void setCancellationPeriod(int cancellationPeriod) {
        this.cancellationPeriod = cancellationPeriod;
    }

    /**
     * Set playground state
     * @param activated playground state
     */
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    /**
     * Returns playground name
     * @return playground name
     */
    public String getPlaygroundName() {
        return playgroundName;
    }

    /**
     * Returns playground owner
     * @return playground owner
     */
    public PlaygroundOwner getPlaygroundOwner() {
        return playgroundOwner;
    }

    /**
     * Returns playground address
     * @return playground address
     */
    public Address getPlaygroundAddress() {
        return playgroundAddress;
    }

    /**
     * Returns the price per hour
     * @return price per hour
     */
    public double getPricePerHour() {
        return pricePerHour;
    }

    /**
     * Returns the cancellation period
     * @return cancellation period
     */
    public int getCancellationPeriod() {
        return cancellationPeriod;
    }

    /**
     * Returns the available hours
     * @return available hours
     */
    public String getAvailableHours() {
        return availableHours;
    }

    /**
     * Returns the playground id
     * @return playground id
     */
    public String getPlaygroundID() {
        return playgroundID;
    }

    /**
     * Returns playground size
     * @return playground size
     */
    public String getSize() {
        return size;
    }

    /**
     * Returns the state of the playground
     * @return state of the playground
     */
    public boolean isActivated() {
        return activated;
    }

    /**
     * Returns a representation of a playground
     * @return playground info
     */
    @Override
    public String toString() {
        return "Playground info: \n" +
                "-> Name: " + getPlaygroundName() +
                "\n-> Owner: " + getPlaygroundOwner() +
                "\n-> Id: " + getPlaygroundID() +
                "\n-> Price per hour: " + getPricePerHour() +
                "\n-> Location: " + getPlaygroundAddress() +
                "\n-> Size: " + getSize() +
                "\n-> Available Hours: " +  getAvailableHours() +
                "\n-> Cancellation Period: " +getCancellationPeriod() +
                "\n-> State: " + (isActivated() ? "Activated" : "Deactivated");
    }
}
