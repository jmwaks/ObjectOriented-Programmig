package wine.project;

import java.io.Serializable;
import java.time.Year;

public class  Wine implements Serializable {
	private WineVariety wv;
	private WineType wt;
	private String labelName;
	private String grape;	// e.g. Merlot, Chardonnay, Riesling, etc.
	private String region;	// e.g. Napa, Russian Valley, etc.
	private String country; // e.g. France, USA, Australia, Chile
	private String maker;	// the wine maker, e.g. Sterling, Krupp Brother, etc.
	private Year year;		// Vintage year
	private static int numberOfRatings;
	private static float rating = 0;
	private static int currentID=126;
	private int ID;

	public Wine() {
		this.wv = WineVariety.RED;
		this.wt = WineType.TABLE;
		this.labelName = "The Mission";
		this.grape = "Cabernet Sauvignon";
		this.region = "Napa";
		this.country = "USA";
		this.maker = "Sterling";
		this.year = Year.parse("2011");
		this.ID = currentID;
    	currentID++;
	}

	public Wine(WineVariety v, WineType t, String ln, String g, String r, String c, String m, Year y) {
		this.wv = v;
		this.wt = t;
		this.labelName = ln;
		this.grape = g;
		this.region = r;
		this.country = c;
		this.maker = m;
		this.year = y;
		this.ID = currentID;
    	currentID++;
	}

	public WineVariety getVariety() {
		return this.wv;
	}
	
	public WineType getType() {
		return this.wt;
	}

	public String getLabelName() {
		return this.labelName;
	}

	public String getGrape() {
		return this.grape;
	}

	public String getRegion() {
		return this.region;
	}
	
	public String getCountry() {
		return this.country;
	}

	public String getMaker() {
		return this.maker;
	}
	
	public String getYear() {
		return this.year.toString();
	}

	public int getNumberOfRatings() {
		return this.numberOfRatings;
	}
	
	public float getRating() {
		return this.rating;
	}
	
	public int  getID() {
		return ID;
	}
	
	public void addRating(int r) {
		numberOfRatings = numberOfRatings + 1;
		rating = rating*((float)(numberOfRatings - 1)/numberOfRatings) + (float)r/numberOfRatings;
	}
	
	public boolean isMatch(String kw) {
        if (isMatchVariety(kw) || isMatchType(kw) || isMatchLabel(kw) || isMatchGrape(kw) || isMatchRegion(kw) || isMatchCountry(kw) || isMatchMaker(kw) || isMatchYear(kw)) {
                return true;
        } else return false;
	}
	    
    private boolean isMatchVariety(String kw) {
    	String regex = "(?i).*" + kw + ".*";
        return this.wv.name().matches(regex);
    }

    private boolean isMatchType(String kw) {
    	String regex = "(?i).*" + kw + ".*";
        return this.wt.name().matches(regex);
    }
    
    private boolean isMatchLabel(String kw) {
        String regex = "(?i).*" + kw + ".*";
        return this.labelName.matches(regex);
    }
    
    private boolean isMatchGrape(String kw) {
    	return false;
    }
    
    private boolean isMatchRegion(String kw) {
    	return false;
    }

    private boolean isMatchCountry(String kw) {
    	return false;
    }

    private boolean isMatchMaker(String kw) {
    	return false;
    }

    private boolean isMatchYear(String kw) {
    	return false;
    }
    
    public String toString(){
    	String output = " WineVariety: "+wv+" WineType: "+wt+" \nlabel name: "+labelName+
    			" Type of grape: \n "+grape+" Region of origin: "+region+
    			" country of origin: "+country+" Make: "+maker+" \nMmanufacturing year: "
    			+year+" WineID: "+ID;
    	
    	return output;
    			
    }

	
}
