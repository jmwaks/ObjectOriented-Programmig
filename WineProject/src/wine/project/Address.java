package wine.project;

import java.io.Serializable;

public class Address implements Serializable{
    private String street, city, state, zip;
    
    public Address() {
        this.street = "123 Main ST, Apt 2F";
        this.city = "Anytown";
        this.state = "Anystate";
        this.zip = "12345";
    }
    
    public Address(String street, String city, String state, String zip) {
    	this.street = street;
    	this.city = city;
    	this.state = state;
    	this.zip = zip;
    }
    public String getStreet(){
    	return street;
    }
    public String getCity(){
    	return city;
    }
    public String getState(){
    	return state;
    }
    public String getZip(){
    	return zip;
    }
    
}

