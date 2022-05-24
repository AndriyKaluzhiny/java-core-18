package ua.lviv.lgs;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Methods {
	public void serialize(File file, Serializable object) throws IOException {
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(object);
		oos.close();
	}
	
	public Serializable deserialize(File file) throws Exception {
		InputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		
		Serializable object = (Serializable) ois.readObject();
		ois.close();
		return object;
	}
	
	public void listSerialization(File file, ArrayList<Emploee> emploeeList) throws IOException {
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos =  new ObjectOutputStream(os);
		
		for (Emploee e : emploeeList) {
			oos.writeObject(e);
			oos.reset();
		}
		
		oos.close();
	}
	
	public String listDeserialization(File file) throws IOException, ClassNotFoundException {
		InputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		ArrayList<Emploee> eList = new ArrayList<>();
		
		
		int available = ois.available();
		try {
			while (available != -1) {
				Emploee e = (Emploee) ois.readObject();
				eList.add(e);	
				}
		} catch (EOFException e) {
			e.printStackTrace();
		}
		
		ois.close();
		
		return eList.toString();
		 
		  
	}
}
 