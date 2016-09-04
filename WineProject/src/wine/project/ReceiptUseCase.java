package wine.project;

import java.util.ArrayList;

public class ReceiptUseCase {
	private static ArrayList<Receipt> rec = new ArrayList<Receipt>();
	
	public int generateReceipt(String name){
		Receipt receipt =new Receipt(name);
		rec.add(receipt);
		return receipt.getReceiptID();
	}
}
