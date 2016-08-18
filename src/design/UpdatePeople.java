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

import modelDM.PeopleDM;

public class UpdatePeople {
	JFrame frame;
	JPanel mainpanle;
	JButton Submit;

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

	public UpdatePeople(PeopleDM peopleDM) {

		frame = new JFrame();
		mainpanle = new JPanel();
		Submit = new JButton("Update New People");

		signUpMainLable = new JLabel("Update People");
		signUpMainLable.setFont(new Font("Verdana", Font.BOLD, 25));

		Name_Labple = new JLabel("Name");
		Name_Text = new JTextField(peopleDM.getName());
		Name_Text.setHorizontalAlignment(JTextField.CENTER);

		// //
		Title_Labple = new JLabel("Title");
		Title_Text = new JTextField(peopleDM.getTitle());
		Title_Text.setHorizontalAlignment(JTextField.CENTER);

		// //
		BillRate_Labple = new JLabel("Bill Rate");
		BillRate_Text = new JTextField(peopleDM.getBillRate());
		BillRate_Text.setHorizontalAlignment(JTextField.CENTER);

		// //

		// //
		Role_Labple = new JLabel("Role");
		Role_Text = new JTextField(peopleDM.getRole());
		Role_Text.setHorizontalAlignment(JTextField.CENTER);

		Submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean checkresult = UpdateRecord(peopleDM);
				if (checkresult) {
					JOptionPane.showMessageDialog(null,
							"Your Recorde Updated Successfully .");
					frame.setVisible(false);
					new People_Data_Importing();
				}
			}
		});

		mainpanle.setLayout(null);

		mainpanle.add(Submit);

		mainpanle.add(signUpMainLable);

		mainpanle.setBackground(new Color(255, 255, 255));

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

		
		signUpMainLable.setBounds(200, 10, 250, 30);

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
		JButton back = new JButton("Back");
		mainpanle.add(back);
		back.setBounds(10, 10, 70, 25);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		frame.setTitle("Update People");
		frame.setVisible(true);

	}

	public boolean UpdateRecord(PeopleDM a) {

		try {
			String sss = "update   `database_task03`.`people` set Name = ?,Title = ? ,BillRate = ? ,Role = ?  where idpeople = "
					+ a.getID();

//			JOptionPane.showMessageDialog(null, "ID " + a.getID());
			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);
			st.setString(1, Name_Text.getText());
			st.setString(2, Title_Text.getText());
			st.setString(3, BillRate_Text.getText());
			st.setString(4, Role_Text.getText());

			st.executeUpdate();
//			JOptionPane.showMessageDialog(null, "Done");
			return true;
		} catch (Exception exception) {

			System.out.println(exception);
			return false;
		}

	}

	public static void main(String[] args) {
		new People_Data_Importing();

	}

}
