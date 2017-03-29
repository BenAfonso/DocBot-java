package models;
import java.util.*;

/**
 * @author BenAfonso
 */
public class Disponibility {

    /**
     * Default constructor
     */
    public Disponibility() {
    }

    public Disponibility(int scheduleId, int hourStart, int minuteStart, int hourEnd, int minuteEnd, String description, boolean isBooked) {
    this.setScheduleId(scheduleId);
    this.setHourStart(hourStart);
    this.setMinuteStart(minuteStart);
    this.setHourEnd(hourEnd);
    this.setMinuteEnd(minuteEnd);;
    this.setDescription(description);
    }

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMinuteStart() {
		return minuteStart;
	}

	public void setMinuteStart(int minuteStart) {
		this.minuteStart = minuteStart;
	}

	public int getMinuteEnd() {
		return minuteEnd;
	}

	public void setMinuteEnd(int minuteEnd) {
		this.minuteEnd = minuteEnd;
	}

	public int getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(int hourEnd) {
		this.hourEnd = hourEnd;
	}

	public int getHourStart() {
		return hourStart;
	}

	public void setHourStart(int hourStart) {
		this.hourStart = hourStart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	/**
     * 
     */
    private int id;

    private int scheduleId;
    /**
     * 
     */
    private int hourStart;

    /**
     * 
     */
    private int hourEnd;
    /**
     * 
     */
    private int minuteEnd;

    /**
     * 
     */
    private int minuteStart;


    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private boolean isBooked;


}