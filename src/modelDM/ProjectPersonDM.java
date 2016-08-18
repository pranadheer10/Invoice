package modelDM;

public class ProjectPersonDM {

	private int ID;
	private String Project_Number;
	private String Project_Name;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public String getProject_Number() {
		return Project_Number;
	}

	public void setProject_Number(String project_Number) {
		Project_Number = project_Number;
	}

	public String getProject_Name() {
		return Project_Name;
	}

	public void setProject_Name(String project_Name) {
		Project_Name = project_Name;
	}

	public String dataprint() {
		return ""
				+ "Project_Number "
				+ getProject_Number()
				+ "\nProject_Name "
				+ getProject_Name()

				+ "\n****************************************************************";
	}

	public String dataprint2() {
		return "" + getProject_Number() + " - " + getProject_Name() + "";
	}
}