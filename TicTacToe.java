import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    static String[] gameBoard;
    static String winner;
    static String player;

    public static String whoIsWinner(){

        for (int i=0; i<8; i++){

            String check = null;

            switch (i){

                case 0: check = gameBoard[0] + gameBoard[1] + gameBoard[2];
                        break;

                case 1: check = gameBoard[3] + gameBoard[4] + gameBoard[5];
                        break;

                case 2: check = gameBoard[6] + gameBoard[7] + gameBoard[8];
                        break;

                case 3: check = gameBoard[0] + gameBoard[3] + gameBoard[6];
                        break;

                case 4: check = gameBoard[1] + gameBoard[4] + gameBoard[7];
                        break;

                case 5: check = gameBoard[2] + gameBoard[5] + gameBoard[8];
                        break;

                case 6: check = gameBoard[0] + gameBoard[4] + gameBoard[8];
                        break;

                case 7: check = gameBoard[2] + gameBoard[4] + gameBoard[6];
                        break;

            }

            if(check.equals("XXX"))
                return "X";
            else if (check.equals("OOO"))
                return "O";

        }

        for (int i=0; i<9; i++){

            if(Arrays.asList(gameBoard).contains(String.valueOf(i+1)))
                break;
            else if(i == 8)
                return "Tie";

        }

        System.out.println("Its " + player + " Chance:");

        return null;

    }

    public static void showBoard(){

        System.out.println("#############");
        System.out.println("| " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " |");
        System.out.println("| " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " |");
        System.out.println("| " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " |");
        System.out.println("#############");

    }

    public static void main(String[] args) {

        winner = null;
        player = "X";
        gameBoard = new String[9];

        for(int i=0; i<9; i++){
            gameBoard[i] = String.valueOf(i+1);
        }

        showBoard();

        System.out.println("Its X Chance: ");

        Scanner sc = new Scanner(System.in);

        while(winner == null){

            int input;
            input = sc.nextInt();

            if(input > 0 && input <= 9){

                if(gameBoard[input-1].equals(String.valueOf(input))){

                    gameBoard[input-1] = player;

                    showBoard();

                    if(player == "X")
                        player = "O";
                    else
                        player = "X";

                    winner = whoIsWinner();
                } else {
                    System.out.println("Enter value into another slot as it is already taken");
                }

            }

        }

        if (winner == "Tie")
            System.out.println("Its a Tie!");

        else{
            System.out.println("Congratulations!" + winner + " Wins");
        }

    }
}