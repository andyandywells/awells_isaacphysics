package version_2;

public abstract class Game implements TicTacToe {
	
	int user; // 1 for 1 player, 2 for 2 player
	int boardDimm; // must be square 
	String [][] board;
	int gameCount;
	Boolean inPlay;
	Boolean moveMade;
	int xCoord, yCoord;
	int currentPlayer; // player 0 or player 1
	
	
	public void makeMove(int x, int y, int currentPlayer) {
		String move = (currentPlayer == 1) ? "O" : "X";

		if(board[x][y].equals("_")) { // move can be made
			board[x][y] = move;
			moveMade = true;
			
		}
		else {
			moveMade = false;
		}
	}
	
	public void checkBoard(int x, int y) {
		String s = board[x][y];
		Boolean checker = checkLines(x, y, s) ^ checkDiag(x,y,s);
		if(checker) {
			inPlay = false;
			
		}
		else {
			inPlay = true;
		}
	}
	
	public abstract void playGame();
	public Boolean checkLines(int x, int y, String s) {
		// check to the right
		if(board[x+1][y].equals(s) && board[x+2][y].equals(s)) {
			return true;
		}
		// check to the left
		if(board[x-1][y].equals(s) && board[x-2][y].equals(s)) {
			return true;
		}
		// check up
		if(board[x][y+1].equals(s) && board[x][y+2].equals(s)) {
			return true;
		}
		// check down
		if(board[x][y-1].equals(s) && board[x][y-2].equals(s)) {
			return true;
		}
		// check for middle pieces
		if(board[x][y-1].equals(s) && board[x][y+1].equals(s)) {
			return true;
		}
		if(board[x-1][y].equals(s) && board[x+1][y].equals(s)) {
			return true;
		}
		return false;
	}
	public Boolean checkDiag(int x, int y, String s) {
				// check for bottom left to top right 
				if(board[x+1][y+1].equals(s) && board[x+2][y+2].equals(s)) {
					return true;
				}
				// check for bottom right to top left
				else if(board[x-1][y+1].equals(s) && board[x-2][y+2].equals(s)) {
					return true;
				}
				// check for top right to bottom left
				else if(board[x-1][y-1].equals(s) && board[x-2][y-2].equals(s)) {
					return true;
				}		
				// check for top left to bottom right
				else if(board[x+1][y-1].equals(s) && board[x+2][y-2].equals(s)) {
					return true;
				}
				// check for diagonal from middle top left, bottom right
				else if(board[x-1][y+1].equals(s) && board[x+1][y-1].equals(s)) {
					return true;
				}
				// check for diagonal from middle top right, bottom left
				else if(board[x+1][y+1].equals(s) && board[x-1][y-1].equals(s)) {
					return true;
				}
				else {
					return false;
				}			
	}

}
