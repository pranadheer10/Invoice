package Invoice;

import java.util.*;

/**
 * This shows all the details of the project
 */
public class Project {

	/**
	 * Client has one or more projects
	 */
	Collection<client> clinet;
	Employee projectMember;
	/**
	 * This is the name of the project
	 */
	private String projectName;
	/**
	 * This the number for the project
	 */
	private int projectNumber;
	/**
	 * This is the project start date
	 */
	private int projectStartDate;
	/**
	 * This is the end date of the project
	 */
	private int projectEndDate;
	/**
	 * This is the client contact for the project
	 */
	private int projectClientContact;
	/**
	 * This is the total budget for the project
	 */
	private int projectBudget;

	public String getProjectName() {
		return this.projectName;
	}

	/**
	 * 
	 * @param projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectNumber() {
		return this.projectNumber;
	}

	/**
	 * 
	 * @param projectNumber
	 */
	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}

	public int getProjectStartDate() {
		return this.projectStartDate;
	}

	/**
	 * 
	 * @param projectStartDate
	 */
	public void setProjectStartDate(int projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public int getProjectEndDate() {
		return this.projectEndDate;
	}

	/**
	 * 
	 * @param projectEndDate
	 */
	public void setProjectEndDate(int projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public int getProjectClientContact() {
		return this.projectClientContact;
	}

	/**
	 * 
	 * @param projectClientContact
	 */
	public void setProjectClientContact(int projectClientContact) {
		this.projectClientContact = projectClientContact;
	}

	public int getProjectBudget() {
		return this.projectBudget;
	}

	/**
	 * 
	 * @param projectBudget
	 */
	public void setProjectBudget(int projectBudget) {
		this.projectBudget = projectBudget;
	}

}