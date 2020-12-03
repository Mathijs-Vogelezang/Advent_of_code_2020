import java.io.IOException;

public class December3a {

    public static void main(String[] args) throws IOException {
        String[] input = Fileparser.toStringArray("C:\\Users\\mathi\\IdeaProjects\\Advent of code\\src\\December3 puzzle input.txt");
        final int stringLength = input[0].length();
        int pos = 3; // start at index 3
        int treeCounter = 0;

        for (int i = 1; i < input.length; i++) { //start at second line of file, so i starts with 1
            if (input[i].charAt(pos % stringLength) == '#') {
                treeCounter++;
            }
            pos += 3;
        }
        System.out.println(treeCounter);
    }
}