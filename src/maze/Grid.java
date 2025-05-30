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

    /**
     * Generates a random grid of the provided size
     * @param size grid dimensions
     * @return new random grid
     */
	public static Grid createRandomGrid(int size) {
		if (size < 3 || size > 7) {
			return null;
		}
		List<Row> rows = new ArrayList<>();
		int exitRow = (int)(Math.random() * size);
		
		for(int i = 0; i < size; i++) {
			ArrayList<Cell> cells = new ArrayList<>();
			for(int j = 0; j < size; j++) {
				CellComponents left = CellComponents.WALL;
				CellComponents right = CellComponents.WALL;
				CellComponents up = CellComponents.WALL;
				CellComponents down = CellComponents.WALL;
				
				//deals with the left and right
				if(j == 0) {
					if(i == exitRow) {
						left = CellComponents.EXIT;
					} else {
						left = CellComponents.WALL;
					}
					right = CellComponents.APERTURE;
				} else if(j == size - 1) {
					left = cells.get(j-1).getRight();
					right = CellComponents.WALL;
				} else {
					left = cells.get(j-1).getRight();
					right = CellComponents.APERTURE;
				}
				
				//deals with up and down
				if(i == 0) {
					up = CellComponents.WALL;
					down = CellComponents.APERTURE;
				} else if(i == size-1) {
					up = CellComponents.APERTURE;
					down = CellComponents.WALL;
				} else {
					up = CellComponents.APERTURE;
					down = CellComponents.APERTURE;
				}
				cells.add(new Cell(left, right, up, down));
				
			}
			rows.add(new Row(cells));
		}
		
		return new Grid(rows);
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
    
	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}

}