package modelDM;

public class CompanyDM {

	private int ID;
	private String Name;
	private String AddressLine1;
	private String AddressLine2;
	private String City;
	private String State;
	private String Zip;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String dataprint() {
		return ""
				+ "Name "
				+ getName()
				+ "\nAddressLine1 "
				+ getAddressLine1()
				+ "\nAddressLine2 "
				+ getAddressLine2()
				+ "\nCity "
				+ getCity()
				+ "\nState "
				+ getState()
				+ "\nZIP "
				+ getZip()
				+ "\n****************************************************************";
	}

	public String dataprint2() {
		return "" + getName() + " - " + getAddressLine1() + " - "
				+ getAddressLine2() + " - " + getCity() + " - " + getState()
				+ " - " + getZip() + "";
	}

}
