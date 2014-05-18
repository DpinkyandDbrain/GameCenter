package gamecenter.board;
public class Move {
	protected Point point;
	protected int row;
	protected int col;
	
	public Move(Board goBoard, Point point, int row, int col) {
		if (row < 0 || row > 19) {
	        throw new IllegalArgumentException("Invalid row value: " + row);
	    }

		if (col < 0 || col > 19) {
	        throw new IllegalArgumentException("Invalid col value: " + col);
	    }
		
		this.point = point;
		this.row = row;
		this.col = col;
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
}
