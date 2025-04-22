package maze;

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
