package ServiceDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelDM.PeopleDM;
import modelDM.ProjectPersonDM;

import com.mysql.jdbc.PreparedStatement;

public class ProjectPersonService {

	ArrayList<String> Project_Number;
	ArrayList<String> Project_Name;

	public static String alldata = "";

	public static ArrayList<ProjectPersonDM> AllProjectPersonDM;

	public void loadCoursesIntoLists() {

		Project_Number = new ArrayList<String>();
		Project_Name = new ArrayList<String>();

		AllProjectPersonDM = new ArrayList<ProjectPersonDM>();

		File file = new File("project_person.txt");

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
					Project_Number.add(data[0]);
				else
					Project_Number.add("");
				if (data.length >= 2)
					Project_Name.add(data[1]);
				else
					Project_Name.add("");

			}
			for (int i = 0; i < Project_Number.size(); i++) {
				ProjectPersonDM projectPersonDM = new ProjectPersonDM();

				projectPersonDM.setProject_Number(Project_Number.get(i));
				projectPersonDM.setProject_Name(Project_Name.get(i));

				AllProjectPersonDM.add(projectPersonDM);
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

	static int number_row = 0;

	public ArrayList<ProjectPersonDM> GetAllDataListfromDB()
			throws ClassNotFoundException, SQLException {

		AllProjectPersonDM = new ArrayList<ProjectPersonDM>();
		PreparedStatement st = (PreparedStatement) Conn.getconnection()
				.prepareStatement(
						"SELECT * from `database_task03`.`projetc_person`");

		ResultSet result = st.executeQuery();
		result.last();
		number_row = result.getRow();

		number_row = 0;

		result.beforeFirst();
		ProjectPersonDM ProjectPersonDM00;
		while (result.next()) {
			ProjectPersonDM00 = new ProjectPersonDM();

			ProjectPersonDM00.setProject_Number(result
					.getString("ProjectNumber"));
			ProjectPersonDM00.setProject_Name(result.getString("ProjectName"));

			AllProjectPersonDM.add(ProjectPersonDM00);
			number_row++;
		}

		return AllProjectPersonDM;
	}

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

	public static void main(String ar[]) {

//		 ProjectPersonService projectPersonService = new
//		 ProjectPersonService();
//		 projectPersonService.loadCoursesIntoLists();
//		 for (ProjectPersonDM projectPersonDM :
//		 projectPersonService.AllProjectPersonDM) {
//		 // System.out.println(courseDM.dataprint());
//		 projectPersonService.insertReqcordDB_Table(projectPersonDM);
//		
//		 }
		
		ProjectPersonService projectPersonService = new ProjectPersonService();

		try {
			for (ProjectPersonDM projectPersonDM : projectPersonService
					.GetAllDataListfromDB()) {
				// System.out.println(courseDM.dataprint());


				System.out.println(projectPersonDM.dataprint());

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}