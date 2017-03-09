package models;

public class User {

	
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

	public User(int id, String fn, String ln, String email, String password) {
		this.id = id;
		this.firstName = fn;
		this.lastName = ln;
		this.email = email;
		this.password = password;
	}

	public User(){};



	
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

	public String getFname() {
		return firstName;
	}
	public void setFname(String fname) {
		this.firstName = fname;
	}
	public String getLname() {
		return lastName;
	}
	public void setLname(String lname) {
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
