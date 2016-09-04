package wine.project;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class AddAdminUseCaseTest implements Serializable{
	AddAdminUseCase a;
	private static ArrayList<Admin> admins = new ArrayList<Admin>();
	@Test
	public void testCreateAdmin() {
		
	Admin ad =new Admin ("James");
	admins.add(ad);
	assertEquals(613, ad.getID());	
	}

	@Test
	public void testGetAdmin() {
		JSONArray result = a.getAdmin();
		try {
			JSONAssert.assertEquals("[{name:\"James\",id:613}]", result, false);
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateAdmin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdminInfo() {
		fail("Not yet implemented");
	}

}
