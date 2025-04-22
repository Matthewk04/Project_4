package game;

import player.Player;
import player.Movement;
import maze.Grid;

public class Game {
    
    private Grid grid;
    
    public Game(Grid grid) {
        this.grid = grid;
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
}
