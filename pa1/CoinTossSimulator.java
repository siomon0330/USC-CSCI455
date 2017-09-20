import java.util.*;
// Name:Chuanli Wei
// USC NetID:6222006323
// CS 455 PA1
// Spring 2017

/**
 * class CoinTossSimulator
 *
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 *
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants,
 * and private methods to the class.  You will also be completing the
 * implementation of the methods given.
 *
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 *
 */
public class CoinTossSimulator {

    int numbersOfTwoHeads;
    int numbersOfTwoTails;
    int numbersOfAHeadAndATail;
    int numTrials;

    /**
     Creates a coin toss simulator with no trials done yet.
     */

    public CoinTossSimulator( ) {

        //initialize all the instance variables to be 0
        numbersOfTwoHeads = 0;
        numbersOfTwoTails = 0;
        numbersOfAHeadAndATail =0;

    }


    /**
     Runs the simulation for numTrials more trials. Multiple calls to this
     without a reset() between them add these trials to the simulation
     already completed.

     @param numTrials  number of trials to for simulation; must be >= 1
     */
    public void run(int numTrials) {

        //get the numtrials from input, and every time a new numTrial occur, add it to the previous one
        this.numTrials = this.numTrials + numTrials;


        for (int i = 1; i <= numTrials; i++) {

            //get two random numbers: 0 and 1 to run the toss, o stands for tail and 1 stands for head
            Random generator = new Random();
            int firstToss = generator.nextInt(2);
            int secondToss = generator.nextInt(2);
            int result = firstToss + secondToss;

            //increment the numbers if don't reset
            if (result == 0) {

                numbersOfTwoTails++;
                this.numbersOfTwoTails = this.numbersOfTwoTails ++;

            } else if (result == 1) {

                numbersOfAHeadAndATail++;
                this.numbersOfAHeadAndATail = this.numbersOfAHeadAndATail ++;

            } else {

                numbersOfTwoHeads++;
                this.numbersOfTwoHeads= this.numbersOfTwoHeads ++;
            }
        }
    }

    /**
     Get number of trials performed since last reset.
     */
    public int getNumTrials() {
        return numTrials;
    }


    /**
     Get number of trials that came up two heads since last reset.
     */
    public int getTwoHeads() {
        return numbersOfTwoHeads;
    }


    /**
     Get number of trials that came up two tails since last reset.
     */
    public int getTwoTails() {
        return numbersOfTwoTails;
    }


    /**
     Get number of trials that came up one head and one tail since last reset.
     */
    public int getHeadTails() {
        return numbersOfAHeadAndATail;
    }


    /**
     Resets the simulation, so that subsequent runs start from 0 trials done.
     */
    public void reset() {

        //reset all the instance variables to be 0
        numbersOfTwoHeads = 0;
        numbersOfTwoTails = 0;
        numbersOfAHeadAndATail = 0;
        numTrials = 0;
    }

}