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

public class AdventureGUI extends JFrame {
//test
	private int selectedPlayer = 0;
	private int selectedCharacter = 0;
	private int selectedCampaign = 0;
	
	private JPanel campaignList = new JPanel();
	private JPanel contentPane;
	private ArrayList<AdvCharacter> advCharacters = new ArrayList<>();
	private ArrayList<Campaign> campaigns = new ArrayList<>();

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
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		/* Campaign Panel */
		
		/* Info panel */
		JPanel infoPanel = new JPanel();
		contentPane.add(infoPanel);
		infoPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInfo = new JLabel("Info");
		infoPanel.add(lblInfo, BorderLayout.NORTH);
	}

	private void charactersPanel() {
		JPanel charactersPanel = new JPanel();
		contentPane.add(charactersPanel);
		charactersPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCharacters = new JLabel("Characters");
		charactersPanel.add(lblCharacters, BorderLayout.NORTH);
	}

	private void campaignPanel() {
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
		for(String name : testData) {
			JButton newButton = new JButton(name);
			newButton.setBorder(new EmptyBorder(5,5,5,5)); // Add padding to space out labels
			
			// Add listener for clicks
			newButton.addActionListener(event -> {
				System.out.println("Clicked: " + newButton.getText());
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
		
		JPanel playersListPanel = new JPanel();
		playersPanel.add(playersListPanel, BorderLayout.CENTER);
	}

}
