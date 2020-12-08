import java.io.IOException;

public class December8a {
    public static void main(String[] args) throws IOException {
        String[] input = Fileparser.toStringArray("src/December8 puzzle input.txt");
        boolean[] executed = new boolean[input.length]; // this array stores if operation is already executed
        int accumulator = 0;

        for(int i = 0; i < input.length; i++) {
            if (!executed[i]) {
                String operation = input[i].split(" ")[0];
                int argument = Integer.parseInt(input[i].split(" ")[1]);
                executed[i] = true;

                if (operation.equals("acc")) {
                    accumulator += argument;
                }
                else if (operation.equals("jmp")) {
                    i += argument - 1; // -1 to compensate for the +1 from the for loop
                }
            }
            else break;
        }
        System.out.println(accumulator);
    }
}
