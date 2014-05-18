package gamecenter.board;

public class GamePiece {
	
	private class CurrPosition{
		private int _x = 0;
		private int _y = 0;
		void setPosition(int x,int y){
			_x = x;
			_y = y;
		}
		
		int[] getPosition(){
			return new int[]{_x,_y};
		}
	}
	
	CurrPosition cp = new CurrPosition();
	
	//other MetaData?
}
