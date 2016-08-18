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

import modelDM.ProjectPersonDM;

public class UpdateProjectPerson {
	JFrame frame;
	JPanel mainpanle;
	JButton Submit;

	JLabel signUpMainLable;

	JLabel ProjectNumber_Labple;
	JTextField ProjectNumber_Text;

	JLabel ProjectName_Labple;
	JTextField ProjectName_Text;

	public UpdateProjectPerson(ProjectPersonDM projectpersonDM) {

		frame = new JFrame();
		mainpanle = new JPanel();
		Submit = new JButton("Update New ProjectPerson");

		signUpMainLable = new JLabel("Update ProjectPerson");
		signUpMainLable.setFont(new Font("Verdana", Font.BOLD, 25));

		ProjectNumber_Labple = new JLabel("Project Number");
		ProjectNumber_Text = new JTextField(projectpersonDM.getProject_Number());
		ProjectNumber_Text.setHorizontalAlignment(JTextField.CENTER);

		ProjectName_Labple = new JLabel("Project Name");
		ProjectName_Text = new JTextField(projectpersonDM.getProject_Name());
		ProjectName_Text.setHorizontalAlignment(JTextField.CENTER);

		Submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean checkresult = UpdateRecord(projectpersonDM);
				if (checkresult) {
					JOptionPane.showMessageDialog(null,
							"Your Recorde Updated Successfully .");
					frame.setVisible(false);
					new ProjectPerson_Data_importing();
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
		backk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Admin_Page();
			}
		});

		ProjectNumber_Labple.setBounds(100, 70, 100, 25);
		ProjectNumber_Text.setBounds(200, 70, 200, 25);

		mainpanle.add(ProjectNumber_Labple);
		mainpanle.add(ProjectNumber_Text);

		ProjectName_Labple.setBounds(100, 115, 100, 25);
		ProjectName_Text.setBounds(200, 115, 200, 25);

		mainpanle.add(ProjectName_Labple);
		mainpanle.add(ProjectName_Text);

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

		Submit.setBounds(200, 190, 190, 30);

		frame.setLayout(null);
		frame.add(mainpanle);
		mainpanle.setBounds(0, 0, 550, 400);

		frame.setSize(550, 400);
		frame.setResizable(false);
		frame.setLocation(400, 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Update ProjectPerson");
		frame.setVisible(true);

	}

	public boolean UpdateRecord(ProjectPersonDM a) {

		try {
			String sss = "update   `database_task03`.`projetc_person` set ProjectNumber = ?,ProjectName = ?  where idprojetc_person = "
					+ a.getID();

			// JOptionPane.showMessageDialog(null, "ID " + a.getID());
			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);
			// st.setString(1, a.getProject_Number());
			// st.setString(2, a.getProject_Name());

			st.setString(1, ProjectNumber_Text.getText());
			st.setString(2, ProjectName_Text.getText());

			st.executeUpdate();
			// JOptionPane.showMessageDialog(null, "Done");
			return true;
		} catch (Exception exception) {

			System.out.println(exception);
			return false;
		}

	}

	public static void main(String[] args) {
		new ProjectPerson_Data_importing();

	}

}
