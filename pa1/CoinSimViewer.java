import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class CoinSimViewer {
    public static void main(String[] args){

        //scanner to get the input from users
        Scanner in = new Scanner(System.in);

        //test whether the input number is a valid number
        System.out.print("Enter number of trials: ");
        int number = in.nextInt();
        while (number <= 0) {
            System.out.println("ERROR: Number entered must be greater than 0");
            System.out.print("Please enter again!");
            number = in.nextInt();
        }

        //initialize the JFrame
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //initialize the CoinSimComponent and draw the bars
        CoinSimComponent component = new CoinSimComponent(number);
        frame.add(component);

        frame.setVisible(true);

    }
}


