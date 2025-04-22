package maze;

/**
 * Enum that represents the possible components of a cell
 *
 * Values:
 * - EXIT : where you exit
 * - APERTURE: an open path
 * - WALL: its a wall
 */


public enum CellComponents {

	EXIT,
	APERTURE,
	WALL;
	
	@Override
	public String toString() {
		return switch(this) {
		case WALL -> "W";
		case APERTURE -> " ";
		case EXIT -> "E";
		};
	}

}
