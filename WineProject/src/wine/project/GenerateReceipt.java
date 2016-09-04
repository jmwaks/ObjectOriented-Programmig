package wine.project;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

@Path("/receipt")
public class GenerateReceipt {
	
	ReceiptUseCase useCase = new ReceiptUseCase();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAdmin(InputStream incomingData){
		String parsedJson = jsonStreamToString(incomingData);
		
		try {
			JSONObject json = new JSONObject(parsedJson);
			String name  = json.getString("name");
			
			int rid = useCase.generateReceipt(name);
			
			JSONObject  jsonResponse = new JSONObject(new JSONStringer().object().
					key("id").value(rid).endObject().toString());
			
			return Response.status(201).entity(jsonResponse.toString()).build();
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
