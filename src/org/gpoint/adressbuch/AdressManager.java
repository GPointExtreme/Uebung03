package org.gpoint.adressbuch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AdressManager {
	
	private ArrayList<Adressen> list = new ArrayList<>();

	public ArrayList<Adressen> getList() {
		return list;
	}
	
	public void loadFromCsv(String path, String seperator) throws AddressLoadException {
		File file = new File(path);
		
		try (
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			) {
			String line;
			while((line = br.readLine()) != null) {
				String[] array = line.split(seperator);
				if(array.length == 4) {
					list.add(new Adressen (array[0], array[1], array[2], array[3]));
				}
				else {
					throw new AddressLoadException();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void exportToCsv(String path, String seperator) throws AddressExportException, AddressExportFileAlreadyExistsException {
		File file = new File(path);
		if(file.exists()) {
			throw new AddressExportFileAlreadyExistsException();
		}
		try (
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			) {
			for (Adressen adressen : list) {
				pw.println(adressen.getFirstname() + seperator + adressen.getLastname() + seperator 
						+ adressen.getMobileNumber() + seperator + adressen.getEmail());
			}
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
