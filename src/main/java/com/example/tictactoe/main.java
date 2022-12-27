package com.example.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         char[][] board = {{' ',' ',' '},
                           {' ',' ',' '},
                           {' ',' ',' '}};

        printBoard(board);
        while(true){
            playerMove(board,sc);

            if(isGameFinished(board)){
                break;
            }
            printBoard(board);
            computerMove(board);
            printBoard(board);
        }
        sc.close();
    }

    private static boolean isGameFinished(char[][] board) {
        if (hasContestantWon(board)) return true;

        if (hasComputerWon(board)) return true;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("the game ended in tie");
        return false;
    }

    private static boolean hasComputerWon(char[][] board) {
        if((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')||
                (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O')||
                (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O')){
            printBoard(board);
            System.out.println("computer win!");
            return true;
        }

        if((board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O')||
                (board[1][0] == 'O' && board[1][1] == 'O' && board[2][1] == 'O')||
                (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')){
            printBoard(board);
            System.out.println("computer win!");
            return true;
        }

        if((board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')||
                (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')){
            printBoard(board);
            System.out.println("computer win!");
            return true;
        }
        return false;
    }

    private static boolean hasContestantWon(char[][] board) {
        if((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X')||
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X')||
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X')){
            printBoard(board);
            System.out.println("you win!");
            return true;
        }

        if((board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X')||
                (board[1][0] == 'X' && board[1][1] == 'X' && board[2][1] == 'X')||
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')){
            printBoard(board);
            System.out.println("you win!");
            return true;
        }

        if((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')||
                (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')){
            printBoard(board);
            System.out.println("you win!");
            return true;
        }
        return false;
    }

    private static void computerMove(char[][] board) {
        Random r = new Random();
        int computerMove;
        while(true) {
            computerMove = r.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))){
                break;
            }
        }
        System.out.println("computer chose "+ computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    private static boolean isValidMove(char[][] board, String position){
        switch (position){

            case "1":
                return (board[0][0]== ' ');
            case "2":
                return (board[0][1]== ' ');
            case "3":
                return (board[0][2]== ' ');
            case "4":
                return (board[1][0]== ' ');
            case "5":
                return (board[1][1]== ' ');
            case "6":
                return (board[1][2]== ' ');
            case "7":
                return (board[2][0]== ' ');
            case "8":
                return (board[2][1]== ' ');
            case "9":
                return (board[2][2]== ' ');

            default:
                return false;
        }
    }

    private static void playerMove(char[][] board, Scanner sc) {
        String userInput;
        while(true) {
            System.out.println("Your Move");
            userInput = sc.nextLine();
            if(isValidMove(board, userInput)){
                break;
            }else{
                System.out.println(userInput + "is Not a valid move");
            }
        }
        placeMove(board, userInput, 'X');
        //sc.close();
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch (position){

            case "1":
                board[0][0]= symbol;
                break;
            case "2":
                board[0][1]= symbol;
                break;
            case "3":
                board[0][2]= symbol;
                break;
            case "4":
                board[1][0]= symbol;
                break;
            case "5":
                board[1][1]= symbol;
                break;
            case "6":
                board[1][2]= symbol;
                break;
            case "7":
                board[2][0]= symbol;
                break;
            case "8":
                board[2][1]= symbol;
                break;
            case "9":
                board[2][2]= symbol ;
                break;

            default:
                System.out.println(":(");
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0]+"|" + board[0][1]+"|" + board[0][2]+" " );
        System.out.println("-+-+-");
        System.out.println(board[1][0]+"|" + board[1][1]+"|" + board[1][2]+" " );
        System.out.println("-+-+-");
        System.out.println(board[2][0]+"|" + board[2][1]+"|" + board[2][2]+" " );
    }
}
