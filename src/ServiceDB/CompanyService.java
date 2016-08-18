package ServiceDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelDM.ClientDM;
import modelDM.CompanyDM;

import com.mysql.jdbc.PreparedStatement;

public class CompanyService {

	ArrayList<String> Name;
	ArrayList<String> AddressLine1;
	ArrayList<String> AddressLine2;

	ArrayList<String> City;
	ArrayList<String> State;
	ArrayList<String> zip;

	public static String alldata = "";

	public static ArrayList<CompanyDM> AllCompanysDM;

	public void loadCoursesIntoLists() {

		Name = new ArrayList<String>();
		AddressLine1 = new ArrayList<String>();
		AddressLine2 = new ArrayList<String>();
		City = new ArrayList<String>();
		State = new ArrayList<String>();
		zip = new ArrayList<String>();

		AllCompanysDM = new ArrayList<CompanyDM>();

		File file = new File("company.txt");

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
					AddressLine1.add(data[1]);
				else
					AddressLine1.add("");
				if (data.length >= 3)
					AddressLine2.add(data[2]);
				else
					AddressLine2.add("");
				if (data.length >= 4)
					City.add(data[3]);
				else
					City.add("");
				if (data.length >= 5)
					State.add(data[4]);
				else
					State.add("");
				if (data.length >= 6)
					zip.add(data[5]);
				else
					zip.add("");

			}
			for (int i = 0; i < Name.size(); i++) {
				CompanyDM companyDM = new CompanyDM();

				companyDM.setName(Name.get(i));
				companyDM.setAddressLine1(AddressLine1.get(i));
				companyDM.setAddressLine2(AddressLine2.get(i));
				companyDM.setCity(City.get(i));
				companyDM.setState(State.get(i));
				companyDM.setZip(zip.get(i));

				AllCompanysDM.add(companyDM);
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

	static int number_row = 0;

	public ArrayList<CompanyDM> GetAllDataListfromDB()
			throws ClassNotFoundException, SQLException {

		AllCompanysDM = new ArrayList<CompanyDM>();
		PreparedStatement st = (PreparedStatement) Conn.getconnection()
				.prepareStatement("SELECT * from `database_task03`.`company`");

		ResultSet result = st.executeQuery();
		result.last();
		number_row = result.getRow();

		number_row = 0;

		result.beforeFirst();
		CompanyDM companyDM00;
		while (result.next()) {
			companyDM00 = new CompanyDM();

			companyDM00.setName(result.getString("Name"));
			companyDM00.setAddressLine1(result.getString("AddressLine1"));
			companyDM00.setAddressLine2(result.getString("AddressLine2"));
			companyDM00.setCity(result.getString("City"));
			companyDM00.setState(result.getString("State"));
			companyDM00.setZip(result.getString("zip"));

			AllCompanysDM.add(companyDM00);
			number_row++;
		}

		return AllCompanysDM;
	}

	public void insertReqcordDB_Table(modelDM.CompanyDM a) {

		System.out.println("in insert");

		try {
			System.out.println("in try insert");

			String sss = "insert into `database_task03`.`client` "
					+ "(Name,AddressLine1,AddressLine2,City,State,zip)"
					+ "values (?,?,?,?,?,?)";

			PreparedStatement st = (PreparedStatement) Conn.getconnection()
					.prepareStatement(sss);

			st.setString(1, a.getName());
			st.setString(2, a.getAddressLine1());
			st.setString(3, a.getAddressLine2());
			st.setString(4, a.getCity());
			st.setString(5, a.getState());
			st.setString(6, a.getZip());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	public static void main(String ar[]) {

		// CompanyService companyService= new CompanyService();
		// companyService.loadCoursesIntoLists();
		// for (CompanyDM companyDM : companyService.AllCompanysDM) {
		// // System.out.println(courseDM.dataprint());
		// companyService.insertReqcordDB_Table(companyDM);
		//
		// }

		CompanyService companyService = new CompanyService();
		try {
			for (CompanyDM companyDM : companyService.GetAllDataListfromDB()) {
				System.out.println(companyDM.dataprint());

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
