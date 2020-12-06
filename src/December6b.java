import java.io.IOException;
import java.util.*;

public class December6b {
    public static void main(String[] args) throws IOException {
        List<List<String>> groups = getGroups("src/December6 puzzle input.txt");

        int count = 0;
        for (List<String> group:groups) {
            count += overLappingChars(group).length();
        }
        System.out.println(count);
    }

    public static List<List<String>> getGroups (String filePath) throws IOException {
        String[] input = Fileparser.toStringArray(filePath);

        List<String> persons = new ArrayList<>();
        List<List<String>> groups = new ArrayList<>();

        for (String line:input) {
            if (!line.equals("")) {
                persons.add(line);
            }
            else {
                groups.add(List.copyOf(persons));
                persons.clear();
            }
        }
        groups.add(List.copyOf(persons));

        return groups;
    }

    public static String overLappingChars(List<String> input) { // returns the characters that occur in every string of input
        if (input.size() == 0) return "";

        String overlaps = input.get(0);

        if (input.size() == 1) {
            return overlaps;
        }
        else {
            for (int i = 1; i < input.size(); i++) {
                String chars = "";
                for (int j = 0; j < overlaps.length(); j++) {
                    for (int k = 0; k < input.get(i).length(); k++) {
                        if (overlaps.charAt(j) == input.get(i).charAt(k)) {
                            if (chars.indexOf(overlaps.charAt(j)) == -1) chars += overlaps.charAt(j);
                            break;
                        }
                    }
                }
                overlaps = chars;
            }
        }
        return overlaps;
    }
}
