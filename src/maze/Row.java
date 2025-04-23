package maze;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a single row in the grid
 * 
 * Fields:
 * -cells: list of cell objects that belong to the row
 * 
 * has methods to get and set the cells
 */

public class Row {

    private ArrayList<Cell> cells;
    private Grid parentGrid;

    public Row(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Row)) return false;
        Row other = (Row) obj;
        return Objects.equals(cells, other.cells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cells);
    }

    @Override
    public String toString() {
        return "Row [cells=" + cells + "]";
    }

	public Grid getParentGrid() {
		return parentGrid;
	}
	
	public void setParentGrid(Grid parentGrid) {
		this.parentGrid = parentGrid;
	}
}
