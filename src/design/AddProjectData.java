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

import modelDM.ProjectDataDM;

public class AddProjectData {
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
	


	public AddProjectData() {

		frame = new JFrame();
		mainpanle = new JPanel();
		Submit = new JButton("Add New ProjectData");

		signUpMainLable = new JLabel("ADD ProjectData");
		signUpMainLable.setFont(new Font("Verdana", Font.BOLD, 25));

				
		Client_Labple = new JLabel("Name");
		Client_Text = new JTextField();
		Client_Text.setHorizontalAlignment(JTextField.CENTER);

		
		Project_Labple = new JLabel("Address 1");
		Project_Text = new JTextField();
		Project_Text.setHorizontalAlignment(JTextField.CENTER);
		
		Number_Labple = new JLabel("Number");
		Number_Text = new JTextField();
		Number_Text.setHorizontalAlignment(JTextField.CENTER);
			

		StartDate_Labple = new JLabel("Address 2");
		StartDate_Text = new JTextField();
		StartDate_Text.setHorizontalAlignment(JTextField.CENTER);
		
		EndDate_Labple = new JLabel("City");
		EndDate_Text = new JTextField();
		EndDate_Text.setHorizontalAlignment(JTextField.CENTER);
		
		Status_Labple = new JLabel("State");
		Status_Text = new JTextField();
		Status_Text.setHorizontalAlignment(JTextField.CENTER);
		
		ProjectManager_Labple = new JLabel("ZIP");
		ProjectManager_Text = new JTextField();
		ProjectManager_Text.setHorizontalAlignment(JTextField.CENTER);
		
		ClientContact_Labple = new JLabel("Email");
		ClientContact_Text = new JTextField();
		ClientContact_Text.setHorizontalAlignment(JTextField.CENTER);
		
		Budget_Labple = new JLabel("Countact");
		Budget_Text = new JTextField();
		Budget_Text.setHorizontalAlignment(JTextField.CENTER);
		
		

		Submit.addActionListener(actionListenerAdd);


		mainpanle.setLayout(null);

		mainpanle.add(Submit);


		mainpanle.add(signUpMainLable);

		mainpanle.setBackground(new Color(255, 255, 255));

		signUpMainLable.setBounds(200, 10, 200, 30);

		
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
		frame.setTitle("Add ProjectData");
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new AddProjectData();

	}
	
	ActionListener actionListenerAdd = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ProjectDataDM ProjectDataDM = new ProjectDataDM ();
			ProjectDataDM.setClient(Client_Text.getText());
			ProjectDataDM.setProject(Project_Text.getText());
			ProjectDataDM.setNumber(Number_Text.getText());
			ProjectDataDM.setStateDate(StartDate_Text.getText());
			ProjectDataDM.setEndDate(EndDate_Text.getText());
			ProjectDataDM.setStatus(Status_Text.getText());
			ProjectDataDM.setProjectManager(ProjectManager_Text.getText());
			ProjectDataDM.setBudget(Budget_Text.getText());
			ProjectDataDM.setClientContact(ClientContact_Text.getText());
			
			
			
			insertReqcordDB_Table(ProjectDataDM);
			
			Number_Text.setText("");
			Client_Text.setText("");
			Project_Text.setText("");
			StartDate_Text.setText("");
			EndDate_Text.setText("");
			Status_Text.setText("");
			ProjectManager_Text.setText("");
			Budget_Text.setText("");
			ClientContact_Text.setText("");
			

			int x = JOptionPane.showConfirmDialog(null,
					"Are you want to Add New item ?");
			if (x==0 ){
				JOptionPane.showMessageDialog(null, "You Add Item Successfully .");
			}
			else{
				frame.setVisible(false);
				new ProjectData_Data_importing();
				
			}
			
		}
	};
	

	public void insertReqcordDB_Table(modelDM.ProjectDataDM a) {

		System.out.println("in insert");

		try {
			System.out.println("in try insert");

			String sss = "insert into `database_task03`.`project_data` "
					+ "(Client,Project,Number,StateDate,EndDate,Status,ProjectManager,ClientContact,Budget)" + "values (?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);

			
			st.setString(1, a.getClient());
			st.setString(2, a.getProject());
			st.setString(3, a.getNumber());
			st.setString(4, a.getStateDate());
			st.setString(5, a.getEndDate());
			st.setString(6, a.getStatus());
			st.setString(7, a.getProjectManager());
			st.setString(8, a.getClientContact());
			st.setString(9, a.getBudget());
			
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
