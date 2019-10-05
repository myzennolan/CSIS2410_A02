package adventureApp;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/**
 * This is the PlayerPanel class of the Adventure Database Applicaiton.
 * It displays the players within the database.
 * @author Nolan Harris
 *
 */
public class InfoPanel extends JPanel {

	private int selectedPlayer = 0;
	private JButton btnDeletePlayer = new JButton("Delete Player");	
	private JPanel playersPanel = new JPanel();
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtContact;
	private JButton[] playerButtons;		
	private JPanel playersList = new JPanel();	
    private JScrollPane scrollPane = new JScrollPane(playersList);
	
	public InfoPanel() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
