import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;

public class December11b {

    public static void main(String[] args) throws IOException {
        String[] input = Fileparser.toStringArray("src/December11 puzzle input.txt");
        char[][] seats = December11a.getSeats(input);

        int occupiedSeats = 0;
        int lastOccupiedSeats = 1;

        while (occupiedSeats != lastOccupiedSeats) {
            lastOccupiedSeats = occupiedSeats;

            char[][] lastState = new char[seats.length][seats[0].length];

            for (int i = 0; i < lastState.length; i++) {
                lastState[i] = seats[i].clone();
            }

            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    if (seats[i][j] == 'L' && occupiedSeats(lastState, i, j) == 0) {
                        seats[i][j] = '#';
                        occupiedSeats++;
                    }
                    else if (seats[i][j] == '#' && occupiedSeats(lastState, i, j) >= 5) {
                        seats[i][j] = 'L';
                        occupiedSeats--;
                    }
                }
            }
        }
        System.out.println(occupiedSeats);
    }

    public static int occupiedSeats(char[][] seats, int i, int j) {
        int seatCounter = 0;

        int rowLength = seats[0].length;

        // 1
        for(int count = 1; i + count < seats.length; count++) {
            if (seats[i + count][j] == '#') {
                seatCounter++;
                break;
            } else if (seats[i + count][j] == 'L') break;
        }

        // 2
        for(int count = 1; i - count >= 0; count++) {
            if (seats[i - count][j] == '#') {
                seatCounter++;
                break;
            }
            else if (seats[i - count][j] == 'L') break;
        }

        // 3
        for(int count = 1; j + count < seats[i].length; count++) {
            if (seats[i][j + count] == '#') {
                seatCounter++;
                break;
            }
            else if (seats[i][j + count] == 'L') break;
        }

        // 4
        for (int count = 1; j - count >= 0; count++) {
            if (seats[i][j - count] == '#') {
                seatCounter++;
                break;
            }
            else if (seats[i][j - count] == 'L') break;
        }

        // 5
        for(int count = 1; i + count < seats.length; count++) {
            if (j + count == seats[i + count].length || seats[i + count][j + count] == 'L') break;
            else if (seats[i + count][j + count] == '#') {
                seatCounter++;
                break;
            }
        }

        // 6
        for(int count = 1; i + count < seats.length; count++) {
            if (j - count == -1 || seats[i + count][j - count] == 'L') break;
            else if (seats[i + count][j - count] == '#') {
                seatCounter++;
                break;
            }

        }

        // 7
        for(int count = 1; i - count >= 0; count++) {
            if (j + count == seats[i - count].length || seats[i - count][j + count] == 'L') break;
            else if (seats[i - count][j + count] == '#') {
                seatCounter++;
                break;
            }
        }

        // 8
        for(int count = 1; i - count >= 0; count++) {
            if (j - count == - 1 || seats[i - count][j - count] == 'L') break;
            else if (seats[i - count][j - count] == '#') {
                seatCounter++;
                break;
            }
        }
        return seatCounter;
    }
}
