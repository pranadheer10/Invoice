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

import modelDM.ProjectDataDM;

public class UpdateProjectData {
	JFrame frame;
	JPanel mainpanle;
	JButton Submit;

	JLabel signUpMainLable;

	JLabel Client_Labple;
	JTextField Client_Text;

	JLabel Project_Labple;
	JTextField Project_Text;
	
	JLabel Number_Labple;
	JTextField Number_Text;
	
	JLabel StartDate_Labple;
	JTextField StartDate_Text;

	JLabel EndDate_Labple;
	JTextField EndDate_Text;
	
	JLabel Status_Labple;
	JTextField Status_Text;
	
	JLabel ProjectManager_Labple;
	JTextField ProjectManager_Text;
	
	JLabel ClientContact_Labple;
	JTextField ClientContact_Text;
	
	JLabel Budget_Labple;
	JTextField Budget_Text;
	
	
	public UpdateProjectData(ProjectDataDM projectdataDM) {

		frame = new JFrame();
		mainpanle = new JPanel();
		Submit = new JButton("Update New ProjectData");

		signUpMainLable = new JLabel("Update ProjectData");
		signUpMainLable.setFont(new Font("Verdana", Font.BOLD, 25));

		Client_Labple = new JLabel("Client");
		Client_Text = new JTextField(projectdataDM.getClient());
		Client_Text.setHorizontalAlignment(JTextField.CENTER);

		
		Project_Labple = new JLabel("Project");
		Project_Text = new JTextField(projectdataDM.getProject());
		Project_Text.setHorizontalAlignment(JTextField.CENTER);
		
		Number_Labple = new JLabel("Number");
		Number_Text = new JTextField(projectdataDM.getNumber());
		Number_Text.setHorizontalAlignment(JTextField.CENTER);
			

		StartDate_Labple = new JLabel("Start Date");
		StartDate_Text = new JTextField(projectdataDM.getStateDate());
		StartDate_Text.setHorizontalAlignment(JTextField.CENTER);
		
		EndDate_Labple = new JLabel("End Date");
		EndDate_Text = new JTextField(projectdataDM.getEndDate());
		EndDate_Text.setHorizontalAlignment(JTextField.CENTER);
		
		Status_Labple = new JLabel("Status");
		Status_Text = new JTextField(projectdataDM.getStatus());
		Status_Text.setHorizontalAlignment(JTextField.CENTER);
		
		ProjectManager_Labple = new JLabel("Project Manager");
		ProjectManager_Text = new JTextField(projectdataDM.getProjectManager());
		ProjectManager_Text.setHorizontalAlignment(JTextField.CENTER);
		
		ClientContact_Labple = new JLabel("Client Contact");
		ClientContact_Text = new JTextField(projectdataDM.getClientContact());
		ClientContact_Text.setHorizontalAlignment(JTextField.CENTER);
		
		Budget_Labple = new JLabel("Budget");
		Budget_Text = new JTextField(projectdataDM.getBudget());
		Budget_Text.setHorizontalAlignment(JTextField.CENTER);

		Submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean checkresult = UpdateRecord(projectdataDM);
				if (checkresult) {
					JOptionPane.showMessageDialog(null,
							"Your Recorde Updated Successfully .");
					frame.setVisible(false);
					new ProjectData_Data_importing();
				}
			}
		});

		mainpanle.setLayout(null);

		mainpanle.add(Submit);

		mainpanle.add(signUpMainLable);

		mainpanle.setBackground(new Color(255, 255, 255));

		signUpMainLable.setBounds(200, 10, 250, 30);

		Client_Labple.setBounds(100, 70, 100, 25);
		Client_Text.setBounds(200, 70, 200, 25);

		mainpanle.add(Client_Labple);
		mainpanle.add(Client_Text);

		
		Project_Labple.setBounds(100, 115, 100, 25);
		Project_Text.setBounds(200, 115, 200, 25);

		mainpanle.add(Project_Labple);
		mainpanle.add(Project_Text);
		
		Number_Labple.setBounds(100, 160, 100, 25);
		Number_Text.setBounds(200, 160, 200, 25);

		mainpanle.add(Number_Labple);
		mainpanle.add(Number_Text);


		StartDate_Labple.setBounds(100, 205, 100, 25);
		StartDate_Text.setBounds(200, 205, 200, 25);

		mainpanle.add(StartDate_Labple);
		mainpanle.add(StartDate_Text);
		
		EndDate_Labple.setBounds(100, 250, 100, 25);
		EndDate_Text.setBounds(200, 250, 200, 25);

		mainpanle.add(EndDate_Labple);
		mainpanle.add(EndDate_Text);
		
		Status_Labple.setBounds(100, 295, 100, 25);
		Status_Text.setBounds(200, 295, 200, 25);

		mainpanle.add(Status_Labple);
		mainpanle.add(Status_Text);
		
		ProjectManager_Labple.setBounds(100, 340, 100, 25);
		ProjectManager_Text.setBounds(200, 340, 200, 25);

		mainpanle.add(ProjectManager_Labple);
		mainpanle.add(ProjectManager_Text);

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

		ClientContact_Labple.setBounds(100, 385, 100, 25);
		ClientContact_Text.setBounds(200, 385, 200, 25);

		mainpanle.add(ClientContact_Labple);
		mainpanle.add(ClientContact_Text);
		
		Budget_Labple.setBounds(100, 430, 100, 25);
		Budget_Text.setBounds(200, 430, 200, 25);

		mainpanle.add(Budget_Labple);
		mainpanle.add(Budget_Text);


		Submit.setBounds(200, 480, 190, 30);

		frame.setLayout(null);
		frame.add(mainpanle);
		mainpanle.setBounds(0, 0, 550, 620);

		frame.setSize(550, 650);
		frame.setResizable(false);
		frame.setLocation(400, 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Update ProjectData");
		frame.setVisible(true);

	}

	public boolean UpdateRecord(ProjectDataDM a) {

		try {
			String sss = "update   `database_task03`.`project_data` set Client = ?,Project = ?,Number = ?,StateDate = ?,EndDate = ?,Status = ?,ProjectManager = ?,ClientContact = ?,Budget = ?  where idproject_data = "
					+ a.getID();

			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);
			st.setString(1, Client_Text.getText());
			st.setString(2, Project_Text.getText());
			st.setString(3, Number_Text.getText());
			st.setString(4, StartDate_Text.getText());
			st.setString(5, EndDate_Text.getText());
			st.setString(6, Status_Text.getText());
			st.setString(7, ProjectManager_Text.getText());
			st.setString(8, ClientContact_Text.getText());
			st.setString(9, Budget_Text.getText());

			st.executeUpdate();
//			JOptionPane.showMessageDialog(null, "Done");
			return true;
		} catch (Exception exception) {

			System.out.println(exception);
			return false;
		}

	}

	public static void main(String[] args) {
		new ProjectData_Data_importing();

	}

}
