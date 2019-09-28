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
	private int selectedCharacter = 0;
	private int selectedCampaign = 0;
	
	private JPanel contentPane;
	
//players
	private int selectedPlayer = 0;
	private JButton btnDeletePlayer = new JButton("Delete Player");	
	private JPanel playersPanel = new JPanel();
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtContact;
	private JButton[] playerButtons;		
	private JPanel playersList = new JPanel();	
    private JScrollPane scrollPane = new JScrollPane(playersList);
	

	private ArrayList<Player> players;

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
		setTitle("Adventure Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 0, 0));
		
		try {
			players = DB.getPlayers(0);
			contentPane.add(playersPanel,0);
			playersPanel.setLayout(new BorderLayout(0, 0));
			playersPanel();
			charactersPanel();			
			campaignPanel();
			infoPanel();	
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 refreshPlayersPanel(false);
		
		
		
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
		JLabel lblLastName = new JLabel("Last Name");	
		JLabel lblContact = new JLabel("Contact");
		
		txtFirstName = new JTextField();
		txtLastName = new JTextField();
		txtContact = new JTextField();

		JButton btnCommit = new JButton("Commit to DB");
		btnCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DB.commitPlayerToDB(
							new Player(
									selectedPlayer,
									txtFirstName.getText(),
									txtLastName.getText(),
									txtContact.getText()
									));
					//playersPanel.removeAll();
					refreshPlayersPanel(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
			
		btnDeletePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DB.deletePlayer(selectedPlayer);
					//playersPanel.removeAll();
					refreshPlayersPanel(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		playerActionPanel.add(lblFirstName);
		playerActionPanel.add(txtFirstName);
				
		playerActionPanel.add(lblLastName);
		playerActionPanel.add(txtLastName);
		
		playerActionPanel.add(lblContact);
		playerActionPanel.add(txtContact);
		
		playerActionPanel.add(btnCommit);		
		playerActionPanel.add(btnDeletePlayer);
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

	private void refreshPlayersPanel(Boolean removeOld) {
		if(removeOld) {

		for(JButton pbtn: playerButtons) {
			playersList.remove(pbtn);
			pbtn = null;
			//pbtn.revalidate();
		}
		}

		try {
			players = DB.getPlayers(0);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i = 0;
		playerButtons = new JButton[players.size()];
				for(Player p : players) {
					playerButtons[i] = new JButton(p.getFirstName()+" "+p.getLastName());
					playerButtons[i].setBorder(new EmptyBorder(5,5,5,5)); // Add padding to space out labels
					
					// Add listener for clicks
					final int j =i;
					playerButtons[i].addActionListener(event -> {
						System.out.println("Clicked: " + playerButtons[j].getText());
						selectedPlayer = p.getId();
						txtFirstName.setText(p.getFirstName());
						txtLastName.setText(p.getLastName());
						txtContact.setText(p.getContact());
						btnDeletePlayer.setVisible(true);
					});
					
					// Add hover effects
					playerButtons[i].setOpaque(true);
					playerButtons[i].addMouseListener(new MouseListener() {
						@Override
						public void mouseEntered(MouseEvent e) {
							playerButtons[j].setBackground(Color.LIGHT_GRAY);
							
						}

						@Override
						public void mouseExited(MouseEvent e) {
							playerButtons[j].setBackground(UIManager.getColor("control"));
							
						}

						// Not used
						@Override
						public void mouseClicked(MouseEvent e) {}

						@Override
						public void mousePressed(MouseEvent e) {}

						@Override
						public void mouseReleased(MouseEvent e) {}
						
					});
					
					playersList.add(playerButtons[i]);
					i++;
				}
				revalidate(); 
				repaint();/*
				playersList.revalidate();
				playersList.repaint();
				scrollPane.revalidate();
				scrollPane.repaint();
				playersPanel.revalidate();
				playersPanel.repaint();
				*/
	}
	
	private void playersPanel(){

		
		JLabel lblPlayers = new JLabel("Players");
		playersPanel.add(lblPlayers, BorderLayout.NORTH);
		
		playersList.setLayout(new BoxLayout(playersList, BoxLayout.Y_AXIS)); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 300, 50);
		playersPanel.add(scrollPane, BorderLayout.CENTER);
		
		// Fill in all the campaigns
		
				
				JButton btnNewPlayer = new JButton("New Player");
				btnNewPlayer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						txtFirstName.setText("");
						txtLastName.setText("");
						txtContact.setText("");
						selectedPlayer = 0;
						btnDeletePlayer.setVisible(false);
					}
					
				});
				playersPanel.add(btnNewPlayer, BorderLayout.SOUTH);
	}

}
