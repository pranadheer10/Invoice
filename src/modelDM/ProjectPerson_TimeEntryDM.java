package modelDM;

public class ProjectPerson_TimeEntryDM {

	private int ID;
	private String Project_Number;
	private String Project_Name;

	private int totalHours;
	private int overTiem;

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public int getOverTiem() {
		return overTiem;
	}

	public void setOverTiem(int overTiem) {
		this.overTiem = overTiem;
	}

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
				+ "\nTotal_Hours "
				+ getTotalHours()
				+ "\nOVer_Time"
				+ getOverTiem()

				+ "\n****************************************************************";
	}

	public String dataprint2() {
		return "" + getProject_Number() + " - " + getProject_Name() + " - " + getTotalHours() + " - " + getOverTiem() + "";
	}
}



