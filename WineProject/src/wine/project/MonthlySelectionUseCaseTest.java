package wine.project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MonthlySelectionUseCaseTest {
	MonthlySelectionUseCase ms = new MonthlySelectionUseCase();
	
	@Test
	public void testCreateMonthlySelection() {
		MonthlySelectionType mst =MonthlySelectionType.AR;
		String ym ="Feb/2015";
		List <Wine> vin =new ArrayList<Wine>();
		
		assertEquals(853, ms.createMonthlySelection(mst, ym, vin));
		
		MonthlySelectionType msr =MonthlySelectionType.AW;
		String ym1 ="Feb/2015";
		List <Wine> vins =new ArrayList<Wine>();
		
		assertEquals(854, ms.createMonthlySelection(msr, ym1, vins));
		
		MonthlySelectionType msw =MonthlySelectionType.RW;
		String ym2 ="Feb/2015";
		List <Wine> vinsw =new ArrayList<Wine>();
		
		assertEquals(855, ms.createMonthlySelection(msw, ym2, vinsw));
		
	}

}
