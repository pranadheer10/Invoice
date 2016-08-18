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

import modelDM.ClientDM;

public class AddClient {
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

	public AddClient() {

		frame = new JFrame();
		mainpanle = new JPanel();
		Submit = new JButton("Add New Client");

		signUpMainLable = new JLabel("ADD Client");
		signUpMainLable.setFont(new Font("Verdana", Font.BOLD, 25));

		Number_Labple = new JLabel("Number");
		Number_Text = new JTextField();
		Number_Text.setHorizontalAlignment(JTextField.CENTER);

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

		Email_Labple = new JLabel("Email");
		Email_Text = new JTextField();
		Email_Text.setHorizontalAlignment(JTextField.CENTER);

		Countact_Labple = new JLabel("Countact");
		Countact_Text = new JTextField();
		Countact_Text.setHorizontalAlignment(JTextField.CENTER);

		InvoiceFreq_Labple = new JLabel("Invoice Frequency");
		InvoiceFreq_Text = new JTextField();
		InvoiceFreq_Text.setHorizontalAlignment(JTextField.CENTER);

		Billing_Labple = new JLabel("Billing");
		Billing_Text = new JTextField();
		Billing_Text.setHorizontalAlignment(JTextField.CENTER);

		InvoiceGrouping_Labple = new JLabel("Invoice Grouping");
		InvoiceGrouping_Text = new JTextField();
		InvoiceGrouping_Text.setHorizontalAlignment(JTextField.CENTER);

		Submit.addActionListener(actionListenerAdd);

		mainpanle.setLayout(null);

		mainpanle.add(Submit);

		mainpanle.add(signUpMainLable);

		mainpanle.setBackground(new Color(255, 255, 255));

		signUpMainLable.setBounds(200, 10, 200, 30);

		Number_Labple.setBounds(100, 70, 100, 25);
		Number_Text.setBounds(200, 70, 200, 25);

		mainpanle.add(Number_Labple);
		mainpanle.add(Number_Text);

		Button backk = new Button("Back");
		backk.setBounds(10, 10, 100, 25);
		mainpanle.add(backk);
		backk.addActionListener(new ActionListener() {
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
		frame.setTitle("Add Client");
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new AddClient();

	}

	ActionListener actionListenerAdd = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ClientDM clientDM = new ClientDM();
			clientDM.setName(Name_Text.getText());
			clientDM.setNumber(Number_Text.getText());
			clientDM.setAddressLine1(Address1_Text.getText());
			clientDM.setAddressLine2(Address2_Text.getText());
			clientDM.setCity(City_Text.getText());
			clientDM.setState(State_Text.getText());
			clientDM.setZip(ZIP_Text.getText());
			clientDM.setCountact(Countact_Text.getText());
			clientDM.setEmail(Email_Text.getText());
			clientDM.setInvoiceFreq(InvoiceFreq_Text.getText());
			clientDM.setBillingTerms(Billing_Text.getText());
			clientDM.setInvoiceGrouping(InvoiceGrouping_Text.getText());

			insertReqcordDB_Table(clientDM);

			Number_Text.setText("");
			Name_Text.setText("");
			Address1_Text.setText("");
			Address2_Text.setText("");
			City_Text.setText("");
			State_Text.setText("");
			ZIP_Text.setText("");
			Countact_Text.setText("");
			Email_Text.setText("");
			InvoiceFreq_Text.setText("");
			Billing_Text.setText("");
			InvoiceGrouping_Text.setText("");

			int x = JOptionPane.showConfirmDialog(null,
					"Are you want to Add New item ?");
			if (x == 0) {
				JOptionPane.showMessageDialog(null,
						"You Add Item Successfully .");
			} else {
				frame.setVisible(false);
				new Client_Data_Importing();

			}

		}
	};

	public void insertReqcordDB_Table(modelDM.ClientDM a) {

		System.out.println("in insert");

		try {
			System.out.println("in try insert");

			String sss = "insert into `database_task03`.`Client` "
					+ "(Number,Name,AddressLine1,AddressLine2,City,State,zip,Email,Countact,InvoiceFreq,BillingTerms,InvoiceGrouping)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);

			st.setString(1, a.getNumber());
			st.setString(2, a.getName());
			st.setString(3, a.getAddressLine1());
			st.setString(4, a.getAddressLine2());
			st.setString(5, a.getCity());
			st.setString(6, a.getState());
			st.setString(7, a.getZip());
			st.setString(8, a.getEmail());
			st.setString(9, a.getCountact());
			st.setString(10, a.getInvoiceFreq());
			st.setString(11, a.getBillingTerms());
			st.setString(12, a.getInvoiceGrouping());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
