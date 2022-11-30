package net.htlgrieskirchen.pos3.sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/* Please enter here an answer to task four between the tags:
 * <answerTask4>
 *    Hier sollte die Antwort auf die Aufgabe 4 stehen.
 * </answerTask4>
 */
public class SudokuSolver implements ISodukoSolver {

    int[][] boardToSolve;
    public SudokuSolver() {
        //initialize if necessary
    }

    @Override
    public final int[][] readSudoku(File file) {
        int[][] data = new int[9][9];
        int x = 0;
        try {
            Scanner fr = new Scanner(file);

            while (fr.hasNext()){
                String line = fr.nextLine();
                String[] splitted = line.split(";");
                for (int i = 0; i < data[x].length;i++){
                    data[x][i] = Integer.parseInt(splitted[i]);
                }
                x++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        return data; // delete this line!
    }

    @Override
    public boolean checkSudoku(int[][] rawSudoku) {
        boolean isSolved = true;
        Set<Integer> set = new TreeSet<>();

        //Check Vertical and Horizontal
        for (int i = 0; i<rawSudoku.length;i++){
            for (int j = 0; j<rawSudoku[i].length;j++){
                int numberToCheck = rawSudoku[i][j];

                for (int x = 0; x<rawSudoku.length;x++){
                    if (x == j){
                        x++;
                    }
                    if (x < 9) {
                        if (numberToCheck == rawSudoku[i][x]) {
                            isSolved = false;
                        }
                    }
                }

                for (int x = 0; x<rawSudoku.length;x++){
                    if (x == i){
                        x++;
                    }

                    if (x < 9) {
                        if (numberToCheck == rawSudoku[x][j]) {
                            isSolved = false;
                        }
                    }
                }
            }
        }

        //Check from Top Left to Bottom right
        /*for (int i = 0; i < 9;i++){
            if (!set.add(rawSudoku[i][i])){
                isSolved = false;
            }
        }
        set.clear();

        //Check from Top Right to Bottom Left
        int n = 8;
        for (int i = 0; i < 9;i++){
            if (!set.add(rawSudoku[i][n])){
                isSolved = false;
            }
            n--;
        }*/

        return isSolved;
    }

    @Override
    public int[][] solveSudoku(int[][] board) {
        boardToSolve = board;
        boolean solved = solve(boardToSolve);

        return boardToSolve;
    }

    public boolean solve(int[][] boardToSolve) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (boardToSolve[row][column] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        boardToSolve[row][column] = k;
                        if (isValid(boardToSolve, row, column) && solve(boardToSolve)) {
                            return true;
                        }
                        boardToSolve[row][column] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public int[][] solveSudokuParallel(int[][] rawSudoku) {
        // implement this method
        return new int[0][0]; // delete this line!
    }

    @Override
    public void printSudokuBoard(int[][] data){
        for (int i = 0; i < data.length;i++){
            for (int j = 0; j < data[i].length;j++){
                System.out.print(data[i][j] + ";");
            }
            System.out.println();
        }
    }

    public boolean isValid(int[][] board, int row, int column) {
        boolean flag = false;
        if (rowConstraint(board,row) && columnConstraint(board,column) && subsectionConstraint(board,row,column)){
            flag = true;
        }

        return flag;
    }

    public boolean rowConstraint(int[][] board, int row) {
        boolean[] constraint = new boolean[9];
        return IntStream.range(0, 9)
                .allMatch(column -> checkConstraint(board, row, constraint, column));
    }

    public boolean columnConstraint(int[][] board, int column) {
        boolean[] constraint = new boolean[9];
        return IntStream.range(0, 9)
                .allMatch(row -> checkConstraint(board, row, constraint, column));
    }

    public boolean subsectionConstraint(int[][] board, int row, int column) {
        boolean[] constraint = new boolean[9];
        int subsectionRowStart = (row / 3) * 3;
        int subsectionRowEnd = subsectionRowStart + 3;

        int subsectionColumnStart = (column / 3) * 3;
        int subsectionColumnEnd = subsectionColumnStart + 3;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
    }

    public boolean checkDiagonal(int[][] board){
        boolean isPossible = true;
        Set<Integer> set = new TreeSet<>();

        //Check from Top Left to Bottom right
        for (int i = 0; i < 9;i++){
            if (board[i][i] != 0) {
                if (!set.add(board[i][i])) {
                    isPossible = false;
                }
            }
        }
        set.clear();

        //Check from Top Right to Bottom Left
        int n = 8;
        for (int i = 0; i < 9;i++){
            if (board[i][n] != 0) {
                if (!set.add(board[i][n])) {
                    isPossible = false;
                }
            }
            n--;
        }
        return isPossible;
    }

    public boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column){
        if (board[row][column] != 0) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
