import java.io.IOException;

public class December12a {
    public static void main(String[] args) throws IOException {
        String[] instructions = Fileparser.toStringArray("src/December12 puzzle input.txt");
        int eastWest = 0;
        int northSouth = 0;
        char[] directions = new char[]{'N', 'E', 'S', 'W'};
        int facing = 1; // start at facing east

        for (String instruction:instructions) {
            char action = instruction.charAt(0);
            int units = Integer.parseInt(instruction.substring(1));
            boolean moved = false;

            while (!moved) { // if a forward (F) move is called, this section will be done twice, but with the action changed
                switch (action) {
                    case ('L'):
                        facing = (facing + 4 - units / 90) % 4;
                        moved = true;
                        break;
                    case ('R'):
                        facing = (facing + units / 90) % 4;
                        moved = true;
                        break;
                    case ('N'):
                        northSouth += units;
                        moved = true;
                        break;
                    case ('E'):
                        eastWest += units;
                        moved = true;
                        break;
                    case ('S'):
                        northSouth -= units;
                        moved = true;
                        break;
                    case ('W'):
                        eastWest -= units;
                        moved = true;
                        break;
                    case ('F'):
                        action = directions[facing];
                        break;
                }
            }
        }

        int ManhattanDistance = Math.abs(eastWest) + Math.abs(northSouth);
        System.out.println(ManhattanDistance);
    }
}
