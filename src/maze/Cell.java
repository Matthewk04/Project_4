package maze;

/**
 * represents a single cell in the grid
 * 
 * fields:
 * -left  :  what is on the left
 * -right :  what is on the right
 * -up    : what is above
 * -down  : what is below
 */

public class Cell {
    
    private CellComponents left;
    private CellComponents right;
    private CellComponents up;
    private CellComponents down;

    public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
    }

    
    //Getters
    public CellComponents getLeft() {
        return left;
    }

    public CellComponents getRight() {
        return right;
    }


    public CellComponents getUp() {
        return up;
    }

   
    public CellComponents getDown() {
        return down;
    }
    
    //Setters
    public void setLeft(CellComponents left) {
    	if(left != null) {
    		this.left = left;
    	} else {
    		this.left = CellComponents.WALL;
    	}
    }
    
    public void setRight(CellComponents right) {
    	if(right != null) {
    		this.right = right;
    	} else {
    		this.right = CellComponents.WALL;
    	}
    }
    
    public void setUp(CellComponents up) {
    	if(up != null) {
    		this.up = up;
    	} else {
    		this.up = CellComponents.WALL;
    	}
    }

    public void setDown(CellComponents down) {
    	if(down != null) {
    		this.down = down;
    	} else {
    		this.down = CellComponents.WALL;
    	}
    }

    @Override
    public String toString() {
        return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
    }
}
