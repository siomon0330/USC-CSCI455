import java.util.*;

public class CoinTossSimulatorTester {

    public static void main(String[] args){

        CoinTossSimulator coinToss = new CoinTossSimulator();

        //print out the result after constructor and before tosses
        System.out.println("After constructor: ");
        System.out.println("Number of trails [Expected:0]: " + coinToss.getNumTrials());
        System.out.println("Twoheads Toss: " + coinToss.getTwoHeads());
        System.out.println("TwoTails Toss: " + coinToss.getTwoTails());
        System.out.println("One Head-One Tail Toss: " + coinToss.getHeadTails());

        //test whether the coin tosses add up correctly
        boolean addUpCorrectly = coinToss.getNumTrials() == (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails());
        System.out.println("Tosses add up correcly? " + addUpCorrectly);
        System.out.println();


        //use an array to store the numbers of trails
        int[] numberOfTrials = {1,10,100};
        for(int i=0; i<numberOfTrials.length; i++) {

            int number = numberOfTrials[i];
            coinToss.run(number);

            ////print out the result for each toss
            System.out.println("Number of trails :Expected: " + coinToss.getNumTrials());
            System.out.println("Twoheads Toss: " + coinToss.getTwoHeads());
            System.out.println("TwoTails Toss: " + coinToss.getTwoTails());
            System.out.println("One Head-One Tail Toss: " + coinToss.getHeadTails());

            //test whether the coin tosses add up correctly
            addUpCorrectly = coinToss.getNumTrials() == (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails());
            System.out.println("Tosses add up correcly? " + addUpCorrectly);
            System.out.println();

        }

        //reset the tosses
        coinToss.reset();
        ////print out the result after reset
        System.out.println("After reset: ");
        System.out.println("Number of trails [Expected:0]: " + coinToss.getNumTrials());
        System.out.println("Twoheads Toss: " + coinToss.getTwoHeads());
        System.out.println("TwoTails Toss: " + coinToss.getTwoTails());
        System.out.println("One Head-One Tail Toss: " + coinToss.getHeadTails());

        //test whether the coin tosses add up correctly
        addUpCorrectly = coinToss.getNumTrials() == coinToss.getTwoHeads()+(coinToss.getTwoTails()+coinToss.getHeadTails());
        System.out.println("Tosses add up correcly? " + addUpCorrectly);

    }
}