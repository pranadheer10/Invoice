package design;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import javax.swing.text.StyledEditorKit.BoldAction;

import com.mysql.jdbc.PreparedStatement;

import modelDM.PeopleDM;
import ServiceDB.Conn;
import ServiceDB.PeopleService;

public class People_Data_Importing {

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

	public People_Data_Importing() {
		frame = new JFrame();
		mainpanle = new JPanel();
		model = new DefaultListModel<>();
		scrollPane = new JScrollPane();

		sub_import_panel = new JPanel();
		sub_view_panel = new JScrollPane();
		cancel = new JButton("Cacel");
		submit = new JButton("Submit");
		liftLable = new JLabel("Import People Data");
		viewLable = new JLabel("View");
		import_B = new JButton("Import");
		importLable = new JLabel("Click On Import To Add People Record");
		dataArea = new JList<String>(model);
		scrollPane.setViewportView(dataArea);
		dataArea.setVisibleRowCount(7);

		add1 = new JButton("ADD");
		update = new JButton("Update");
		delete1 = new JButton("Delete");

		mainLable = new JLabel("People Data Importing");

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

		PeopleService peopleService = new PeopleService();
		try {
			for (PeopleDM peopleDM : peopleService.GetAllDataListfromDB()) {
				System.out.println(peopleDM.dataprint());

				model.addElement(peopleDM.dataprint2());
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
		frame.setTitle("People Data Importing");
		frame.setVisible(true);
	}

	ActionListener importAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.removeAllElements();
			PeopleService peopleService = new PeopleService();
			try {
				for (PeopleDM peopleDM : peopleService.GetAllDataListfromDB()) {
					System.out.println(peopleDM.dataprint());

					model.addElement(peopleDM.dataprint2());
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
			new AddPeople();
		}
	};

	ActionListener deleteAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (dataArea.getSelectedValue() != null) {
				try {
					String dd = dataArea.getSelectedValue();
					String arrdd[] = dd.split(" - ");
					String nameS = arrdd[0];
					String titleS = arrdd[1];

					// JOptionPane.showMessageDialog(null,
					// "You item Deleted Successfully .");
					int x = JOptionPane.showConfirmDialog(null,
							"Are you want to delete this Item ?");
					if (x == 0) {
						boolean checkresult = deleteRecord(nameS, titleS);
						if (checkresult) {
							JOptionPane.showMessageDialog(null,
									"You item Deleted Successfully .");
							model.removeAllElements();
							PeopleService peopleService = new PeopleService();
							try {
								for (PeopleDM peopleDM : peopleService
										.GetAllDataListfromDB()) {
									System.out.println(peopleDM.dataprint());

									model.addElement(peopleDM.dataprint2());
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
					String nameS = arrdd[0];
					String titleS = arrdd[1];

					int x = JOptionPane.showConfirmDialog(null,
							"Are you want to Update This Item ?");
					PeopleDM peopleDM0 = GetRecordFromDB(nameS, titleS) ;
					if (x == 0 &&peopleDM0 !=null) {
						frame.setVisible(false);
						new UpdatePeople(peopleDM0);
					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			} else
				JOptionPane.showMessageDialog(null,
						"Please Select item First !! ");
		}
	};

	public boolean deleteRecord(String name, String titel) {
		try {
			java.sql.Statement st = Conn.getconnection().createStatement();

			st.executeUpdate("delete from `database_task03`.`people` where Name = '"
					+ name + "' and Title = '" + titel + "'");
			Conn.getconnection().close();
			st.close();
			return true;
		} catch (Exception exception) {
			System.out.println(exception);
			return false;
		}

	}

	public PeopleDM GetRecordFromDB(String name, String title) {
		int number_row = 0;
		try {
			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(
							"SELECT * from `database_task03`.`people` where Name = '"
									+ name + "' and Title = '" + title + "'");

			ResultSet result = st.executeQuery();
			result.last();
			number_row = result.getRow();
			if (number_row >= 1) {
				result.beforeFirst();
				PeopleDM peopleDM00;
				while (result.next()) {
					peopleDM00 = new PeopleDM();

					peopleDM00.setName(result.getString("Name"));
					peopleDM00.setTitle(result.getString("Title"));
					peopleDM00.setBillRate(result.getString("BillRate"));
					peopleDM00.setRole(result.getString("Role"));
					peopleDM00.setID(result.getInt("idpeople"));

					return peopleDM00;

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
		new People_Data_Importing();

	}

}
