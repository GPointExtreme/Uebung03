package org.gpoint.blackjack;

public class Demo {

	public static void main(String[] args) {

		Player dominik = new Player("Dominik", 24);
		Player david = new Player("David", 23);
		
		Blackjack map = new Blackjack();
		
		map.add(dominik);
		map.add(david);
		
		map.addCard(dominik, 10);
		map.addCard(david, 11);
		
		System.out.println(map.getValue(david));
		
		System.out.println(map.toString());

	}

}
