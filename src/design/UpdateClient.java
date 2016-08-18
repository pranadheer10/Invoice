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

import modelDM.ClientDM;

public class UpdateClient {
	JFrame frame;
	JPanel mainpanle;
	JButton Submit;

	JLabel signUpMainLable;

	JLabel Number_Labple;
	JTextField Number_Text;

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
	
	JLabel Email_Labple;
	JTextField Email_Text;
	
	JLabel Countact_Labple;
	JTextField Countact_Text;
	
	JLabel InvoiceFreq_Labple;
	JTextField InvoiceFreq_Text;
	
	JLabel Billing_Labple;
	JTextField Billing_Text;
	
	JLabel InvoiceGrouping_Labple;
	JTextField InvoiceGrouping_Text;
	
	public UpdateClient(ClientDM clientDM) {

		frame = new JFrame();
		mainpanle = new JPanel();
		Submit = new JButton("Update New Client");

		signUpMainLable = new JLabel("Update Client");
		signUpMainLable.setFont(new Font("Verdana", Font.BOLD, 25));

		Number_Labple = new JLabel("Number");
		Number_Text = new JTextField(clientDM.getNumber());
		Number_Text.setHorizontalAlignment(JTextField.CENTER);
		
		Name_Labple = new JLabel("Name");
		Name_Text = new JTextField(clientDM.getName());
		Name_Text.setHorizontalAlignment(JTextField.CENTER);

		
		Address1_Labple = new JLabel("Address 1");
		Address1_Text = new JTextField(clientDM.getAddressLine1());
		Address1_Text.setHorizontalAlignment(JTextField.CENTER);

	

		Address2_Labple = new JLabel("Address 2");
		Address2_Text = new JTextField(clientDM.getAddressLine2());
		Address2_Text.setHorizontalAlignment(JTextField.CENTER);
		
		City_Labple = new JLabel("City");
		City_Text = new JTextField(clientDM.getCity());
		City_Text.setHorizontalAlignment(JTextField.CENTER);
		
		State_Labple = new JLabel("State");
		State_Text = new JTextField(clientDM.getState());
		State_Text.setHorizontalAlignment(JTextField.CENTER);
		
		ZIP_Labple = new JLabel("ZIP");
		ZIP_Text = new JTextField(clientDM.getZip());
		ZIP_Text.setHorizontalAlignment(JTextField.CENTER);
		
		Email_Labple = new JLabel("Email");
		Email_Text = new JTextField(clientDM.getEmail());
		Email_Text.setHorizontalAlignment(JTextField.CENTER);
		
		Countact_Labple = new JLabel("Countact");
		Countact_Text = new JTextField(clientDM.getCountact());
		Countact_Text.setHorizontalAlignment(JTextField.CENTER);
		
		InvoiceFreq_Labple = new JLabel("Invoice Frequency");
		InvoiceFreq_Text = new JTextField(clientDM.getInvoiceFreq());
		InvoiceFreq_Text.setHorizontalAlignment(JTextField.CENTER);
		
		Billing_Labple = new JLabel("Billing");
		Billing_Text = new JTextField(clientDM.getBillingTerms());
		Billing_Text.setHorizontalAlignment(JTextField.CENTER);
		
		InvoiceGrouping_Labple = new JLabel("Invoice Grouping");
		InvoiceGrouping_Text = new JTextField(clientDM.getInvoiceGrouping());
		InvoiceGrouping_Text.setHorizontalAlignment(JTextField.CENTER);

		Submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean checkresult = UpdateRecord(clientDM);
				if (checkresult) {
					JOptionPane.showMessageDialog(null,
							"Your Recorde Updated Successfully .");
					frame.setVisible(false);
					new Client_Data_Importing();
				}
			}
		});

		mainpanle.setLayout(null);

		mainpanle.add(Submit);

		mainpanle.add(signUpMainLable);

		mainpanle.setBackground(new Color(255, 255, 255));

		signUpMainLable.setBounds(200, 10, 250, 30);

		Number_Labple.setBounds(100, 70, 100, 25);
		Number_Text.setBounds(200, 70, 200, 25);

		mainpanle.add(Number_Labple);
		mainpanle.add(Number_Text);

		
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
		
		Email_Labple.setBounds(100, 385, 100, 25);
		Email_Text.setBounds(200, 385, 200, 25);

		mainpanle.add(Email_Labple);
		mainpanle.add(Email_Text);
		
		Countact_Labple.setBounds(100, 430, 100, 25);
		Countact_Text.setBounds(200, 430, 200, 25);

		mainpanle.add(Countact_Labple);
		mainpanle.add(Countact_Text);
		
		InvoiceFreq_Labple.setBounds(100, 475, 100, 25);
		InvoiceFreq_Text.setBounds(200, 475, 200, 25);

		mainpanle.add(InvoiceFreq_Labple);
		mainpanle.add(InvoiceFreq_Text);
		
		Billing_Labple.setBounds(100, 520, 100, 25);
		Billing_Text.setBounds(200, 520, 200, 25);

		mainpanle.add(Billing_Labple);
		mainpanle.add(Billing_Text);
		
		InvoiceGrouping_Labple.setBounds(100, 565, 100, 25);
		InvoiceGrouping_Text.setBounds(200, 565, 200, 25);

		mainpanle.add(InvoiceGrouping_Labple);
		mainpanle.add(InvoiceGrouping_Text);


		Submit.setBounds(200, 600, 190, 30);

		frame.setLayout(null);
		frame.add(mainpanle);
		mainpanle.setBounds(0, 0, 550, 620);

		frame.setSize(550, 720);
		frame.setResizable(false);
		frame.setLocation(400, 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Update Client");
		frame.setVisible(true);

	}

	public boolean UpdateRecord(ClientDM a) {

		try {
			String sss = "update   `database_task03`.`Client` set Number = ?,Name = ?,AddressLine1 = ?,AddressLine2 = ?,City = ?,State = ?,zip = ?,Email = ?,Countact = ?,InvoiceFreq = ?,BillingTerms = ?,InvoiceGrouping = ?  where idclient = "
					+ a.getID();

			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);
			st.setString(1, Number_Text.getText());
			st.setString(2, Name_Text.getText());
			st.setString(3, Address1_Text.getText());
			st.setString(4, Address2_Text.getText());
			st.setString(5, City_Text.getText());
			st.setString(6, State_Text.getText());
			st.setString(7, ZIP_Text.getText());
			st.setString(8, Email_Text.getText());
			st.setString(9, Countact_Text.getText());
			st.setString(10, InvoiceFreq_Text.getText());
			st.setString(11, Billing_Text.getText());
			st.setString(12, InvoiceGrouping_Text.getText());

			st.executeUpdate();
//			JOptionPane.showMessageDialog(null, "Done");
			return true;
		} catch (Exception exception) {

			System.out.println(exception);
			return false;
		}

	}

	public static void main(String[] args) {
		new Client_Data_Importing();

	}

}
