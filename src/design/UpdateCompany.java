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
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.BoldAction;

import ServiceDB.Conn;

import com.mysql.jdbc.PreparedStatement;

import modelDM.CompanyDM;

public class UpdateCompany {
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

	
	public UpdateCompany(CompanyDM CompanyDM) {

		frame = new JFrame();
		mainpanle = new JPanel();
		Submit = new JButton("Update New Company");

		signUpMainLable = new JLabel("Update Company");
		signUpMainLable.setFont(new Font("Verdana", Font.BOLD, 25));

		Name_Labple = new JLabel("Name");
		Name_Text = new JTextField(CompanyDM.getName());
		Name_Text.setHorizontalAlignment(JTextField.CENTER);

		
		Address1_Labple = new JLabel("Address 1");
		Address1_Text = new JTextField(CompanyDM.getAddressLine1());
		Address1_Text.setHorizontalAlignment(JTextField.CENTER);

	

		Address2_Labple = new JLabel("Address 2");
		Address2_Text = new JTextField(CompanyDM.getAddressLine2());
		Address2_Text.setHorizontalAlignment(JTextField.CENTER);
		
		City_Labple = new JLabel("City");
		City_Text = new JTextField(CompanyDM.getCity());
		City_Text.setHorizontalAlignment(JTextField.CENTER);
		
		State_Labple = new JLabel("State");
		State_Text = new JTextField(CompanyDM.getState());
		State_Text.setHorizontalAlignment(JTextField.CENTER);
		
		ZIP_Labple = new JLabel("ZIP");
		ZIP_Text = new JTextField(CompanyDM.getZip());
		ZIP_Text.setHorizontalAlignment(JTextField.CENTER);
		

		Submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean checkresult = UpdateRecord(CompanyDM);
				if (checkresult) {
					JOptionPane.showMessageDialog(null,
							"Your Recorde Updated Successfully .");
					frame.setVisible(false);
					new Company_Data_Importing();
				}
			}
		});

		mainpanle.setLayout(null);

		mainpanle.add(Submit);

		mainpanle.add(signUpMainLable);

		mainpanle.setBackground(new Color(255, 255, 255));

		signUpMainLable.setBounds(200, 10, 250, 30);


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

		Name_Labple.setBounds(100, 115, 100, 25);
		Name_Text.setBounds(200, 115, 200, 25);

		mainpanle.add(Name_Labple);
		mainpanle.add(Name_Text);

		
		Address1_Labple.setBounds(100, 160, 100, 25);
		Address1_Text.setBounds(200, 160, 200, 25);

		mainpanle.add(Address1_Labple);
		mainpanle.add(Address1_Text);



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
		frame.setTitle("Update Company");
		frame.setVisible(true);

	}

	public boolean UpdateRecord(CompanyDM a) {

		try {
			String sss = "update   `database_task03`.`company` set Name = ?,AddressLine1 = ?,AddressLine2 = ?,City = ?,State = ?,Zip = ? where idcompany = "
					+ a.getID();

			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);

			st.setString(1, Name_Text.getText());
			st.setString(2, Address1_Text.getText());
			st.setString(3, Address2_Text.getText());
			st.setString(4, City_Text.getText());
			st.setString(5, State_Text.getText());
			st.setString(6, ZIP_Text.getText());
			

			st.executeUpdate();
//			JOptionPane.showMessageDialog(null, "Done");
			return true;
		} catch (Exception exception) {

			System.out.println(exception);
			return false;
		}

	}

	public static void main(String[] args) {
		new Company_Data_Importing();

	}

}
