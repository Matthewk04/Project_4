package game;

import maze.Grid;
import player.Player;

public class Game {
	
	private Grid grid;

	public Game(Grid grid) {
		this.grid = grid;
	}

	public Game(int i) {
		if (size < 3 || size > 7) {
			this.grid = null;
		}else {
			this.grid=createRandomGrid(size);
		}
	}

	public Grid createRandomGrid(int i) {
		if (size<3||size>7) return null;
		
		Random rand = new Random
	}

	public Object getGrid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object play(Object action, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setGrid(Object object) {
		// TODO Auto-generated method stub
		
	}

}
