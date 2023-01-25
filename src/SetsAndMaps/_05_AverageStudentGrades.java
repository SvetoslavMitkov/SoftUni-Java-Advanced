package SetsAndMaps;

import java.util.*;

public class _05_AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<Double>> record = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);
            if (!record.containsKey(name)) {
                record.put(name, new ArrayList<>());
                record.get(name).add(grade);
            }else{
                record.get(name).add(grade);
            }
        }
        for (String name : record.keySet()) {
            double sum = 0;
            for (double grade: record.get(name)) {
                sum += grade;
            }
            double average = sum / record.get(name).size();

            System.out.printf("%s -> ", name);
            record.get(name).forEach(e -> System.out.printf("%.2f ",e));
            System.out.printf("(avg: %.2f)%n", average);
        }

    }
}
