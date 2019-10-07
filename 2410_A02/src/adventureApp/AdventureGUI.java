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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * AdventureGUI class is the outer most container of the Adventure Database Application.
 * It represents the main GUI of the application.
 * 
 * @author Nolan Harris, Trevor Hodson, and Dominick Wiley
 *
 */
public class AdventureGUI extends JFrame {
//test
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4999898966177525198L;

	private JPanel contentPane;
	
//players
	private int selectedPlayer = 0;
	private String filteredPlayers = "Players";
	private JButton btnDeletePlayer = new JButton("Delete Player");	
	private JPanel playersPanel = new JPanel();
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtContact;
	private JButton[] playerButtons;		
	private JPanel playersList = new JPanel();	
    private JScrollPane scrollPane = new JScrollPane(playersList);
	
//campaigns
	private int selectedCampaign = 0;
	private JButton btnDeleteCampaign = new JButton("Delete Campaign");	
	private JTextField txtCampaignName = new JTextField();
	private JTextField txtCampaignSetting = new JTextField();
	private JTextField txtCampaignDescription = new JTextField();
	private JTextField txtCampaignExperience = new JTextField();
	private JTextField txtCampaignLevelLow = new JTextField();
	private JTextField txtCampaignLevelHigh = new JTextField();
	private JButton[] campaignButtons;
	private JPanel campaignList = new JPanel();

//characters
	private int selectedCharacter = 0;
	private JButton btnDeleteCharacter = new JButton("Delete Character");	
	private JTextField txtCharacterName = new JTextField();
	private JTextField txtCharacterClass = new JTextField();
	private JTextField txtCharacterExperience = new JTextField();
	private JTextField txtCharacterStrength = new JTextField();
	private JTextField txtCharacterDexterity = new JTextField();
	private JTextField txtCharacterConstitution = new JTextField();
	private JTextField txtCharacterWisdom = new JTextField();
	private JTextField txtCharacterIntelligence = new JTextField();
	private JTextField txtCharacterCharisma = new JTextField();
	private JButton[] characterButtons;
	private CharacterPanel characterList = new CharacterPanel();
	private JLabel lblCharacters = new JLabel("Characters");
	
	
//info
	private JPanel infoPanel = new JPanel();
	private JPanel infoPanelPlayer = new JPanel();
	private JPanel infoPanelCharacter = new JPanel();
	private JPanel infoPanelCampaign = new JPanel();
	
	private ArrayList<Player> players;
	private ArrayList<AdvCharacter> advCharacters;
	private ArrayList<Campaign> campaigns;

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
			//Load Full tables
			players = DB.getPlayers(0);
			advCharacters = DB.getCharacters(0);
			campaigns = DB.getCampaigns(0);
			
