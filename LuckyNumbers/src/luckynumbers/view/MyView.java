package luckynumbers.view;
import luckynumbers.model.*;
import java.util.Scanner;

public class MyView implements View {
	Model game;
	Scanner scan;
	
	public MyView(Model model) {
		game = model;
		scan = new Scanner(System.in);
	};
	
	public void displayWelcome() {
		System.out.println("\tAuteur\tNom du jeu\tVersion");
		System.out.println("\tLuka Chkoidze\tLucky Numbers\t0.1");
	};

	public void displayGame() {
		System.out.println(" Joueur : " + (game.getCurrentPlayerNumber()+1));
		System.out.printf("%2s  ", " ");
		for (int j = 0; j < game.getBoardSize(); j++) {
			System.out.printf("%2d ", j+1);
		};
		System.out.println();
		System.out.printf("  --");
		for (int j = 0; j < game.getBoardSize(); j++) {
			System.out.printf("---");
		};
		System.out.println();
		for (int i = 0; i < game.getBoardSize(); i++) {
			System.out.printf("%2d| ", i+1);
			for (int j = 0; j < game.getBoardSize(); j++) {
				Tile tl = game.getTile(game.getCurrentPlayerNumber(), new Position(i, j));
				if (tl == null) {
					System.out.printf("%2s ", ".");
				} else {
					System.out.printf("%2d ", tl.getValue());
				};
			};
			System.out.println();
		};
		System.out.printf("  --");
		for (int j = 0; j < game.getBoardSize(); j++) {
			System.out.printf("---");
		};
		System.out.println();
		System.out.println(" Tuile choisie : " + game.getPickedTile().getValue());
	};

	public void displayWinner() {
		System.out.println("\n\n\n   " + game.getWinner());
	};

	public int askPlayerCount() {
		System.out.print("Player count : ");
		int pcount = scan.nextInt();
		return pcount;
	};

	public Position askPosition() {
		System.out.print("Row : ");
		int pos1 = scan.nextInt();
		System.out.print("Column : ");
		int pos2 = scan.nextInt();
		return new Position(pos1-1, pos2-1);
	};

	public void displayError(String message) {
		System.out.println("\n\n\n   " + message);
	};
	
}
