package design;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.PreparedStatement;

import modelDM.ProjectDataDM;
import ServiceDB.Conn;
import ServiceDB.ProjectDataService;

public class ProjectData_Data_importing {

	JFrame frame;
	JPanel mainpanle;
	JButton submit;
	JButton cancel;
	JLabel liftLable;
	JLabel viewLable;
	JLabel importLable;
	JButton import_B;
	JPanel sub_import_panel;
	JScrollPane sub_view_panel;
	JList<String> dataArea;
	DefaultListModel<String> model;
	JLabel mainLable;
	JScrollPane scrollPane;

	JButton add1;
	JButton delete1;
	JButton update;

	public ProjectData_Data_importing() {
		frame = new JFrame();
		mainpanle = new JPanel();
		model = new DefaultListModel<>();
		scrollPane = new JScrollPane();

		sub_import_panel = new JPanel();
		sub_view_panel = new JScrollPane();
		cancel = new JButton("Cacel");
		submit = new JButton("Submit");
		liftLable = new JLabel("Import Project_Data Data");
		viewLable = new JLabel("View");
		import_B = new JButton("Import");
		importLable = new JLabel("Click On Import To Add ProjectData Record");
		dataArea = new JList<String>(model);
		scrollPane.setViewportView(dataArea);
		dataArea.setVisibleRowCount(7);

		add1 = new JButton("ADD");
		update = new JButton("Update");
		delete1 = new JButton("Delete");

		mainLable = new JLabel("ProjectData Data Importing");

		import_B.addActionListener(importAction);
		add1.addActionListener(addAction);
		update.addActionListener(updateAction);
		delete1.addActionListener(deleteAction);

		mainLable.setHorizontalAlignment(JTextField.CENTER);

		viewLable.setBackground(new Color(205, 205, 205));
		viewLable.setBorder(LineBorder.createGrayLineBorder());
		sub_view_panel.setBackground(new Color(245, 245, 245));

		mainpanle.setLayout(null);
		sub_import_panel.setLayout(null);
		// sub_view_panel.setLayout(null);

		mainpanle.add(submit);
		mainpanle.add(cancel);

		mainpanle.add(liftLable);

		mainpanle.add(add1);
		mainpanle.add(update);
		mainpanle.add(delete1);

		mainpanle.add(mainLable);
		mainpanle.add(sub_import_panel);
		mainpanle.add(sub_view_panel);

		sub_import_panel.add(import_B);
		sub_import_panel.add(importLable);

		mainpanle.add(viewLable);
		sub_view_panel.setViewportView(dataArea);

		// sub_view_panel.add(dataArea);
		mainpanle.setBackground(new Color(255, 255, 255));
		sub_import_panel.setBackground(new Color(205, 205, 205));
		mainLable.setFont(new Font("Verdana", Font.BOLD, 25));
		mainLable.setBounds(80, 30, 400, 30);

		add1.setBounds(90, 550, 100, 30);
		update.setBounds(220, 550, 100, 30);
		delete1.setBounds(350, 550, 100, 30);


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

		
		viewLable.setBounds(250, 220, 45, 20);
		import_B.setBounds(2, 5, 80, 30);
		importLable.setBounds(85, 5, 200, 30);

		liftLable.setBounds(30, 100, 200, 30);
		sub_import_panel.setBounds(200, 100, 300, 40);
		sub_view_panel.setBounds(30, 240, 480, 300);

		submit.setBounds(200, 180, 100, 30);
		cancel.setBounds(355, 180, 100, 30);

		ProjectDataService projectDataService = new ProjectDataService();

		try {
			for (ProjectDataDM projectDataDM : projectDataService
					.GetAllDataListfromDB()) {
				System.out.println(projectDataDM.dataprint());

				model.addElement(projectDataDM.dataprint2());
			}
		} catch (Exception e) {
			System.out.println(e);

		}

		frame.setLayout(null);
		frame.add(mainpanle);
		mainpanle.setBounds(0, 0, 550, 620);

		frame.setSize(550, 620);
		frame.setResizable(false);
		frame.setLocation(400, 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Project_Data Data Importing");
		frame.setVisible(true);
	}

	ActionListener importAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.removeAllElements();
			ProjectDataService projectDataService = new ProjectDataService();

			try {
				for (ProjectDataDM projectDataDM : projectDataService
						.GetAllDataListfromDB()) {
					System.out.println(projectDataDM.dataprint());

					model.addElement(projectDataDM.dataprint2());
				}
			} catch (Exception ee) {
				System.out.println(ee);

			}

		}

	};

	ActionListener addAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			 frame.setVisible(false);
			 new AddProjectData();
		}
	};

	ActionListener deleteAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (dataArea.getSelectedValue() != null) {
				try {
					String dd = dataArea.getSelectedValue();
					String arrdd[] = dd.split(" - ");
					String projectS = arrdd[1];
			
					int x = JOptionPane.showConfirmDialog(null,
							"Are you want to delete this Item ?");
					if (x == 0) {
						boolean checkresult = deleteRecord(projectS);
						if (checkresult) {
							JOptionPane.showMessageDialog(null,
									"You item Deleted Successfully .");
							model.removeAllElements();
							ProjectDataService projectdataservice = new ProjectDataService();
							try {
								for (ProjectDataDM projectdataDM : projectdataservice
										.GetAllDataListfromDB()) {
									System.out.println(projectdataDM.dataprint());

									model.addElement(projectdataDM.dataprint2());
								}
							} catch (Exception ee) {
								System.out.println(ee);

							}
						} else {
							JOptionPane.showMessageDialog(null,
									"You item Not Deleted .");

						}
					}
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			} else
				JOptionPane.showMessageDialog(null,
						"Please Select item First !! ");

		}
	};
	ActionListener updateAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (dataArea.getSelectedValue() != null) {
				try {
					String dd = dataArea.getSelectedValue();
					String arrdd[] = dd.split(" - ");
					String projectS = arrdd[1];

					int x = JOptionPane.showConfirmDialog(null,
							"Are you want to Update This Item ?");
					ProjectDataDM projectdataDM0 = GetRecordFromDB(projectS) ;
					if (x == 0 && projectdataDM0 !=null) {
						frame.setVisible(false);
						new UpdateProjectData(projectdataDM0);
					}


				} catch (Exception e1) {

					e1.printStackTrace();
				}

			} else
				JOptionPane.showMessageDialog(null,
						"Please Select item First !! ");
		}
	};
	
	public boolean deleteRecord(String project) {
		try {
			java.sql.Statement st = Conn.getconnection().createStatement();

			st.executeUpdate("delete from `database_task03`.`project_data` where Project = '" + project + "'");
			Conn.getconnection().close();
			st.close();
			return true;
		} catch (Exception exception) {
			System.out.println(exception);
			return false;
		}

	}
	
	public ProjectDataDM GetRecordFromDB(String project) {
		int number_row = 0;
		try {
			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(
							"SELECT * from `database_task03`.`project_data` where Project = '" + project + "'");

			ResultSet result = st.executeQuery();
			result.last();
			number_row = result.getRow();
			if (number_row >= 1) {
				result.beforeFirst();
				ProjectDataDM projectdataDM00;
				while (result.next()) {
					projectdataDM00 = new ProjectDataDM();
					
					
					projectdataDM00.setProject(result.getString("Project"));
					projectdataDM00.setClient(result.getString("Client"));
					projectdataDM00.setNumber(result.getString("Number"));
					projectdataDM00.setStateDate(result.getString("StateDate"));
					projectdataDM00.setEndDate(result.getString("EndDate"));
					projectdataDM00.setStatus(result.getString("Status"));
					projectdataDM00.setProjectManager(result.getString("ProjectManager"));
					projectdataDM00.setClientContact(result.getString("ClientContact"));
					projectdataDM00.setBudget(result.getString("Budget"));
					projectdataDM00.setID(result.getInt("idproject_data"));

					return projectdataDM00;

				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Error In select the record ..");
			}
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return null;
	}


	public static void main(String[] args) {
		new ProjectData_Data_importing();

	}

}