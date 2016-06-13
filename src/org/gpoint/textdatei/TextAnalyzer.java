package org.gpoint.textdatei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class TextAnalyzer implements Runnable{
	
	private ArrayList<String> list = new ArrayList<>();
	private HashMap<Character, Integer> map = new HashMap<>();
	private long counter = 0;
	private Object lock = new Object();

	public TextAnalyzer(ArrayList<String> list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		synchronized (lock) {
			for (String string : list) {
				counter += string.length();
				for (int i = 0; i < string.length(); i++) {
					if(map.containsKey(string.charAt(i))) {
						Integer in = map.get(string.charAt(i));
						map.put(string.charAt(i), in + 1);
					}
					else {
						map.put(string.charAt(i), 1);
					}
				}
			}
			System.out.println("Anzahl der Zeichen: " + counter);
			for (Entry<Character, Integer> entry : map.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}
}
