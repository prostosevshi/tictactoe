import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int flag = 0;
    static String tie = "";

    public static void main(String[] args) {

            

        /*String[][] board = {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""},};

        PrintBoard(board);

        while (true) {

            if (flag == 1 || tie.equals("Tis a tie")) {
                break;
            }

            PlayerTurnStr();
            PlayerMoves(board);

            PrintBoard(board);
            TableCheck(board);
            *//*ForParadise(board);*//*

            if (flag == 1 || tie.equals("Tis a tie")) {
                break;
            }

            space();

            ComputerTurnStr();
            ComputerMoves(board);

            PrintBoard(board);
            TableCheck(board);
            *//*ForParadise(board);*//*
        }*/
    }

    public static void space() {
        System.out.println();
    }

    public static void ComputerTurnStr() {
        System.out.println("Computer turn");
    }

    public static void PlayerTurnStr() {
        System.out.println("Player turn");
    }

    public static void TableCheck(String[][] board) {
        int a = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("")) {
                    a++;
                }
            }
        }
        if (a >= 0) {
            ForParadise(board);
        }
        if (flag == 0 && a == 0) {
            tie = "Tis a tie";
            System.out.println("Tis a tie");
        }
    }

    public static void ForParadise(String[][] board) {

        String win = "";


        if (flag == 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    win += board[i][j];
                }
                ifHelper(win);
                win = "";
            }
        }

        if (flag == 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    win += board[j][i];
                }
                ifHelper(win);
                win = "";
            }
        }

        if (flag == 0) {
            for (int i = 0; i < board.length; i++) {
                win += board[i][i];
            }
            ifHelper(win);
            win = "";
        }

        if (flag == 0) {
            for (int i = 0; i < board.length; i++) {
                win += board[i][board.length - 1 - i];
            }
            ifHelper(win);
        }
    }

    public static void ifHelper(String win) {
        if (win.equals("XXX")) {
            flag = 1;
            System.out.println("X wins");
        }
        if (win.equals("000")) {
            flag = 1;
            System.out.println("0 wins");
        }
    }

    public static void PlayerMoves(String[][] board) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("row= ");
            int row = scanner.nextInt() -1;
            System.out.print("column= ");
            int column = scanner.nextInt() -1;

            if (row >= 0 && row < board.length && column >= 0 && column < board.length && board[row][column].equals("")) {
                board[row][column] = "X";
                break;
            } else {
                System.out.println("try again, wrong inputs");
                PrintBoard(board);
            }
        }
    }

    public static void ComputerMoves(String[][] board) {
        Random random = new Random();

        while (true) {
            int row = random.nextInt(3);
            int column = random.nextInt(3);

            if (board[row][column].equals("")) {
                board[row][column] = "0";
                break;
            }
        }
    }

    public static void PrintBoard(String[][] board) {
        System.out.println("-------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("|" + "\t" + board[i][j] + "\t");
            }
            System.out.println("|");
            System.out.println("-------------------------");
        }
    }

}
