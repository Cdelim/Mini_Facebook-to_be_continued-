import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FriendPage {

	private JFrame frmFriendPage;
	private JTextField textSearchFriend;
	private JTextField textBirth;
	private JTextField textGrad;

	/**
	 * Launch the application.
	 */
	public static void FriendPage(String userName) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendPage window = new FriendPage(userName);
					window.frmFriendPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FriendPage(String userName) {
		initialize(userName);
		frmFriendPage.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String userName) {
		frmFriendPage = new JFrame();
		frmFriendPage.setTitle("Profile Page");
		frmFriendPage.setBounds(100, 100, 787, 741);
		frmFriendPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFriendPage.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 771, 702);
		frmFriendPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FriendPage.class.getResource("/image/personicon8.png")));
		lblNewLabel.setBounds(52, 48, 173, 170);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBounds(0, 0, 771, 35);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Search Friends");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(222, 6, 98, 24);
		panel_1.add(lblNewLabel_1);
		
		textSearchFriend = new JTextField();
		textSearchFriend.setBounds(326, 9, 178, 20);
		panel_1.add(textSearchFriend);
		textSearchFriend.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<UserCollection.users.size();i++){
					if(UserCollection.users.get(i).isOnline()==true){
						UserCollection.users.get(i).setOnline(false);;
					}
				}
				frmFriendPage.dispose();
				Login lg=new Login();
			}
		});
		
		btnNewButton_1.setBounds(677, 8, 84, 23);
		panel_1.add(btnNewButton_1);
		
		textSearchFriend = new JTextField();
		textSearchFriend.setBounds(326, 9, 178, 20);
		panel_1.add(textSearchFriend);
		textSearchFriend.setColumns(10);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFriendPage.dispose();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHome.setBounds(20, 8, 72, 23);
		panel_1.add(btnHome);
		
		
		
		JList list = new JList();
		list.setBounds(325, 35, 179, 82);
		panel.add(list);
		
		
		JLabel lblNameSurname = new JLabel("");
		lblNameSurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNameSurname.setBounds(235, 175, 173, 25);
		lblNameSurname.setEnabled(true);
		for(int i=0;i<UserCollection.users.size();i++){
			if(UserCollection.users.get(i).getUserName().equals(userName)){
				System.out.println("asd");
				lblNameSurname.setText(UserCollection.users.get(i).getName());
			}
		}
		panel.add(lblNameSurname);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(52, 229, 190, 259);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Date of Birth");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 27, 108, 15);
		panel_2.add(lblNewLabel_2);
		
		textBirth = new JTextField();
		textBirth.setBounds(10, 53, 86, 20);
		for(int i=0;i<UserCollection.users.size();i++){
			if(UserCollection.users.get(i).getUserName().equals(userName)){
				textBirth.setText(UserCollection.users.get(i).getDoB());
			}
		}
		panel_2.add(textBirth);
		textBirth.setColumns(10);
		textBirth.setEditable(false);
		textBirth.setBorder(null);
		
		JLabel lblNewLabel_3 = new JLabel("School Graduated");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 84, 108, 20);
		panel_2.add(lblNewLabel_3);
		
		textGrad = new JTextField();
		textGrad.setBounds(10, 115, 158, 20);
		panel_2.add(textGrad);
		for(int i=0;i<UserCollection.users.size();i++){
			if(UserCollection.users.get(i).getUserName().equals(userName)){
				textGrad.setText(UserCollection.users.get(i).getSchoolG());
			}
		}
		textGrad.setColumns(10);
		textGrad.setEditable(false);
		textGrad.setBorder(null);
		
		JLabel lblNewLabel_4 = new JLabel("Relationship Status");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 155, 132, 14);
		panel_2.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Single", "Divorced", "Complicated", "In relation"}));
		for(int i=0;i<UserCollection.users.size();i++){
			if(UserCollection.users.get(i).getUserName().equals(userName)){
				comboBox.setEditable(true);
				comboBox.setSelectedItem(UserCollection.users.get(i).getRelationShip());
				comboBox.setEditable(false);
			}
		}
		comboBox.setBounds(10, 177, 132, 26);
		panel_2.add(comboBox);
		
		textBirth = new JTextField();
		textBirth.setEditable(false);
		textBirth.setColumns(10);
		textBirth.setBorder(null);
		textBirth.setBounds(10, 53, 86, 20);
		panel_2.add(textBirth);
		
		textGrad = new JTextField();
		textGrad.setEditable(false);
		textGrad.setColumns(10);
		textGrad.setBorder(null);
		textGrad.setBounds(10, 115, 158, 20);
		panel_2.add(textGrad);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(52, 532, 190, 146);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JList list_1 = new JList();
		list_1.setBounds(10, 11, 170, 99);
		panel_3.add(list_1);
		
		DefaultListModel list1 = new DefaultListModel();
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list1.removeAllElements();
				for(int i=0;i<UserCollection.users.size();i++){
					if(UserCollection.users.get(i).getUserName().equals(userName)){
						for(int a=0;a<UserCollection.users.get(i).friends.size();a++){
							list1.addElement(UserCollection.users.get(i).friends.get(a).getUserName());
						}
					}
				}
			list_1.setModel(list1);
			}
		});
		rdbtnNormal.setSelected(true);
		rdbtnNormal.setBounds(90, 495, 72, 23);
		panel.add(rdbtnNormal);
		
		DefaultListModel list2=new DefaultListModel();
		for(int i=0;i<UserCollection.users.size();i++){
			if(UserCollection.users.get(i).isOnline()==true){
				for(int a=0;a<UserCollection.users.get(i).friends.size();a++){
					list2.addElement(UserCollection.users.get(i).friends.get(a).getName());
				}
				}
			}
		list.setModel(list2);
		
		JLabel lblNewLabel_5 = new JLabel("Friends");
		lblNewLabel_5.setBounds(38, 499, 86, 14);
		panel.add(lblNewLabel_5);
		
		JRadioButton rdbtnBlocked = new JRadioButton("Blocked");
		rdbtnBlocked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list1.removeAllElements();
				for(int i=0;i<UserCollection.users.size();i++){
					if(UserCollection.users.get(i).getUserName().equals(userName)){
						for(int a=0;a<UserCollection.users.get(i).block_friends.size();a++){
							list1.addElement(UserCollection.users.get(i).block_friends.get(a).getUserName());
						}
					}
				}
			list_1.setModel(list1);
			}
		});
		rdbtnBlocked.setBounds(164, 495, 109, 23);
		panel.add(rdbtnBlocked);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnNormal);
		group.add(rdbtnBlocked);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(279, 239, 469, 437);
		panel.add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Posts", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Friends' Posts", null, panel_5, null);
		
		JButton btnBlockButton = new JButton("Block this person");
		btnBlockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<UserCollection.users.size();i++){
					if(UserCollection.users.get(i).getUserName().equals(userName)){
						for(int a=0;a<UserCollection.users.size();a++){
							if(UserCollection.users.get(a).isOnline()==true){
								UserCollection.users.get(a).friends.remove(UserCollection.users.get(i));
								UserCollection.users.get(a).block_friends.add(UserCollection.users.get(i));
								frmFriendPage.dispose();
							}
						}
					}
				}
			}
		});
		btnBlockButton.setBounds(558, 209, 190, 23);
		panel.add(btnBlockButton);
		frmFriendPage.setVisible(true);
	}
}
