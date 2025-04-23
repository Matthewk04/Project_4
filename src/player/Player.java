package player;

import maze.Cell;
import maze.Row;
import maze.Grid;
import maze.CellComponents;

import java.util.List;

/**
 * Represents a player within a grid.
 * Allows the player to move up, down, left, and right.
 * But the player can move only if the path contains an APERTURE or EXIT.
 *
 * Fields:
 * - currentRow: The current row the player is located in.
 * - currentCell: The current cell the player occupies in the row.
 */

public class Player {

    private Row currentRow;
    private Cell currentCell;

    public Player(Row currentRow, Cell currentCell) {
        this.currentRow = currentRow;
        this.currentCell = currentCell;
    }

    public Row getCurrentRow() {
        return currentRow;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentRow(Row currentRow) {
        this.currentRow = currentRow;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public boolean moveUp() {
        Grid grid = currentRow.getParentGrid();
        List<Row> rows = grid.getRows();
        int currentRowIndex = rows.indexOf(currentRow);  
        int currentCellIndex = currentRow.getCells().indexOf(currentCell);

        CellComponents upComponent = currentCell.getUp();
        if(upComponent == CellComponents.EXIT) {
        	return true;
        }
        if (currentRowIndex > 0) {
            Cell aboveCell = rows.get(currentRowIndex - 1).getCells().get(currentCellIndex);
            if (upComponent == CellComponents.APERTURE) {
                this.currentRow = rows.get(currentRowIndex - 1);
                this.currentCell = aboveCell;
                return true;
            }
        }
        return false;
    }

    public boolean moveDown() {
        Grid grid = currentRow.getParentGrid();
        List<Row> rows = grid.getRows();
        int currentRowIndex = rows.indexOf(currentRow);  
        int currentCellIndex = currentRow.getCells().indexOf(currentCell);

        CellComponents downComponent = currentCell.getDown();
        if(downComponent == CellComponents.EXIT) {
        	return true;
        }
        if (currentRowIndex < rows.size() - 1) {
            Cell belowCell = rows.get(currentRowIndex + 1).getCells().get(currentCellIndex);
            if (downComponent == CellComponents.APERTURE) {
                this.currentRow = rows.get(currentRowIndex + 1);
                this.currentCell = belowCell;
                return true;
            }
        }
        return false;
    }

    public boolean moveLeft() {
        List<Cell> cells = currentRow.getCells();
        int currentCellIndex = cells.indexOf(currentCell);

        CellComponents leftComponent = currentCell.getLeft();
        if(leftComponent == CellComponents.EXIT) {
        	return true;
        }
        if (currentCellIndex > 0) {
            Cell leftCell = cells.get(currentCellIndex - 1);
            if (leftComponent == CellComponents.APERTURE) {
                this.currentCell = leftCell;
                return true;
            }
        }
        return false;
    }

    public boolean moveRight() {
        List<Cell> cells = currentRow.getCells();
        int currentCellIndex = cells.indexOf(currentCell);

        CellComponents rightComponent = currentCell.getRight();
        if(rightComponent == CellComponents.EXIT) {
        	return true;
        }
        if (currentCellIndex < cells.size() - 1) {
            Cell rightCell = cells.get(currentCellIndex + 1);
            if (rightComponent == CellComponents.APERTURE) {
                this.currentCell = rightCell;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
    }

}
