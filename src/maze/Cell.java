package maze;

import java.util.ArrayList;

public class Cell {
	
	private CellComponents up;
	private CellComponents down;
	private CellComponents left;
	private CellComponents right;
	

	public Cell(CellComponents up, CellComponents down, CellComponents left, CellComponents right) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}

	public ArrayList<Cell> getCells() {
		// TODO Auto-generated method stub
		return null;
	}

	public CellComponents getUp() {
		return up;
	}

	public void setUp(CellComponents up) {
		this.up = up;
	}

	public CellComponents getDown() {
		return down;
	}

	public void setDown(CellComponents down) {
		this.down = down;
	}

	public CellComponents getLeft() {
		return left;
	}

	public void setLeft(CellComponents left) {
		this.left = left;
	}

	public CellComponents getRight() {
		return right;
	}

	public void setRight(CellComponents right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Cell [up=" + up + ", down=" + down + ", left=" + left + ", right=" + right + "]";
	}


}
