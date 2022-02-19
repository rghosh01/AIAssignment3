package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * CS4341 Assignment 1
 * Professor Joseph Beck
 * Lena Dias, Roopsa Ghosh, Adam Yang
 * 1/25/2022
 */

// This class will be responsible for running the AStar Search Program
public class astar {

    // Main method to run the program
    public static void main(String[] args) throws FileNotFoundException {
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        Board gameboard = new Board("assignment_1/src/assignment 1, sample board - 0.txt");
        gameboard.generateBoard();

        Agent agent1 = new Agent(gameboard);
//        Search search1 = new Search(gameboard, agent1, Integer.parseInt(args[1]));
        Search search1 = new Search(gameboard, agent1, 5);

        search1.A_Star_Search();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long actualMemUsed=afterUsedMem-beforeUsedMem;
//        System.out.println(actualMemUsed);

    }
    public void runLearning() throws IOException {
        // constructs the output file
        File stats = new File("stats.csv");
        stats.createNewFile();
        FileWriter statsW = new FileWriter("stats.csv");

        // write hedder line
        statsW.write("path_cost,valuesOfFeatures,adjacent");
        // square location
        // robot location
        // goal location

        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < start+(120*60*1000)) {
            System.out.println("Running for: "+Long.valueOf((start+(120*60*1000) -System.currentTimeMillis()/1000))+ "More Sec");
            // generate board,
            Board rgen = new Board(10);
            // solve board
            Agent agent1 = new Agent(rgen);
            Search search = new Search(rgen, agent1, 5);

            // write path to a CSV
            statsW.write("Write String");

        }
        statsW.close();
    }
}
