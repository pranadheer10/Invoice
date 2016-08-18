package design;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ServiceDB.Conn;

import com.mysql.jdbc.PreparedStatement;

import modelDM.CompanyDM;

public class AddCompany {
	JFrame frame;
	JPanel mainpanle;
	JButton Submit;


	JLabel signUpMainLable;
	

	JLabel Name_Labple;
	JTextField Name_Text;
	
	JLabel Address1_Labple;
	JTextField Address1_Text;
	
	JLabel Address2_Labple;
	JTextField Address2_Text;

	JLabel City_Labple;
	JTextField City_Text;
	
	JLabel State_Labple;
	JTextField State_Text;
	
	JLabel ZIP_Labple;
	JTextField ZIP_Text;


	public AddCompany() {

		frame = new JFrame();
		mainpanle = new JPanel();
		Submit = new JButton("Add New Company");

		signUpMainLable = new JLabel("ADD Company");
		signUpMainLable.setFont(new Font("Verdana", Font.BOLD, 25));

		
		Name_Labple = new JLabel("Name");
		Name_Text = new JTextField();
		Name_Text.setHorizontalAlignment(JTextField.CENTER);

		
		Address1_Labple = new JLabel("Address 1");
		Address1_Text = new JTextField();
		Address1_Text.setHorizontalAlignment(JTextField.CENTER);

	

		Address2_Labple = new JLabel("Address 2");
		Address2_Text = new JTextField();
		Address2_Text.setHorizontalAlignment(JTextField.CENTER);
		
		City_Labple = new JLabel("City");
		City_Text = new JTextField();
		City_Text.setHorizontalAlignment(JTextField.CENTER);
		
		State_Labple = new JLabel("State");
		State_Text = new JTextField();
		State_Text.setHorizontalAlignment(JTextField.CENTER);
		
		ZIP_Labple = new JLabel("ZIP");
		ZIP_Text = new JTextField();
		ZIP_Text.setHorizontalAlignment(JTextField.CENTER);


		Submit.addActionListener(actionListenerAdd);


		mainpanle.setLayout(null);

		mainpanle.add(Submit);


		mainpanle.add(signUpMainLable);

		mainpanle.setBackground(new Color(255, 255, 255));

		signUpMainLable.setBounds(200, 10, 200, 30);

		Name_Labple.setBounds(100, 115, 100, 25);
		Name_Text.setBounds(200, 115, 200, 25);

		mainpanle.add(Name_Labple);
		mainpanle.add(Name_Text);

		
		Address1_Labple.setBounds(100, 160, 100, 25);
		Address1_Text.setBounds(200, 160, 200, 25);

		mainpanle.add(Address1_Labple);
		mainpanle.add(Address1_Text);


		Button backk = new Button("Back");
		backk.setBounds(10, 10, 100, 25);
		mainpanle.add(backk);
		backk.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Admin_Page();
			}
		});



		Address2_Labple.setBounds(100, 205, 100, 25);
		Address2_Text.setBounds(200, 205, 200, 25);

		mainpanle.add(Address2_Labple);
		mainpanle.add(Address2_Text);
		
		City_Labple.setBounds(100, 250, 100, 25);
		City_Text.setBounds(200, 250, 200, 25);

		mainpanle.add(City_Labple);
		mainpanle.add(City_Text);
		
		State_Labple.setBounds(100, 295, 100, 25);
		State_Text.setBounds(200, 295, 200, 25);

		mainpanle.add(State_Labple);
		mainpanle.add(State_Text);
		
		ZIP_Labple.setBounds(100, 340, 100, 25);
		ZIP_Text.setBounds(200, 340, 200, 25);

		mainpanle.add(ZIP_Labple);
		mainpanle.add(ZIP_Text);
		

		Submit.setBounds(200, 400, 190, 30);


		frame.setLayout(null);
		frame.add(mainpanle);
		mainpanle.setBounds(0, 0, 550, 620);

		frame.setSize(550, 620);
		frame.setResizable(false);
		frame.setLocation(400, 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Add Company");
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new AddCompany();

	}
	
	ActionListener actionListenerAdd = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			CompanyDM companyDM = new CompanyDM ();
			companyDM.setName(Name_Text.getText());
			companyDM.setAddressLine1(Address1_Text.getText());
			companyDM.setAddressLine2(Address2_Text.getText());
			companyDM.setCity(City_Text.getText());
			companyDM.setState(State_Text.getText());
			companyDM.setZip(ZIP_Text.getText());
			
			
			insertReqcordDB_Table(companyDM);
			
			Name_Text.setText("");
			Address1_Text.setText("");
			Address2_Text.setText("");
			City_Text.setText("");
			State_Text.setText("");
			ZIP_Text.setText("");

			int x = JOptionPane.showConfirmDialog(null,
					"Are you want to Add New item ?");
			if (x==0 ){
				JOptionPane.showMessageDialog(null, "You Add Item Successfully .");
			}
			else{
				frame.setVisible(false);
				new Company_Data_Importing();
				
			}
			
		}
	};
	

	public void insertReqcordDB_Table(modelDM.CompanyDM a) {

		System.out.println("in insert");

		try {
			System.out.println("in try insert");

			String sss = "insert into `database_task03`.`company` "
					+ "(Name,AddressLine1,AddressLine2,City,State,Zip)" + "values (?,?,?,?,?,?)";

			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);

	
			st.setString(1, a.getName());
			st.setString(2, a.getAddressLine1());
			st.setString(3, a.getAddressLine2());
			st.setString(4, a.getCity());
			st.setString(5, a.getState());
			st.setString(6, a.getZip());
			

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
