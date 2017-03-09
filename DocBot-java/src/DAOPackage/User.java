package DAOPackage;

public class User {
	//ID
	private int id = 0;
	//Nom de l'user
	private String fname = "";
	//Prénom de l'user
	private String lname = "";
	//Mail de l'user
	private String mail = "";
	//Mdp de l'user
	private String mdp = "";
	   
	public User(int id, String fn, String ln, String mail, String mdp) {
	    this.id = id;
	    this.fname = fn;
	    this.lname = ln;
	    this.mail = mail;
	    this.mdp = mdp;
	}
	  
	public User(){};
	     
	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}
	  
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	   
}
