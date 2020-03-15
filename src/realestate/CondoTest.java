package realestate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CondoTest {

	@Test
	void testCondo() {
		Condo c = new Condo();
		String result = c.getStreetAddress();
		assertEquals("", result);
	} // testCondo()

	@Test
	void testCondoStringStringIntIntDoubleInt() {
		Condo c = new Condo("address", "zip", 1, 1, 30.5, 1);
		String result = c.getStreetAddress();
		assertEquals("address", result);
	} // testCondoStringStringIntIntDoubleInt()

	@Test
	void testGetFloorLvl() {
		Condo c = new Condo("address", "zip", 1, 1, 1.5, 1);
		int result = c.getFloorLvl();
		assertEquals(1, result);
	} // testGetFloorLvl()

	@Test
	void testSetFloorLvl() {
		Condo c = new Condo();
		int result = c.setFloorLvl(5);
		assertEquals(5, result);
	} // testSetFloorLvl()

	@Test
	void testCalculateAppraisalPrice() {
		Condo c = new Condo("address", "zip", 1, 1, 1, 1);
		double result = c.calculateAppraisalPrice();
		assertEquals(18088f, result, .0001);
	}
} // class CondoTest