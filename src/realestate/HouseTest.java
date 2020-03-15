package realestate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HouseTest {

	@Test
	void testHouse() {
		House h = new House();
		String result = h.getStreetAddress();
		assertEquals("", result);
	} // testHouse()

	@Test
	void testHouseStringStringIntIntDoubleDouble() {
		House h = new House("243 S 600 E", "84102", 1, 1, 70.0, 40.5);
		String result = h.getStreetAddress();
		assertEquals("243 S 600 E", result);
	} // testHouseStringStringIntIntDoubleDouble()

	@Test
	void testGetYardAcres() {
		House h = new House("243 S 600 E", "84102", 1, 1, 70.0, 40.5);
		double result = h.getYardAcres();
		assertEquals(40.5, result, .0001);
	} // testGetYardAcres()

	@Test
	void testSetYardAcres() {
		House h = new House();
		double result = h.setYardAcres(30.23);
		assertEquals(30.23, result, .0001);
	} // testSetYardAcres()

	@Test
	void testCalculateAppraisalPrice() {
		House h = new House("243 S 600 E", "84102", 1, 1, 1, 1);
		double result = h.calculateAppraisalPrice();
		assertEquals(482097f, result, .0001);
	}
} // class HouseTest