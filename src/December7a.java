import java.io.IOException;
import java.util.*;

public class December7a {
    public static void main(String[] args) throws IOException {
        String[] rules = Fileparser.toStringArray("src/December7 puzzle input.txt");
        Set<String> containsGold = getColors(rules);
        System.out.println(containsGold.size() - 1); // shiny gold also appears in the list, but that should not be counted
    }

    public static Set<String> getColors (String[] input) {
        Set<String> containsGold = new HashSet<>();
        containsGold.add("shiny gold");
        int oldsize = 0;

        while (containsGold.size() != oldsize) {
            oldsize = containsGold.size();
            for (String rule : input) {
                for (String color : containsGold) {
                    if (rule.split("contain")[1].contains(color)) { // check if bag contains a bag that contains a shiny gold bag
                        containsGold.add(rule.split("contain")[0].replace(" bags", ""));
                        break; // if a color is found in rules, there is no need to continue looking for the other colors, because this color bag contains gold
                    }
                }
            }
        }
        return containsGold;
    }
}
