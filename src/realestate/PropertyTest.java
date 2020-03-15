package realestate;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropertyTest {

	@Test
	public void testProperty() {
		Property p = new Condo();
		String result = p.getStreetAddress();
		assertEquals("", result);
	} // testProperty()

	@Test
	public void testPropertyStringString() {
		Property p = new Condo("R. Julio Perneta 969", "80810-110", 0, 0, 0, 0);
		String result = p.getStreetAddress();
		assertEquals("R. Julio Perneta 969", result);
	} // testPropertyStringString()

	@Test
	public void testGetStreetAddress() {
		Property p = new Condo("R. Julio Perneta 969", "80810-110", 0, 0, 0, 0);
		String result = p.getStreetAddress();
		assertEquals("R. Julio Perneta 969", result);
	} // testGetStreetAddress()

	@Test
	public void testGetZip() {
		Property p = new Condo("R. Julio Perneta 969", "80810-110", 0, 0, 0, 0);
		String result = p.getZip();
		assertEquals("80810-110", result);
	} // testGetZip()

	@Test
	public void testSetStreetAddress() {
		Property p = new Condo();
		String result = p.setStreetAddress("243 S 600 E");
		assertEquals("243 S 600 E", result);
	} // testSetStreetAddress()

	@Test
	public void testSetZip() {
		Property p = new Condo();
		String result = p.setZip("84102");
		assertEquals("84102", result);
	} // testSetZip()

	@Test
	public void testGetAppraisalPrice() {
		Property p = new Condo();
		p.setAppraisalPrice(19999.9);
		double result = p.getAppraisalPrice();
		assertEquals(19999.9, result, .0001);
	}

	@Test
	public void testSetAppraisalPrice() {
		Property p = new Condo();
		double result = p.setAppraisalPrice(10.3);
		assertEquals(10.3, result, .0001);
	}

	@Test
	public void testGetListPrice() {
		Property p = new Condo();
		p.setListPrice(10.3);
		double result = p.getListPrice();
		assertEquals(10.3, result, .0001);
	}

	@Test
	public void testSetListPrice() {
		Property p = new Condo();
		double result = p.setListPrice(11.3);
		assertEquals(11.3, result, .0001);
	}
} // PropertyTest