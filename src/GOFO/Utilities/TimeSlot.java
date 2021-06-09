package GOFO.Utilities;

public class TimeSlot {
    private int day;
    private int month;
    private int year;
    private int startHour;
    private int endHour;
    private boolean booked;
    private String bookedTo;

    /**
     * Construct a TimeSlot object
     * @param day day
     * @param month month
     * @param year year
     * @param startHour start hour
     * @param endHour end hour
     * @param bookedTo bookedTo
     */
    TimeSlot(int day,int month,  int year, int startHour,
             int endHour, String bookedTo) {
        setDay(day);
        setMonth(month);
        setYear(year);
        setStartHour(startHour);
        setEndHour(endHour);
        setBookedTo(bookedTo);
        setBooked(false);
    }

    /**
     * Set the day
     * @param day day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Set the month
     * @param month month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Set the year
     * @param year year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Set start hour
     * @param startHour start hour
     */
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    /**
     * Set end hour
     * @param endHour end hour
     */
    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    /**
     * Set booked
     * @param booked true or false
     */
    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    /**
     * Set to whom it is booked
     * @param bookedTo to whom
     */
    public void setBookedTo(String bookedTo) {
        this.bookedTo = bookedTo;
    }

    /**
     * Returns day
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns month
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the year
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the start hour
     * @return start hour
     */
    public int getStartHour() {
        return startHour;
    }

    /**
     * Returns end hour
     * @return end hour
     */
    public int getEndHour() {
        return endHour;
    }

    /**
     * Returns to whom it is booked
     * @return to whom
     */
    public String getBookedTo() {
        return bookedTo;
    }

    /**
     * Returns if it is booked or not
     * @return true or false
     */
    public boolean isBooked() {
        return booked;
    }
}
