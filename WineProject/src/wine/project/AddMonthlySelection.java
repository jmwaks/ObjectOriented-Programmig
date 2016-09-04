package wine.project;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

@Path("/admin/monthly_selection")
public class AddMonthlySelection implements IGetMonthlySelctions {
	
	MonthlySelectionUseCase useCase =  new MonthlySelectionUseCase();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMonthlySelection(InputStream incomingData){
		String parsedJson = jsonStreamToString(incomingData);
		List<Wine> vin = new ArrayList<Wine>();
		try {
			JSONObject json = new JSONObject(parsedJson);
			
			String type = json.getString("type");
			String selectionmonth = json.getString("selection_month");
			
			MonthlySelectionType ms = MonthlySelectionType.valueOf(type);
			
			JSONArray jarray= json.getJSONArray("wines");
			
			for (int i = 0; i<jarray.length(); i++){
				
				JSONObject wine = jarray.getJSONObject(i);
				
				String variety = wine.getString("variety");
				String winetype = wine.getString("wine_type");
				String label = wine.getString("label_name"); 
				String grape = wine.getString("grape");
				String region = wine.getString("region");
				String country = wine.getString("country");
				String maker = wine.getString("maker");
				String year = wine.getString("year");
				
				WineVariety wv = WineVariety.valueOf(variety);
				WineType wt = WineType.valueOf(winetype);
				Year y = Year.parse(year);
				
				Wine w = new Wine (wv, wt, label, grape, region, country, maker,y);
				vin.add(w);
			}
			
			
			int uid = useCase.createMonthlySelection(ms, selectionmonth, vin);
			
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
	public Response getMonthlySelection(){
		JSONArray selects =useCase.getMonthlySelections();
		JSONObject jsonRes;
		
		try {
			jsonRes = new JSONObject(new JSONStringer().object().
					key("monthly_selection").value(selects).endObject().toString());
			return Response.status(201).entity(jsonRes.toString()).build();
		} catch (JSONException e) {
			e.printStackTrace();
			return Response.status(404).entity(e.toString()).build();
		}
	}
	
	@GET
	@Path("/{mid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMonthlySelection(@PathParam("mid") String mid) {
		JSONObject monthly = useCase.getMonthlySelection(Integer.parseInt(mid));
		
		return Response.status(201).entity(monthly.toString()).build();
	}
	
	public Response getAllMonthlySelections() {
	
		return null;
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
