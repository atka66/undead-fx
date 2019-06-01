package hu.atka.undeadfx.logic;

import java.util.Random;

public enum Tile {
	MIRROR_DEXTER /* \ */, MIRROR_SINISTER /* / */,
	GHOST, VAMPIRE, ZOMBIE;

	public static Tile randomTile()  {
		Random rand = new Random();
		return Tile.values()[rand.nextInt(Tile.values().length)];
	}
}
