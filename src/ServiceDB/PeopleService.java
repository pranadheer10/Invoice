package ServiceDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelDM.CompanyDM;
import modelDM.PeopleDM;

import com.mysql.jdbc.PreparedStatement;

public class PeopleService {

	ArrayList<String> Name;
	ArrayList<String> Title;
	ArrayList<String> Bill;

	ArrayList<String> Role;

	public static String alldata = "";

	public static ArrayList<PeopleDM> AllPeopleDM;

	public void loadCoursesIntoLists() {

		Name = new ArrayList<String>();
		Title = new ArrayList<String>();
		Bill = new ArrayList<String>();

		Role = new ArrayList<String>();

		AllPeopleDM = new ArrayList<PeopleDM>();

		File file = new File("people.txt");

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
					Name.add(data[0]);
				else
					Name.add("");
				if (data.length >= 2)
					Title.add(data[1]);
				else
					Title.add("");
				if (data.length >= 3)
					Bill.add(data[2]);
				else
					Bill.add("");

				if (data.length >= 4)
					Role.add(data[3]);
				else
					Role.add("");

			}
			for (int i = 0; i < Name.size(); i++) {
				PeopleDM peopleDM = new PeopleDM();

				peopleDM.setName(Name.get(i));
				peopleDM.setTitle(Title.get(i));
				peopleDM.setBillRate(Bill.get(i));

				peopleDM.setRole(Role.get(i));

				AllPeopleDM.add(peopleDM);
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

	static int number_row = 0;

	public ArrayList<PeopleDM> GetAllDataListfromDB()
			throws ClassNotFoundException, SQLException {

		AllPeopleDM = new ArrayList<PeopleDM>();
		PreparedStatement st = (PreparedStatement) Conn.getconnection()
				.prepareStatement("SELECT * from `database_task03`.`people`");

		ResultSet result = st.executeQuery();
		result.last();
		number_row = result.getRow();

		number_row = 0;

		result.beforeFirst();
		PeopleDM peopleDM00;
		while (result.next()) {
			peopleDM00 = new PeopleDM();

			peopleDM00.setName(result.getString("Name"));
			peopleDM00.setTitle(result.getString("Title"));
			peopleDM00.setBillRate(result.getString("BillRate"));
			peopleDM00.setRole(result.getString("Role"));

			AllPeopleDM.add(peopleDM00);
			number_row++;
		}

		return AllPeopleDM;
	}

	public void insertReqcordDB_Table(modelDM.PeopleDM a) {

		System.out.println("in insert");

		try {
			System.out.println("in try insert");

			String sss = "insert into `database_task03`.`people` "
					+ "(Name,Title,BillRate,Role)" + "values (?,?,?,?)";

			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);

			st.setString(1, a.getName());
			st.setString(2, a.getTitle());
			st.setString(3, a.getBillRate());
			st.setString(4, a.getRole());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	public static void main(String ar[]) {

		// PeopleService peopleService= new PeopleService();
		// peopleService.loadCoursesIntoLists();
		// for (PeopleDM peopleDM: peopleService.AllPeopleDM) {
		// // System.out.println(courseDM.dataprint());
		// peopleService.insertReqcordDB_Table(peopleDM);
		//
		// }

		PeopleService peopleService = new PeopleService();
		try {
			for (PeopleDM peopleDM : peopleService.GetAllDataListfromDB()) {
				System.out.println(peopleDM.dataprint());

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
