package wine.project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class AddSubscriber implements Serializable{
	private Address a;
	
	private static Collection<Subscriber> subs =  new HashSet<Subscriber>();
	
	public static void saveClubState(Subscriber s) throws IOException {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		try {
			fout = new FileOutputStream("james-mwakichako.ser", true);
			oos = new ObjectOutputStream(fout);
			Iterator<Subscriber> itr = subs.iterator();
			Subscriber temp;
			while(itr.hasNext()){
				temp = (Subscriber) itr.next();
				oos.writeObject(temp);
			}
			
		} catch (IOException e) {
		        e.printStackTrace();
		} finally {
			if(oos != null) {
				oos.close();
			} 
		}
	}
	
	public static Subscriber restoreClubState(Subscriber s) throws IOException {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("james-mwakichako.ser");
			ois = new ObjectInputStream(fis);
			
			
			while ((s=(Subscriber) ois.readObject())!=null) {
				return s;
			}
		} catch (IOException e) {
			System.err.println("Nothing to restore.\n");
		} 
		catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException caught in restoreClubState()");
			e.printStackTrace();
		}
			finally {
			if (ois != null) {
				ois.close();
			} 
		}
		return s;
	}
	
	public int addSubscriber(String email, String name, String phone, Address a,String fb, String tw) {
		int id = 0; 
		Subscriber s;
		if (addressInBannedState(a)) {
			return id;
		}
		
		if (userHasAccount(email)) {
			return id;
		} else {
			s = new Subscriber (name, email, phone, a, fb, tw);
			subs.add(s);
			return s.getID();
		}
	}
	
	private boolean userHasAccount(String e) {
		
		Iterator<Subscriber> itr = subs.iterator();
		Subscriber temp;
		while(itr.hasNext()){
			temp = (Subscriber) itr.next();
			if((e).equals(temp.getEmail())){
				return true;
			}
		}
		return false;
	}
	
	private boolean addressInBannedState(Address a) {
		if (a.getState().equals("AR")|| (a.getState().equals("AL"))
				|| (a.getState().equals("DE"))|| (a.getState().equals("KY"))
				|| (a.getState().equals("MA"))|| (a.getState().equals("MS"))
				|| (a.getState().equals("SD"))|| (a.getState().equals("UT"))){
			return true;
		}
		return false;
	}
	
	public void updateSubscriber(int id,String email, String name, String phone, Address a,String fb, String tw){
		
		Iterator<Subscriber> itr = subs.iterator();
		Subscriber temp;
		while(itr.hasNext()){
			temp = (Subscriber) itr.next();
			if (temp.getID()==id){
				temp.setEmail(email);
				temp.setName(name);
				temp.setPhone(phone);
				temp.setFacebook(fb);
				temp.setTwitter(tw);
				temp.setAddress(a);
			}
		}	
	}
	
	public JSONObject getSubscriber(int id){
		Iterator<Subscriber> itr = subs.iterator();
		Subscriber temp1;
		JSONObject subOb = new JSONObject();
		
		while(itr.hasNext()){
			temp1 = (Subscriber) itr.next();
			if (temp1.getID()==id){
				try {
					subOb.put("email", temp1.getEmail());
					subOb.put("phone", temp1.getPhone());
					subOb.put("name", temp1.getName());
					subOb.put("address", new JSONObject(temp1.getAddress()));
					subOb.put("facebook", temp1.getFacebook());
					subOb.put("twitter", temp1.getTwitter());
				} catch (JSONException e) {
					
					e.printStackTrace();
				}
			}	
		}
		return subOb;
	}
	
}
