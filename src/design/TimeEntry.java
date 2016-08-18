package design;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelDM.ProjectPerson_TimeEntryDM;
import ServiceDB.Conn;

import com.mysql.jdbc.PreparedStatement;




public class TimeEntry  {

	JFrame frame;
	JPanel mainpanle;
	JButton Submit;

	JLabel signUpMainLable;

	JLabel ProjectNumber_Labple;
	JTextField ProjectNumber_Text;

	JLabel ProjectName_Labple;
	JTextField ProjectName_Text;

	JLabel TotalHours_Labple;
	JTextField TotalHoursr_Text;

	JLabel OverTime_Labple;
	JTextField OverTime_Text;

	public TimeEntry() {

		frame = new JFrame();
		mainpanle = new JPanel();
		Submit = new JButton("Submit");

		signUpMainLable = new JLabel("Time Entry");
		signUpMainLable.setFont(new Font("Verdana", Font.BOLD, 25));

		ProjectNumber_Labple = new JLabel(" Project Number");
		ProjectNumber_Text = new JTextField();
		ProjectNumber_Text.setHorizontalAlignment(JTextField.CENTER);

		ProjectName_Labple = new JLabel("Project Name");
		ProjectName_Text = new JTextField();
		ProjectName_Text.setHorizontalAlignment(JTextField.CENTER);

		OverTime_Labple = new JLabel("Over Time");
		OverTime_Text = new JTextField("0");
		OverTime_Text.setHorizontalAlignment(JTextField.CENTER);

		TotalHours_Labple = new JLabel("Total Hours");
		TotalHoursr_Text = new JTextField("0");
		TotalHoursr_Text.setHorizontalAlignment(JTextField.CENTER);

		Submit.addActionListener(actionListenerAdd);
		TotalHoursr_Text.addKeyListener(keyListeneroverTime);
		mainpanle.setLayout(null);

		mainpanle.add(Submit);

		// mainpanle.add(signUpMainLable);

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

		
		signUpMainLable.setBounds(200, 10, 200, 30);

		ProjectNumber_Labple.setBounds(100, 70, 100, 25);
		ProjectNumber_Text.setBounds(200, 70, 200, 25);

		mainpanle.add(ProjectNumber_Labple);
		mainpanle.add(ProjectNumber_Text);

		ProjectName_Labple.setBounds(100, 115, 100, 25);
		ProjectName_Text.setBounds(200, 115, 200, 25);

		mainpanle.add(ProjectName_Labple);
		mainpanle.add(ProjectName_Text);

		//
		TotalHours_Labple.setBounds(100, 170, 100, 25);
		TotalHoursr_Text.setBounds(200, 170, 200, 25);

		mainpanle.add(TotalHours_Labple);
		mainpanle.add(TotalHoursr_Text);

		OverTime_Labple.setBounds(100, 215, 100, 25);
		OverTime_Text.setBounds(200, 215, 200, 25);

		mainpanle.add(OverTime_Labple);
		mainpanle.add(OverTime_Text);

		Submit.setBounds(200, 290, 190, 30);

		frame.setLayout(null);
		frame.add(mainpanle);
		mainpanle.setBounds(0, 0, 550, 500);

		frame.setSize(550, 500);
		frame.setResizable(false);
		frame.setLocation(400, 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Time Entry");
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new TimeEntry();

	}

	KeyListener keyListeneroverTime = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
//			JOptionPane.showMessageDialog(null, "--");

		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (!TotalHoursr_Text.getText().isEmpty()
					|| !TotalHoursr_Text.getText().equals("")) {
				if(Integer.parseInt(TotalHoursr_Text.getText())<=40){
					OverTime_Text.setText("0");
				}
				else{
					OverTime_Text.setText((Integer.parseInt(TotalHoursr_Text.getText())-40)+"");
				}
			}

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener actionListenerAdd = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ProjectPerson_TimeEntryDM projectPersonTimeEntryDM = new ProjectPerson_TimeEntryDM();
			projectPersonTimeEntryDM.setProject_Number(ProjectNumber_Text
					.getText());
			projectPersonTimeEntryDM
					.setProject_Name(ProjectName_Text.getText());
			projectPersonTimeEntryDM.setTotalHours(Integer
					.parseInt(TotalHoursr_Text.getText()));
			projectPersonTimeEntryDM.setOverTiem(Integer.parseInt(OverTime_Text
					.getText()));

			insertReqcordDB_Table(projectPersonTimeEntryDM);

			ProjectNumber_Text.setText("");
			ProjectName_Text.setText("");
			TotalHoursr_Text.setText("0");
			OverTime_Text.setText("0");

			int x = JOptionPane.showConfirmDialog(null,
					"Are you want to Add New item ?");
			if (x == 0) {
				JOptionPane.showMessageDialog(null,
						"You Add Item Successfully .");

			} else {
				frame.setVisible(false);
				// new ProjectPerson_Data_importing();

			}

		}
	};

	public void insertReqcordDB_Table(modelDM.ProjectPerson_TimeEntryDM a) {

		System.out.println("in insert");

		try {
			System.out.println("in try insert");

			String sss = "insert into `database_task03`.`projetc_person` "
					+ "(ProjectNumber,ProjectName , totalHours , overtime)"
					+ "values (?,? , ?,?)";

			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);

			st.setString(1, a.getProject_Number());
			st.setString(2, a.getProject_Name());
			st.setInt(3, a.getTotalHours());
			st.setInt(4, a.getOverTiem());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
