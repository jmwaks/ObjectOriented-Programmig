package wine.project;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdminTest {

	@Test
	public void testAdmin() {
		Admin ad =  new Admin();
		assertEquals("Default Admin",ad.getName());
		assertEquals(613, ad.getID());
		
	}
	
	@Test
	public void testGetName(){
		Admin ad =  new Admin("James");
		assertEquals("James", ad.getName());
	}
	
	@Test 
	public void testSetName(){
		Admin ad  = new Admin();	
		ad.setName("Shane");
		assertEquals("Shane",ad.getName());
	}
}
