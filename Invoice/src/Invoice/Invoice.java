package Invoice;

/**
 * This is the invoice for the employees
 */
public class Invoice {

	client Invoice;
	InvoiceLineItem InvoiceLineItem;
	/**
	 * This is the invoice number
	 */
	private int Number;
	/**
	 * This is the invoice date
	 */
	private int date;
	/**
	 * This is the number of hours for which invoice is generated
	 */
	private int hoursWorked;
	/**
	 * This is the invoice for the overload hours
	 */
	private int overloadHours;

	public void getAttribute() {
		// TODO - implement Invoice.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement Invoice.setAttribute
		throw new UnsupportedOperationException();
	}

	public int getNumber() {
		// TODO - implement Invoice.getNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Number
	 */
	public void setNumber(int Number) {
		// TODO - implement Invoice.setNumber
		throw new UnsupportedOperationException();
	}

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

	public int getHoursWorked() {
		return this.hoursWorked;
	}

	/**
	 * 
	 * @param hoursWorked
	 */
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public int getOverloadHours() {
		return this.overloadHours;
	}

	/**
	 * 
	 * @param overloadHours
	 */
	public void setOverloadHours(int overloadHours) {
		this.overloadHours = overloadHours;
	}

}