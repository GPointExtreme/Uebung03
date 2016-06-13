package org.gpoint.textdatei;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<>();
		
		ImportText it = new ImportText();
		
		it.importReader();
		list = it.getEven();
		list1 = it.getOdd();
		
		TextAnalyzer ta = new TextAnalyzer(list);
		TextAnalyzer ta1 = new TextAnalyzer(list1);
		
		Thread t1 = new Thread(ta);
		Thread t2 = new Thread(ta1);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
