package org.gpoint.adressbuch;

import java.util.ArrayList;

public class AddressDemo {

	public static void main(String[] args) {
		
		AdressManager am = new AdressManager();
		
		//Export testen
//		am.add(new Adressen("Dominik", "Geiger", "0800666666", "mail@pipapo.com"));
//		am.add(new Adressen("David", "Erlacher", "0800696969", "baum@pipapo.com"));
//		
//		try {
//			am.exportToCsv("C://temp//export.txt", ",");
//		} catch (AddressExportException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AddressExportFileAlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			am.loadFromCsv("C://temp//export.txt", ",");
		} catch (AddressLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Adressen> list = am.getList();
		
		for (Adressen adressen : list) {
			System.out.println(adressen.toString());
		}
	}

}
