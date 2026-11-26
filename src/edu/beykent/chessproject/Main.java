package edu.beykent.chessproject;

import java.util.Scanner;

import edu.beykent.chessproject.game.Game;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			game.printBoard();
			System.out.print("Select Piece: ");
			String from = sc.nextLine();
			game.visualizePieceMovement(from);
			System.out.print("Play Move: ");
			String to = sc.nextLine();
			game.playMove(from+to);
		}
		
	}
}
