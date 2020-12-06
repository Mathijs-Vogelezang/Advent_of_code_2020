import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class December6a {
    public static void main(String[] args) throws IOException {
        List<String> groups = getGroups("src/December6 puzzle input.txt");

        int count = 0;
        for (String answers:groups) {
            count += countDistinctChars(answers);
        }
        System.out.println(count);
    }

    public static List<String> getGroups (String filePath) throws IOException {
        String[] input = Fileparser.toStringArray(filePath);

        String persons = "";
        List<String> groups = new ArrayList<>();

        for (String line:input) {
            if (!line.equals("")) {
                persons += line;
            }
            else {
                groups.add(persons);
                persons = "";
            }
        }
        groups.add(persons);

        return groups;
    }

    public static int countDistinctChars (String input) {
        String charsOccurring = "";
        for (int i = 0; i < input.length(); i++) {
            if (charsOccurring.indexOf(input.charAt(i)) == -1) { // check if character doesn't yet occur in charsOccurring
                charsOccurring += input.charAt(i);
            }
        }
        return charsOccurring.length();
    }
}
