package Invoice;

/**
 * The time is shown
 */
public class Time {

	/**
	 * This is the date of the invoice
	 */
	private int date;
	/**
	 * This is the time of the invoice
	 */
	private int time;

	public int getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(int date) {
		this.date = date;
	}

	public int getTime() {
		return this.time;
	}

	/**
	 * 
	 * @param time
	 */
	public void setTime(int time) {
		this.time = time;
	}

}