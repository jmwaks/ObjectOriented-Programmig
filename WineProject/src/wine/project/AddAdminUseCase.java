package wine.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;


public class AddAdminUseCase implements Serializable{

	private static ArrayList<Admin> admins = new ArrayList<Admin>();
	private static ArrayList<Shipments> ships =  new ArrayList<Shipments>();
	Admin def = new Admin();
	
	public int createAdmin(String name){
		Admin ad = new Admin(name);
		admins.add(ad);
		return ad.getID();
	}
	
	public JSONArray getAdmin(){
		JSONArray array = new JSONArray();
		Iterator <Admin> ad = admins.iterator();
		Admin temp;
		while (ad.hasNext()){
			temp = (Admin) ad.next();
			try {
			
				array.put(new JSONObject().put("id", temp.getID()).put("name",temp.getName()));
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}
		return array;
	}
	
	 public void updateAdmin(int id,String name){
		
		Iterator <Admin> ad = admins.iterator();
		Admin temp;
		while(ad.hasNext()){
			temp = (Admin) ad.next();
			if (temp.getID()==id){
				temp.setName(name);
			}
		}
	 }
		
		public JSONObject getAdminInfo(int id1){
			Iterator <Admin> ad2 = admins.iterator();
			
			JSONObject admininfo =new JSONObject();
			Admin temp1;
			
			while (ad2.hasNext()){
				temp1 =(Admin) ad2.next();
				if (temp1.getID() == id1){
					try {
						
						admininfo.put("id", temp1.getID());
						admininfo.put("name", temp1.getName());
						admininfo.put("created_date", 20140413);
						admininfo.put("created_by", def.getID());
					} catch (JSONException e) {
						
						e.printStackTrace();
					}
				}	
			}
			return admininfo;
		}
		
	public JSONObject getUnits() {
		Iterator itr = ships.iterator();
		int count = 0;
		double wineprice = 54.01;
		double delivery = 6.01;
		double wine_revenue = 0;
		double delivery_revenue = 0;
		JSONObject metrics = new JSONObject();
		Shipments temp;

		while (itr.hasNext()) {
			temp = (Shipments) itr.next();
			wine_revenue += wineprice * count;
			delivery_revenue += delivery * count;
			count++;

		}
		try {
			metrics.put("units delivered", count);
			metrics.put("delivery_revenue", delivery_revenue);
			metrics.put("wine_revenue", wine_revenue);
		} catch (JSONException e) {

			e.printStackTrace();
		}
		return metrics;
	}
			
	}
