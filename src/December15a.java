import java.util.*;

public class December15a {
    public static void main(String[] args) {
        int[] puzzleInput = new int[]{1, 20, 11, 6, 12, 0};
        System.out.println(getValueAfterRounds(puzzleInput, 2020));
    }

    public static int getValueAfterRounds(int[] puzzleInput, int round) {
        List<Integer> numbersSpoken = new ArrayList<>();
        Map<Integer, Integer> prevIndexes = new HashMap<>();

        for(int i = 0; i < puzzleInput.length - 1; i++) {
            numbersSpoken.add(puzzleInput[i]);
            prevIndexes.put(puzzleInput[i], i);
        }
        numbersSpoken.add(puzzleInput[puzzleInput.length - 1]);

        for (int i = puzzleInput.length; i < round; i++) {
            int number = numbersSpoken.get(i - 1);
            try {
                int prevIndex = prevIndexes.get(number);
                numbersSpoken.add(i - prevIndex - 1);
            }
            catch (NullPointerException e) {
                numbersSpoken.add(0);
            }
            prevIndexes.put(number, i - 1);
        }
        return numbersSpoken.get(round - 1);
    }
}
