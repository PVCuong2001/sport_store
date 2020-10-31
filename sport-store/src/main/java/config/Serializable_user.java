package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class Serializable_user {
	static final String filename="/home/cuong/eclipse-workspace/Java/sport-store/src/main/resources/userhistory.txt";
	static List<User>users=new ArrayList<User>();
	public Serializable_user(User user)   {
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			FileOutputStream fos=new FileOutputStream(filename,true);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			users=(List<User>) ois.readObject();
			users.add(user);
			oos.writeObject(users);
			System.out.println("Success...........");
		} catch ( IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
	public void serialuser(User user) throws IOException  {
			
	}
	public List<User> deserialuser() throws IOException, ClassNotFoundException {
		FileInputStream fis=new FileInputStream(filename);
		ObjectInputStream ois=new ObjectInputStream(fis);
		List<User> users=new ArrayList<>();
		User i=null;
		while((i=(User) ois.readObject())!=null) {
			users.add(i);
		}
		fis.close();
		ois.close();
		return users;
	}
}
