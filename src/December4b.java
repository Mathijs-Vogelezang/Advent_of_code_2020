import java.io.IOException;
import java.util.*;

public class December4b {
    public static void main(String[] args) throws IOException {
        String[] passes = December4a.getPasses("C:\\Users\\mathi\\IdeaProjects\\Advent of code\\src\\December4 puzzle input.txt");
        int validPasses = 0;

        for (String pass:passes) {
            if (December4a.isValid(pass)) {
                List<String> contents = new ArrayList<>(Arrays.asList(pass.split(" ")));
                contents.sort(String.CASE_INSENSITIVE_ORDER); // sort passContents alphabetically, so the fields are always in the same order

                if (contents.size() == 8) {
                    contents.remove(1); // remove second element, if length of passContents = 8, because then it is the country id
                }

                String[] passContents = contents.toArray(new String[0]);

                for (int i = 0; i < passContents.length; i++) {
                    passContents[i] = passContents[i].split(":")[1]; // only keeping the contents of the field, not the type
                }

                // byr check
                if (Integer.parseInt(passContents[0]) < 1920 || Integer.parseInt(passContents[0]) > 2002) {
                    continue;
                }

                // ecl check
                if (!"amb blu brn gry grn hzl oth".contains(passContents[1])) { // checks if the eye color is in the allowed colors
                    continue;
                }

                // eyr check
                if (Integer.parseInt(passContents[2]) < 2020 || Integer.parseInt(passContents[2]) > 2030) {
                    continue;
                }

                // hcl check
                if (!passContents[3].matches("#[0-f]{6}")) {
                    continue;
                }
                // hgt check
                if (passContents[4].contains("cm")) {
                    passContents[4] = passContents[4].replace("cm", "");
                    if (Integer.parseInt(passContents[4]) < 150 || Integer.parseInt(passContents[4]) > 193) {
                        continue;
                    }
                }
                else if (passContents[4].contains("in")) {
                    passContents[4] = passContents[4].replace("in", "");
                    if (Integer.parseInt(passContents[4]) < 59 || Integer.parseInt(passContents[4]) > 76) {
                        continue;
                    }
                }
                else continue;

                // iyr check
                if (Integer.parseInt(passContents[5]) < 2010 || Integer.parseInt(passContents[5]) > 2020) {
                    continue;
                }

                // pid check
                if (passContents[6].length() != 9) {
                    continue;
                }

                validPasses++;
            }
        }
        System.out.println(validPasses);
    }
}
