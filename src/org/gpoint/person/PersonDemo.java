package org.gpoint.person;

public class PersonDemo {

	public static void main(String[] args) {
		PersonManager m = new PersonManager();
		
		m.add(new Person("Dominik", "Geiger", 24));
		m.add(new Person("David", "Erlacher", 23));
		
		m.savePerson("C:\\temp\\PersonSave.txt");
		m.loadPerson("C:\\temp\\PersonSave.txt");

	}

}
