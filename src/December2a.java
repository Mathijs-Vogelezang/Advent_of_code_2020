import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class December2a {
    public static void main(String[] args) throws IOException {
        File file = new File("src/December2 puzzle input.txt");
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }

        int count = 0;
        for (String line:input){
            String[] components = line.split(" ");
            int min = Integer.parseInt(components[0].split("-")[0]);
            int max = Integer.parseInt(components[0].split("-")[1]);
            String requiredLetter = Character.toString(components[1].charAt(0));
            String password = components[2];
            int charCount = password.length() - password.replace(requiredLetter, "").length(); /* first get length of password,
            then remove every occurrence of requiredLetter and get the length of password again, and subtract from original length*/

            if (charCount >= min && charCount <= max) {
                count++;
            }
        }
        System.out.println(count);
    }
}
