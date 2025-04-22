package maze;

import java.util.ArrayList;
import java.util.Objects;

public class Row {

    private ArrayList<Cell> cells;

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
}
