package org.gpoint.copytextsort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class TextCopy {
	
	public static void main(String[] args) {
		
		File in = new File("C://temp//in.txt");
		File out = new File("C://temp//out.txt");
		
		ArrayList<String> even = new ArrayList<>();
		ArrayList<String> odd = new ArrayList<>();
		
		try (
			FileReader fr = new FileReader(in);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(out, true);
			PrintWriter pw = new PrintWriter(fw, true);
			) {
			String line;
			int counter = 1;
			while((line=br.readLine()) != null) {
				if(counter%2==0) {
					odd.add(line);
					counter++;
				}
				else if(counter%2!=0) {
					even.add(line);
					counter++;
				}
				else {
					System.out.println("Fehler");
				}
			}
			
			Collections.sort(even);
			Collections.sort(odd);
			
			for (String s : odd) {
				pw.println(s);
			}
			pw.flush();
			for (String s : even) {
				pw.println(s);
			}
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
