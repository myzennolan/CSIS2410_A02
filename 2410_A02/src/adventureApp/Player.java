package adventureApp;

/**
 * This is the Player class of the Adventure Database Application.
 * It represents the players of the application.
 * 
 * @author Nolan Harris, Trevor Hodson, and Dominick Wiley
 *
 */
public class Player {
	private int id;// int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), \r\n" + 
	private String FirstName;// varchar(255), \r\n" + 
	private String LastName;// varchar(255), \r\n" + 
	private String Contact;// varchar(255), \r\n" + 

	/**
	 * Gets Player FirstName
	 * @return FistName
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * Sets Player FirstName if it needs to be changed
	 * 
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	/**
	 * Gets Player LastName
	 * @return LastName
	 */
	public String getLastName() {
		return LastName;
	}
	
	/**
	 * Sets Player LastName if it needs to be changed
	 * 
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * Gets Player Contact
	 * @return Contact
	 */
	public String getContact() {
		return Contact;
	}

	/**
	 * Sets Player Contact if it needs to be changed
	 * 
	 */
	public void setContact(String contact) {
		Contact = contact;
	}

	/**
	 * Gets Player ID
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets Player ID if it needs to be changed
	 * 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Constructor method
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param contact
	 */
	public Player(int id, String firstName, String lastName, String contact) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		Contact = contact;
	}

	/**
	 * for testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
