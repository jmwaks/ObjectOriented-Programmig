package wine.project;

import java.io.InputStream;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public interface IGetMonthlySelctions {
 
	public Response getAllMonthlySelections();
	
	public Response createMonthlySelection(InputStream incomingData);
	
	public Response getMonthlySelection(@PathParam("mid") String mid);
}
