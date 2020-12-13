import java.io.IOException;

public class December12b {
    public static void main(String[] args) throws IOException {
        String[] instructions = Fileparser.toStringArray("src/December12 puzzle input.txt");
        int eastWest = 0;
        int northSouth = 0;
        int wpEastWest = 10;
        int wpNorthSouth = 1;

        for (String instruction:instructions) {
            char action = instruction.charAt(0);
            int units = Integer.parseInt(instruction.substring(1));

            switch (action) {
                case ('L'):
                    if (units == 90) {
                        int ew = wpEastWest; // temporary storing variable
                        wpEastWest = -wpNorthSouth;
                        wpNorthSouth = ew;
                    }
                    else if (units == 180) {
                        wpEastWest = -wpEastWest;
                        wpNorthSouth = -wpNorthSouth;
                    }
                    else if (units == 270) {
                        int ew = wpEastWest; // temporary storing variable
                        wpEastWest = wpNorthSouth;
                        wpNorthSouth = -ew;
                    }
                    break;
                case ('R'):
                    if (units == 90) {
                        int ew = wpEastWest; // temporary storing variable
                        wpEastWest = wpNorthSouth;
                        wpNorthSouth = -ew;
                    }
                    else if (units == 180) {
                        wpEastWest = -wpEastWest;
                        wpNorthSouth = -wpNorthSouth;
                    }
                    else if (units == 270) {
                        int ew = wpEastWest; // temporary storing variable
                        wpEastWest = -wpNorthSouth;
                        wpNorthSouth = ew;
                    }
                    break;
                case ('N'):
                    wpNorthSouth += units;
                    break;
                case ('E'):
                    wpEastWest += units;
                    break;
                case ('S'):
                    wpNorthSouth -= units;
                    break;
                case ('W'):
                    wpEastWest -= units;
                    break;
                case ('F'):
                    eastWest += units * wpEastWest;
                    northSouth += units * wpNorthSouth;
                    break;
            }
        }

        int ManhattanDistance = Math.abs(eastWest) + Math.abs(northSouth);
        System.out.println(ManhattanDistance);
    }
}
