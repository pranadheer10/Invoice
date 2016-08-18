package design;

import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Admin_Page {
	JFrame frame;
	JPanel mainpanle;

	MenuBar menuBar;
	Menu maintinace;
	Menu Invoice;
	Menu Reports;
	Menu Help;

	Menu Generate_Invoice;
	Menu Forward_Invoice;
	Menu Test_Invoice;

	Menu Invoice_report;
	Menu Project_report;
	Menu Payroll_report;
	Menu Missing_time_Report;

	Menu Project_data;
	Menu Project_person_data;
	Menu people_data;
	Menu company_data;
	Menu Client_data;
	


	MenuItem importClient;
	MenuItem importProjectData;
	MenuItem importProjectPerson;
	MenuItem importPeople;
	MenuItem importCompany;

	Menu Get_started;
	Menu FAQ;

	ArrayList<String> sttudents;
	ArrayList<String> Facultys;

	public Admin_Page() {

		frame = new JFrame();
		mainpanle = new JPanel();

		menuBar = new MenuBar();
		maintinace = new Menu("Maintain");

		Get_started = new Menu("Get Started");
		FAQ = new Menu("FAQ's");

		Invoice = new Menu("Invoice");
		Reports = new Menu("Reports");
		Help = new Menu("Help");

		importClient = new MenuItem("importClient");
		importProjectData = new MenuItem("importProjectData");
		importProjectPerson = new MenuItem("importProjectPerson");
		importPeople = new MenuItem("importPeople");
		importCompany = new MenuItem("importCompany");

		Invoice_report = new Menu("Invoice report");
		Project_report = new Menu("Project report");
		Payroll_report = new Menu("Payroll report");
		Missing_time_Report = new Menu("Missing time Report");

		Generate_Invoice = new Menu("Generate Invoice");
		Forward_Invoice = new Menu("Forward Invoice");
		Test_Invoice = new Menu("Test Invoice");

		Project_data = new Menu("Project data");
		Project_person_data = new Menu("Project person data");
		people_data = new Menu("people data");
		company_data = new Menu("company data");
		Client_data = new Menu("Client data");

		Invoice.add(Generate_Invoice);
		Invoice.add(Forward_Invoice);
		Invoice.add(Test_Invoice);

		maintinace.add(Project_data);
		maintinace.add(Project_person_data);
		maintinace.add(people_data);
		maintinace.add(company_data);
		maintinace.add(Client_data);

		Project_data.add(importProjectData);
		Project_person_data.add(importProjectPerson);
		people_data.add(importPeople);
		company_data.add(importCompany);
		Client_data.add(importClient);

		Reports.add(Invoice_report);
		Reports.add(Project_report);
		Reports.add(Payroll_report);
		Reports.add(Missing_time_Report);

		menuBar.add(maintinace);
		menuBar.add(Invoice);
		menuBar.add(Reports);
		menuBar.add(Help);

		Help.add(Get_started);
		Help.add(FAQ);

		mainpanle.setLayout(null);

		importClient.addActionListener(actionListenerClient);
		importCompany.addActionListener(actionListenerCompany);
		importPeople.addActionListener(actionListenerPeople);
		importProjectData.addActionListener(actionListenerProjectData);
		importProjectPerson.addActionListener(actionListenerProjectPerson);

		mainpanle.setBackground(new Color(255, 255, 255));

		frame.setLayout(null);
		frame.add(mainpanle);
		mainpanle.setBounds(0, 0, 550, 620);
		frame.setMenuBar(menuBar);

		frame.setSize(550, 620);
		frame.setResizable(false);
		frame.setLocation(400, 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Admin Page");
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new Admin_Page();

	}

	ActionListener actionListenerProjectData = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new ProjectData_Data_importing();

		}
	};

	ActionListener actionListenerProjectPerson = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new ProjectPerson_Data_importing();

		}
	};

	ActionListener actionListenerClient = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new Client_Data_Importing();

		}
	};

	ActionListener actionListenerCompany = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new Company_Data_Importing();

		}
	};

	ActionListener actionListenerPeople = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new People_Data_Importing();

		}
	};
	

}
