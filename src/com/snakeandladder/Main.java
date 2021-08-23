package com.snakeandladder;

public class Main {

	public static void main(String[] args) {
		
		final int LADDER = 1;
		final int SNAKE = 2;
		final int NO_PLAY = 3;
		
		System.out.println("Welcome to Snake and Ladder Game");
		Game g = new Game();
		
		while(g.pos < 100) {
			
			int dieNumber = g.rollDie();
			int opt = g.generateOption();
			
			switch (opt) {
			case LADDER:
				g.pos += dieNumber;
				System.out.println("Hit Ladder");
				break;
			case SNAKE:
				g.pos -= dieNumber;
				System.out.println("Hit Snake");
				break;
			case NO_PLAY:
				System.out.println("Hit No-Play");
				break;
			}
			
			if(g.pos < 0) {
				g.pos = 0;
			}
			
			g.printCurrentPosition();
		
		}
		
	}

}

class Game {
	int pos = 0;
	
	public int rollDie() {
		int numberOnDie = (int)Math.floor(Math.random()*((6-1)+1)+1);
		System.out.println("Die Says: "+numberOnDie);
		return numberOnDie;
	}
	
	public int generateOption() {
		int option = (int)Math.floor(Math.random()*((3-1)+1)+1);
		return option;
	}
	
	public void printCurrentPosition() {
		System.out.println("Position: "+pos);
	}
	
}