			contentPane.add(playersPanel,0);
			playersPanel.setLayout(new BorderLayout(0, 0));
			playersPanel();
			charactersPanel();			
			campaignPanel();
			infoPanel();	
			//infoPanel.setVisible(false);
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		 refreshPlayersPanel(false);
		
	}

	/**
	 * The panel where records are displayed and acted on
	 */
	private void infoPanel() {
		contentPane.add(infoPanel);
		infoPanel.setLayout(new BorderLayout(0, 0));
		infoPanelPlayer.setLayout(new BorderLayout(0, 0));
		infoPanelCharacter.setLayout(new BorderLayout(0, 0));
		infoPanelCampaign.setLayout(new BorderLayout(0, 0));
		
		
		// ---- Player Info Panel ----
		JLabel lblInfo = new JLabel("Info");
		infoPanel.add(lblInfo, BorderLayout.NORTH);

		//infoPanel.add(infoPanelPlayer, BorderLayout.CENTER);
		infoPanelPlayer.setLayout(new BoxLayout(infoPanelPlayer, BoxLayout.Y_AXIS));
		
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
					//players = DB.filterPlayers(filteredPlayers);
					refreshPlayersPanel(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
			
		btnDeletePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DB.deletePlayer(selectedPlayer);
					refreshPlayersPanel(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		infoPanelPlayer.add(lblFirstName);
		infoPanelPlayer.add(txtFirstName);
				
		infoPanelPlayer.add(lblLastName);
		infoPanelPlayer.add(txtLastName);
		
		infoPanelPlayer.add(lblContact);
		infoPanelPlayer.add(txtContact);
		
		infoPanelPlayer.add(btnCommit);		
		infoPanelPlayer.add(btnDeletePlayer);

		
		// ---- Character Info Panel ----
		infoPanelCharacter.setLayout(new BoxLayout(infoPanelCharacter, BoxLayout.Y_AXIS));

		JLabel lblCharacterName = new JLabel("Charcter Name");
		JLabel lblCharacterClass = new JLabel("Class");
		JLabel lblCharacterExperience = new JLabel("Experience Points");
		JLabel lblCharacterStrength = new JLabel("Strength");
		JLabel lblCharacterDexterity = new JLabel("Dexterity");
		JLabel lblCharacterConstitution = new JLabel("Constitution");
		JLabel lblCharacterWisdom = new JLabel("Wisdom");
		JLabel lblCharacterIntelligence = new JLabel("Intelligence");
		JLabel lblCharacterCharisma = new JLabel("Charisma");

		JButton btnCharcterCommit = new JButton("Commit to DB");
		btnCharcterCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DB.commitCharacterToDB(
							new AdvCharacter(
									selectedCharacter,
									selectedPlayer, txtCharacterName.getText(),
									txtCharacterClass.getText(),
									Integer.parseInt(txtCharacterExperience.getText()),
									Integer.parseInt(txtCharacterStrength.getText()),
									Integer.parseInt(txtCharacterDexterity.getText()),
									Integer.parseInt(txtCharacterConstitution.getText()),
									Integer.parseInt(txtCharacterWisdom.getText()),
									Integer.parseInt(txtCharacterIntelligence.getText()),
									Integer.parseInt(txtCharacterCharisma.getText()),
									0
									));
					//playersPanel.removeAll();
					//players = DB.filterPlayers(filteredPlayers);
					refreshCharactersPanel(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
			
		btnDeleteCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB.deleteCharacter(selectedCharacter);
				refreshCharactersPanel(false);
			}
		});
/*
		txtCharacterName.setText("");
		txtCharacterClass.setText("");
		txtCharacterExperience.setText("");
		txtCharacterStrength.setText("");
		txtCharacterDexterity.setText("");
		txtCharacterConstitution.setText("");
		txtCharacterWisdom.setText("");
		txtCharacterIntelligence.setText("");
		txtCharacterCharisma.setText("");
	*/	
		infoPanelCharacter.add(lblCharacterName);
		infoPanelCharacter.add(txtCharacterName);
				
		infoPanelCharacter.add(lblCharacterClass);
		infoPanelCharacter.add(txtCharacterClass);
		
		infoPanelCharacter.add(lblCharacterExperience);
		infoPanelCharacter.add(txtCharacterExperience);

		infoPanelCharacter.add(lblCharacterStrength);
		infoPanelCharacter.add(txtCharacterStrength);
		
		infoPanelCharacter.add(lblCharacterDexterity);
		infoPanelCharacter.add(txtCharacterDexterity);
		
		infoPanelCharacter.add(lblCharacterConstitution);
		infoPanelCharacter.add(txtCharacterConstitution);
		
		infoPanelCharacter.add(lblCharacterWisdom);
		infoPanelCharacter.add(txtCharacterWisdom);
		
		infoPanelCharacter.add(lblCharacterIntelligence);
		infoPanelCharacter.add(txtCharacterIntelligence);
		
		infoPanelCharacter.add(lblCharacterCharisma);
		infoPanelCharacter.add(txtCharacterCharisma);
		
		infoPanelCharacter.add(btnCharcterCommit);		
		infoPanelCharacter.add(btnDeleteCharacter);

		
		// ---- Campaign Info Panel ----
		infoPanelCampaign.setLayout(new BoxLayout(infoPanelCampaign, BoxLayout.Y_AXIS));

		JLabel lblCampaignName = new JLabel("Campaign Name");
		JLabel lblCampaignDescription = new JLabel("Description");
		JLabel lblCampaignSetting = new JLabel("Setting");
		JLabel lblCampaignLevelLow = new JLabel("Minimum Level");
		JLabel lblCampaignLevelHigh = new JLabel("Maximum Level");
		JLabel lblCampaignExperience = new JLabel("Experience Available");

		JButton btnCampaignCommit = new JButton("Commit to DB");
		btnCampaignCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DB.commitCampaignToDB(
							new Campaign(
									selectedCampaign,
									txtCampaignName.getText(),
									txtCampaignSetting.getText(),
									txtCampaignDescription.getText(),
									Integer.parseInt(txtCampaignName.getText()),
									Integer.parseInt(txtCampaignName.getText()),
									Integer.parseInt(txtCampaignName.getText())
									));
					//playersPanel.removeAll();
					//players = DB.filterPlayers(filteredPlayers);
					refreshPlayersPanel(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
			
		btnDeleteCampaign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try {
					DB.deleteCampaign(selectedCampaign);
					refreshCampaignsPanel(true);
				//} catch (SQLException e1) {
				//	e1.printStackTrace();
				//}
			}
		});
