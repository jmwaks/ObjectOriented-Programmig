package wine.project;

import static org.junit.Assert.*;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;

public class AddSubscriberTest {
	
	AddSubscriber ad =new AddSubscriber();
	@Test
	public void testAddSubscriber() {
		Address a =  new Address("CHi","IL","IL","3132252");
		
		
		assertEquals(300, ad.addSubscriber("jmwak@gmail.com", "James", "312768", a, "face", "twitter"));
	}
	
	@Test
	public void testgetSubscriber(){
		JSONArray jarray = new JSONArray();
		
	}

	

}
