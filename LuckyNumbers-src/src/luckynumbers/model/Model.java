package luckynumbers.model;

public interface Model {
	// Action
	public void start(int PlayerCount);
	public Tile pickTile();
	public void putTile(Position pos);
	public void nextPlayer();
	
	// Info
	public int getBoardSize();
	public State getState();
	public int getPlayerCount();
	public int getCurrentPlayerNumber();
	public Tile getPickedTile();
	public boolean isInside(Position pos);
	public boolean canTileBePut(Position pos);
	public Tile getTile(int playerNumber, Position pos);
	public int getWinner();
}
