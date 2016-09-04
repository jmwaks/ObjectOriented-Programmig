package wine.project;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

	@Test
	public void testAddress() {
		Address a=new Address();
		assertEquals("123 Main ST, Apt 2F",a.getStreet());
		assertEquals("Anytown",a.getCity());
		assertEquals("Anystate",a.getState());
		assertEquals("12345",a.getZip());
	}

}
