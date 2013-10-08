import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import services.UserServicesRemote;
import domaine.User;


public class userUpdate extends JFrame {

	private JPanel contentPane;
	private final Button button_1 = new Button("New button");
	private JTextField textPass;
	private JTextField textLogin;
	private JTextField textPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userUpdate frame = new userUpdate();
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
	public userUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Update an account ");
		lblNewLabel.setBounds(10, 11, 115, 14);
		contentPane.add(lblNewLabel);

		JLabel lblFristName = new JLabel("Frist Name :");
		lblFristName.setBounds(23, 47, 70, 14);
		contentPane.add(lblFristName);

		final JTextField textFristName = new JTextField();
		textFristName.setBounds(130, 44, 137, 20);
		contentPane.add(textFristName);
		textFristName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setBounds(23, 72, 70, 14);
		contentPane.add(lblLastName);

		final JTextField textLastName = new JTextField();
		textLastName.setBounds(130, 75, 137, 20);
		contentPane.add(textLastName);
		textLastName.setColumns(10);

		JLabel lblMailBox = new JLabel("Mail Box :");
		lblMailBox.setBounds(23, 112, 70, 14);
		contentPane.add(lblMailBox);

		final JTextField textMailBox = new JTextField();
		textMailBox.setBounds(130, 106, 137, 20);
		contentPane.add(textMailBox);
		textMailBox.setColumns(10);

		JLabel lblPassword = new JLabel("PassWord :");
		lblPassword.setBounds(23, 137, 70, 14);
		contentPane.add(lblPassword);

		JLabel lblLoca = new JLabel("Location :");
		lblLoca.setBounds(23, 162, 70, 14);
		contentPane.add(lblLoca);

		final JComboBox textLocation = new JComboBox();
		textLocation.setModel(new DefaultComboBoxModel(new String[] { "tunis",
				"nabeul" }));
		textLocation.setBounds(130, 159, 137, 20);
		contentPane.add(textLocation);

		JLabel lblDateofbirth = new JLabel("Login :");
		lblDateofbirth.setBounds(23, 187, 83, 14);
		contentPane.add(lblDateofbirth);
		
		JLabel lblStatut = new JLabel("Statut :");
		lblStatut.setBounds(23, 212, 88, 14);
		contentPane.add(lblStatut);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		textPass = new JTextField();
		textPass.setBounds(130, 137, 137, 20);
		contentPane.add(textPass);
		textPass.setColumns(10);
		
		textLogin = new JTextField();
		textLogin.setBounds(130, 184, 137, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		final JComboBox textStatut = new JComboBox();
		textStatut.setBounds(130, 209, 137, 20);
		contentPane.add(textStatut);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				try {
					Context context = new InitialContext();
					UserServicesRemote proxy = (UserServicesRemote) context
							.lookup("ejb:/tn.edu.esprit.piDevSeifProject/UserServices!services.UserServicesRemote");

					User user = new User();
					user.setIdUser(0);
					
					
					  
					  user.setFirstName(textFristName.getText());
				  user.setPhoneNumber(textPhone.getText());
			 user.setLastName(textLastName.getText());
			user.setMailBox(textMailBox.getText());
		    user.setPassWord(textPass.getText());
			user.setLocation(textLocation.getSelectedItem().toString());
		
		//	user.setLocation(textStatut.getSelectedItem().toString());	
					
					
					
					
					proxy.updateUser(user);

					
					
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
			}
		});
		btnUpdate.setBounds(322, 228, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblPhonenumber = new JLabel("PhoneNumber :");
		lblPhonenumber.setBounds(23, 232, 83, 14);
		contentPane.add(lblPhonenumber);
		
		textPhone = new JTextField();
		textPhone.setBounds(130, 229, 137, 20);
		contentPane.add(textPhone);
		textPhone.setColumns(10);

		
		
		
		
		
		Button button = new Button("Add");

	}
}
