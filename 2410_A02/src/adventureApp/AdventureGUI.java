package adventureApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdventureGUI extends JFrame {
//test
	private int selectedPlayer = 0;
	private int selectedCharacter = 0;
	private int selectedCampaign = 0;
	
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdventureGUI frame = new AdventureGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdventureGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 0, 0));
		
		try {
			playersPanel();
			charactersPanel();			
			campaignPanel();
			infoPanel();	
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		/* Campaign Panel */
		
		/* Info panel */
	}

	private void infoPanel() {
		JPanel infoPanel = new JPanel();
		contentPane.add(infoPanel);
		infoPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInfo = new JLabel("Info");
		infoPanel.add(lblInfo, BorderLayout.NORTH);
		
		JPanel playerActionPanel = new JPanel();
		infoPanel.add(playerActionPanel, BorderLayout.CENTER);
		playerActionPanel.setLayout(new BoxLayout(playerActionPanel, BoxLayout.Y_AXIS));
		
		JLabel lblFirstName = new JLabel("First Name");
		playerActionPanel.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(new Rectangle(0, 0, 150, 50));
		playerActionPanel.add(txtFirstName);
		txtFirstName.setColumns(80);
		
		JLabel label = new JLabel("");
		label.setLabelFor(txtFirstName);
		playerActionPanel.add(label);
		
		JLabel label_1 = new JLabel("");
		playerActionPanel.add(label_1);
		
		JLabel lblLastName = new JLabel("Last Name");
		playerActionPanel.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		playerActionPanel.add(txtLastName);
		
		JLabel label_2 = new JLabel("");
		playerActionPanel.add(label_2);
		
		JLabel lblContact = new JLabel("Contact");
		playerActionPanel.add(lblContact);
		
		JLabel label_3 = new JLabel("");
		playerActionPanel.add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		playerActionPanel.add(textField);
		
		JButton btnCommit = new JButton("Commit to DB");
		playerActionPanel.add(btnCommit);
		
		JButton btnDeletePlayer = new JButton("Delete Player");
		playerActionPanel.add(btnDeletePlayer);
		
		JLabel label_4 = new JLabel("");
		playerActionPanel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		playerActionPanel.add(label_5);
	}

	private void charactersPanel() {
		JPanel charactersPanel = new JPanel();
		contentPane.add(charactersPanel);
		charactersPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCharacters = new JLabel("Characters");
		charactersPanel.add(lblCharacters, BorderLayout.NORTH);
	}

	private void campaignPanel() {

		ArrayList<Campaign> campaigns = DB.getCampaigns(0);
		
		String[] testData = {"Campaign One", "Campaign Two", "Campaign Three", "Campaign Four", "Campaign Five"};
		
		// Make campaign panel
		JPanel campaignPanel = new JPanel();
		campaignPanel.setLayout(new BorderLayout(0,0));
		
		// Title
		JLabel lblCampaigns = new JLabel("Campaigns:");
		lblCampaigns.setBorder(new EmptyBorder(0,0,10,0));
		campaignPanel.add(lblCampaigns, BorderLayout.NORTH);
		
		// Make new panel to hold all of the campaigns
		JPanel campaignList = new JPanel();
		campaignList.setLayout(new BoxLayout(campaignList, BoxLayout.Y_AXIS)); // Box layout adds vertically
		
		// Fill in all the campaigns
		for(Campaign c : campaigns) {
			JButton newButton = new JButton(c.getName());
			newButton.setBorder(new EmptyBorder(5,5,5,5)); // Add padding to space out labels
			
			// Add listener for clicks
			newButton.addActionListener(event -> {
				System.out.println("Clicked: " + c.getName());
			});
			
			// Add hover effects
			newButton.setOpaque(true);
			newButton.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					newButton.setBackground(Color.LIGHT_GRAY);
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					newButton.setBackground(UIManager.getColor("control"));
					
				}

				// Not used
				@Override
				public void mouseClicked(MouseEvent e) {}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {}
				
			});
			
			campaignList.add(newButton);
		}
		
		// Make a scroll pane and wrap the campaignList
		JScrollPane campaignScrollPane = new JScrollPane(campaignList);
		campaignPanel.add(campaignScrollPane);
		
		// Done building panel, add it to the window
		contentPane.add(campaignPanel);
	}

	private void playersPanel() throws SQLException {

		ArrayList<Player> players = DB.getPlayers(0);
		
		JPanel playersPanel = new JPanel();
		contentPane.add(playersPanel);
		playersPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPlayers = new JLabel("Players");
		playersPanel.add(lblPlayers, BorderLayout.NORTH);
		
		JPanel playersList = new JPanel();
		playersPanel.setAutoscrolls(true);
		
        JScrollPane scrollPane = new JScrollPane(playersList);
		playersList.setLayout(new BoxLayout(playersList, BoxLayout.Y_AXIS)); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 300, 50);
		playersPanel.add(scrollPane, BorderLayout.CENTER);
		
		// Fill in all the campaigns
				for(Player p : players) {
					JButton newButton = new JButton(p.getFirstName()+" "+p.getLastName());
					newButton.setBorder(new EmptyBorder(5,5,5,5)); // Add padding to space out labels
					
					// Add listener for clicks
					newButton.addActionListener(event -> {
						System.out.println("Clicked: " + newButton.getText());
						selectedPlayer = p.getId();
					});
					
					// Add hover effects
					newButton.setOpaque(true);
					newButton.addMouseListener(new MouseListener() {
						@Override
						public void mouseEntered(MouseEvent e) {
							newButton.setBackground(Color.LIGHT_GRAY);
							
						}

						@Override
						public void mouseExited(MouseEvent e) {
							newButton.setBackground(UIManager.getColor("control"));
							
						}

						// Not used
						@Override
						public void mouseClicked(MouseEvent e) {}

						@Override
						public void mousePressed(MouseEvent e) {}

						@Override
						public void mouseReleased(MouseEvent e) {}
						
					});
					
					playersList.add(newButton);
				}
				
				JButton btnNewPlayer = new JButton("New Player");
				btnNewPlayer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
					
				});
				playersPanel.add(btnNewPlayer, BorderLayout.SOUTH);
	}

}
