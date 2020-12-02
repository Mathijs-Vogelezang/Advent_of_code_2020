import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class December2b {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\mathi\\IdeaProjects\\Advent of code\\src\\December2 puzzle input.txt");
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }

        int count = 0;
        for (String line:input){
            String[] components = line.split(" ");
            int index1 = Integer.parseInt(components[0].split("-")[0]);
            int index2 = Integer.parseInt(components[0].split("-")[1]);
            char requiredLetter = components[1].charAt(0);
            String password = components[2];


            if ((password.charAt(index1-1) == requiredLetter && password.charAt(index2-1) != requiredLetter) || // they work with 1 as first index, so -1
                    (password.charAt(index1-1) != requiredLetter && password.charAt(index2-1) == requiredLetter)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
