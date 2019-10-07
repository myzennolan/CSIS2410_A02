package adventureApp;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

/**
 * This is the CharacterPanel class of the Adventure Database Application. 
 * It displays the characters within the local database of the application.
 * 
 * @author Nolan Harris, Trevor Hodson, and Dominick Wiley
 *
 */
public class CharacterPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CharacterPanel() 
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

}