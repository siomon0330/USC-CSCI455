import java.math.*;
import javax.swing.*;
import java.awt.*;

public class CoinSimComponent extends JComponent {

    int numbersOfTwoHeads;
    int numbersOfTwoTails;
    int numbersOfAHeadAndATail;
    int numTrials;
    double percentOfTwoHeads;
    double percentOfTwoTails;
    double percentOfAHeadAndATail;
    int numberOfTrials;
    CoinTossSimulator coinToss;

    public CoinSimComponent(int numberOfTrials) {

        this.numberOfTrials = numberOfTrials;
        coinToss = new CoinTossSimulator();
        coinToss.run(numberOfTrials);

        //get the numbers of the two heads, two tails, and a head and tail
        numbersOfTwoHeads = coinToss.getTwoHeads();
        numbersOfTwoTails = coinToss.getTwoTails();
        numbersOfAHeadAndATail = coinToss.getHeadTails();
        numTrials = coinToss.getNumTrials();

        //calculate the percentage of the numbers of the two heads, two tails, and a head and a tail
        percentOfTwoHeads = (double) numbersOfTwoHeads / numTrials;
        percentOfTwoTails = (double)numbersOfTwoTails / numTrials;
        percentOfAHeadAndATail = (double)numbersOfAHeadAndATail / numTrials;


    }

    public void paintComponent(Graphics g){

        //get the height and width of the panel
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        //calculate the width and the location of the bottom of the bar according to the size of the panel
        int bottom = (int)(panelHeight*0.86);
        int width = (int)(panelWidth*0.0625);

        //calculate the location of the left side of the three bars according to the size of the panel
        int left1 = (int)(panelWidth*0.25-0.5*width);
        int left2 = (int)(panelWidth*0.5-0.5*width);
        int left3 = (int)(panelWidth*0.75-0.5*width);

        //calculate the height of the bar according to the size of the panel
        int barHeight = (int)(panelHeight*0.8);

        //calculate the scale
        double scaleOfTwoHeads = percentOfTwoHeads;
        double scaleOfAHeadAndATail = percentOfAHeadAndATail;
        double scaleOfTwoTails = percentOfTwoTails;



        //draw the three bars
        Graphics2D g2 = (Graphics2D) g;

        //the Math.round() method is used to round the percentage to two decimal
        Bar bar1 = new Bar(bottom,left1,width,barHeight,
                scaleOfTwoHeads,Color.red, "Two Heads: "+numbersOfTwoHeads+"("+Math.round(percentOfTwoHeads*100)+"%)");
        bar1.draw(g2);

        Bar bar2 = new Bar(bottom,left2,width,barHeight,
                scaleOfAHeadAndATail,Color.green, "A Head and A Tail: "+numbersOfAHeadAndATail+"("+Math.round(percentOfAHeadAndATail*100)+"%)");
        bar2.draw(g2);

        Bar bar3 = new Bar(bottom,left3,width,barHeight,
                scaleOfTwoTails,Color.blue, "Two Tails: "+numbersOfTwoTails+"("+Math.round(percentOfTwoTails*100)+"%)");
        bar3.draw(g2);

    }

}