/*
		txtCharacterName.setText("");
		txtCharacterClass.setText("");
		txtCharacterExperience.setText("");
		txtCharacterStrength.setText("");
		txtCharacterDexterity.setText("");
		txtCharacterConstitution.setText("");
		txtCharacterWisdom.setText("");
		txtCharacterIntelligence.setText("");
		txtCharacterCharisma.setText("");
	*/	
		infoPanelCampaign.add(lblCampaignName);
		infoPanelCampaign.add(txtCampaignName);
				
		infoPanelCampaign.add(lblCampaignSetting);
		infoPanelCampaign.add(txtCampaignSetting);
		
		infoPanelCampaign.add(lblCampaignDescription);
		infoPanelCampaign.add(txtCampaignDescription);

		infoPanelCampaign.add(lblCampaignLevelLow);
		infoPanelCampaign.add(txtCampaignLevelLow);

		infoPanelCampaign.add(lblCampaignLevelHigh);
		infoPanelCampaign.add(txtCampaignLevelHigh);
		
		infoPanelCampaign.add(lblCampaignExperience);
		infoPanelCampaign.add(txtCampaignExperience);
		
		infoPanelCampaign.add(btnCampaignCommit);		
		infoPanelCampaign.add(btnDeleteCampaign);
		
	}

	private void refreshCampaignsPanel(boolean b) {
		// TODO Auto-generated method stub
				campaignList.removeAll();
				campaigns = DB.getCampaigns(0);

				int i = 0;
				campaignButtons = new JButton[campaigns.size()];
						for(Campaign c : campaigns) {
							campaignButtons[i] = new JButton(c.getName()+" ["+c.getSetting()+"](Level: "+c.getLevelLow()+" - "+c.getLevelHigh()+")");
							campaignButtons[i].setBorder(new EmptyBorder(5,5,5,5)); // Add padding to space out labels
							
							// Add listener for clicks
							final int j =i;
							campaignButtons[i].addActionListener(event -> {
								System.out.println("Clicked: " + characterButtons[j].getText());
								selectedCharacter = c.getId();
								txtCampaignName.setText(c.getName());
								txtCampaignSetting.setText(c.getSetting());
								txtCampaignDescription.setText(c.getDescription());
								txtCampaignLevelLow.setText(((Integer)c.getLevelLow()).toString());
								txtCampaignLevelHigh.setText(((Integer)c.getLevelHigh()).toString());
								txtCampaignExperience.setText(((Integer)c.getAvailableExp()).toString());
								btnDeleteCharacter.setVisible(true);
								infoPanel.removeAll();
								infoPanel.add(infoPanelCharacter);
								revalidate();
								repaint();
							});
							
							// Add hover effects
							characterButtons[i].setOpaque(true);
							characterButtons[i].addMouseListener(new MouseListener() {
								@Override
								public void mouseEntered(MouseEvent e) {
									characterButtons[j].setBackground(Color.LIGHT_GRAY);
									
								}

								@Override
								public void mouseExited(MouseEvent e) {
									characterButtons[j].setBackground(UIManager.getColor("control"));
									
								}

								// Not used
								@Override
								public void mouseClicked(MouseEvent e) {}

								@Override
								public void mousePressed(MouseEvent e) {}

								@Override
								public void mouseReleased(MouseEvent e) {}
								
							});
							
							characterList.add(characterButtons[i]);
							i++;
						}
						revalidate(); 
						repaint();
		
	}

	protected void refreshCharactersPanel(boolean removeOld) {
		// TODO Auto-generated method stub
		characterList.removeAll();
		advCharacters = DB.getPlayerCharacters(selectedPlayer);

		int i = 0;
		characterButtons = new JButton[advCharacters.size()];
				for(AdvCharacter c : advCharacters) {
					characterButtons[i] = new JButton(c.getName()+" ["+c.getCharClass()+"](Level: "+c.getLevel()+")");
					characterButtons[i].setBorder(new EmptyBorder(5,5,5,5)); // Add padding to space out labels
					
					// Add listener for clicks
					final int j =i;
					characterButtons[i].addActionListener(event -> {
						System.out.println("Clicked: " + characterButtons[j].getText());
						selectedCharacter = c.getId();
						txtCharacterName.setText(c.getName());
						txtCharacterClass.setText(c.getCharClass());
						txtCharacterExperience.setText(((Integer)c.getExperience()).toString());
						txtCharacterStrength.setText(((Integer)c.getStrength()).toString());
						txtCharacterDexterity.setText(((Integer)c.getDexterity()).toString());
						txtCharacterConstitution.setText(((Integer)c.getConstitution()).toString());
						txtCharacterWisdom.setText(((Integer)c.getWisdom()).toString());
						txtCharacterIntelligence.setText(((Integer)c.getIntelligence()).toString());
						txtCharacterCharisma.setText(((Integer)c.getCharisma()).toString());
						btnDeleteCharacter.setVisible(true);
						infoPanel.removeAll();
						infoPanel.add(infoPanelCharacter);
						revalidate();
						repaint();
					});
					
					// Add hover effects
					characterButtons[i].setOpaque(true);
					characterButtons[i].addMouseListener(new MouseListener() {
						@Override
						public void mouseEntered(MouseEvent e) {
							characterButtons[j].setBackground(Color.LIGHT_GRAY);
							
						}

						@Override
						public void mouseExited(MouseEvent e) {
							characterButtons[j].setBackground(UIManager.getColor("control"));
							
						}

						// Not used
						@Override
						public void mouseClicked(MouseEvent e) {}

						@Override
						public void mousePressed(MouseEvent e) {}

						@Override
						public void mouseReleased(MouseEvent e) {}
						
					});
					
					characterList.add(characterButtons[i]);
					i++;
				}
				revalidate(); 
				repaint();
	}

	/**
	 * List of AdvCharacters as buttons
	 */
	private void charactersPanel() {
		JPanel charactersPanel = new JPanel();
		contentPane.add(charactersPanel);
		charactersPanel.setLayout(new BorderLayout(0, 0));
		charactersPanel.add(characterList, BorderLayout.CENTER);
		
		charactersPanel.add(lblCharacters, BorderLayout.NORTH);
		

		
		JButton btnNewCharacter = new JButton("New Character");
		btnNewCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCharacterInfoPanel();
				infoPanel.removeAll();
				infoPanel.add(infoPanelCharacter);
				revalidate();
				repaint();
			}
			
		});
		
		charactersPanel.add(btnNewCharacter, BorderLayout.SOUTH);
	}

	/**
	 * List of Campaigns as buttons
	 */
	private void campaignPanel() {

		campaigns = DB.getCampaigns(0);
		
		//String[] testData = {"Campaign One", "Campaign Two", "Campaign Three", "Campaign Four", "Campaign Five"};
		
		// Make campaign panel
		JPanel campaignPanel = new JPanel();
		campaignPanel.setLayout(new BorderLayout(0,0));
		
		// Title
		JLabel lblCampaigns = new JLabel("Campaigns:");
		lblCampaigns.setBorder(new EmptyBorder(0,0,10,0));
		campaignPanel.add(lblCampaigns, BorderLayout.NORTH);
		
		// Make new panel to hold all of the campaigns
		campaignList.setLayout(new BoxLayout(campaignList, BoxLayout.Y_AXIS)); // Box layout adds vertically
		
		// Fill in all the campaigns
		for(Campaign c : campaigns) {
			JButton newButton = new JButton(c.getName());
			newButton.setBorder(new EmptyBorder(5,5,5,5)); // Add padding to space out labels
			
			// Add listener for clicks
			newButton.addActionListener(event -> {
				System.out.println("Clicked: " + c.getName());
				

				txtCampaignName.setText(c.getName());
				txtCampaignDescription.setText(c.getDescription());
				txtCampaignSetting.setText(c.getSetting());
				txtCampaignExperience.setText(c.getAvailableExp().toString());
				txtCampaignLevelLow.setText(c.getLevelLow().toString());
				txtCampaignLevelHigh.setText(c.getLevelHigh().toString());
				selectedCampaign = 0;
				btnDeleteCampaign.setVisible(true);
				infoPanel.removeAll();
				infoPanel.add(infoPanelCampaign);
				revalidate();
				repaint();
				
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
		campaignPanel.add(campaignScrollPane, BorderLayout.CENTER);
		
		JButton btnNewCampaign = new JButton("New Campaign");
		btnNewCampaign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCampaignInfoPanel();
				infoPanel.removeAll();
				infoPanel.add(infoPanelCampaign);
				revalidate();
				repaint();
			}
			
		});
		
		campaignPanel.add(btnNewCampaign, BorderLayout.SOUTH);
		
		// Done building panel, add it to the window
		contentPane.add(campaignPanel);
	}
	
	/**
	 * List of Players as buttons.
	 */
	private void playersPanel(){

		JComboBox<String> letterSelector = new JComboBox<String>();
		letterSelector.addItem("Players");
		for(Character i = 'A'; i <= 'Z'; i++) {
			letterSelector.addItem(i.toString());
		}
		
		letterSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filteredPlayers = letterSelector.getSelectedItem().toString();
				players = DB.filterPlayers(filteredPlayers);
				//playersPanel.removeAll();
				System.out.println("Clicked: " + letterSelector.getSelectedItem().toString());
				refreshPlayersPanel(true);
			}
		});
		
		//JLabel lblPlayers = new JLabel("Players");
		//playersPanel.add(lblPlayers, BorderLayout.NORTH);
		
		playersList.setLayout(new BoxLayout(playersList, BoxLayout.Y_AXIS)); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 300, 50);
		playersPanel.add(scrollPane, BorderLayout.CENTER);
		playersPanel.add(letterSelector, BorderLayout.NORTH);
		
		// Fill in all the campaigns
		
				
				JButton btnNewPlayer = new JButton("New Player");
				btnNewPlayer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						resetPlayerInfoPanel();
						infoPanel.removeAll();
						infoPanel.add(infoPanelPlayer);
						revalidate();
						repaint();
					}
					
				});
				playersPanel.add(btnNewPlayer, BorderLayout.SOUTH);
	}
	
	
	/**
	 * panel refresh method
	 * removes old records from the  before repopulating 
	 * 
	 * @param removeOld
	 */
	private void refreshPlayersPanel(Boolean removeOld) {
		if(removeOld) {

		for(JButton pbtn: playerButtons) {
			playersList.remove(pbtn);
			pbtn = null;

		}
		}
		players = DB.filterPlayers(filteredPlayers);

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
						refreshCharactersPanel(false);
						lblCharacters.setText("Characters - "+p.getFirstName()+" "+p.getLastName());
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
				repaint();
	}

	/**
	 * 
	 */
	private void resetCharacterInfoPanel() {
		txtCharacterName.setText("");
		txtCharacterClass.setText("");
		txtCharacterExperience.setText("");
		txtCharacterStrength.setText("");
		txtCharacterDexterity.setText("");
		txtCharacterConstitution.setText("");
		txtCharacterWisdom.setText("");
		txtCharacterIntelligence.setText("");
		txtCharacterCharisma.setText("");
		selectedCharacter = 0;
		btnDeleteCharacter.setVisible(false);
	}

	/**
	 * 
	 */
	private void resetCampaignInfoPanel() {
		txtCampaignName.setText("");
		txtCampaignDescription.setText("");
		txtCampaignExperience.setText("");
		txtCampaignLevelLow.setText("");
		txtCampaignLevelHigh.setText("");
		selectedCampaign = 0;
		btnDeleteCampaign.setVisible(false);
	}

	/**
	 * 
	 */
	private void resetPlayerInfoPanel() {
		txtFirstName.setText("");
		txtLastName.setText("");
		txtContact.setText("");
		selectedPlayer = 0;
		btnDeletePlayer.setVisible(false);
	}

}
