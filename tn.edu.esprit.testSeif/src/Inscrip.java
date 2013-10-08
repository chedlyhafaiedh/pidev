import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PRIVATE_MEMBER;

import services.UserServicesRemote;
import domaine.User;

public class Inscrip extends JFrame {
	private static int i=10;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFristName;
	private JTextField textLastName;
	private JTextField textMailBox;
	private JPasswordField textPassword;
	private JTextField textLogin;
	private JTextField textPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
			
					
					
					
					Inscrip frame = new Inscrip();
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
	public Inscrip() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Create an account ");
		lblNewLabel.setBounds(10, 11, 115, 14);
		contentPane.add(lblNewLabel);

		JLabel lblFristName = new JLabel("Frist Name :");
		lblFristName.setBounds(23, 47, 70, 14);
		contentPane.add(lblFristName);

		textFristName = new JTextField();
		textFristName.setBounds(130, 44, 137, 20);
		contentPane.add(textFristName);
		textFristName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setBounds(23, 72, 70, 14);
		contentPane.add(lblLastName);

		textLastName = new JTextField();
		textLastName.setBounds(130, 75, 137, 20);
		contentPane.add(textLastName);
		textLastName.setColumns(10);

		JLabel lblMailBox = new JLabel("Mail Box :");
		lblMailBox.setBounds(23, 112, 70, 14);
		contentPane.add(lblMailBox);

		textMailBox = new JTextField();
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
		lblStatut.setBounds(23, 212, 46, 14);
		contentPane.add(lblStatut);

		final JComboBox textStatut = new JComboBox();
		textStatut.setModel(new DefaultComboBoxModel(new String[] { "married ",
				"divorced ", "single", "widowed" }));
		textStatut.setBounds(130, 209, 137, 20);
		contentPane.add(textStatut);

		Button button = new Button("Add");
		button.addActionListener(new ActionListener() {

			

			public void actionPerformed(ActionEvent arg0) {

			
				  try {
					  Context context = new InitialContext();
						UserServicesRemote proxy = (UserServicesRemote) context
								.lookup("tn.edu.esprit.piDevSeifProject/UserServices!services.UserServicesRemote");

				  User user = new User(); 
				  i++;
				  user.setIdUser(i);
				 

	
		
				System.out.println(textFristName.getText());
			//System.out.println(textLastName.getText());
			/*		System.out.println(textMailBox.getText());
		System.out.println(textDays.getSelectedIndex());
		  System.out.println(textDays.getSelectedItem().toString());
		System .out.println(textStatut.getSelectedItem().toString());*/
			  
				  
				  user.setFirstName(textFristName.getText());
			  
		 user.setLastName(textLastName.getText());
		 
		user.setMailBox(textMailBox.getText());
	    user.setPassWord(textPassword.getText());
	    user.setPhoneNumber(textPhone.getText());
	    user.setLogin(textLogin.getText());
	    user.setLocation(textLocation.getSelectedItem().toString());
		user.setStatut(textStatut.getSelectedItem().toString());
		 
				  proxy.addUser(user);
				  
				  } catch (Exception e) { // TODO Auto-generated catch
				  e.printStackTrace();
				  
				  
				  }
				 

			}

		}

		);
		button.setBounds(335, 230, 70, 22);
		contentPane.add(button);

		textPassword = new JPasswordField();
		textPassword.setBounds(130, 134, 137, 20);
		contentPane.add(textPassword);
		
		textLogin = new JTextField();
		textLogin.setBounds(130, 184, 137, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblPhonenumber = new JLabel("PhoneNumber :");
		lblPhonenumber.setBounds(10, 237, 83, 14);
		contentPane.add(lblPhonenumber);
		
		textPhone = new JTextField();
		textPhone.setBounds(130, 232, 137, 20);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
	}
}
