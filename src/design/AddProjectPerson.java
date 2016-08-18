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

import modelDM.ProjectPersonDM;

public class AddProjectPerson {
	JFrame frame;
	JPanel mainpanle;
	JButton Submit;



	JLabel signUpMainLable;

	JLabel ProjectNumber_Labple;
	JTextField ProjectNumber_Text;
	
	JLabel ProjectName_Labple;
	JTextField ProjectName_Text;
	


	public AddProjectPerson() {

		frame = new JFrame();
		mainpanle = new JPanel();
		Submit = new JButton("Add New ProjectPerson");

		signUpMainLable = new JLabel("ADD ProjectPerson");
		signUpMainLable.setFont(new Font("Verdana", Font.BOLD, 25));

		ProjectNumber_Labple = new JLabel(" Project Number");
		ProjectNumber_Text = new JTextField();
		ProjectNumber_Text.setHorizontalAlignment(JTextField.CENTER);

		
		ProjectName_Labple = new JLabel("Project Name");
		ProjectName_Text = new JTextField();
		ProjectName_Text.setHorizontalAlignment(JTextField.CENTER);


		Submit.addActionListener(actionListenerAdd);


		mainpanle.setLayout(null);

		mainpanle.add(Submit);


		mainpanle.add(signUpMainLable);

		mainpanle.setBackground(new Color(255, 255, 255));

		signUpMainLable.setBounds(200, 10, 200, 30);


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

		

		Submit.setBounds(200, 190, 190, 30);


		frame.setLayout(null);
		frame.add(mainpanle);
		mainpanle.setBounds(0, 0, 550, 400);

		frame.setSize(550, 400);
		frame.setResizable(false);
		frame.setLocation(400, 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Add ProjectPerson");
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new AddProjectPerson();

	}
	
	ActionListener actionListenerAdd = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ProjectPersonDM projectpersonDM = new ProjectPersonDM ();
			projectpersonDM.setProject_Number(ProjectNumber_Text.getText());
			projectpersonDM.setProject_Name(ProjectName_Text.getText());
			
			insertReqcordDB_Table(projectpersonDM);
			
			ProjectNumber_Text.setText("");
			ProjectName_Text.setText("");
			
			int x = JOptionPane.showConfirmDialog(null,
					"Are you want to Add New item ?");
			if (x==0 ){
				JOptionPane.showMessageDialog(null, "You Add Item Successfully .");
				
			}
			else{
				frame.setVisible(false);
				new ProjectPerson_Data_importing();
				
			}
			
		}
	};
	

	public void insertReqcordDB_Table(modelDM.ProjectPersonDM a) {

		System.out.println("in insert");

		try {
			System.out.println("in try insert");

			String sss = "insert into `database_task03`.`projetc_person` "
					+ "(ProjectNumber,ProjectName)" + "values (?,?)";

			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);

			st.setString(1, a.getProject_Number());
			st.setString(2, a.getProject_Name());
			

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
