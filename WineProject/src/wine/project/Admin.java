package wine.project;

import java.io.Serializable;

public class Admin implements Serializable{
	private String name;
	private int ID;
	private static int currentID=614;
	
	public Admin(){
		this.name = "Default Admin";
		this.ID = 613;
		
	}
	
	public Admin(String n){
		this.name = n;
		this.ID = currentID;
		currentID ++;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public void setName(String na){
		name = na;
	}
	
	@Override
	public String toString(){
		return new StringBuffer(" Admin names: ").append(this.name).
				append(" ID: ").append(this.ID).toString();
		
	}
	
	 	
}
