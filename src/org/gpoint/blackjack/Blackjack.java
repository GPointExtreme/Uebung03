package org.gpoint.blackjack;

import java.util.HashMap;

public class Blackjack {
	
	private HashMap<Player, Integer> map = new HashMap<>();
	
	public boolean add(Player player) {
		if(map.containsKey(player)) {
			return false;
		}
		else {
			map.put(player, 0);
			return true;
		}
	}
	
	public boolean addCard(Player player, Integer cardValue) {
		if(map.containsKey(player)) {
			Integer i = map.get(player);
			map.put(player, i+cardValue);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Integer getValue(Player player) {
		Integer i = 0;
		if(map.containsKey(player)) {
			i = map.get(player);
			return i;
		}
		else {
			return i;
		}
	}
	
	public String toString() {
		String result = "";
		
		for (Player player : map.keySet()) {
			result += player.getName() + ", Kartenwert: " + getValue(player) + "\n"; 
		}
		return result;
	}
}
