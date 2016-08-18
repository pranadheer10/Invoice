package modelDM;

public class ProjectDataDM {
	
	private int ID;
	private String Client;
	private String Project;
	private String Number;
	private String StateDate;
	private String EndDate;
	private String Status;
	private String ProjectManager;
	private String ClientContact;
	private String Budget;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public String getClient() {
		return Client;
	}

	public void setClient(String client) {
		Client = client;
	}

	public String getProject() {
		return Project;
	}

	public void setProject(String project) {
		Project = project;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getStateDate() {
		return StateDate;
	}

	public void setStateDate(String stateDate) {
		StateDate = stateDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getProjectManager() {
		return ProjectManager;
	}

	public void setProjectManager(String projectManager) {
		ProjectManager = projectManager;
	}

	public String getClientContact() {
		return ClientContact;
	}

	public void setClientContact(String clientContact) {
		ClientContact = clientContact;
	}

	public String getBudget() {
		return Budget;
	}

	public void setBudget(String budget) {
		Budget = budget;
	}

	public String dataprint() {
		return ""
				+ "Client "
				+ getClient()
				+ "\nProject "
				+ getProject()
				+ "\nNumber "
				+ getNumber()
				+ "\nStateDate "
				+ getStateDate()
				+ "\nEndDate "
				+ getEndDate()
				+ "\nStatus "
				+ getStatus()
				+ "\nProjectManager "
				+ getProjectManager()
				+ "\nClientContact "
				+ getClientContact()
				+ "\nBudget "
				+ getBudget()

				+ "\n****************************************************************";
	}

	public String dataprint2() {
		return "" + "" + getClient() + " - " + getProject() + " - "
				+ getNumber() + " - " + getStateDate() + " - " + getEndDate()
				+ " - " + getStatus() + " - " + getProjectManager() + " - "
				+ getClientContact() + " - " + getBudget();

	}

}
