package player;

import maze.Cell;
import maze.Row;
import maze.Grid;
import maze.CellComponents;

import java.util.List;

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

        if (currentRowIndex > 0) {
            CellComponents upComponent = currentCell.getUp();
            Cell aboveCell = rows.get(currentRowIndex - 1).getCells().get(currentCellIndex);
            if (upComponent == CellComponents.APERTURE || upComponent == CellComponents.EXIT) {
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

        if (currentRowIndex < rows.size() - 1) {
            CellComponents downComponent = currentCell.getDown();
            Cell belowCell = rows.get(currentRowIndex + 1).getCells().get(currentCellIndex);
            if (downComponent == CellComponents.APERTURE || downComponent == CellComponents.EXIT) {
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

        if (currentCellIndex > 0) {
            CellComponents leftComponent = currentCell.getLeft();
            Cell leftCell = cells.get(currentCellIndex - 1);
            if (leftComponent == CellComponents.APERTURE || leftComponent == CellComponents.EXIT) {
                this.currentCell = leftCell;
                return true;
            }
        }
        return false;
    }

    public boolean moveRight() {
        List<Cell> cells = currentRow.getCells();
        int currentCellIndex = cells.indexOf(currentCell);

        if (currentCellIndex < cells.size() - 1) {
            CellComponents rightComponent = currentCell.getRight();
            Cell rightCell = cells.get(currentCellIndex + 1);
            if (rightComponent == CellComponents.APERTURE || rightComponent == CellComponents.EXIT) {
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
