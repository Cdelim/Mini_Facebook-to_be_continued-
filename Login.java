import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmLoginPage;
	private JTextField textUsername;
	private JPasswordField textPw;

	/**
	 * Launch the application.
	 */
	public static void Login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		frmLoginPage.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setTitle("Facebook Login Page");
		frmLoginPage.setBounds(100, 100, 745, 594);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 729, 555);
		frmLoginPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(43, 169, 336, 64);
		label.setIcon(new ImageIcon(Login.class.getResource("/image/Facebooklogo1.png")));
		panel.add(label);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(441, 169, 82, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(441, 209, 59, 14);
		panel.add(lblPassword);
		
		JLabel lblRegisteredUsers = new JLabel("Registered Users");
		lblRegisteredUsers.setBounds(42, 412, 113, 14);
		panel.add(lblRegisteredUsers);
		
		JList list = new JList();
		
		list.setVisibleRowCount(-1);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setBounds(42, 433, 657, 38);
		panel.add(list);
		
		DefaultListModel list1 = new DefaultListModel();
		for (User usr : UserCollection.users) {
			list1.addElement(usr.getUserName());
		}
		list.setModel(list1);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				textUsername.setText((String) list.getSelectedValue());
				for(int i=0;i<UserCollection.users.size();i++){
					if(UserCollection.users.get(i).getUserName().equals(list.getSelectedValue())){
					textPw.setText(UserCollection.users.get(i).getPassword());
					}
				}
			}
		});
		JButton RemoveButton = new JButton("Remove User");
		RemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel mdel = (DefaultListModel) list.getModel();
					mdel.removeElement(list.getSelectedValue());
					textPw.setText(null);
			}
		});
		RemoveButton.setBounds(42, 521, 113, 23);
		panel.add(RemoveButton);
		
		textUsername = new JTextField();
		textUsername.setBounds(510, 169, 138, 20);
		panel.add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=1;
				for(int i=0;i<UserCollection.users.size();i++){
					if(UserCollection.users.get(i).getUserName().equals(textUsername.getText())){
						if(UserCollection.users.get(i).getPassword().equals(textPw.getText())){
							UserCollection.users.get(i).setOnline(true);
							ProfilePage pp=new ProfilePage();
						}
						else{
							JOptionPane.showMessageDialog(frmLoginPage,"Password is mistake!");
						}
					}
					else{
						a++;
					}
					if(a>UserCollection.users.size()){
						JOptionPane.showMessageDialog(frmLoginPage,"Invalid username!");
					}
				}
			}
		});
		btnLogin.setBounds(510, 248, 138, 23);
		panel.add(btnLogin);
		JButton NewUserButton = new JButton("New User...");
		NewUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateUser cu = new CreateUser();
			}
		});
		NewUserButton.setBounds(583, 521, 116, 23);
		panel.add(NewUserButton);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar.setBounds(42, 490, 657, 20);
		panel.add(scrollBar);
		
		textPw = new JPasswordField();
		textPw.setBounds(510, 203, 138, 20);
		panel.add(textPw);
		frmLoginPage.setVisible(true);
	}
}
