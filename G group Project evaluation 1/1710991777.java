package Shubham;

import java.util.*;

public class TicTacToe {
	
	private static void printGameBoard(char[][] gameBoard) {
		for(int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	private static boolean placeMove(char[][] gameBoard,int pos,String user) {
		char move=' ';
		if(user.equals("player1"))
			move='X';
		else if(user.equals("player2"))
			move='O';
		
		switch (pos) {
		case 1:
			if(gameBoard[0][0]==' ') {
				gameBoard[0][0]=move;
				printGameBoard(gameBoard);
				return true;
			}
			else {
				System.out.println("Move Invalid");
				return false;
			}
			
		case 2:
			if(gameBoard[0][2]==' ') {
				gameBoard[0][2]=move;
				printGameBoard(gameBoard);
				return true;
			}
			else {
				System.out.println("Move Invalid");
				return false;
			}
		case 3:
			if(gameBoard[0][4]==' ') {
				gameBoard[0][4]=move;
				printGameBoard(gameBoard);
				return true;
			}
			else {
				System.out.println("Move Invalid");
				return false;
			}			
		case 4:
			if(gameBoard[2][0]==' ') {
				gameBoard[2][0]=move;
				printGameBoard(gameBoard);
				return true;
			}
			else {
				System.out.println("Move Invalid");
				return false;
			}			
		case 5:
			if(gameBoard[2][2]==' ') {
				gameBoard[2][2]=move;
				printGameBoard(gameBoard);
				return true;
			}
			else {
				System.out.println("Move Invalid");
				return false;
			}			
		case 6:
			if(gameBoard[2][4]==' ') {
				gameBoard[2][4]=move;
				printGameBoard(gameBoard);
				return true;
			}
			else {
				System.out.println("Move Invalid");
				return false;
			}			
		case 7:
			if(gameBoard[4][0]==' ') {
				gameBoard[4][0]=move;
				printGameBoard(gameBoard);
				return true;
			}
			else {
				System.out.println("Move Invalid");
				return false;
			}
		case 8:
			if(gameBoard[4][2]==' ') {
				gameBoard[4][2]=move;
				printGameBoard(gameBoard);
				return true;
			}
			else {
				System.out.println("Move Invalid");
				return false;
			}
		case 9:
			if(gameBoard[4][4]==' ') {
				gameBoard[4][4]=move;
				printGameBoard(gameBoard);
				return true;
			}
			else {
				System.out.println("Move Invalid");
				return false;
			}
		default:
			System.out.println("Move Invalid");
			return false;
		}
	}
	private static String getResult(char[][] gameBoard){
		for(int i=0;i<gameBoard.length;i+=2) {
			String ans=rowCheck(gameBoard,i);
			if(ans=="0")
				continue;
			else
				return ans;
		}
		for(int i=0;i<gameBoard.length;i+=2) {
			String ans=columnCheck(gameBoard,i);
			if(ans=="0")
				continue;
			else
				return ans;
		}
		String d1=""+gameBoard[0][0]+gameBoard[2][2]+gameBoard[4][4];
		//System.out.print(d1+" ");
		if(d1.equals("XXX"))
			return "X";
		else if(d1.equals("OOO"))
			return "O";
		
		String d2=""+gameBoard[0][4]+gameBoard[2][2]+gameBoard[4][0];
		//System.out.println(d2);
		if(d2.equals("XXX"))
			return "X";
		else if(d2.equals("OOO"))
			return "O";
		
		return "0";
	}
	private static String columnCheck(char[][] gameBoard, int in) {
		String str="";
		for(int i=0;i<gameBoard[in].length;i+=2) {
			str+=gameBoard[i][in];
		}
		//System.out.println(str);
		if(str.equals("XXX")) 
			return "X";
		else if(str.equals("OOO"))
			return "O";
			
		return "0";
	}
	private static String rowCheck(char[][] gameBoard, int in) {
		String str="";
		for(int i=0;i<gameBoard[in].length;i+=2) {
			str+=gameBoard[in][i];
		}
		//System.out.println(str);
		if(str.equals("XXX")) 
			return "X";
		else if(str.equals("OOO"))
			return "O";
		return "0";
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Random rn=new Random();
		char[][] gameBoard= {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
		};
		printGameBoard(gameBoard);
		System.out.println("Select Mode:");
		System.out.println("Press 1 for Player v/s CPU");
		System.err.println("Press 2 for Player v/s Player");
		int ch=s.nextInt();
		String ans="";
		switch (ch) {
		case 1:
			int pos=0,cpos=0;
			for(int i=1;i<=9;i++) {

				if(i%2!=0) {
					System.out.println("Place your move Player-1:");
					pos=s.nextInt();
					boolean valid=placeMove(gameBoard, pos, "player1");
					while(valid!=true) {
						pos=s.nextInt();
						valid=placeMove(gameBoard, pos, "player1");
					}
				}
				else {
					cpos=rn.nextInt(9)+1;
					boolean valid=placeMove(gameBoard, cpos, "player2");
					while(valid!=true) {
						cpos=rn.nextInt(9)+1;
						valid=placeMove(gameBoard, cpos, "player2");
					}	
				}
				if(i>4) {
					ans=getResult(gameBoard);
					if(ans=="0")
						continue;
					else if(ans=="X"){
						System.out.println("Player wins");
						break;
					}
					else {
						System.out.println("CPU wins");
						break;
					}
				}
			}
			if(ans=="0")
				System.out.println("Draw");
			break;
		case 2:
			pos=0;
			for(int i=1;i<=9;i++) {

				if(i%2!=0) {
					System.out.println("Place your move Player-1:");
					pos=s.nextInt();
					boolean valid=placeMove(gameBoard, pos, "player1");
					while(valid!=true) {
						pos=s.nextInt();
						valid=placeMove(gameBoard, pos, "player1");
					}
				}
				else {
					//int cpos=rn.nextInt(9)+1;
					System.out.println("Place your move Player-2:");
					pos=s.nextInt();
					boolean valid=placeMove(gameBoard, pos, "player2");
					while(valid!=true) {
						pos=s.nextInt();
						valid=placeMove(gameBoard, pos, "player2");
					}	
				}
				if(i>4) {
					ans=getResult(gameBoard);
					if(ans=="0")
						continue;
					else if(ans=="X"){
						System.out.println("Player1 wins");
						break;
					}
					else {
						System.out.println("Player2 wins");
						break;
					}
				}
			}
			if(ans=="0")
				System.out.println("Draw");
			break;
		default:
			System.out.print("Option Invalid");
			break;
		}
		s.close();
	}
}

