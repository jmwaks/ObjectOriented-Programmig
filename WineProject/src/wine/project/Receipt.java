package wine.project;

public class Receipt {
	private String receiver;
	private static int currentID=906;
	private int receiptID;
	
	public Receipt(){
		this.receiver ="Anne Costa";
		this.receiptID =906;
		currentID ++;
	}
	public Receipt(String name){
		this.receiver = name;
		receiptID =currentID;
		currentID ++;
	}
	
	public String getReceiver(){
		return receiver;
	}
	
	public int getReceiptID(){
		return receiptID;
	}
}
