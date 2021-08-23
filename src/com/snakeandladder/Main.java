package com.snakeandladder;

public class Main {

	public static void main(String[] args) {
		
		
		final int PLAYER_1_WIN = 1;
		final int PLAYER_2_WIN = 2;
		
		System.out.println("Welcome to Snake and Ladder Game");
		Player p1 = new Player(1);
		Player p2 = new Player(2);
		int winFlag = 0;
		
		while(true) {
			
			p1.play();
			if(p1.pos == 100) {
				winFlag = PLAYER_1_WIN;
				break;
			}
			p2.play();
			if(p2.pos == 100) {
				winFlag = PLAYER_2_WIN;
				break;
			}
			
		}
		
		if(winFlag == PLAYER_1_WIN) {
			System.out.println("Player 1 is the Winner\nDice was thrown "+p1.count+" times");
		}
		else {
			System.out.println("Player 2 is the Winner\nDice was thrown "+p2.count+" times");

		}
		
	}

}

class Game {
	
	public int rollDie() {
		int numberOnDie = (int)Math.floor(Math.random()*((6-1)+1)+1);
		System.out.println("Die Says: "+numberOnDie);
		return numberOnDie;
	}
	
	public int generateOption() {
		int option = (int)Math.floor(Math.random()*((3-1)+1)+1);
		return option;
	}
		
}

class Player extends Game {
	
	final int LADDER = 1;
	final int SNAKE = 2;
	final int NO_PLAY = 3;
	
	int id;
	int pos = 0;
	int count = 0;
	
	Player(int id){
		this.id = id;
	}
	
	public void printCurrentPosition() {
		System.out.println("Current Position: "+pos);
	}
	
	public void play() {
			
			System.out.println();
			System.out.println("Player "+id+" is playing");
		
			count++;
			int prevPos = pos;
			int dieNumber = rollDie();
			int opt = generateOption();
			
			
			switch (opt) {
			case LADDER:
				pos += dieNumber;
				System.out.println("Hit Ladder");
				if(pos > 100) {
					pos = prevPos;
				}
				printCurrentPosition();
				this.play();
				break;
			case SNAKE:
				pos -= dieNumber;
				System.out.println("Hit Snake");
				if(pos < 0) {
					pos = 0;
				}
				printCurrentPosition();
				break;
			case NO_PLAY:
				System.out.println("Hit No-Play");
				printCurrentPosition();
				break;
			}
			
			System.out.println();
			
	}
	
}
