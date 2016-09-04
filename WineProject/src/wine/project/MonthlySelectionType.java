package wine.project;

import java.io.Serializable;

public enum MonthlySelectionType implements Serializable{
	AW ("All whites"),
	AR ("All reds"),
	RW ("Reds and Whites");
	
	private String description;
	private MonthlySelectionType(String ms) {
		this.description = ms;
	}
}
