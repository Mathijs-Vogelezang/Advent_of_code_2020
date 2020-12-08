import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class December8b {
    public static void main(String[] args) throws IOException {
        String[] input = Fileparser.toStringArray("src/December8 puzzle input.txt");
        List<Integer> nopjmp = new ArrayList<>(); // list which stores the indexes of all jmp and nop operations

        for (int i = 0; i < input.length; i++) {
            String operation = input[i].split(" ")[0];
            if (operation.equals("jmp") || operation.equals("nop")) nopjmp.add(i);
        }

        for (int i:nopjmp) {
            String[] test = input.clone();
            String operation = input[i].split(" ")[0];
            if (operation.equals("nop")) test[i] = test[i].replace("nop", "jmp");
            else test[i] = test[i].replace("jmp", "nop");

            boolean[] executed = new boolean[input.length]; // this array stores if operation is already executed
            boolean loop = false; // stores if the program has a loop
            int accumulator = 0;

            for(int j = 0; j < test.length; j++) {
                if (!executed[j]) {
                    operation = test[j].split(" ")[0];
                    int argument = Integer.parseInt(test[j].split(" ")[1]);
                    executed[j] = true;

                    if (operation.equals("acc")) {
                        accumulator += argument;
                    }
                    else if (operation.equals("jmp")) {
                        j += argument - 1; // -1 to compensate for the +1 from the for loop
                    }
                }
                else {
                    loop = true;
                    break;
                }
            }

            if (!loop) {
                System.out.println(accumulator);
                break;
            }
        }
    }
}
