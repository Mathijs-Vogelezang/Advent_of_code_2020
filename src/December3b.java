import java.io.IOException;

public class December3b {
    private static String[] input;

    static {
        try {
            input = Fileparser.toStringArray("C:\\Users\\mathi\\IdeaProjects\\Advent of code\\src\\December3 puzzle input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final int stringLength = input[0].length();

    public static void main(String[] args) {
        int[] subresult = new int[5];

        subresult[0] = treeCounter(1, 1);
        subresult[1] = treeCounter(3, 1);
        subresult[2] = treeCounter(5, 1);
        subresult[3] = treeCounter(7, 1);
        subresult[4] = treeCounter(1, 2);

        int result = 1;
        for (int sub:subresult) {
            System.out.println(sub); // print subresults (for fun)
            result *= sub;
        }

        System.out.println(result);
    }

    public static int treeCounter(int right, int down) {
        int pos = right;
        int treeCounter = 0;

        for (int i = down; i < input.length; i+= down) { //start at line down of file, so i starts with down
            if (input[i].charAt(pos % stringLength) == '#') {
                treeCounter++;
            }
            pos += right;
        }
        return treeCounter;
    }
}
