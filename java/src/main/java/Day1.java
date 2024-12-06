import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Day 1");

        int[][] data = getData();

        List<Integer> fromList = new ArrayList<>();
        List<Integer> toList = new ArrayList<>();

        for (int[] row : data) {
            fromList.add(row[0]);
            toList.add(row[1]);
        }

        Collections.sort(fromList);
        Collections.sort(toList);

        System.out.println("Sorted From: " + fromList);
        System.out.println("Sorted To: " + toList);

        int result = getDistances(fromList, toList);

        System.out.println("res" + result);

    }

    public static int[][] getData() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/input.txt"));

        int[][] data = lines.stream()
                .map(line -> Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        return data;

    }

    public static int getDistances(List<Integer> from, List<Integer> to) {
        int index = 0;
        int sum = 0;

        System.out.println(from);
        for (Iterator<Integer> l = to.iterator(); l.hasNext(); index++) {
            l.next();
            int fromValue = from.get(index);
            int toValue = to.get(index);

            sum += Math.abs(fromValue - toValue);
        }

        return sum;
    }

}
