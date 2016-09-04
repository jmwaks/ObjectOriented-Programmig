package wine.project;

public class Shipments {
	
	MonthlySelection mst; 
	private String status;
	private static int currentID = 1;
	private int shipmentID;
	
	public Shipments() {
		
		this.status = "Delivered";
		this.shipmentID = currentID;
		currentID++;
	}
	public Shipments(MonthlySelection ms, String st, int id){
		this.mst = ms;
		this.status = st;
		this.shipmentID = id;	
	}
	
	public MonthlySelection getMonthlySelection(){
		return mst;
	}
	
	public String getStatus(){
		return status;
	}
	
	public int getShipmentID(){
		return shipmentID;
	}
}
