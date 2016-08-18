package modelDM;

public class PeopleDM {

	private int ID;
	private String Name;
	private String Title;
	private String BillRate;
	private String Role;

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

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getBillRate() {
		return BillRate;
	}

	public void setBillRate(String billRate) {
		BillRate = billRate;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String dataprint() {
		return ""
				+ "Name "
				+ getName()
				+ "\nTitle "
				+ getTitle()
				+ "\nBill "
				+ getBillRate()

				+ "\nRole "
				+ getRole()

				+ "\n****************************************************************";
	}

	public String dataprint2() {
		return "" + getName() + " - " + getTitle() + " - " + getBillRate()
				+ " - " + getRole() + "";
	}

}
