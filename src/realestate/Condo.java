package realestate;

public class Condo extends Residential {
	/* Attributes */
	private int floorLvl;
	
	/* Constructors */
	public Condo() { // default constructor
		super();
		floorLvl = 0;
	} // Condo()

	public Condo(String sa, String z, int bd, int bt, double sf, int f) { // parameter constructor
		super(sa, z, bd, bt, sf);
		floorLvl = f;
	} // Condo(String, String, int, int, double, int)

	/* Accessor Methods */
	public int getFloorLvl() { // read only access to the floorLvl attribute
		return floorLvl;
	} // getFloorLvl()

	/* Mutator Methods */
	public int setFloorLvl(int f) { // assigns the int argument to the floorLvl attribute and returns it
		floorLvl = f;
		return floorLvl;
	} // setFloorLvl()

	@Override
	public double calculateAppraisalPrice() {
		return (88f * getSize()) + (8000f * getBeds()) + (10000f * getBaths()) + ((floorLvl - 1) * 5000f);
	} // end of calculateAppraisalPrice()

	@Override
	public String toString() {
		String space = " ";
		String str = "---------------------------------------------------------------------\n";

		/* String formatting */
		str += String.format("Residence Type: Condo %s Address: %-18s %s Zip Code: %5s", space, getStreetAddress(), space, getZip());
		str += "\n---------------------------------------------------------------------\n";
		str += String.format("Sq Footage: %.2f\nBedrooms: %d\nBathrooms: %d\nFloor: %d", getSize(), getBeds(), getBaths(), getFloorLvl());
		str += "\n------------------------------\n";
		str += String.format("Appraisal Price: $%,.2f\n", calculateAppraisalPrice());
		str += String.format("List Price: $%,.2f", getListPrice());
		str += "\n------------------------------\n";

		return str;
	} // end of toString()
}// class Condo
