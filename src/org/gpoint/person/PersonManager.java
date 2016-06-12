package org.gpoint.person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PersonManager {
	
	private ArrayList<Person> list = new ArrayList<>();
	File file = new File("C://temp//person.txt");
	
	public void add(Person p) {
		list.add(p);
	}
	
	public void savePerson(String path) {
		File file = new File(path);
		try (
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			) {
			for (Person person : list) {
				oos.writeObject(person);
			}
			oos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void loadPerson(String path) {
		File file = new File(path);
		try (
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			) {
			Person p;
			while((p=(Person) ois.readObject()) != null) {
				System.out.println(p.toString());
			}

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
