package maze;

import java.util.Objects;

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

    public CellComponents getLeft() {
        return left;
    }

    public void setLeft(CellComponents left) {
        if (left != null) {
            this.left = left;
        }
    }

    public CellComponents getRight() {
        return right;
    }

    public void setRight(CellComponents right) {
        if (right != null) {
            this.right = right;
        }
    }

    public CellComponents getUp() {
        return up;
    }

    public void setUp(CellComponents up) {
        if (up != null) {
            this.up = up;
        }
    }

    public CellComponents getDown() {
        return down;
    }

    public void setDown(CellComponents down) {
        if (down != null) {
            this.down = down;
        }
    }

    @Override
    public String toString() {
        return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cell)) return false;
        Cell other = (Cell) obj;
        return left == other.left &&
               right == other.right &&
               up == other.up &&
               down == other.down;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, up, down);
    }
}
