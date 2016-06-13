package org.gpoint.textdatei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportText {
	
	private ArrayList<String> even = new ArrayList<>();
	private ArrayList<String> odd = new ArrayList<>();
	
	public void importReader() {
		File file = new File("C://temp//text.txt");
		
		try (
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			) {
			String line;
			int counter = 0;
			while((line = br.readLine()) != null) {
				if(counter%2==0) {
					even.add(line);
				}
				else {
					odd.add(line);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> getEven() {
		return even;
	}

	public ArrayList<String> getOdd() {
		return odd;
	}

}
