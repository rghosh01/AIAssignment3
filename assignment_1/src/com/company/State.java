package com.company;


// This class is used to hold important information about the state of the agent
// as it traverses through the game board
public class State {
    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    public static final int EAST = 4;


    Coordinate position;
    int faceDirection;
    int priorityValue;
    int currentCost;
    State previousState;
    String previousMove;


    // Constructor for the State class
    public State(Coordinate coordinates, int faceDirection) {
        this.position = coordinates;
        this.faceDirection = faceDirection;
        this.priorityValue = 0;
        this.currentCost = 0;
    }

    // Alternative Constructor for the State class
    public State(Coordinate coordinates, int faceDirection, int cost) {
        this.position = coordinates;
        this.faceDirection = faceDirection;
        this.priorityValue = 0;
        this.currentCost = cost;
    }



    // Alternative Constructor for the State class
    public State(Coordinate coordinates, int faceDirection, int cost, State parent, String previousMove) {
        this.position = coordinates;
        this.faceDirection = faceDirection;
        this.priorityValue = 0;
        this.currentCost = cost;
        this.previousMove = previousMove;
        this.previousState = parent;
        if(currentCost < 0) {
            System.out.println(this.currentCost);
        }
    }

    // returns the x coordinate
    public int getX() {
        return this.position.getX();
    }

    // returns the y coordinate
    public int getY() {
        return this.position.getY();
    }

    // returns the face direction
    public int getFaceDirection() {
        return faceDirection;
    }

    // returns the priority value
    public int getPriorityValue() {
        return priorityValue;
    }

    public int getCurrentCost() {
        return currentCost;
    }

    // retrieves the coordinate of the state
    public Coordinate getCoordinate() { return position; }

    // sets the face direction of the state
    public void setFaceDirection(int faceDirection) { this.faceDirection = faceDirection; }







}
