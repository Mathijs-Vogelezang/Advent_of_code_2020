import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fileparser {
    public static String[] toStringArray (String path) throws IOException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        return input.toArray(new String[0]);
    }

    public static Integer[] toIntArray (String path) throws IOException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        List<Integer> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(Integer.parseInt(scanner.nextLine()));
        }
        return input.toArray(new Integer[0]);
    }
}
