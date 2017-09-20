// Name:Chuanli Wei
// USC loginid:6222006323
// CS 455 PA3
// Spring 2017

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import javax.swing.JComponent;

/**
 MazeComponent class

 A component that displays the maze and path through it if one has been found.
 */
public class MazeComponent extends JComponent
{

    private static final int START_X = 10; // top left of corner of maze in frame
    private static final int START_Y = 10;
    private static final int BOX_WIDTH = 20;  // width and height of one maze "location"
    private static final int BOX_HEIGHT = 20;
    private static final int INSET = 2;
    // how much smaller on each side to make entry/exit inner box


    private Maze maze;

    /**
     Constructs the component.
     @param maze   the maze to display
     */
    public MazeComponent(Maze maze)
    {
        this.maze = maze;
    }


    /**
     Draws the current state of maze including the path through it if one has
     been found.
     @param g the graphics context
     */
    public void paintComponent(Graphics g)
    {

        Graphics2D g2 = (Graphics2D)g;

        for(int i = 0; i < maze.numRows(); i++){
            for(int j = 0; j < maze.numCols(); j++){

                //initialize the rectangle to be drawn
                Rectangle rectangle = new Rectangle(START_X + BOX_WIDTH * j,START_Y + BOX_HEIGHT * i,BOX_WIDTH,BOX_HEIGHT);

                //if the maze coordinate is a wall, then draw it black
                if(maze.mazeData[i][j] == true) {

                    g2.setColor(Color.BLACK);
                    g2.fill(rectangle);
                    g2.draw(rectangle);

                    //check whether this coordinate is the entry location, if it is, draw a yellow rectangle on it
                    if(i == maze.startLoc.getRow() && j == maze.startLoc.getCol()){
                        Rectangle rectangleStart = new Rectangle(START_X + BOX_WIDTH * j + INSET,START_Y + BOX_HEIGHT * i + INSET,BOX_WIDTH - 2 * INSET,BOX_HEIGHT - 2 * INSET);
                        g2.setColor(Color.yellow);
                        g2.fill(rectangleStart);
                        g2.draw(rectangleStart);
                    }
                    //check whether this coordinate is the exit location, if it is, draw a green rectangle on it
                    if(i == maze.exitLoc.getRow() && j == maze.exitLoc.getCol()){
                        Rectangle rectangleExit = new Rectangle(START_X +BOX_WIDTH * j + INSET,START_Y + BOX_HEIGHT * i + INSET,BOX_WIDTH - 2 * INSET,BOX_HEIGHT - 2 * INSET);
                        g2.setColor(Color.green);
                        g2.fill(rectangleExit);
                        g2.draw(rectangleExit);
                    }


                }else{

                    // there is no wall in the coordinate, so draw it white
                    g2.setColor(Color.white);
                    g2.fill(rectangle);
                    g2.draw(rectangle);

                    //check whether this coordinate is the entry location, if it is, draw a yellow rectangle on it
                    if(i == maze.startLoc.getRow() && j == maze.startLoc.getCol()){
                        Rectangle rectangleStart = new Rectangle(START_X + BOX_WIDTH * j + INSET,START_Y + BOX_HEIGHT * i + INSET,BOX_WIDTH - 2 * INSET,BOX_HEIGHT - 2 * INSET);
                        g2.setColor(Color.yellow);
                        g2.fill(rectangleStart);
                        g2.draw(rectangleStart);
                    }

                    //check whether this coordinate is the exit location, if it is, draw a green rectangle on it
                    if(i == maze.exitLoc.getRow() && j == maze.exitLoc.getCol()){
                        Rectangle rectangleExit = new Rectangle(START_X +BOX_WIDTH * j + INSET,START_Y + BOX_HEIGHT * i + INSET,BOX_WIDTH - 2 * INSET,BOX_HEIGHT - 2 * INSET);
                        g2.setColor(Color.green);
                        g2.fill(rectangleExit);
                        g2.draw(rectangleExit);
                    }

                }
            }
        }

        // draw the path from the start location to exit location
        LinkedList<MazeCoord> list = maze.getPath();

        
        for(int i = 1; i < list.size(); i++){

            double xCoordinateOfFirstPoint = START_X + 0.5 * BOX_WIDTH + BOX_WIDTH *list.get(i).getCol();
            double yCoordinateOfFirstPoint = START_Y + 0.5 * BOX_HEIGHT + BOX_HEIGHT *list.get(i).getRow();
            double xCoordinateOfSecondPoint = START_X + 0.5 * BOX_WIDTH + BOX_WIDTH *list.get(i-1).getCol();
            double yCoordinateOfSecondPoint = START_Y + 0.5 * BOX_HEIGHT + BOX_HEIGHT *list.get(i-1).getRow();

            Line2D.Double line = new Line2D.Double(xCoordinateOfFirstPoint, yCoordinateOfFirstPoint, xCoordinateOfSecondPoint, yCoordinateOfSecondPoint);

            g2.setColor(Color.blue);
            g2.fill(line);
            g2.draw(line);
        }

    }

}



