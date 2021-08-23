package com.snakeandladder;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Snake and Ladder Game");
		Game g = new Game();
		g.rollDie();
		
	}

}

class Game {
	int pos = 0;
	
	public int rollDie() {
		int numberOnDie = (int)Math.floor(Math.random()*((6-1)+1)+1);
		System.out.println("Die Says: "+numberOnDie);
		return numberOnDie;
	}
	
}
