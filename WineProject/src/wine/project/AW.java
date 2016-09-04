package wine.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AW extends MonthlySelection implements Serializable {
	
	private List<Wine> ms = new ArrayList<Wine>();
	

	public AW(MonthlySelectionType mst, String y, List<Wine> vin){
		
		super(mst,y,vin);
		super.mst = MonthlySelectionType.AW;
	}
	
	public AW(MonthlySelectionType mst, String y){
		
		super(mst,y);
		super.mst = MonthlySelectionType.AW;
	}
	
	@Override
	void addWine(Wine w) {
		// Make sure only white wines are added
		if(!(w.getVariety()==WineVariety.WHITE)){
			System.out.println("You can only add white wine");
		} else
			ms.add(w);	

	}

	

	
	

}
