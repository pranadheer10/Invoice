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

import modelDM.PeopleDM;

public class AddPeople {
	JFrame frame;
	JPanel mainpanle;
	JButton Submit;


//	private String Name;
//	private String Title;
//	private String BillRate;
//	private String Role;


	JLabel signUpMainLable;

	JLabel Name_Labple;
	JTextField Name_Text;
	//
	JLabel Title_Labple;
	JTextField Title_Text;
	//
	JLabel BillRate_Labple;
	JTextField BillRate_Text;
	//

	JLabel Role_Labple;
	JTextField Role_Text;


	public AddPeople() {

		frame = new JFrame();
		mainpanle = new JPanel();
		Submit = new JButton("Add New People");

		signUpMainLable = new JLabel("ADD People");
		signUpMainLable.setFont(new Font("Verdana", Font.BOLD, 25));

		Name_Labple = new JLabel("Name");
		Name_Text = new JTextField();
		Name_Text.setHorizontalAlignment(JTextField.CENTER);

		// //
		Title_Labple = new JLabel("Title");
		Title_Text = new JTextField();
		Title_Text.setHorizontalAlignment(JTextField.CENTER);

		// //
		BillRate_Labple = new JLabel("Bill Rate");
		BillRate_Text = new JTextField();
		BillRate_Text.setHorizontalAlignment(JTextField.CENTER);

		// //


		// //
		Role_Labple = new JLabel("Role");
		Role_Text = new JTextField();
		Role_Text.setHorizontalAlignment(JTextField.CENTER);


		Submit.addActionListener(actionListenerAdd);


		mainpanle.setLayout(null);

		mainpanle.add(Submit);


		mainpanle.add(signUpMainLable);

		mainpanle.setBackground(new Color(255, 255, 255));

		signUpMainLable.setBounds(200, 10, 200, 30);

		Name_Labple.setBounds(100, 70, 100, 25);
		Name_Text.setBounds(200, 70, 200, 25);

		mainpanle.add(Name_Labple);
		mainpanle.add(Name_Text);

		// //
		Title_Labple.setBounds(100, 115, 100, 25);
		Title_Text.setBounds(200, 115, 200, 25);

		mainpanle.add(Title_Labple);
		mainpanle.add(Title_Text);

		// //
		BillRate_Labple.setBounds(100, 160, 100, 25);
		BillRate_Text.setBounds(200, 160, 200, 25);

		mainpanle.add(BillRate_Labple);
		mainpanle.add(BillRate_Text);

		// //


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


		Role_Labple.setBounds(100, 205, 100, 25);
		Role_Text.setBounds(200, 205, 200, 25);

		mainpanle.add(Role_Labple);
		mainpanle.add(Role_Text);




		Submit.setBounds(200, 300, 190, 30);


		frame.setLayout(null);
		frame.add(mainpanle);
		mainpanle.setBounds(0, 0, 550, 620);

		frame.setSize(550, 620);
		frame.setResizable(false);
		frame.setLocation(400, 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Add People");
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new AddPeople();

	}
	
	ActionListener actionListenerAdd = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			PeopleDM peopleDM = new PeopleDM ();
			peopleDM.setName(Name_Text.getText());
			peopleDM.setTitle(Title_Text.getText());
			peopleDM.setBillRate(BillRate_Text.getText());
			peopleDM.setRole(Role_Text.getText());
			
			insertReqcordDB_Table(peopleDM);
			
			Name_Text.setText("");
			Title_Text.setText("");
			BillRate_Text.setText("");
			Role_Text.setText("");

			int x = JOptionPane.showConfirmDialog(null,
					"Are you want to Add New item ?");
			if (x==0 ){
				JOptionPane.showMessageDialog(null, "You Add Item Successfully .");
			}
			else{
				frame.setVisible(false);
				new People_Data_Importing();
				
			}
			
		}
	};
	

	public void insertReqcordDB_Table(modelDM.PeopleDM a) {

		System.out.println("in insert");

		try {
			System.out.println("in try insert");

			String sss = "insert into `database_task03`.`people` "
					+ "(Name,Title,BillRate,Role)" + "values (?,?,?,?)";

			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);

			st.setString(1, a.getName());
			st.setString(2, a.getTitle());
			st.setString(3, a.getBillRate());
			st.setString(4, a.getRole());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
