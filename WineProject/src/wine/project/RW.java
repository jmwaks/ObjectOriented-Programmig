package wine.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RW extends MonthlySelection implements Serializable{
	private List<Wine> ms= new ArrayList<Wine>();
	

	public RW(MonthlySelectionType mst, String y, List<Wine> vin){
		
		super(mst,y,vin);
		super.mst = MonthlySelectionType.RW;
	}
	
	public RW(MonthlySelectionType mst, String y){
		
		super(mst,y);
		super.mst = MonthlySelectionType.RW;
	}
	
	@Override
	void addWine(Wine w) {
		//You can add both red and white wine
		
	}

	
}
