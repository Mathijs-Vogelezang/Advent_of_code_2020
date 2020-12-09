import java.io.IOException;

public class December9a {
    public static void main(String[] args) throws IOException {
        long[] input = Fileparser.toLongArray("src/December9 puzzle input.txt");
        System.out.println(getInvalidNumber(input));
    }

    public static long getInvalidNumber(long[] numbers) {
        for (int i = 25; i < numbers.length; i++) {
            boolean isValid = false;

            for (int j = i - 25; j < i; j++) {
                for (int k = j + 1; k < i; k++) {
                    if (numbers[j] + numbers[k] == numbers[i]) {
                        isValid = true;
                        break;
                    }
                }
            }
            if (!isValid) {
                return numbers[i];
            }
        }
        return -1; // return -1 if no invalid number can be found
    }
}
