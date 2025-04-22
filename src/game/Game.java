package game;

import maze.Grid;
import maze.Row;
import maze.Cell;
import maze.CellComponents;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    
    private Grid grid;

    // Constructor accepting a grid
    public Game(Grid grid) {
        this.grid = grid;
    }

    // Constructor that creates a random grid based on the provided size
    public Game(int size) {
        if (size < 3 || size > 7) {
            this.grid = null; // Invalid size
        } else {
            this.grid = createRandomGrid(size); // Valid size, create random grid
        }
    }

    // Method to generate a random grid of the given size
    public Grid createRandomGrid(int size) {
        if (size < 3 || size > 7) return null;

        Random rand = new Random();
        List<Row> rows = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Cell> cells = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                // Randomly assign cell components (just an example, can modify this logic)
                CellComponents left = rand.nextBoolean() ? CellComponents.WALL : CellComponents.APERTURE;
                CellComponents right = rand.nextBoolean() ? CellComponents.WALL : CellComponents.APERTURE;
                CellComponents up = rand.nextBoolean() ? CellComponents.WALL : CellComponents.APERTURE;
                CellComponents down = rand.nextBoolean() ? CellComponents.WALL : CellComponents.APERTURE;
                cells.add(new Cell(left, right, up, down));
            }
            rows.add(new Row(cells));
        }
        return new Grid(rows); // Return the newly created grid
    }

    // Getter for the grid
    public Grid getGrid() {
        return grid;
    }

    // Method to perform a movement action for the player
    public boolean play(Movement action, Player player) {
        if (action == null || player == null) return false; // Invalid input check

        // Handle different movement actions
        switch (action) {
            case UP:
                return player.moveUp();
            case DOWN:
                return player.moveDown();
            case LEFT:
                return player.moveLeft();
            case RIGHT:
                return player.moveRight();
            default:
                return false;
        }
    }

    // Setter for the grid (useful for replacing the grid)
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    // ToString method to return a string representation of the game
    @Override
    public String toString() {
        return "Game [grid=" + grid + "]";
    }
}
