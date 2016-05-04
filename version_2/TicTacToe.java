package version_2;

public interface TicTacToe {
	public abstract void playGame();
	public abstract void makeMove(int x, int y, int currentPlayer);
	public abstract Boolean checkLines(int x, int y, String s);
	public abstract Boolean checkDiag(int x, int y, String s);
	public abstract void checkBoard(int x, int y);
}
