import java.io.IOException;

public class December5a {

    public  static void main(String[] args) throws IOException {
        int[] inputValues = getValues(Fileparser.toStringArray("src/December5 puzzle input.txt"));

        int maxValue = 0;
        for (int value:inputValues) {
            if (value > maxValue) maxValue = value;
        }

        System.out.println(maxValue);
    }

    public static int[] getValues(String[] input) {
        int[] inputValues = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            inputValues[i] = Integer.parseInt(input[i].replace('F', '0').replace('B', '1')
                    .replace('L', '0').replace('R', '1'), 2);
        }
        return inputValues;
    }
}

/*
FBFBBFF
0101100
F = 0
B = 1

RLR
101
L = 0
R = 1

FBFBBFFRLR
0101100101
*/
