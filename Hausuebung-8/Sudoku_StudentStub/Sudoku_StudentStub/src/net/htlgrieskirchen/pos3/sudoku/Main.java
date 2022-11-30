package net.htlgrieskirchen.pos3.sudoku;


import java.io.File;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();
        int[][] input = ss.readSudoku(new File("1_sudoku_level1.csv"));
        System.out.println(">--- ORIGINAL ---");
        ss.printSudokuBoard(input);
        // print the sudoku if you want
        int[][] output = ss.solveSudoku(input);
        System.out.println(">--- SOLUTION ---");
        ss.printSudokuBoard(output);
        // print the sudoku if you want
        System.out.println(">----------------");
        System.out.println("SOLVED    = " + ss.checkSudoku(output));
        System.out.println(">----------------");
        long millies = benchmark(input);
        System.out.println("The process lasted about " + millies + " ms.");
    }

    public static long benchmark(int[][] rawSudoku){
        long startMillis = System.currentTimeMillis();
        SudokuSolver ss = new SudokuSolver();
        for (int i = 0; i<3;i++){


            int[][] input = rawSudoku;
            int[][] output = ss.solveSudoku(input);
            boolean b = ss.checkSudoku(output);
        }

        long endMillis = System.currentTimeMillis();

        return (endMillis-startMillis)/3;
    }
}
