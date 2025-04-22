package player;

import maze.Cell;
import maze.Row;

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
	

}
