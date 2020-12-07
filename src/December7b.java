import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class December7b {
    public static void main(String[] args) throws IOException {
        String[] input = Fileparser.toStringArray("src/December7 puzzle input.txt");
        Map<String, String> rules = new HashMap<>();
        for (java.lang.String rule:input) {
            String[] ruleParts = rule.split(" contain ");
            rules.put(ruleParts[0].replace(" bags", ""), ruleParts[1]);
        }

        System.out.println(numberOfBags(rules, "shiny gold")-1); // -1 because counting starts at 1, so there is 1 count to many
    }

    public static int numberOfBags(Map<String, String> rules, String color) {
        int bagCounter = 1;
        String rule = rules.get(color);
        String[] bags = rule.split(", ");

        for (String bag : bags) {
            if (!bag.equals("no other bags.")) {
                String[] ruleParts = bag.split(" ");
                bagCounter += Integer.parseInt(ruleParts[0]) * numberOfBags(rules, ruleParts[1] + " " + ruleParts[2]);
            }
        }
        return bagCounter;
    }
}
