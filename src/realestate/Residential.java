package realestate;

import java.util.HashMap;
import java.util.Set;

public abstract class Residential extends Property implements Biddable {
	/* Properties */
	private int bedCount;
	private int bathCount;
	private double sqFootage;
	private HashMap<String, Double> bids;
	
	/* Constructors */
	public Residential() { // default constructor
		super(); // calls Property default constructor
		bedCount = 0;
		bathCount = 0;
		sqFootage = 0;
		bids = new HashMap<String, Double>();
	} // Residential()
	
	public Residential(String sa, String z, int bd, int bt, double sf) { // parameter constructor
		super(sa, z);
		bedCount = bd;
		bathCount = bt;
		sqFootage = sf;
		bids = new HashMap<String, Double>();
	} // Residential(String, String, int, int, double)
	
	/* Accessor Methods */
	public int getBeds() { // read only access to bedCount attribute
		return bedCount;
	} // getBeds()
	
	public int getBaths() { // read only access to bathCount attribute
		return bathCount;
	} // getBaths()
	
	public double getSize() { // read only access to bedCount attribute
		return sqFootage;
	} // getSize()
	
	/* Mutator Methods */
	public int setBeds(int b) { // assigns the int argument to the bedCount attribute and returns it
		bedCount = b;
		return bedCount;
	} // setBeds()
	
	public int setBaths(int b) { // assigns the int argument to the bathCount attribute and returns it
		bathCount = b;
		return bathCount;
	} // setBaths()
	
	public double setSize(double s) { // assigns the double argument to the sqFootage attribute and returns it
		sqFootage = s;
		return sqFootage;
	} // setSize()

	/* Abstract Methods */
	public abstract double calculateAppraisalPrice();

	/* Overridden Methods */
	@Override
	public HashMap<String, Double> getBids() {
		return bids;
	} // end of getBids()

	@Override
	public Double getBid(String key) {
		return bids.get(key);
	} // end of getBid(String key)

	@Override
	public Set<String> getBidders() {
		return bids.keySet();
	} // end of getBidders()

	@Override
	public int getBidCount() {
		return bids.size();
	} // end of getBidCount()

	@Override
	public void newBid(String key, Double value) {
		if (bids.containsKey(key)) bids.replace(key, value);
		else bids.put(key, value);
	} // end of newBid(String key, Double value)
} // class Residential
