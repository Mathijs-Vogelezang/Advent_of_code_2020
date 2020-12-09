import java.io.File;
import java.io.FileNotFoundException;
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

    public static int[] toIntArray (String path) throws IOException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        List<Integer> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(Integer.parseInt(scanner.nextLine()));
        }
        return input.stream().mapToInt(i->i).toArray();
    }

    public static long[] toLongArray (String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        List<Long> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(Long.parseLong(scanner.nextLine()));
        }
        return input.stream().mapToLong(i->i).toArray();
    }
}
