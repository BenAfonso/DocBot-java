 package models;

 import java.util.Date;

public class Person {

	
	/********************************************************
	 * 
	 * 						Properties
	 * 
	 ********************************************************/

	private int id = 0;
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String password = "";
	private Date birthday;
	private String phoneNumber;
	
	
	
	/********************************************************
	 * 
	 * 						Constructors
	 * 
	 ********************************************************/

	public Person(int id, String fn, String ln, String email, String password) {
		this.id = id;
		this.firstName = fn;
		this.lastName = ln;
		this.email = email;
		this.password = password;
	}
	
	
	public Person(String fname, String lname, String password, Date birthday, String phoneNumber, String mail) {
		this.firstName = fname;
		this.lastName = lname;
		this.email = mail;
		this.password = password;
		this.setBirthday(birthday);
		this.setPhoneNumber(phoneNumber);
	}

	public Person(int id,String fname, String lname, String password, Date birthday, String phoneNumber, String mail) {
		this.id=id;
		this.firstName = fname;
		this.lastName = lname;
		this.email = mail;
		this.password = password;
		this.setBirthday(birthday);
		this.setPhoneNumber(phoneNumber);
	}

    public Person() {
    }


    /********************************************************
	 * 
	 * 						Getters and setters
	 * 
	 ********************************************************/

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lname) {
		this.lastName = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String mail) {
		this.email = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
