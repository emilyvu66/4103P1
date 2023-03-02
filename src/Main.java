/*
Name: Vu, Emily
Email: Evu3@lsu.edu
project: PA-1 (Multithreading)
Instructor: Feng Chen
Class: cs4103-sp23
Login ID : cs410380
*/

import java.io.File;
import java.io.PrintStream;

public class Main {

    public static void main(String args[]) throws Exception {
        boolean validSolution = false;
        
        
        makeGrid newGrid = new makeGrid(args[1]);

        File output = new File(args[2]);
        System.setOut(new PrintStream(new File(args[2])));
        
        checkRow newRowCheck = new checkRow(newGrid);
        Thread rowThread = new Thread(newRowCheck);
        rowThread.start();

        checkColumn newColumnCheck = new checkColumn(newGrid);
        Thread coulmnThread = new Thread(newColumnCheck);
        coulmnThread.start(); 

        checkSubGrid newSubGridCheck = new checkSubGrid(newGrid);
        Thread subGridThread = new Thread(newSubGridCheck);
        subGridThread.start();
        
        rowThread.join();
        coulmnThread.join();
        subGridThread.join();

        System.out.println("Valid rows: " + checkRow.rowCount);
        System.out.println("Valid columns: "  + checkColumn.columnCount);
        System.out.println("Valid subgrids: " + checkSubGrid.subGridCount);
        
        int valid = checkRow.rowCount + checkColumn.columnCount + checkSubGrid.subGridCount;
        
        if (valid == 27)
            System.out.println("This Sudoku solution is: Valid ");
        else
            System.out.println("This Sudoku solution is: Invalid ");
    } 
}
