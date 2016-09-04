package wine.project;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
public class AddAdmin implements Serializable{
	AddAdminUseCase useCase = new AddAdminUseCase();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAdmin(InputStream incomingData){
		String parsedJson = jsonStreamToString(incomingData);
		try {
			JSONObject json = new JSONObject(parsedJson);
			
			String name = json.getString("name");
			
			
			int uid = useCase.createAdmin(name);
			
			JSONObject jsonResponse = new JSONObject(new JSONStringer().object()
					.key("id").value(uid).endObject().toString());
			
			return Response.status(201).entity(jsonResponse.toString()).build();
		} catch (JSONException e) {
			
			e.printStackTrace();
			return Response.status(404).entity(e.toString()).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdmin(){
		
		JSONArray name = useCase.getAdmin();
		JSONObject jsonRes;
		try {
			jsonRes = new JSONObject(new JSONStringer().object().
					key("admins").value(name).endObject().toString());
			
			return Response.status(201).entity(jsonRes.toString()).build();
		} catch (JSONException e) {
			e.printStackTrace();
			return Response.status(404).entity(e.toString()).build();
		}
		
	}
	
	@GET
	@Path("/{wid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdminInfo(@PathParam("wid") String wid){
		
		JSONObject jsonRes = useCase.getAdminInfo(Integer.parseInt(wid));

			return Response.status(201).entity(jsonRes.toString()).build();
		
		
	}
	
	@PUT
	@Path("/{wid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAdmin(@PathParam("wid") String wid,InputStream incomingData){
		String parsedJson = jsonStreamToString(incomingData);
		
		
		try {
			JSONObject json =  new JSONObject(parsedJson);
			String name = json.getString("name");
			useCase.updateAdmin(Integer.parseInt(wid),name);
			
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
	@Path("/revenue")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUnitsDelivered(){
			
		
		JSONObject jsonRes = useCase.getUnits();

		return Response.status(200).entity(jsonRes.toString()).build();
		
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
}
