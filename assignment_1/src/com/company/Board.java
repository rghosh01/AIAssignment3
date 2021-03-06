package com.company;

import java.io.*;
import java.util.*;
import java.lang.*;


// This class is responsible for holding information regarding the board that the
// agent will traverse
public class Board {

    int numRows;
    int numCols;
    char[][] gameboard = new char[numRows][numCols];
    String fileName;

    // Constructor for the Board class
    public Board(String fileName) {
        this.fileName = fileName;
    }

    // overloaded constructor:
    public Board(int size) {gameboard = genRandBoard(size); }

    // This method finds the starting point of the board,
    // Starting point is coordinate with 'S'
    public Coordinate getStartPoint() {
        // return the coordinate of the "S" tile
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(gameboard[i][j] == 'S') {
                    return new Coordinate(i, j);
                }
            }
        }

        return null;
    }

    public static char[][] genRandBoard(int size) {
        int boardSize = size;
        Random rng = new Random();
        char board[][] = new char[boardSize][boardSize];
        int sCol = rng.nextInt(boardSize);
        int sRow = rng.nextInt(boardSize);
        int gCol = rng.nextInt(boardSize);
        int gRow = rng.nextInt(boardSize);
        while(gCol == sCol && gRow == sRow){
            gCol = rng.nextInt(boardSize);
            gRow = rng.nextInt(boardSize);
        }
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(i == sRow && j == sCol){
                    board[i][j] = 'S';
                }
                else if(i == gRow && j == gCol){
                    board[i][j] = 'G';
                }
                else {
                    board[i][j] =(char) ((rng.nextInt(10) + 1) + '0');
                }
            }
        }
        return board;
    }
    // This method finds the end point of the board,
    // end point is coordinate with 'G'
    public Coordinate getEndPoint() {
        // return the coordinate of the "S" tile
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(gameboard[i][j] == 'G') {
                    return new Coordinate(i, j);
                }
            }
        }
        return null;
    }

    // Returns the terrain complexity of a certain coordinate
    public char getComplexity(int x_Coord, int y_Coord) {
        return gameboard[x_Coord][y_Coord];
    }

    // This method determines if the given coordinate is out of bounds
    public boolean OutOfBounds(Coordinate coordinate) {
        if((coordinate.getX() >= 0) && (coordinate.getX() <= numRows-1)
                && (coordinate.getY() >= 0) && (coordinate.getY() <= numCols-1)) {
            return false;
        }
        return true;
    }

    // This method generates the game board from the given file name
    public void generateBoard() throws FileNotFoundException {
        //File I/O
        try {

            File levelFile = new File(this.fileName);

            //count total chars
            BufferedReader colScanner = new BufferedReader(new FileReader(levelFile));
            String line = null;
            while((line = colScanner.readLine()) != null)
            {
                System.out.println(line);
                //tokenize it here
                String[] tokens = line.split("\t");
                numCols = tokens.length;
                numRows++;
            }

            System.out.println(numCols);
            System.out.println(numRows);

            Scanner sc = new Scanner(levelFile);
            sc.useDelimiter("\\n|\\t");
            char[][] level = new char[numRows][numCols];



            //now, actually put them in a list. would be better to do this all in one loop, but this works.
            for (int i = 0; i < numRows; i++)
            {
                for (int j = 0; j < numCols; j++)
                {
                    if(sc.hasNext())
                    {
                        char ch = sc.next().charAt(0); // Convert to char
                        level[i][j] = ch;
                        //System.out.println(ch);
                        //System.out.println(level[i][j]);
                    }
                }
            }
            this.gameboard = level;
            sc.close();
        }
        catch (FileNotFoundException err)
        {
            System.out.println("File not found.");
            err.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Board myBoard = new Board("assignment_1/src/assignment 1, sample board - 0.txt");
        myBoard.generateBoard();
    }



}
