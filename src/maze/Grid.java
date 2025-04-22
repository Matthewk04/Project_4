package maze;

import java.util.ArrayList;

public class Grid {

	private ArrayList<Row> rows;
	
	public Grid(ArrayList<Row> rows) {
		this.rows = rows;
		//here we set reference to this grid in each row
		for (Row row : rows) {
			row.setParentGrid(this);
		}
	}

	public ArrayList<Row> getRows() {
		return rows;
	}

	public void setRows(Object object) {
		this.rows = rows;
		if (rows != null) {
			for (Row row :row) {
				row.setParentGrid(this);
			}
		}
	}
	
	@Override
	public String toString() {
		return "Grid [rows=" + rows+"]";
	}
}
