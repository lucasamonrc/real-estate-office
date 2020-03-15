package realestate;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class REO {
    /* Global Attribute */
    private static Listings listings = new Listings();

    // This method implements the Menu for the REO system,
        // it takes a scanner and returns a boolean to terminate the process if necessary
    private static boolean mainMenu(Scanner sc) {
        boolean done = false;
        while (!done) {
            /* Output Menu */
            System.out.println("\n----------------------------------------");
            System.out.printf("%24s\n", "Main Menu");
            System.out.println("----------------------------------------");
            System.out.println("1: Listings\n2: Bids\n");
            System.out.print("What would you like to do? (1-2): ");
            String in = sc.nextLine();

            // Switch on in, call respective method.
            switch (in) {
                case "1":
                    listingMenu(sc);
                    break;
                case "2":
                    bidsMenu(sc);
                    break;
                case "close":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            } // end of switch (in)
        } // end of while (!done)
        return true;
    } // end of mainMenu(Scanner sc)

    /* This method implements the submenu for listings. When done, it returns to the mainMenu() method */
    private static void listingMenu(Scanner sc) {
        boolean done = false;
        while (!done) {
            /* output menu */
            System.out.println("\n----------------------------------------");
            System.out.printf("%26s\n", "Listing Menu");
            System.out.println("----------------------------------------");
            System.out.println("1: Add Listings\n2: Show Listings\n3: Auto Populate Listing (Dev tool)");
            System.out.println("ENTER: Exit back to previous menu\n");
            System.out.print("What would you like to do? (1-3): ");
            String in = sc.nextLine();

            // switch on in, call respective method
            switch (in) {
                case "1":
                    addListingMenu(sc);
                    break;
                case "2":
                    showListings();
                case "3":
                    autoPopulate();
                    break;
                case "":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            } // end of switch (in)
        } // end of while (!done)
    } // end of listingMenu(Scanner sc)

    /* This method implements the submenu for  adding listings. When done, it returns to the listingMenu() method */
    private static void addListingMenu(Scanner sc) {
        boolean done = false;
        while (!done) {
            /* output menu */
            System.out.println("\n----------------------------------------");
            System.out.printf("%28s\n", "Add Listing Menu");
            System.out.println("----------------------------------------");
            System.out.println("1: Add House\n2: Add Condo\nENTER: Exit back to previous menu\n");
            System.out.print("What would you like to do? (1-2): ");
            String in = sc.nextLine();

            // switch on in, call respective method
            switch (in) {
                case "1":
                    addResidence("HOUSE", sc);
                    break;
                case "2":
                    addResidence("CONDO", sc);
                    break;
                case "":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            } // end of switch (in)
        } // end of while (!done)
    } // end of addListingMenu(Scanner sc)

    private static void addResidence(String type, Scanner sc) {
        System.out.print("\nPlease enter the street address for the residence: ");
        String address = sc.nextLine();

        System.out.print("Please enter the zip code for the residence: ");
        String zip = sc.nextLine();

        int bedrooms = (int) getNum("Please enter the number of bedrooms: ", "Invalid number.", sc);
        int bathrooms = (int) getNum("Please enter the number of bathrooms: ", "Invalid number.", sc);
        double sqrFt = getNum("Please enter the square footage of the residence: ", "Invalid number.", sc);

        // Residence Type-specific promptings
        if (type.equals("HOUSE")) {
            double yardAcr = getNum("Please enter the size of the yard in acres: ", "Invalid number.", sc);
            House h = new House(address, zip, bedrooms, bathrooms, sqrFt, yardAcr);
            listings.addListing(address, h);
            System.out.printf("Appraisal Price for this property is: $%,.2f\n", h.calculateAppraisalPrice());
            double listPrice = getNum("Please enter the List Price for the property: $", "Invalid number", sc);
            h.setListPrice(listPrice);
        } // end of if (type.equals("HOUSE")
        else if (type.equals("CONDO")) {
            int floorLvl = (int) getNum("Please enter the floor level of the condo: ", "Invalid number.", sc);
            Condo c = new Condo(address, zip, bedrooms, bathrooms, sqrFt, floorLvl);
            listings.addListing(address, c);
            System.out.printf("Appraisal Price for this property is: $%,.2f\n", c.calculateAppraisalPrice());
            double listPrice = getNum("Please enter the List Price for the property: $", "Invalid number", sc);
            c.setListPrice(listPrice);
        } // end of else if (type.equals("CONDO")
    } // end of addResidence(String type, Scanner sc)

    private static void autoPopulate() {
        int currentSize = listings.getListingCount();

        House house1 = new House("34 Elm","95129", 3, 2, 2200, .2);
        house1.setListPrice(house1.calculateAppraisalPrice() * 1.1);
        listings.addListing("34 Elm", house1);

        House house2 = new House("42 Hitchhikers","95136", 4, 3, 2800, .3);
        house2.setListPrice(house2.calculateAppraisalPrice() * 1.1);
        listings.addListing("42 Hitchhikers", house2);

        Condo condo1 = new Condo("4876 Industrial", "95177", 3, 1, 1800, 3);
        condo1.setListPrice(condo1.calculateAppraisalPrice() * 1.1);
        listings.addListing("4876 Industrial", condo1);

        House house3 = new House("2654 Oak","84062", 5, 53, 4200, .5);
        house3.setListPrice(house3.calculateAppraisalPrice() * 1.1);
        listings.addListing("2654 Oak", house3);

        Condo condo2 = new Condo("9875 Lexington","84063", 2, 1, 1500, 1);
        condo2.setListPrice(condo2.calculateAppraisalPrice() * 1.1);
        listings.addListing("9875 Lexington", condo2);

        Condo condo3 = new Condo("3782 Market", "84066", 3, 1, 1800, 2);
        condo3.setListPrice(condo3.calculateAppraisalPrice() * 1.1);
        listings.addListing("3782 Market", condo3);

        House house4 = new House("7608 Glenwood", "84055", 6, 3, 3900, .4);
        house4.setListPrice(house4.calculateAppraisalPrice() * 1.1);
        listings.addListing("7608 Glenwood", house4);

        House house5 = new House("1220 Apple", "84057", 8, 7, 7900, 1);
        house5.setListPrice(house5.calculateAppraisalPrice() * 1.1);
        listings.addListing("1220 Apple", house5);

        System.out.println("\n" + (listings.getListingCount() - currentSize) + " listings were auto-generated.");
    } // end of autoPopulate()

    private static void showListings() {
        int counter = 1;
        System.out.println();
        for (String address : listings.getStreetAddresses()) {
            System.out.println("Listing No. " + counter);
            System.out.println(listings.getListing(address));
            counter++;
        } // end of for (String addresses : listings.getStreetAddresses())
    } // end of showListings()

    /* This method implements the submenu for bid. When done, it returns to the mainMenu() method */
    private static void bidsMenu(Scanner sc) {
        boolean done = false;
        while (!done) {
            /* output menu */
            System.out.println("\n----------------------------------------");
            System.out.printf("%24s\n", "Bids Menu");
            System.out.println("----------------------------------------");
            System.out.println("1: Add New Bid\n2: Show Existing Bids\n3: Auto Populate Bids (Dev tool)");
            System.out.println("ENTER: Exit back to previous menu\n");
            System.out.print("What would you like to do? (1-3): ");
            String in = sc.nextLine();

            // switch on in, call respective method
            switch (in) {
                case "1":
                    newBid(sc);
                    break;
                case "2":
                    showBids(sc);
                    break;
                case "3":
                    autoBids();
                    break;
                case "":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            } // end of switch (in)
        } // end of while (!done)
    } // end of bidsMenu(Scanner sc)

    private static HashMap<String, String> currentListingsMenu() {
        HashMap<String, String> menu = new HashMap<String, String>();
        int option = 1;

        for (String address : listings.getStreetAddresses()) {
            System.out.printf("%d: %s (%d)\n", option, address, listings.getListing(address).getBidCount());

            String str = Integer.toString(option);
            menu.put(str, address);

            option++;
        } // end of for (String address : listings.getStreetAddresses())

        System.out.println("ENTER: Exit back to previous menu\n");
        return menu;
    }
    // todo: bids module
    private static void newBid(Scanner sc) {
        HashMap<String, String> menu;
        boolean done = false;

        System.out.println("\n\nCurrent Listings for REO:");
        System.out.printf("No. %2s Properties (bids)\n", " ");
        System.out.println("---------------------------");

        while (!done) {
            menu = currentListingsMenu();

            System.out.print("For which property would you like to add a bid?: ");
            String choice = sc.nextLine();

            if (choice.equals("")) done = true;
            else if (!menu.containsKey(choice)) System.out.println("Invalid option. Try again.\n");
            else {
                Residential listing = listings.getListing(menu.get(choice));

                System.out.println(listing);

                System.out.print("Please enter the name of the bidder: ");
                String name = sc.nextLine();

                double bid = getNum("Please enter the new bid: $", "Invalid value.", sc);

                listing.newBid(name, bid);

                System.out.printf("\nNew bid for property for '%s' added\n\n", listing.getStreetAddress());
            } // end of else
        } // end of while (!done)
    } // end of newBid(Scanner sc)

    private static void showBids(Scanner sc) {
        HashMap<String, String> menu;
        boolean done = false;

        System.out.println("\n\nCurrent Listings for REO:");
        System.out.printf("No. %2s Properties (bids)\n", " ");
        System.out.println("---------------------------");

        while (!done) {
            menu = currentListingsMenu();

            System.out.print("For which property would you like to see the current bids?: ");
            String choice = sc.nextLine();

            if (choice.equals("")) done = true;
            else if (!menu.containsKey(choice)) System.out.println("Invalid option. Try again.\n");
            else {
                Residential listing = listings.getListing(menu.get(choice));
                System.out.println(listing + "\n");

                System.out.println("Current bids for this listing:");
                System.out.println("--------------------------------------");
                System.out.printf("%3s Bidder %17s Bid\n", " ", " ");
                System.out.println("--------------------------------------");

                for (String bidder : listing.getBidders()) {
                    System.out.printf("%-15s $%,10.2f\n", bidder, listing.getBid(bidder));
                } // end of for (String bidder : listing.getBidders())
                System.out.println("\n");
            } // end of else
        } // end of while (!done)
    } // end of showBids()

    private static void autoBids() {
        Random rd = new Random();

        String[] autoBidders = {
                "Patric Stewart",
                "Walter Koenig",
                "William Shatner",
                "Leonard Nimoy",
                "DeForect Kelley",
                "James Doohan",
                "George Takei",
                "Majel Barrett",
                "Nichelle Nichol",
                "Jonathan Frank",
                "Marina Sirtis",
                "Brent Spiner",
                "Gates McFadden",
                "Michael Dorn",
                "LeVar Burton",
                "Wil Wheaton",
                "Colm Meaney",
                "Michelle Forbes"
        }; // end of autoBidders
        System.out.println("\n");
        for (Residential prop : listings.getResidences()) {
            int qtyBids = rd.nextInt(5) + 1;
            for (int i = 0; i < qtyBids; i++) {
                int nameIndex = rd.nextInt((autoBidders.length - 1) + 1);
                double rate = rd.nextInt(10) / 100f;
                prop.newBid(autoBidders[nameIndex], prop.calculateAppraisalPrice() * (1 + rate));
            } // end of for (int i = 0; i < qtyBids; i++)
            System.out.println(qtyBids + " new bids have been added to listing " + prop.getStreetAddress() + ".");
        } // end of for (Residential prop : listings.getResidences())
    } // end of autoBids()

    private static double getNum(String prompt, String warning, Scanner sc) {
        double num;

        while (true) {
            System.out.print(prompt);
            String str = sc.nextLine();
            try {
                num = Double.parseDouble(str);
                break;
            } catch (Exception e) {
                System.out.println(warning);
            } // end of try-catch
        } // end of while (true)
        return num;
    } // end of getNum(String prompt, String warning, Scanner sc)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean done = false;
        while (!done) {
            done = mainMenu(sc);
        } // end of while (!done)
        sc.close();
    } // end of main(String[] args)
} // end of REO