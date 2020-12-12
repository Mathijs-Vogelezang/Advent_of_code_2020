import java.io.IOException;
import java.util.Arrays;

public class December11a {

    public static void main(String[] args) throws IOException {
        String[] input = Fileparser.toStringArray("src/December11 puzzle input.txt");

        char[][] seats = getSeats(input);

        int occupiedSeats = 0;
        int lastOccupiedSeats = 1;

        while (occupiedSeats != lastOccupiedSeats) {
            lastOccupiedSeats = occupiedSeats;
            char[] adjacent = new char[8]; // al the 8 adjacent positions, is '.' when it is at the edge
            Arrays.fill(adjacent, '.');
            char[][] lastState = new char[seats.length][seats[0].length];

            for (int i = 0; i < lastState.length; i++) {
                lastState[i] = seats[i].clone();
            }

            for (int i = 0; i < seats.length; i++) {

                for (int j = 0; j < seats[i].length; j++) {
                    // begin determining adjacent
                    if (i == 0 && j == 0) {
                        adjacent[0] = '.';
                        adjacent[1] = '.';
                        adjacent[2] = '.';
                        adjacent[3] = '.';
                        adjacent[4] = lastState[i][j + 1];
                        adjacent[5] = '.';
                        adjacent[6] = lastState[i + 1][j];
                        adjacent[7] = lastState[i + 1][j + 1];
                    } else if (i == 0 && j == seats[i].length - 1) {
                        adjacent[0] = '.';
                        adjacent[1] = '.';
                        adjacent[2] = '.';
                        adjacent[3] = lastState[i][j - 1];
                        adjacent[4] = '.';
                        adjacent[5] = lastState[i + 1][j - 1];
                        adjacent[6] = lastState[i + 1][j];
                        adjacent[7] = '.';
                    } else if (i == seats.length - 1 && j == 0) {
                        adjacent[0] = '.';
                        adjacent[1] = lastState[i - 1][j];
                        adjacent[2] = lastState[i - 1][j + 1];
                        adjacent[3] = '.';
                        adjacent[4] = lastState[i][j + 1];
                        adjacent[5] = '.';
                        adjacent[6] = '.';
                        adjacent[7] = '.';
                    } else if (i == seats.length - 1 && j == seats[i].length - 1) {
                        adjacent[0] = lastState[i - 1][j - 1];
                        adjacent[1] = lastState[i - 1][j];
                        adjacent[2] = '.';
                        adjacent[3] = lastState[i][j - 1];
                        adjacent[4] = '.';
                        adjacent[5] = '.';
                        adjacent[6] = '.';
                        adjacent[7] = '.';
                    } else if (i == 0) {
                        adjacent[0] = '.';
                        adjacent[1] = '.';
                        adjacent[2] = '.';
                        adjacent[3] = lastState[i][j - 1];
                        adjacent[4] = lastState[i][j + 1];
                        adjacent[5] = lastState[i + 1][j - 1];
                        adjacent[6] = lastState[i + 1][j];
                        adjacent[7] = lastState[i + 1][j + 1];
                    } else if (j == 0) {
                        adjacent[0] = '.';
                        adjacent[1] = lastState[i - 1][j];
                        adjacent[2] = lastState[i - 1][j + 1];
                        adjacent[3] = '.';
                        adjacent[4] = lastState[i][j + 1];
                        adjacent[5] = '.';
                        adjacent[6] = lastState[i + 1][j];
                        adjacent[7] = lastState[i + 1][j + 1];
                    } else if (i == seats.length - 1) {
                        adjacent[0] = lastState[i - 1][j - 1];
                        adjacent[1] = lastState[i - 1][j];
                        adjacent[2] = lastState[i - 1][j + 1];
                        adjacent[3] = lastState[i][j - 1];
                        adjacent[4] = lastState[i][j + 1];
                        adjacent[5] = '.';
                        adjacent[6] = '.';
                        adjacent[7] = '.';
                    } else if (j == seats[i].length - 1) {
                        adjacent[0] = lastState[i - 1][j - 1];
                        adjacent[1] = lastState[i - 1][j];
                        adjacent[2] = '.';
                        adjacent[3] = lastState[i][j - 1];
                        adjacent[4] = '.';
                        adjacent[5] = lastState[i + 1][j - 1];
                        adjacent[6] = lastState[i + 1][j];
                        adjacent[7] = '.';
                    } else {
                        adjacent[0] = lastState[i - 1][j - 1];
                        adjacent[1] = lastState[i - 1][j];
                        adjacent[2] = lastState[i - 1][j + 1];
                        adjacent[3] = lastState[i][j - 1];
                        adjacent[4] = lastState[i][j + 1];
                        adjacent[5] = lastState[i + 1][j - 1];
                        adjacent[6] = lastState[i + 1][j];
                        adjacent[7] = lastState[i + 1][j + 1];
                    }
                    // end determining adjacent

                    if (seats[i][j] == 'L') {
                        if (countOccurances(adjacent, '#') == 0) {
                            seats[i][j] = '#';
                            occupiedSeats++;
                        }
                    } else if (seats[i][j] == '#') {
                        if (countOccurances(adjacent, '#') >= 4) {
                            seats[i][j] = 'L';
                            occupiedSeats--;
                        }
                    }
                }
            }
        }
        System.out.println(occupiedSeats);
    }

    public static int countOccurances(char[] input, char toCount) {
        int counter = 0;
        for (char character:input) {
            if (character == toCount) {
                counter++;
            }
        }
        return counter;
    }

    public static char[][] getSeats(String[] input) {
        char[][] seats = new char[input.length][input[0].length()];

        for (int i = 0; i < input.length; i++) {
            seats[i] = input[i].toCharArray();
        }

        return seats;
    }
}
