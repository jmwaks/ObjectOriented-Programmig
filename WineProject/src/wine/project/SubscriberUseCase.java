package wine.project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

@Path("/sub")
public class SubscriberUseCase implements Serializable{
	
	Subscriber s;
	AddSubscriber a = new AddSubscriber();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSubcriber(InputStream incomingData){
		
		String parsedJson = jsonStreamToString(incomingData);
		
		try {
			JSONObject json = new JSONObject(parsedJson);
			
			String email = json.getString("email");
			String name = json.getString("name");
			String phone = json.getString("phone");
			JSONObject add = json.getJSONObject("address");
			String street = add.getString("street");
			String city = add.getString("city");
			String state = add.getString("state");
			String zip = add.getString("zip");
			String facebook = json.getString("facebook");
			String twitter = json.getString("twitter");
			
			
			
			Address ad = new Address (street, city, state, zip);
			
			
			int id = a.addSubscriber(email, name, phone, ad, facebook, twitter);
			
			JSONArray jarray = new JSONArray();
			
			JSONObject jsonResponse = new JSONObject(new JSONStringer().object().
					key("id").value(id==0 ? null : id).key("errors").
					value(jarray).endObject().toString());
			
			return Response.status(201).entity(jsonResponse.toString()).build();
			
		} catch (JSONException e){
			e.printStackTrace();
			return Response.status(404).entity(e.toString()).build();
		}
		
		
	}
	
	@PUT
	@Path("/{wid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSubscriber(@PathParam("wid") String wid,InputStream incomingData){
		String parsedJson = jsonStreamToString(incomingData);
		JSONArray errorsArray = new JSONArray();
		
		try {
			JSONObject json =  new JSONObject(parsedJson);
			
			String email = json.getString("email");
			String name = json.getString("name");
			String phone = json.getString("phone");
			JSONObject add = json.getJSONObject("address");
			String street = add.getString("street");
			String city = add.getString("city");
			String state = add.getString("state");
			String zip = add.getString("zip");
			String facebook = json.getString("facebook");
			String twitter = json.getString("twitter");
			
			
			Address ad =  new Address(street,city,state,zip);
			
			
			a.updateSubscriber(Integer.parseInt(wid),email,name,phone,ad,facebook, twitter);
			
			JSONArray js = new JSONArray();
			JSONObject jsonRes = new JSONObject(new JSONStringer().object().
					key("Errors").value(js).endObject().toString());
			
			return Response.status(200).entity(jsonRes.toString()).build();
		} catch (JSONException e) {
			e.printStackTrace();
			return Response.status(404).entity(e.toString()).build();	
		}
	}

	@GET
	@Path("/{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSubscriber(@PathParam("sid") String sid) {
		JSONObject getsub = a.getSubscriber(Integer.parseInt(sid));
		JSONObject jRes;
		jRes = getsub;

		return Response.status(201).entity(jRes.toString()).build();
	}

	private String jsonStreamToString(InputStream incomingData) {
		StringBuilder jsonBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				jsonBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}

		return jsonBuilder.toString();
	}
	
	public boolean VerifyEmail(String email){
		
		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		Matcher mat = pattern.matcher(email);
		if (mat.matches()){
			return true;
		}
		else
		return false;
	}
}
