package hu.atka.undeadfx.logic;

import hu.atka.undeadfx.resources.Settings;

public class Game {

	private Tile[][] map;

	private int[][] horizontalVisible;
	private int[][] verticalVisible;

	public Game() {
		this.generateMap();
	}

	private void generateMap() {
		map = new Tile[Settings.GRID_SIZE_Y][Settings.GRID_SIZE_X];
		horizontalVisible = new int[2][Settings.GRID_SIZE_Y];
		verticalVisible = new int[2][Settings.GRID_SIZE_X];

		// randomize tiles
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Tile.randomTile();
			}
		}

		// calculate visibility
		for (int i = 0; i < horizontalVisible[0].length; i++) {
			int x = -1;
			int y = i;
			int visible = 0;
			boolean hitMirror = false;
			Direction direction = Direction.RIGHT;
			do {
				switch (direction) {
					case DOWN:
						break;
					case LEFT:
						break;
					case RIGHT:
						x++;
						break;
					case UP:
						break;
				}
				if (map[y][x] == Tile.MIRROR_DEXTER) {
					direction = Direction.DOWN;
				}
				if (map[y][x] == Tile.MIRROR_SINISTER) {
					direction = Direction.UP;
				}
			} while (isInBoundaries(x, y));
		}
		for (int i = 0; i < horizontalVisible[1].length; i++) {

		}
	}

	private boolean isInBoundaries(int x, int y) {
		return x >= 0 && x < Settings.GRID_SIZE_X && y >= 0 && y < Settings.GRID_SIZE_Y;
	}

	public void putTile(int x, int y, Tile tile) {
		Tile currentTile = map[y][x];
		if (currentTile != Tile.MIRROR_DEXTER && currentTile != Tile.MIRROR_SINISTER) {
			map[y][x] = tile;
		}
	}

	public Tile[][] getMap() {
		return map;
	}

	public int[] getHorizontalVisible() {
		return horizontalVisible;
	}

	public int[] getVerticalVisible() {
		return verticalVisible;
	}
}
