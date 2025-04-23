package game;

import player.Player;
import player.Movement;

import java.util.List;

import maze.Cell;
import maze.CellComponents;
import maze.Grid;
import maze.Row;

/**
 * represents the logic of the game
 * 
 * fields:
 * -grid: the maze that is used in teh game
 * 
 * provides methods to get and set the grid and moove the player based on input
 */

public class Game {
	
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RESET = "\u001B[0m";
    
    private Grid grid;
    
    public Game(Grid grid) {
    	this.grid = grid;
    }
    
    public Game(int i) {
        this.grid = Grid.createRandomGrid(i);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public boolean play(Movement movement, Player player) {
        if (movement == null || player == null) {
            return false; // invalid movement or null player
        }
        
        boolean result = false;
        
        switch (movement) {
            case UP:
                result = player.moveUp();
                break;
            case DOWN:
                result = player.moveDown();
                break;
            case LEFT:
                result = player.moveLeft();
                break;
            case RIGHT:
                result = player.moveRight();
                break;
        }
        
        return result;
    }
    
    

    @Override
    public String toString() {
        return "Game [grid=" + grid + "]";
    }

	public Grid createRandomGrid(int i) {
		return Grid.createRandomGrid(i);
	}
	
	public void printGrid(Player player) {
		List<Row> rows = grid.getRows();
		for(Row row : rows) {
			StringBuilder sb = new StringBuilder();
			List<Cell> cells = row.getCells();
			for(int j = 0; j < cells.size(); j++) {
				Cell cell = cells.get(j);
				
				if(player.getCurrentRow() == row && player.getCurrentCell() == cell) {
					sb.append(ANSI_BLUE + "A" + ANSI_RESET);
				} else if(j == 0 && cell.getLeft() == CellComponents.EXIT) {
					sb.append(ANSI_GREEN + "E" + ANSI_RESET);
				} else {
					sb.append("S");
				}
				if(j < cells.size()-1) {
					sb.append(" ");
				}
			}
			System.out.println(sb);
		}
	}

}
