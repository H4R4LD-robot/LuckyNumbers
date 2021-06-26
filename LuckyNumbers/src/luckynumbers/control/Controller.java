package luckynumbers.control;

import luckynumbers.model.*;
import luckynumbers.view.*;

public class Controller {
	Model game;
	View view;

	public Controller(Model model, View view) {
		game = model;
		this.view = view;
	};

	public void play() {
		Position pos;
		int winner;

		view.displayWelcome();
		while (game.getState() != State.GAME_OVER) {
			switch (game.getState()) {
			case NOT_STARTED:
				int pcount = view.askPlayerCount();
				game.start(pcount);
				break;
			case PICK_TILE:
				game.pickTile();
				break;
			case PLACE_TILE:
				view.displayGame();
				pos = view.askPosition();
				while (!game.canTileBePut(pos)) {
					view.displayError(
							" Mettez une position correct. La position indiquée est inaccessible pour cette tuile.");
					pos = view.askPosition();
				}
				;
				game.putTile(pos);
				break;
			case TURN_END:
				winner = game.getWinner();
				if (winner != -1) {
					view.displayWinner();
				} else {
					game.nextPlayer();
				}
				;
				break;
			default:
				break;
			}
			;
		}
		;
	};
}
