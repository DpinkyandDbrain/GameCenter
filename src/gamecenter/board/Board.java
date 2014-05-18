package gamecenter.board;
//TODO id to make sure player is really who they say they are
//ranking system (lvl 1 = 1 win, 2 = 2, +1/-1 for win/loss, 0 pnt minimum), player seed breaks tie
//who goes first system

public class Board {
	static Point[][] board;
	static Point turn;
	static int rows;
	static int cols;

	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		
		board = new Point[rows][cols];
		turn = Point.BLACK;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Point.EMPTY;
			}
		}
	}

	public static int getRows() {
		return rows;
	}

	public static void setRows(int rows) {
		Board.rows = rows;
	}

	public static int getCols() {
		return cols;
	}

	public static void setCols(int cols) {
		Board.cols = cols;
	}

	private void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private boolean makeMove(Move move) throws IllegalMoveException {
		boolean moveMade = false;

		if (validateMove(move)) {
			board[move.row][move.col] = move.point;
			this.switchTurn();
		}else{
			throw new IllegalMoveException("Invalid move attempted");
		}

		return moveMade;
	}

	private void switchTurn(){
		if(Board.turn == Point.WHITE){
			Board.turn = Point.BLACK;
		}else{
			Board.turn = Point.WHITE;			
		}
	}
	
	private boolean validateMove(Move move) {
		boolean validity = false;
		if(board[move.row][move.col] == Point.EMPTY){
			if(move.point == Board.turn){
				validity = true;
			}
		}
		return validity;
	}

	public static void main(String args[]) throws Exception {
		//put in config files to read from to make a game
		int rows = 19;
		int cols = 19;
		if(args.length > 0){
			if(args[0].equals("-h") || args[0].equals("--help")){
				System.out.println("------------------------------------------\n");
				System.out.println("Usage: \n");
				System.out.println("java -jar Game.jar -c <# of Columns> -r <# of rows> \n");
				System.out.println("Defaults are 19X19\n");
				System.out.println("------------------------------------------\n");
				return;
			}
			
			if(args[0].equals("-c")){
				cols = new Integer(args[1]);
			} else if(args[2].equals("-c")){
				cols = new Integer(args[3]);
			} else if(args[0].equals("-r")){
				rows = new Integer(args[1]);
			} else if(args[2].equals("-r")){
				rows = new Integer(args[3]);
			}
		}

		Board myGoBoard = new Board(rows, cols);
//		myGoBoard.makeMove(new Move(myGoBoard, Point.BLACK, 3, 5));
//		myGoBoard.makeMove(new Move(myGoBoard, Point.WHITE, 2, 2));
		myGoBoard.printBoard();
//		
//		myGoBoard.makeMove(new Move(myGoBoard, Point.BLACK, 3, 6));
//		myGoBoard.makeMove(new Move(myGoBoard, Point.BLACK, 3, 5));
	}

}
