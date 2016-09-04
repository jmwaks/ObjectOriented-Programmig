package wine.project;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;


public class MonthlySelectionUseCase implements Serializable{
	
	private static Collection <MonthlySelection> ar = new HashSet<MonthlySelection>();
	private static List <Wine> wineList = new ArrayList<Wine>();
	MonthlySelection ms;
	
	
	public int createMonthlySelection(MonthlySelectionType at, String ym, List<Wine> vin ){
		
		if (at == MonthlySelectionType.AR){
		ms =  new AR(at, ym, vin);
		ar.add(ms);
		}
		else if (at == MonthlySelectionType.AW){
			ms = new AW(at, ym, vin);
			ar.add(ms);
		}
		else {
			ms = new RW(at, ym, vin);
			ar.add(ms);
		}
		wineList = new ArrayList<Wine>(vin);
		return ms.getSelectionID();
	}
	
	public JSONObject getMonthlySelection(int mid){
		
		
		Iterator <MonthlySelection> mse = ar.iterator();
		
		MonthlySelection temp;
		JSONArray wine =printwines();
		JSONObject MsObject=new JSONObject();
		while(mse.hasNext()){
			temp = (MonthlySelection) mse.next();
			if (temp.getSelectionID()==mid){
				try {

					MsObject.put("id", mid);
					MsObject.put("selection_month", temp.getSelectionMonth());
					MsObject.put("type", temp.getMonthlySelction().toString());
					MsObject.put("wines", wine);
					
				} catch (JSONException e) {
					
					e.printStackTrace();
				}
			}
		}
		return MsObject;
	}
	
	public JSONArray getMonthlySelections(){
		Iterator<MonthlySelection> ms =ar.iterator();
		JSONArray select = new JSONArray();
		MonthlySelection temp;
		
		while(ms.hasNext()){
			temp =(MonthlySelection) ms.next();
			
			try {
				select.put(new JSONObject().put("id", temp.getSelectionID()).
						put("selection_month", temp.getSelectionMonth()).
						put("type", temp.getMonthlySelction().toString()));
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}
		return select;
	}
	
	public JSONArray printwines(){
		Iterator <Wine> wi = wineList.iterator();
		JSONArray wArray=new JSONArray();
		Wine temp;
		while(wi.hasNext()){
			temp = (Wine) wi.next();
			try {
				
				wArray.put(new JSONObject().put("id", temp.getID()).put("label_name", temp.getLabelName()));
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}
		return wArray;
	}
	
	
	public JSONObject getWine(int wid){
		Iterator <Wine> vin =wineList.iterator();
		JSONObject wineO = new JSONObject();
		Wine temp;
		while(vin.hasNext()){
			temp =(Wine) vin.next();
			if (temp.getID()==wid){
				try {
					wineO.put("id", temp.getID());
					wineO.put("variety", temp.getVariety().toString());
					wineO.put("wine_type", temp.getType().toString());
					wineO.put("label_name", temp.getLabelName());
					wineO.put("grape", temp.getGrape());
					wineO.put("region", temp.getRegion());
					wineO.put("country", temp.getCountry());
					wineO.put("maker", temp.getMaker());
					wineO.put("ratings", temp.getRating());
				} catch (JSONException e) {
					
					e.printStackTrace();
				}
				
			}
		}
		return wineO;
	}
	
}
