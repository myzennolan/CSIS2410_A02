package adventureApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class AdventureGUI extends JFrame {
//test
	private JPanel contentPane;

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
		
		JPanel playersPanel = new JPanel();
		contentPane.add(playersPanel);
		playersPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPlayers = new JLabel("Players");
		playersPanel.add(lblPlayers, BorderLayout.NORTH);
		
		JPanel charactersPanel = new JPanel();
		contentPane.add(charactersPanel);
		charactersPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCharacters = new JLabel("Characters");
		charactersPanel.add(lblCharacters, BorderLayout.NORTH);
		
		JPanel campaignPanel = new JPanel();
		contentPane.add(campaignPanel);
		campaignPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCampaigns = new JLabel("Campaigns");
		campaignPanel.add(lblCampaigns, BorderLayout.NORTH);
		
		JPanel infoPanel = new JPanel();
		contentPane.add(infoPanel);
		infoPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInfo = new JLabel("Info");
		infoPanel.add(lblInfo, BorderLayout.NORTH);
	}

}
