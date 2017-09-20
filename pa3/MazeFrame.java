import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
   MazeFrame
   
   JFrame for the maze program.
   
   Displays the status of the maze search and the maze itself
   with the path through it once search is successful.  Has a key listener that
   allows user to initiate the maze search.
   
   Note: the listener class, MazeKeyListener, is an inner class.  See below.
 */

public class MazeFrame extends JFrame {

   private JLabel searchStatusLabel;     // displays initial prompt and
                                         // the status of the search
   
   private MazeComponent mazeComponent;  // displays the maze and path
   
   private Maze maze;     // needed by component to access the data to display,
                          // and by listener to initiate maze search.

   private static final int FRAME_WIDTH = 500;
   private static final int FRAME_HEIGHT = 500;

   private static final String PROMPT_STRING = "Type any key to start maze search . . . ";
   private static final String SUCCESS_STRING = "Found the way out!";
   private static final String FAIL_STRING = "No path out of maze.";
   
   /**
      Sets up the gui components with the given maze data. 
      @param mazeData for details about what should be in this array see class comments in Maze.java
      @param entryLoc the entry location of the maze
      @param exitLoc the "exit" location of the maze
      PRE: 0 <= entryLoc.getRow() < mazeData.length and 0 <= entryLoc.getCol() < mazeData[0].length
         and 0 <= exitLoc.getRow() < mazeData.length and 0 <= exitLoc.getCol() < mazeData[0].length
    */
   public MazeFrame(boolean[][] mazeData, MazeCoord entryLoc, MazeCoord exitLoc) {

      setSize(FRAME_WIDTH, FRAME_HEIGHT);

      searchStatusLabel = new JLabel(PROMPT_STRING);
      add(searchStatusLabel, BorderLayout.NORTH); // put label at the top of the
                                                  // frame
      maze = new Maze(mazeData, entryLoc, exitLoc);

      mazeComponent = new MazeComponent(maze);
      add(mazeComponent, BorderLayout.CENTER); // put maze display in the middle
                                               // of the frame

      KeyAdapter listener = new MazeKeyListener(); // defined below
      addKeyListener(listener); // process keyboard input
      setFocusable(true);

   }
   
   
   /**
      getSearchMessage returns the message to display for a successful
      or failed search.

      @param success whether the search succeeded
      @return the string to display
   */
   public String getSearchMessage(boolean success) {
      if (success) {
         return SUCCESS_STRING;
      } else {
         return FAIL_STRING;
      }
   }

   
   class MazeKeyListener extends KeyAdapter { // inner class -- has access to outer
                                              // object's instance variables
      /**
         keyPressed is called when the user types a character.
         The action taken is to do the maze search, then update the display
         according to the results of the search.
         @param event  What the user typed.  Ignored here.
       */
      public void keyPressed(KeyEvent event) {
         System.out.println("DEBUG: key pressed");
         
         System.out.println("DEBUG: doing maze search. . . "); 
         boolean success = maze.search();     // maze defined in enclosing MazeFrame
        
         mazeComponent.repaint();  // update drawing to show the results
         
         System.out.println("DEBUG: " + getSearchMessage(success));
         searchStatusLabel.setText(getSearchMessage(success));
      }
   }
    
}
