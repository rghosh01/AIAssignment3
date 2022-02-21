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
    public static void main(String[] args) throws IOException {
        /*long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        Board gameboard = new Board(10);
//        Board gameboard = new Board(args[0]);
        //gameboard.generateBoard();

        Agent agent1 = new Agent(gameboard);
//        Search search1 = new Search(gameboard, agent1, Integer.parseInt(args[1]));
        Search search1 = new Search(gameboard, agent1, 5);

        search1.A_Star_Search();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long actualMemUsed=afterUsedMem-beforeUsedMem;
//        System.out.println(actualMemUsed);
*/
        //runLearning();
        for(int i = 0; i < 10; i++) {
            System.out.println("Map: " + (i + 1));
            Board rgen = new Board(1000);
            Agent agent1 = new Agent(rgen);
            Agent agent2 = new Agent(rgen);
            Agent agent3 = new Agent(rgen);
            Search search = new Search(rgen, agent1, 5);
            Search search2 = new Search(rgen, agent2, 6);
            Search search3 = new Search(rgen, agent3, 7);
            search.A_Star_Search();
            search2.A_Star_Search();
            search3.A_Star_Search();
        }
    }
    public static void runLearning() throws IOException {
        // constructs the output file
        File stats = new File("stats.csv");
        stats.createNewFile();
        FileWriter statsW = new FileWriter("stats.csv");

        // write hedder line
        statsW.write("path_cost, Euclidean Distance, Manhattan Distance, Bash");
        statsW.write("\n");
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
            Search search = new Search(rgen, agent1, 7);
            search.A_Star_Search();
            // write path to a CSV
        for(int i = 0; i < search.output.size(); i++) {
            statsW.write(search.output.get(i));
            statsW.write("\n");
        }
        }
        statsW.close();
    }

}
