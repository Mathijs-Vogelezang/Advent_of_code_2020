import java.io.IOException;
import java.util.Arrays;

public class December5b {
    public static void main(String[] args) throws IOException {
        int[] inputValues = December5a.getValues(Fileparser.toStringArray("src/December5 puzzle input.txt"));
        Arrays.sort(inputValues);

        int seat = 0;
        for (int i = 0; i < inputValues.length-1; i++) {
            if (inputValues[i+1] - inputValues[i] == 2) {
                seat = inputValues[i] + 1;
                break;
            }
        }
        System.out.println(seat);
    }
}
