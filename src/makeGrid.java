import java.io.*;
import java.util.Scanner;
import java.io.FileReader;
import java.util.Arrays;

public class makeGrid {

    public int[][] sudokuTable = new int[9][9];
    
    public makeGrid(String sudoku) throws Exception {
        Scanner scanner = new Scanner(sudoku);
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                sudokuTable[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }
    
    public int[] makeRow(int rowIndex) {
        int rows[] = new int[9];
        for(int i = 0; i < 9; i++){
            rows[i] = sudokuTable[rowIndex][i];
        }
        return rows;
        //System.out.println(Arrays.toString(rows));
    }
    
    public int[] makeColumn(int columnIndex) {
        int columns[] = new int[9];
        for(int i = 0; i < 9; i++){
            columns[i] = sudokuTable[i][columnIndex];
        }
        return columns;
        //System.out.println(Arrays.toString(columns));
    }
    
    public int[][] makeGridArray(){
        return sudokuTable;
    }

    public void printSudokuGrid(int[][] matrix){
        for(int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}


