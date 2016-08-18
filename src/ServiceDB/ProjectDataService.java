package ServiceDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelDM.ClientDM;
import modelDM.ProjectDataDM;

import com.mysql.jdbc.PreparedStatement;

public class ProjectDataService {

	ArrayList<String> Client;
	ArrayList<String> Project;
	ArrayList<String> Number;
	ArrayList<String> StateDate;

	ArrayList<String> EndDate;
	ArrayList<String> Status;
	ArrayList<String> ProjectManager;
	ArrayList<String> ClientContact;
	ArrayList<String> Budget;

	public static String alldata = "";

	public static ArrayList<ProjectDataDM> AllprojectDataDM;

	public void loadCoursesIntoLists() {
		Client = new ArrayList<String>();
		Project = new ArrayList<String>();
		Number = new ArrayList<String>();
		StateDate = new ArrayList<String>();
		EndDate = new ArrayList<String>();
		Status = new ArrayList<String>();
		ProjectManager = new ArrayList<String>();
		ClientContact = new ArrayList<String>();
		Budget = new ArrayList<String>();

		AllprojectDataDM = new ArrayList<ProjectDataDM>();

		File file = new File("project_data.txt");

		BufferedReader br = null;

		try {

			String sCurrentLine = "";

			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				if (br.readLine() == null) {
					break;
				}
				String data[] = sCurrentLine.split(",");

				if (data.length >= 1)
					Client.add(data[0]);
				else
					Client.add("");
				if (data.length >= 2)
					Project.add(data[1]);
				else
					Project.add("");
				if (data.length >= 3)
					Number.add(data[2]);
				else
					Number.add("");
				if (data.length >= 4)
					StateDate.add(data[3]);
				else
					StateDate.add("");
				if (data.length >= 5)
					EndDate.add(data[4]);
				else
					EndDate.add("");
				if (data.length >= 6)
					Status.add(data[5]);
				else
					Status.add("");
				if (data.length >= 7)
					ProjectManager.add(data[6]);
				else
					ProjectManager.add("");
				if (data.length >= 8)
					ClientContact.add(data[7]);
				else
					ClientContact.add("");
				if (data.length >= 9)
					Budget.add(data[8]);
				else
					Budget.add("");

			}
			for (int i = 0; i < Client.size(); i++) {
				ProjectDataDM projectDataDM = new ProjectDataDM();

				projectDataDM.setClient(Client.get(i));
				projectDataDM.setProject(Project.get(i));
				projectDataDM.setNumber(Number.get(i));
				projectDataDM.setStateDate(StateDate.get(i));
				projectDataDM.setEndDate(EndDate.get(i));
				projectDataDM.setStatus(Status.get(i));
				projectDataDM.setProjectManager(ProjectManager.get(i));
				projectDataDM.setClientContact(ClientContact.get(i));
				projectDataDM.setBudget(Budget.get(i));

				AllprojectDataDM.add(projectDataDM);
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

	static int number_row = 0;

	public ArrayList<ProjectDataDM> GetAllDataListfromDB()
			throws ClassNotFoundException, SQLException {

		AllprojectDataDM = new ArrayList<ProjectDataDM>();
		PreparedStatement st = (PreparedStatement) Conn.getconnection()
				.prepareStatement(
						"SELECT * from `database_task03`.`project_data`");

		ResultSet result = st.executeQuery();
		result.last();
		number_row = result.getRow();

		number_row = 0;

		result.beforeFirst();
		ProjectDataDM projectDataDM00;
		while (result.next()) {
			projectDataDM00 = new ProjectDataDM();

			projectDataDM00.setClient(result.getString("Client"));
			projectDataDM00.setProject(result.getString("Project"));
			projectDataDM00.setNumber(result.getString("Number"));
			projectDataDM00.setStateDate(result.getString("StateDate"));
			projectDataDM00.setEndDate(result.getString("EndDate"));
			projectDataDM00.setStatus(result.getString("Status"));
			projectDataDM00.setProjectManager(result
					.getString("ProjectManager"));
			projectDataDM00.setClientContact(result.getString("ClientContact"));
			projectDataDM00.setBudget(result.getString("Budget"));

			AllprojectDataDM.add(projectDataDM00);
			number_row++;
		}

		return AllprojectDataDM;
	}

	public void insertReqcordDB_Table(modelDM.ProjectDataDM a) {

		System.out.println("in insert");

		try {
			System.out.println("in try insert");

			String sss = "insert into `database_task03`.`project_data` "
					+ "( Client,Project,Number,StateDate,EndDate,Status,ProjectManager,ClientContact,Budget)"
					+ "values (?,?,?,?,?,?,?,?,?)";

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

	public static void main(String ar[]) {

		// ProjectDataService projectDataService = new ProjectDataService();
		// projectDataService.loadCoursesIntoLists();
		// for (ProjectDataDM projectDataDM :
		// projectDataService.AllprojectDataDM) {
		// // System.out.println(courseDM.dataprint());
		// projectDataService.insertReqcordDB_Table(projectDataDM);
		//
		// }

		ProjectDataService projectDataService = new ProjectDataService();

		try {
			for (ProjectDataDM projectDataDM : projectDataService
					.GetAllDataListfromDB()) {
				System.out.println(projectDataDM.dataprint());

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
