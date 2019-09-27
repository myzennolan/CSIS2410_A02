package adventureApp;

public class Player {
	private int id;// int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), \r\n" + 
	private String FirstName;// varchar(255), \r\n" + 
	private String LastName;// varchar(255), \r\n" + 
	private String Contact;// varchar(255), \r\n" + 

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public int getId() {
		return id;
	}

	public Player() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
