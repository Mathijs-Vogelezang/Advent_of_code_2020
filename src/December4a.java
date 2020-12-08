import java.io.IOException;
import java.util.Arrays;

public class December4a {
    private static String[] requiredContents = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

    public static void main(String[] args) throws IOException {
        String[] passes = getPasses("src/December4 puzzle input.txt");

        int validPasses = 0;
        for (String pass:passes) {
            if (isValid(pass)) {
                validPasses++;
            }
        }

        System.out.println(validPasses);
    }

    public static Boolean isValid(String pass) {
        String[] passContents = pass.split(" ");

        if (passContents.length == 8) {
            return true;
        }
        else if (passContents.length == 7) {
            int requiredCounter = 0;
            for (String content:passContents) {
                if (Arrays.stream(requiredContents).anyMatch(content::contains)) {
                    requiredCounter++;
                }
            }
            return requiredCounter == 7;
        }
        return false;
    }

    public static String[] getPasses(String filePath) throws IOException {
        String[] lines = Fileparser.toStringArray(filePath);
        int passCounter = 1; /* passCounter counts how many passes are in the input, it does this by counting the blank lines,
                                there is one blank line less than the amount of passes, so the counter starts at 1 */

        for (String line:lines) {
            if (line.equals("")) {
                passCounter++;
            }
        }

        String[] passes = new String[passCounter];
        Arrays.fill(passes, "");
        int passIndex = 0;

        for (String line:lines) {
            if (line.equals("")) {
                passIndex++;
            }
            else {
                passes[passIndex] += line + " ";
            }
        }
        return passes;
    }
}
