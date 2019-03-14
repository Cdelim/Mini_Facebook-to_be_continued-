import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CreateUser {
	private JFrame frame;
	private JTextField textUserName;
	private JTextField textNameSurname;
	private JTextField textSchoolGraduated;
	private JTextField textBirth;
	private JPasswordField textPw;
	private JPasswordField textPwr;

	/**
	 * Launch the application.
	 */
	public static void CreateUser() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser window = new CreateUser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateUser() {
		initialize();
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 365, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 357, 458);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CreateUser.class.getResource("/image/Facebooklogo1.png")));
		lblNewLabel.setBounds(27, 11, 303, 124);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("     Create User");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(114, 139, 126, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(27, 189, 72, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(27, 221, 72, 14);
		panel.add(lblPassword);
		
		JLabel lblNewLabel_3 = new JLabel("Password(re-type)");
		lblNewLabel_3.setBounds(27, 255, 113, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name Surname");
		lblNewLabel_4.setBounds(27, 292, 113, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("School graduated");
		lblNewLabel_5.setBounds(27, 326, 113, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setBounds(27, 364, 86, 14);
		panel.add(lblBirthDate);
		
		JLabel lblNewLabel_6 = new JLabel("Relationship Status");
		lblNewLabel_6.setBounds(27, 394, 98, 14);
		panel.add(lblNewLabel_6);
		
		textUserName = new JTextField();
		textUserName.setBounds(140, 185, 132, 23);
		panel.add(textUserName);
		textUserName.setColumns(10);
		
		textNameSurname = new JTextField();
		textNameSurname.setColumns(10);
		textNameSurname.setBounds(140, 288, 196, 23);
		panel.add(textNameSurname);
		
		textSchoolGraduated = new JTextField();
		textSchoolGraduated.setColumns(10);
		textSchoolGraduated.setBounds(140, 322, 196, 23);
		panel.add(textSchoolGraduated);
		
		textBirth = new JTextField();
		textBirth.setColumns(10);
		textBirth.setBounds(140, 356, 132, 23);
		panel.add(textBirth);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Single", "Divorced", "Complicated", "In relation"}));
		comboBox.setBounds(140, 390, 126, 23);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*int a=1;
				for (User usr : UserCollection.users) {
					if(usr.getName().equals(textUserName.getText())){
						a++;
						if(a>2){
						}
						else{
						JOptionPane.showMessageDialog(frame,"This username is being used by another user");
						}
					}
					else{*/
						if(textPw.getText().equals(textPwr.getText())){
							User new_user=new User(textNameSurname.getText(),textUserName.getText(),textPw.getText(),textBirth.getText(),textSchoolGraduated.getText(),comboBox.getSelectedItem().toString());
							UserCollection.users.add(new_user);
						}
						else{
							JOptionPane.showMessageDialog(frame,"Password(re-type) is not same Password");
						}
					//}
				//}
				
				frame.setVisible(false);
				Login lp = new Login();
			}
		});
		btnNewButton.setBounds(114, 424, 132, 23);
		panel.add(btnNewButton);
		
		textPw = new JPasswordField();
		textPw.setBounds(140, 217, 132, 23);
		panel.add(textPw);
		
		textPwr = new JPasswordField();
		textPwr.setBounds(140, 251, 132, 23);
		panel.add(textPwr);
		frame.setVisible(true);
	}
}
