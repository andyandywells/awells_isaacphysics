package version_2;

import java.util.Scanner;

public class ConsoleGame extends Game {

	public ConsoleGame(int user, int boardDimm) throws InvalidOptionException {
		super();
		if (user == 1 || user == 2) {
			this.user = user;
			this.boardDimm = boardDimm;
			board = new String[boardDimm + 2][boardDimm + 2];
			this.gameCount = 9; // max number of moves before draw
			this.inPlay = true; // true until one person wins
			setupBoard();
		} else
			throw new InvalidOptionException("Invalid option");
	}

	public void playGame() {

		while (gameCount > 0 && inPlay) {
			System.out.println("Current player: " + currentPlayer);
			System.out.println();
			try {
				player();
				if (moveMade) {
					gameCount--;
					currentPlayer = currentPlayer ^ 1;
				} else {
					System.out.println();
					System.out.println("Cannot make that move");
					try {
						player();
					} catch (InvalidOptionException e) {
						e.printStackTrace();
					}
				}
			} catch (InvalidOptionException e1) {
				e1.printStackTrace();
			}
			
		}
		if (!inPlay) {
			int winner = (currentPlayer == 1) ? 0 : 1;
			System.out.println("Winner is: " + winner);
		}
		else {
			System.out.println("It's a draw!");
		}
	}
	
	public void player() throws InvalidOptionException {
		Scanner in = new Scanner(System.in);
		System.out.println("Choose a coordinate to place your counter in form x-y");
		String playerChoice = in.nextLine();
		String[] coordinates = playerChoice.split("-");

		try {
			int x = Integer.parseInt(coordinates[0]);
			int y = Integer.parseInt(coordinates[1]);
			if (x >= 0 && x < 3 && y >= 0 && y < 3) {
				xCoord = x + 1;
				yCoord = y + 1;
			} else {
				System.out.println("Invalid coordinates. Try again.");

				player();
			}
		} catch (NumberFormatException e) {
			throw new InvalidOptionException("Invalid Coordinates");
		}

		makeMove(xCoord, yCoord, currentPlayer);
		if (moveMade == true)
			printBoard();
		super.checkBoard(xCoord, yCoord);

	}

	public void printBoard() {
		for (int dy = boardDimm; dy >= 1; dy--) {
			for (int dx = 1; dx < boardDimm + 1; dx++) {
				System.out.print(board[dx][dy]);
			}
			System.out.println();
		}
	}

	public void setupBoard() {
		for (int dy = 0; dy < boardDimm + 2; dy++) {
			for (int dx = 0; dx < boardDimm + 2; dx++) {
				board[dx][dy] = "_";
			}
		}
	}

	public static void main(String args[]) throws InvalidOptionException {
		ConsoleGame test = new ConsoleGame(1, 3);

		// positions are shifted one right and one up
		// board goes from (1,1) to (3,3)
		/*
		 * test.board[1][1] = "X"; test.board[2][1] = "X"; test.board[3][3] =
		 * "X"; test.printBoard(); test.checkBoard(1, 1);
		 */
		test.playGame();
	}





}
