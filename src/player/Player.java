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

	public Object getCurrentRow() {
		return currentRow;
	}

	public Object getCurrentCell() {
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
		int currentRowIndex = row.indexOf(currentRow);
		int currentCellIndex = currentRow.getCells().indexOf(currentCell);
		
		if (currentRowIndex > 0) {
			CellComponents upComponent = currentCell.getUp();
			Cell aboveCell = rows.get(currentRowIndex-1).getCells().get(currentCellIndex);
			if (upComponent == CellComponents.APERTURE || upComponent == CellComponents.EXIT) {
				this.currentRow = rows.get(currentRowIndex-1);
				this.currentCell = aboveCell;
				return true;
			}
		}
		return false;
	}
	

}
