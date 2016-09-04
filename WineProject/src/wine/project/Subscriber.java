package wine.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Subscriber implements Serializable{
    private String name, email, phone, twitter, facebook;
    private Address address;
    private MonthlySelectionType mst;
    Collection <MonthlySelection> ms = new HashSet<MonthlySelection>();
    private static int currentID=300;
    private int ID;
    
    
    public Subscriber() {
    	this.name = "Jane Doe";
    	this.email = "jane.doe@example.com";
    	this.phone = "1234567890";
    	this.address = new Address();
    	this.mst = MonthlySelectionType.RW;
    	this.ID = currentID;
    	currentID++;
    }
    public Subscriber (String name, String email, String phone, Address address) {
    	this.name = name;
    	this.email = email;
    	this.phone = phone.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters
    	this.address = address;
    	this.mst = MonthlySelectionType.RW;
    	
    	this.ID = currentID;
    	currentID++;
    }
    public Subscriber (String name, String email, String phone, Address address, String fb, String tw) {
    	this.name = name;
    	this.email = email;
    	this.phone = phone.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters
    	this.address = address;
    	this.facebook = fb;
    	this.twitter = tw;
     	this.mst = MonthlySelectionType.RW;
    	this.ID = currentID;
    	currentID++;
    }

    private boolean isMatchName(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.name.matches(regex);
    }

    private boolean isMatchEmail(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.email.matches(regex);
    }

    private boolean isMatchPhone(String kw) {
    	String s = kw.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters from search string
    	String regex = "(?i).*" + s + ".*";
    	return this.phone.matches(regex);
    }
    public boolean isMatch(String kw) {
    	if (isMatchName(kw) || isMatchEmail(kw) || isMatchPhone(kw)) {
    		return true;
    	} else return false;
    }

    public int getID() {
    	return this.ID;
    }
    
    
    public void updateInfo(String name, String email, String phone, Address address) {
    	
    	this.name = name;
    	this.email = email;
    	this.phone = phone;
    	this.address = address;
    }
    
    public void setName(String na){
    	this.name = na;
    }
    
    public void setEmail(String em){
    	this.email = em;
    }
    
    public void setPhone(String ph){
    	this.phone = ph;
    }
   public void setAddress(Address ad){
	   this.address = ad;
   }
    public MonthlySelectionType getPreference() {
    	return mst;
    }
    
    public void setPreference(MonthlySelectionType t) {
    	this.mst = t;
    }
    
    public void setFacebook(String fb){
    	this.facebook =fb;
    }
    
    public void setTwitter(String tw){
    	this.twitter = tw;
    }
    
    public String getEmail(){
    	return this.email;
    }
    
    public String getName(){
    	return this.name;
    }
    public String getPhone(){
    	return this.phone;
    }
    
    public Address getAddress(){
    	return address;
    }
    
    public String getFacebook(){
    	return facebook;
    }
    
    public String getTwitter(){
    	return twitter;
    }
    
    public String toString(){
    	String output="The name of the Subscriber is " +name+ " The email is " +email+
    			" The phone number is " +phone+" The address is "  +address+" The monthly selection is " +mst;
    	
    	return output;
    }
	
	public Object phone() {
		// TODO Auto-generated method stub
		return null;
	}

}
