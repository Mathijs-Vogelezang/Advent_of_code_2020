import java.io.IOException;
import java.util.Arrays;

public class December9b {
    public static void main(String[] args) throws IOException {
        long[] input = Fileparser.toLongArray("src/December9 puzzle input.txt");
        long invalidNumber = December9a.getInvalidNumber(input);

        long[] sumArray = getSumArray(input, invalidNumber);
        System.out.println(Arrays.toString(sumArray)); // print out the numbers of the sum (for fun)

        Arrays.sort(sumArray);
        long sum = sumArray[0] + sumArray[sumArray.length - 1];
        System.out.println("Lowest: " + sumArray[0] + "\nHighest: " + sumArray[sumArray.length - 1] + "\nSum: " + sum);
    }

    public static long[] getSumArray(long[] input, long invalidNumber) {
        for (int i = 0; i < input.length; i++) {
            long sum = 0;
            for (int j = i; sum < invalidNumber; j++) {
                sum += input[j];
                if (sum == invalidNumber) {
                    long[] result = new long[j - i];
                    int startIndex = i;
                    for (; i < j; i++) {
                        result[i - startIndex] = input[i];
                    }
                    return result;
                }
            }

        }
        return new long[0];
    }
}
