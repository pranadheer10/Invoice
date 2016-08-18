package modelDM;

public class ClientDM {

	
	private int ID;
	private String Number;
	private String Name;
	private String AddressLine1;
	private String AddressLine2;
	private String City;
	private String State;
	private String zip;
	private String Email;
	private String Countact;
	private String InvoiceFreq;
	private String BillingTerms;
	private String InvoiceGrouping;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
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
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCountact() {
		return Countact;
	}

	public void setCountact(String countact) {
		Countact = countact;
	}

	public String getInvoiceFreq() {
		return InvoiceFreq;
	}

	public void setInvoiceFreq(String invoiceFreq) {
		InvoiceFreq = invoiceFreq;
	}

	

	public String getBillingTerms() {
		return BillingTerms;
	}

	public void setBillingTerms(String billingTerms) {
		BillingTerms = billingTerms;
	}


	public String getInvoiceGrouping() {
		return InvoiceGrouping;
	}

	public void setInvoiceGrouping(String invoiceGrouping) {
		InvoiceGrouping = invoiceGrouping;
	}

	
	public String dataprint() {
		return "" + "Number "
				+ getNumber()
				+ "\nName "
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
				+ "\nEmail "
				+ getEmail()
				+ "\nCountact "
				+ getCountact()
				+ "\nInvoiceFreq "
				+ getInvoiceFreq()
				+ "\nBillingTerms "
				+ getBillingTerms()
				+ "\nInvoiceGrouping "
				+ getInvoiceGrouping()
				+ "\n****************************************************************";
	}

	public String dataprint2() {
		return "" + "" + getNumber() + " - " + getName() + " - "
				+ getAddressLine1() + " - " + getAddressLine2() + " - "
				+ getCity() + " - " + getState() + " - " + getZip() + " - "
				+ getEmail() + " - " + getCountact() + " - " + getInvoiceFreq()
				+ " - " + getBillingTerms() + " - " + getInvoiceGrouping() + "";
	}
	

}
