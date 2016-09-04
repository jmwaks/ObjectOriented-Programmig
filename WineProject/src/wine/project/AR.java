package wine.project;

import java.io.Serializable;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AR extends MonthlySelection implements Serializable {
	
	protected MonthlySelectionType mst;
	private String selectionmonth;
	private List<Wine> ARList = new ArrayList<Wine>();
	private static int currentID = 800;
	private int wineID;
	
	
	public AR(MonthlySelectionType mst, String y, List<Wine> vin){
		
		super(mst,y,vin);
		super.mst = MonthlySelectionType.AR;
	}
	
	public AR(MonthlySelectionType mst, String y){
		
		super(mst,y);
		super.mst = MonthlySelectionType.AR;
	}
	
	@Override
	public void addWine(Wine w) {
		
		if(!(w.getVariety().equals(WineVariety.RED))){
			System.out.println("You can only add red wine");
		}
		else{
			ARList.add(w);
			System.out.println("Wine successfully added");
		}

	}


}
