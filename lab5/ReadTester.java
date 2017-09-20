import java.util.*;
public class ReadTester {


    public static void main(String[] args) {


        while (true) {
            ArrayList<Integer> array = new ArrayList<>();
            String string = "";

            Scanner in = new Scanner(System.in);
            System.out.print("please enter your numbers: ");


            if (in.hasNextLine()) {
                string = in.nextLine();
            }


            Scanner out = new Scanner(string).useDelimiter(" ");

            while (out.hasNextInt()) {
                int a = out.nextInt();
                array.add(a);
            }
            System.out.println(array);


        }


    }

}

