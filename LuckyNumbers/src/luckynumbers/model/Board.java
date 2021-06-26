package luckynumbers.model;

public class Board {
	Tile[][] tiles;
	
	public Board() {
		tiles = new Tile[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tiles[i][j] = null;
			};
		};
	};
	
	public int getSize() {
		return tiles.length;
	};
	public boolean isInside(Position pos) {
		return pos.getRow() < tiles.length & pos.getColumn() < tiles.length;
	};
	
	public Tile getTile(Position pos) {
		return tiles[pos.getRow()][pos.getColumn()];
	};
	
	public boolean canBePut(Tile tile, Position pos) {
		if (tiles[pos.getRow()][pos.getColumn()] != null) {
			return false;
		};
		
		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i][pos.getColumn()] != null) {
				if ((i > pos.getRow()) & (tiles[i][pos.getColumn()].getValue() <= tile.getValue())) {
					return false;
				} else if ((i < pos.getRow()) & (tiles[i][pos.getColumn()].getValue() >= tile.getValue())) {
					return false;
				};
			};
				
			if (tiles[pos.getRow()][i] != null)
			{
				if ((i < pos.getColumn()) & (tiles[pos.getRow()][i].getValue() >= tile.getValue())) {
					return false;
				} else if ((i > pos.getColumn()) & (tiles[pos.getRow()][i].getValue() <= tile.getValue())) {
					return false;
				};
			};
		};
		return true;
	};
	
	public void put(Tile tile, Position pos) {
		tiles[pos.getRow()][pos.getColumn()] = tile;
	};
	
	public boolean isFull() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tiles[i][j] == null) {
					return false;
				}
			};
		};
		return true;
	};
	
	public void getB() {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j] != null) {
					System.out.print(tiles[i][j].getValue() + " ");
				} else {
					System.out.print("  ");
				};
			};
			System.out.println();
		};
	};
}
