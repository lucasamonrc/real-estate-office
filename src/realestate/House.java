package realestate;

public class House extends Residential {
	/* Attributes */
	private double yardAcres;
	
	/* Constructors */
	public House() { // default constructor
		super();
		yardAcres = 0.0;
	} // House()
	
	public House(String sa, String z, int bd, int bt, double sf, double y) { // parameter constructor
		super(sa, z, bd, bt, sf);
		yardAcres = y;
	} // House(String, String, int, int, double, double)
	
	/* Accessor Methods */
	public double getYardAcres() { // read only access to the yardAcres attribute
		return yardAcres;
	} // getYardAcres()
	
	/* Mutator Methods */
	public double setYardAcres(double y) { // assigns the double argument to the yardAcres attribute and returns it
		yardAcres = y;
		return yardAcres;
	} // setYardAcres()

	@Override
	public double calculateAppraisalPrice() {
		return (97f * getSize()) + (10000f * getBeds()) + (12000f * getBaths()) + (460000f * getYardAcres());
	} // end of calculateAppraisalPrice()

	@Override
	public String toString() {
		String space = " ";
		String str = "---------------------------------------------------------------------\n";

		/* String formatting */
		str += String.format("Residence Type: House %s Address: %-18s %s Zip Code: %5s", space, getStreetAddress(), space, getZip());
		str += "\n---------------------------------------------------------------------\n";
		str += String.format("Sq Footage: %.2f\nBedrooms: %d\nBathrooms: %d\nYard Size (Acres): %.2f", getSize(), getBeds(), getBaths(), getYardAcres());
		str += "\n------------------------------\n";
		str += String.format("Appraisal Price: $%,.2f\n", calculateAppraisalPrice());
		str += String.format("List Price: $%,.2f", getListPrice());
		str += "\n------------------------------\n";

		return str;
	} // end of toString()
}// class House