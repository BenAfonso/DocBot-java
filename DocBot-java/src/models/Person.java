package models;

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

	public Person(){};



	
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
	public String getFisrtName() {
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


}
