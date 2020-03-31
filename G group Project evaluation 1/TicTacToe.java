public class TicTacToe {

	public static void main(String[] args) {
		char[][] gameBoard= {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '} 
				
		};
		
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.err.println(gameBoard[i][j]);
			}
			System.err.println();
		}
		
	}
}

