// Name:Chuanli Wei
// USC loginid:6222006323
// CS 455 PA3
// Spring 2017

import java.util.LinkedList;


/**
 Maze class

 Stores information about a maze and can find a path through the maze
 (if there is one).

 Assumptions about structure of the maze, as given in mazeData, startLoc, and endLoc
 (parameters to constructor), and the path:
 -- no outer walls given in mazeData -- search assumes there is a virtual
 border around the maze (i.e., the maze path can't go outside of the maze
 boundaries)
 -- start location for a path is maze coordinate startLoc
 -- exit location is maze coordinate exitLoc
 -- mazeData input is a 2D array of booleans, where true means there is a wall
 at that location, and false means there isn't (see public FREE / WALL
 constants below)
 -- in mazeData the first index indicates the row. e.g., mazeData[row][col]
 -- only travel in 4 compass directions (no diagonal paths)
 -- can't travel through walls

 */

/**
 Representation invariant
 The maze is composed of boolean variables: true stands for there is a wall, false stands for there is a free way.
 The row increases vertically and the column increase horizontally.
 The row of the coordinate is in the range of 0 <= row < maze.length.
 The column of the coordinate is in the range of 0 <= column < maze[0].length.
 */



public class Maze {

    public static final boolean FREE = false;
    public static final boolean WALL = true;
    public static final int MOVE_NORTH = -1; //use this variable to indicate the direction when exploring the maze
    public static final int MOVE_SOUTH = 1; //use this variable to indicate the direction when exploring the maze
    public static final int MOVE_EAST = 1; //use this variable to indicate the direction when exploring the maze
    public static final int MOVE_WEST = -1; //use this variable to indicate the direction when exploring the maze

    boolean[][] mazeData;
    MazeCoord startLoc;
    MazeCoord exitLoc;
    boolean[][] visited;   // use this 2D array to store whether a specific coordinate has been visited
    LinkedList<MazeCoord> res; // use this list to store our final path if there is one
    boolean hasBeenSearched; // use this boolean variant to indicate whether the maze has been searched

    /**
     Constructs a maze.
     @param mazeData the maze to search.  See general Maze comments above for what
     goes in this array.
     @param startLoc the location in maze to start the search (not necessarily on an edge)
     @param exitLoc the "exit" location of the maze (not necessarily on an edge)
     PRE: 0 <= startLoc.getRow() < mazeData.length and 0 <= startLoc.getCol() < mazeData[0].length
     and 0 <= endLoc.getRow() < mazeData.length and 0 <= endLoc.getCol() < mazeData[0].length

     */
    public Maze(boolean[][] mazeData, MazeCoord startLoc, MazeCoord exitLoc) {

        this.mazeData = mazeData;
        this.startLoc = startLoc;
        this.exitLoc = exitLoc;
        visited = new boolean[mazeData.length][mazeData[0].length];
        res = new LinkedList<>();
        hasBeenSearched = false;
    }


    /**
     Returns the number of rows in the maze
     @return number of rows
     */
    public int numRows() {
        return mazeData.length;
    }


    /**
     Returns the number of columns in the maze
     @return number of columns
     */
    public int numCols() {
        return mazeData[0].length;
    }


    /**
     Returns true iff there is a wall at this location
     @param loc the location in maze coordinates
     @return whether there is a wall here
     PRE: 0 <= loc.getRow() < numRows() and 0 <= loc.getCol() < numCols()
     */
    public boolean hasWallAt(MazeCoord loc) {

        return mazeData[loc.getRow()][loc.getCol()] == true;

    }


    /**
     Returns the entry location of this maze.
     */
    public MazeCoord getEntryLoc() {
        return startLoc;
    }


    /**
     Returns the exit location of this maze.
     */
    public MazeCoord getExitLoc() {
        return exitLoc;
    }


    /**
     Returns the path through the maze. First element is start location, and
     last element is exit location.  If there was not path, or if this is called
     before a call to search, returns empty list.

     @return the maze path
     */
    public LinkedList<MazeCoord> getPath() {

       if(hasBeenSearched == false){
           return new LinkedList<MazeCoord>();
       }else{
           return res;
       }
    }


    /**
     Find a path from start location to the exit location (see Maze
     constructor parameters, startLoc and exitLoc) if there is one.
     Client can access the path found via getPath method.

     @return whether a path was found.
     */
    public boolean search(){

        return helper(getEntryLoc().getRow(), getEntryLoc().getCol());

    }


    /**
    Returns whether the MazeCoord of x and y is a valid step to search.
    If the (x, y) is out of boundary or has already been visited or there
    is a wall, then (x, y) is not valid.

    @param x  the row of the maze coordinates
    @param y  the column of the maze coordinates
    @return whether (x, y) is a valid MazeCoord
    */

    private boolean isValid(int x, int y){

        if(x >= 0 && x < numRows() && y >= 0 && y < numCols() && visited[x][y] == false && !hasWallAt(new MazeCoord(x, y))){
            return true;
        }

        return false;
    }

    /**
     Returns whether there is a path in the maze

     @param x  the row of the start coordinates
     @param y  the column of the start coordinates
     @return true if there is a path or false otherwise
     */

     private boolean helper(int x, int y){

         hasBeenSearched = true; //mark this maze has been searched

        //if the exit location is in a wall, then there is no path
        if(mazeData[getExitLoc().getRow()][getExitLoc().getCol()] == true){
            return false;
        }

        //if we get to the exit location, return true and add this coordinate to our result path
        if(x == getExitLoc().getRow() && y == getExitLoc().getCol()){

            res.addLast(new MazeCoord(x, y));
            return true;
        }

        //if (x, y) is not valid, return false
        if(!isValid(x, y)){
            return false;
        }

        //mark (x, y) has been visited
        visited[x][y] = true;

        //to see whether we can get to the exit location from west direction
        if(helper(x + MOVE_NORTH, y)){
            res.addFirst(new MazeCoord(x, y));
            return true;
        }

        //to see whether we can get to the exit location from east direction
        if(helper(x + MOVE_SOUTH, y)){
            res.addFirst(new MazeCoord(x, y));
            return true;
        }

        //to see whether we can get to the exit location from north direction
        if(helper(x, y + MOVE_WEST)){
            res.addFirst(new MazeCoord(x, y));
            return true;
        }

        //to see whether we can get to the exit location from south direction
        if(helper(x, y + MOVE_EAST)){
            res.addFirst(new MazeCoord(x, y));
            return true;
        }

        return false;
     }



}













