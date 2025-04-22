package maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Grid {

    private List<Row> rows;

    public Grid(List<Row> rows) {
        this.rows = rows;
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
}
