package realestate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Listings implements Listable {
    /* Attributes */
    private HashMap<String, Residential> listings;

    /* Constructor */
    public Listings() {
        listings = new HashMap<String, Residential>();
    } // end of Listings()

    /* Methods */

    // Takes no arguments and  returns a HashMap<String, Residential> containing a
        // list of street addresses (key) and their associated residences (value)
    @Override
    public HashMap<String, Residential> getListings() {
        return listings;
    } // end of getListings()

    // Takes a String argument and returns the Residential value for the
        // associated String key in a HashMap<String, Residential>
    @Override
    public Residential getListing(String key) {
        return listings.get(key);
    } // end of getListing(String key)

    // Takes no arguments and returns a Set<String> of keys from a HashMap<String, Residential>
    @Override
    public Set<String> getStreetAddresses() {
        return listings.keySet();
    } // end of getStreetAddresses()

    // Takes no arguments and returns a Collection<Residential> of values from a HashMap<String, Residential>
    @Override
    public Collection<Residential> getResidences() {
        return listings.values();
    } // end of getResidences()

    // Takes no arguments and returns the number of listings in the HashMap<String, Residential>
    @Override
    public int getListingCount() {
        return listings.size();
    } // end of getListingCount()

    // addListing(String, Residential) Returns void. Adds a new key/value pair in a HashMap<String, Residential>
    @Override
    public void addListing(String key, Residential value) {
        listings.put(key, value);
    } // end of addListing(String key, Residential value)
} // end of Listings