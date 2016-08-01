package Invoice;

/**
 * This are the line items in the invoice
 */
public class InvoiceLineItem {

	Invoice Invoice;
	/**
	 * This is the start date for the invoice
	 */
	private int StartDate;
	/**
	 * This is the end date for the invoice of the days worked
	 */
	private int EndDate;
	/**
	 * This shows the invoice description like name
	 */
	private String Description;
	/**
	 * This specifies the rate of each employee
	 */
	private int rate;
	/**
	 * This shows the number of hours for which invoice is generated
	 */
	private int Hours;
	/**
	 * This is the total amount of the invoice payment
	 */
	private int total;

	public int getStartDate() {
		// TODO - implement InvoiceLineItem.getStartDate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param StartDate
	 */
	public void setStartDate(int StartDate) {
		// TODO - implement InvoiceLineItem.setStartDate
		throw new UnsupportedOperationException();
	}

	public int getEndDate() {
		// TODO - implement InvoiceLineItem.getEndDate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param EndDate
	 */
	public void setEndDate(int EndDate) {
		// TODO - implement InvoiceLineItem.setEndDate
		throw new UnsupportedOperationException();
	}

	public String getDescription() {
		// TODO - implement InvoiceLineItem.getDescription
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Description
	 */
	public void setDescription(String Description) {
		// TODO - implement InvoiceLineItem.setDescription
		throw new UnsupportedOperationException();
	}

	public int getRate() {
		return this.rate;
	}

	/**
	 * 
	 * @param rate
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getHours() {
		// TODO - implement InvoiceLineItem.getHours
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Hours
	 */
	public void setHours(int Hours) {
		// TODO - implement InvoiceLineItem.setHours
		throw new UnsupportedOperationException();
	}

	public int getTotal() {
		return this.total;
	}

	/**
	 * 
	 * @param total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

}