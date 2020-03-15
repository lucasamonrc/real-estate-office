package realestate;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResidentialTest {

	@Test
	public void testResidential() {
		Residential r = new House();
		String result = r.getStreetAddress();
		assertEquals("", result);
	} // testResidential()

	@Test
	public void testResidentialStringStringIntIntDouble() {
		Residential r = new House("N Temple", "84100", 30, 15, 100.00, 100);
		String result = r.getStreetAddress();
		assertEquals("N Temple", result);		
	} // testResidentialStringStringIntIntDouble()

	@Test
	public void testGetBeds() {
		Residential r = new House("N Temple", "84100", 30, 15, 100.00, 100);
		int result = r.getBeds();
		assertEquals(30, result);
	} // testGetBeds()

	@Test
	public void testGetBaths() {
		Residential r = new House("N Temple", "84100", 30, 15, 100.00, 100);
		int result = r.getBaths();
		assertEquals(15, result);
	} // testGetBaths()

	@Test
	public void testGetSize() {
		Residential r = new House("N Temple", "84100", 30, 15, 100.00, 100);
		double result = r.getSize(); // cast the return value to an int, to not cause deprecation on the assertion
		assertEquals(100f, result, .0001);
	} // testGetSize()

	@Test
	public void testSetBeds() {
		Residential r = new House();
		int result = r.setBeds(2);
		assertEquals(2, result);
	} // testSetBeds()

	@Test
	public void testSetBaths() {
		Residential r = new House();
		int result = r.setBaths(2);
		assertEquals(2, result);
	} // testSetBaths()

	@Test
	public void testSetSize() {
		Residential r = new House();
		double result = r.setSize(200.00);
		assertEquals(200f, result, .0001);
	} // testSetSize()
} // class ResidentialTest