package wine.project;

import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public abstract class MonthlySelection implements Serializable{
	protected MonthlySelectionType mst;
	private String selectionmonth;
	private List<Wine> ms = new ArrayList<Wine>();
	private static int currentID = 853;
	private int selectionID;
	
	public MonthlySelection(MonthlySelectionType ms, String y, List<Wine> vin){
		this.mst = ms;
		this.selectionmonth = y;
		this.ms = vin;
		selectionID = currentID; 
		currentID++;
	}
	
	public MonthlySelection(MonthlySelectionType mst, String ym){
		this.mst = mst;
		this.selectionmonth = ym;
		selectionID = currentID; 
		currentID++;
	}
	
	public MonthlySelectionType getMonthlySelction(){
		return mst;
	}
	
	public String getSelectionMonth(){
		return selectionmonth;
	}
	
	public int getSelectionID(){
		return selectionID;
	}
	
	public List<Wine> getWine(){
		return ms;
	}
	
	abstract void addWine(Wine w);
	
	
	
	public boolean isMatch(String kw) {
		Iterator<Wine> it = this.ms.iterator();
		while (it.hasNext()) {
			Wine w = it.next();
			if (w.isMatch(kw)) return true;
		}
		return false;
	}
	
	

}
