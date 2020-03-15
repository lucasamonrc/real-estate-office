package realestate;

public abstract class Property {
	/* Properties */
	private String streetAddress;
	private String zip;
	private double listPrice;
	private double appraisalPrice;
	
	/* Constructors */
	public Property() { // default constructor;
		streetAddress = "";
		zip = "";
	} // Property()
	
	public Property(String sa, String z) { // parameter constructor;
		streetAddress = sa;
		zip = z;
	} // Property(String, String)
	
	/* Accessor Methods */
	public String getStreetAddress() { // read only access to the streetAddress attribute
		return streetAddress;
	} // getStreetAddress()
	
	public String getZip() { // read only access to the zip attribute
		return zip;
	} // getZip()

	public double getListPrice() { return listPrice; }

	public double getAppraisalPrice() { return appraisalPrice; }

	/* Mutator Methods */
	public String setStreetAddress(String sa) { // assigns the String argument to the streetAddress attribute and returns it
		streetAddress = sa;
		return streetAddress;
	} // setStreetAddress()
	
	public String setZip(String z) { // assigns the String argument to the zip attribute and returns it
		zip = z;
		return zip;
	} // setZip()

	public double setListPrice(double lp) {
		listPrice = lp;
		return listPrice;
	}

	protected double setAppraisalPrice(double ap) {
		appraisalPrice = ap;
		return appraisalPrice;
	}

	public abstract double calculateAppraisalPrice();

} // class Property
