package models;

import java.sql.Date;

/**
 * @author BenAfonso
 */
public class Appointment {

    /**
     * Default constructor
     */
    private int id;
    private int hourStart;
    private int hourEnd;
    private int minuteEnd;
    private int minuteStart;
    private int personid;
    private String firstName;
    private String lastName;
    private Date date;

    public Appointment() {
    }

    public Appointment(int id, Date date, int hourStart, int minuteStart, int hourEnd, int minuteEnd, String firstName, String lastName,
                       int personid) {
        this.setId(id);
        this.setDate(date);
        this.setFirstName(firstName);
        this.setHourEnd(hourEnd);
        this.setHourStart(hourStart);
        this.setLastName(lastName);
        this.setMinuteEnd(minuteEnd);
        this.setMinuteStart(minuteStart);
        this.setPersonid(personid);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHourStart() {
        return hourStart;
    }

    public void setHourStart(int hourStart) {
        this.hourStart = hourStart;
    }

    public int getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(int hourEnd) {
        this.hourEnd = hourEnd;
    }

    public int getMinuteEnd() {
        return minuteEnd;
    }

    public void setMinuteEnd(int minuteEnd) {
        this.minuteEnd = minuteEnd;
    }

    public int getMinuteStart() {
        return minuteStart;
    }

    public void setMinuteStart(int minuteStart) {
        this.minuteStart = minuteStart;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHourStartFull() {
        return this.getHourStart() + ":" + this.getMinuteStart();
    }

    public String getHourEndFull() {
        return this.getHourEnd() + ":" + this.getMinuteEnd();
    }


}