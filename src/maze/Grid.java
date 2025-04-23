package maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the maze grid that is composed of list of rows.
 * 
 * Fields:
 * - rows: the list of row objects that make up a grid
 * 
 * provides methods to get and set rows
 */

public class Grid {

    private List<Row> rows;

    public Grid(List<Row> rows) {
        this.rows = rows;
        for (Row row : rows) {
        	row.setParentGrid(this);
        }
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Grid [rows=" + rows + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Grid)) return false;
        Grid other = (Grid) obj;
        return Objects.equals(rows, other.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows);
    }

	public static Grid createRandomGrid(int size) {
		if (size < 3 || size > 7) {
			return null;
		}
		List<Row> rows = new ArrayList<>();
		int exitRow = (int)Math.random() * size;
		
		for(int i = 0; i < size; i++) {
			ArrayList<Cell> cells = new ArrayList<>();
			for(int j = 0; j < size; j++) {
				CellComponents left;
				if(j == 0 && i == exitRow) {
					left = CellComponents.EXIT;
				} else if(j == 0) {
					left = CellComponents.WALL;
				} else {
					left = CellComponents.APERTURE;
				}
				
				CellComponents right;
				if(j == size-1) {
					right = CellComponents.WALL;
				} else {
					right = CellComponents.APERTURE;
				}
				
				CellComponents up;
				if(i == 0) {
					up = CellComponents.WALL;
				} else {
					up = CellComponents.APERTURE;
				}
				
				CellComponents down;
				if(i == size-1) {
					down = CellComponents.WALL;
				} else {
					down = CellComponents.APERTURE;
				}
				
				if(j > 0) {
					left = cells.get(j-1).getRight();
				}
				cells.add(new Cell(left, right, up, down));
			}
			rows.add(new Row(cells));
		}
		
		for(int i = 0; i < size - 1; i++) {
			Row currentRow = rows.get(i);
			Row nextRow = rows.get(i+1);
			for(int j = 0; j < size; j++) {
				Cell currentCell = currentRow.getCells().get(j);
				Cell nextCell = nextRow.getCells().get(j);
				currentCell.setDown(nextCell.getUp());
				nextCell.setUp(currentCell.getDown());
			}
		}
		return new Grid(rows);
	}

}
