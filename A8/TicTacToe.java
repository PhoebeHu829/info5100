
import java.util.*;
/**
 * I put some codes I wrote in ticTacToe.java file which can give some tips I think. 
 * You can just delete codes or functions I wrote if you come up with 
 * some other methods to finish the requirements.
 */

public class TicTacToe {

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '}, //0
                {'-', '+', '-', '+', '-'}, //1
                {' ', '|', ' ', '|', ' '}, //2
                {'-', '+', '-', '+', '-'}, //3
                {' ', '|', ' ', '|', ' '}, //4
        };
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("Hola! Welcome to TicTacTow! \nYou will have a TicTacToe battle with CPU,"
        		+ "\nAS player, you will be represented by 'X' and CPU will be represented by 'O' "
        		+ "\nYou will go first everytime! Good Luck & Have Fun!");
        
        System.out.println();
        printGameBoard(gameBoard);
        int step = 0;
      
        while (!gameOver(gameBoard)) {
        	if(checkTie(step)) {
        		System.out.println("CAT!");
        		break;
        	}
        	int playerPos = -1;
        	while(!checkAvailability(gameBoard, playerPos)) {
        	   System.out.println("Enter your placement (1-9): ");
               playerPos = scan.nextInt() - 1;
               System.out.println("Player choose " + (playerPos + 1) + ", Game result for now is ");
               System.out.println();
        	}
        	step++;
            placePiece(gameBoard, playerPos, "player");
            
            if(gameOver(gameBoard)) {
            	break;
            }
            int cpuPos = -1;
            while(!checkAvailability(gameBoard, cpuPos)) {
        		System.out.print("CPU's placement (1-9): ");
        		cpuPos = rand.nextInt(9);
        		System.out.println();
        		System.out.println("CPU choose " + (cpuPos + 1));
        		System.out.println();
        	}
            step++;
            placePiece(gameBoard, cpuPos, "cpu");
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
    	for(int i = 0; i < gameBoard.length; i++) {
    		for(int j = 0; j < gameBoard[0].length; j++) {
    			System.out.print(gameBoard[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println();
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
    	int row = (pos / 3) * 2;
        int col = (pos % 3) * 2; 
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
        } else if (user.equals("cpu")) {
            symbol = 'O';
        }
        gameBoard[row][col] = symbol;
        printGameBoard(gameBoard);
        
        if(gameOver(gameBoard)) {
        	System.out.println(checkWinner(gameBoard));
        }
    }
    
    private static boolean checkAvailability(char[][] gameBoard, int pos) {
//    	System.out.println("You have not choose a position or"
//    			+ " the position you chosen is already taken. "
//    			+ "\nSo make a choice!");
    	if (pos < 0 || pos > 9) {
    		return false;
    	}
    	int row = (pos / 3) * 2;
        int col = (pos % 3) * 2;
        
    	if(gameBoard[row][col] == ' ') {
    		return true;
    	}
    	return false;
    }
    
    public static String checkWinner(char[][] gameBoard) {
    	String results = checking(gameBoard);
    	if (results.equals("none")) {
    		return "Game continues... No winner yet.....";
    	}
    	if(results.equals("X")) {
    		return "Congratulations you won!";
    	}
    	return "CPU wins! Sorry:(";
    }
    
    public static boolean gameOver(char[][] gameBoard)  {
    	String results = checking(gameBoard);
    	if (results.equals("none")) {
    		return false;
    	}
    	return true;
    }
    
    private static boolean checkTie(int step) {
    	return step == 9;
    }
    
    private static String checking(char[][] gameBoard) {
        for(int i = 0; i < gameBoard.length; i = i + 2) {
        	if (gameBoard[i][0] != ' ' && gameBoard[i][0] == gameBoard[i][2] && gameBoard[i][2] == gameBoard[i][4]) {
        		return "" + gameBoard[i][0];
        		
            }
        	
        	if ( gameBoard[0][i] != ' ' &&  gameBoard[0][i] == gameBoard[2][i] && gameBoard[2][i] == gameBoard[4][i]) {
        		return "" + gameBoard[0][i];
        	}
        }
        
        if (gameBoard[0][4] == gameBoard[2][2] && gameBoard[2][2] == gameBoard[4][0]) {
        	if (gameBoard[0][4] != ' ') {
        		return "" + gameBoard[2][2];
        	}
        }
        
        if (gameBoard[0][0] != ' ' && gameBoard[2][2] == gameBoard[0][0] && gameBoard[2][2] == gameBoard[4][4]) {
    		return "" + gameBoard[0][0];
        }
        return "none";
    }
   

}

