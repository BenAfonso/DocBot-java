package models;

import java.util.Date;

/**
 * @author BenAfonso
 */
public class Patient extends Person {

    private boolean isBlocked = false;

    /**
     * Default constructor
     */
    public Patient(String fname, String lname, String password, Date birthday, String s2, String s1, String s, String aze, String azea, String phoneNumber, String mail) {
        super(fname, lname, password, birthday, phoneNumber, mail);
    }

    public Patient(int id, String fname, String lname, String password, Date birthday, String phoneNumber, String mail, boolean isBlocked) {
        super(id, fname, lname, password, birthday, phoneNumber, mail);
        this.setBlocked(isBlocked);
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public void setBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }


}