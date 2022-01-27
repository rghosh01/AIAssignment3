package com.company;

public class AStarGame {
    // This class will be responsible for running the AStar Search Program

    public static void main(String[] args) {
        Agent agent1 = new Agent();
        Board gameboard = new Board();
        gameboard.generateBoard("assignment_1/assignment 1, sample board.txt");
        AStar astarSearch = new AStar(gameboard, agent1);
        astarSearch.A_Star_Search();

    }

}