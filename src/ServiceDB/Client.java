package ServiceDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import modelDM.ClientDM;

import com.mysql.jdbc.PreparedStatement;

public class Client {

	ArrayList<String> Number;
	ArrayList<String> Name;
	ArrayList<String> AddressLine1;
	ArrayList<String> AddressLine2;

	ArrayList<String> City;
	ArrayList<String> State;
	ArrayList<String> zip;
	ArrayList<String> Email;
	ArrayList<String> Countact;
	ArrayList<String> InvoiceFreq;
	ArrayList<String> BillingTerms;
	ArrayList<String> InvoiceGrouping;

	public static String alldata = "";

	public static ArrayList<ClientDM> AllClientsDM;

	public void loadCoursesIntoLists() {
		Number = new ArrayList<String>();
		Name = new ArrayList<String>();
		AddressLine1 = new ArrayList<String>();
		AddressLine2 = new ArrayList<String>();
		City = new ArrayList<String>();
		State = new ArrayList<String>();
		zip = new ArrayList<String>();
		Email = new ArrayList<String>();
		Countact = new ArrayList<String>();
		InvoiceFreq = new ArrayList<String>();
		BillingTerms = new ArrayList<String>();
		InvoiceGrouping = new ArrayList<String>();

		AllClientsDM = new ArrayList<ClientDM>();

		File file = new File("client.txt");

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
					Number.add(data[0]);
				else
					Number.add("");
				if (data.length >= 2)
					Name.add(data[1]);
				else
					Name.add("");
				if (data.length >= 3)
					AddressLine1.add(data[2]);
				else
					AddressLine1.add("");
				if (data.length >= 4)
					AddressLine2.add(data[3]);
				else
					AddressLine2.add("");
				if (data.length >= 5)
					City.add(data[4]);
				else
					City.add("");
				if (data.length >= 6)
					State.add(data[5]);
				else
					State.add("");
				if (data.length >= 7)
					zip.add(data[6]);
				else
					zip.add("");
				if (data.length >= 8)
					Email.add(data[7]);
				else
					Email.add("");
				if (data.length >= 9)
					Countact.add(data[8]);
				else
					Countact.add("");
				if (data.length >= 10)
					InvoiceFreq.add(data[9]);
				else
					InvoiceFreq.add("");
				if (data.length >= 11)
					BillingTerms.add(data[10]);
				else
					BillingTerms.add("");
				if (data.length >= 12)
					InvoiceGrouping.add(data[11]);
				else
					InvoiceGrouping.add("");

			}
			for (int i = 0; i < Number.size(); i++) {
				ClientDM clientDM = new ClientDM();

				clientDM.setNumber(Number.get(i));
				clientDM.setName(Name.get(i));
				clientDM.setAddressLine1(AddressLine1.get(i));
				clientDM.setAddressLine2(AddressLine2.get(i));
				clientDM.setCity(City.get(i));
				clientDM.setState(State.get(i));
				clientDM.setZip(zip.get(i));
				clientDM.setEmail(Email.get(i));
				clientDM.setCountact(Countact.get(i));
				clientDM.setInvoiceFreq(InvoiceFreq.get(i));
				clientDM.setBillingTerms(BillingTerms.get(i));
				clientDM.setInvoiceGrouping(InvoiceGrouping.get(i));

				AllClientsDM.add(clientDM);
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

	static int number_row = 0;

	public ArrayList<ClientDM> GetAllDataListfromDB() throws ClassNotFoundException, SQLException {

		AllClientsDM = new ArrayList<ClientDM>();
		PreparedStatement st = (PreparedStatement) Conn.getconnection()
				.prepareStatement("SELECT * from `database_task03`.`client`");

		ResultSet result = st.executeQuery();
		result.last();
		number_row = result.getRow();

		number_row = 0;

		result.beforeFirst();
		ClientDM clientDM00;
		while (result.next()) {
			clientDM00 = new ClientDM();

			clientDM00.setNumber(result.getString("Number"));
			clientDM00.setName(result.getString("Name"));
			clientDM00.setAddressLine1(result.getString("AddressLine1"));
			clientDM00.setAddressLine2(result.getString("AddressLine2"));
			clientDM00.setCity(result.getString("City"));
			clientDM00.setState(result.getString("State"));
			clientDM00.setZip(result.getString("zip"));
			clientDM00.setEmail(result.getString("Email"));
			clientDM00.setCountact(result.getString("Countact"));
			clientDM00.setInvoiceFreq(result.getString("InvoiceFreq"));
			clientDM00.setBillingTerms(result.getString("BillingTerms"));
			clientDM00.setInvoiceGrouping(result.getString("InvoiceGrouping"));

			AllClientsDM.add(clientDM00);
			number_row++;
		}

		return AllClientsDM;
	}

	public void insertReqcordDB_Table(modelDM.ClientDM a) {

		System.out.println("in insert");

		try {
			System.out.println("in try insert");

			String sss = "insert into `database_task03`.`client` "
					+ "( Number,Name,AddressLine1,AddressLine2,City,State,zip,Email,Countact,InvoiceFreq,BillingTerms ,InvoiceGrouping )"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = (PreparedStatement) Conn.getconnection().prepareStatement(sss);
			st.setString(1, a.getNumber());
			st.setString(2, a.getName());
			st.setString(3, a.getAddressLine1());
			st.setString(4, a.getAddressLine2());
			st.setString(5, a.getCity());
			st.setString(6, a.getState());
			st.setString(7, a.getZip());
			st.setString(8, a.getEmail());
			st.setString(9, a.getCountact());
			st.setString(10, a.getInvoiceFreq());
			st.setString(11, a.getBillingTerms());
			st.setString(12, a.getInvoiceGrouping());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	/**
	 * @param ar
	 */
	public static void main(String ar[]) {

		
		Client clientService = new Client();
		
		try {
			for (ClientDM clientDM : clientService.GetAllDataListfromDB()) {
				System.out.println(clientDM.dataprint());

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
