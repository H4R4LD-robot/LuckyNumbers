package luckynumbers.model;
import java.util.Random;

public class Game implements Model {
	State state;
	int playerCount;
	int currentPlayerNumber;
	Board[] boards;
	Tile pickedTile;
	
	public Game(){
		state = State.NOT_STARTED;
	}

	public void start(int PlayerCount) {
		playerCount = PlayerCount;
		currentPlayerNumber = 0;
		boards = new Board[PlayerCount];
		for (int i = 0; i < PlayerCount; i++) {
			boards[i] = new Board();
		};
		state = State.PICK_TILE;
	}

	public Tile pickTile() {
		state = State.PLACE_TILE;
		Random rand = new Random();
		pickedTile = new Tile(rand.nextInt(20)+1);
		return pickedTile;
	}

	public void putTile(Position pos) {
		state = State.TURN_END;
		boards[currentPlayerNumber].put(pickedTile, pos);
	}

	public void nextPlayer() {
		state = State.PICK_TILE;
		if (currentPlayerNumber == (playerCount-1)) {
			currentPlayerNumber -= (playerCount-1);
		} else {
			currentPlayerNumber++;
		};
	}

	public int getBoardSize() {
		return boards[currentPlayerNumber].getSize();
	}

	public State getState() {
		return state;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public int getCurrentPlayerNumber() {
		return currentPlayerNumber;
	}

	public Tile getPickedTile() {
		return pickedTile;
	}

	public boolean isInside(Position pos) {
		return boards[currentPlayerNumber].isInside(pos);
	}

	public boolean canTileBePut(Position pos) {
		return boards[currentPlayerNumber].canBePut(pickedTile, pos);
	}

	public Tile getTile(int playerNumber, Position pos) {
		return boards[playerNumber].getTile(pos);
	}

	public int getWinner() {
		for (int i = 0; i < playerCount; i++) {
			if (boards[i].isFull()) {
				state = State.GAME_OVER;
				return i;
			};
		};
		return -1;
	};
	
}
