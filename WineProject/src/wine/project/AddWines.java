package wine.project;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

@Path("/wines")

public class AddWines implements Serializable{
	MonthlySelectionUseCase mse = new MonthlySelectionUseCase();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWines(){
		JSONArray wineArray = mse.printwines();
		JSONObject jRes;
		try {
			jRes =new JSONObject(new JSONStringer().object().key("wines").
					value(wineArray).endObject().toString());
			
			return Response.status(201).entity(jRes.toString()).build();
		} catch (JSONException e) {
			e.printStackTrace();
			return Response.status(404).entity(e.toString()).build();
		}
		
	}
	
	@GET
	@Path("/{wid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWine(@PathParam("wid") String wid){
		JSONObject wineO = mse.getWine(Integer.parseInt(wid));
		JSONObject jsonRes;
		try {
			jsonRes = new JSONObject(new JSONStringer().object().
					key("").value(wineO).endObject().toString());
			
			return Response.status(201).entity(jsonRes.toString()).build();
		} catch (JSONException e) {
			e.printStackTrace();
			return Response.status(404).entity(e.toString()).build();
		}	
		
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
