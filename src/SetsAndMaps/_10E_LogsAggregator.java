package SetsAndMaps;

import com.sun.source.tree.LiteralTree;

import java.util.*;
import java.util.stream.Collectors;

public class _10E_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> log = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            String user = inputArr[1];
            String IP = inputArr[0];
            int duration = Integer.parseInt(inputArr[2]);

            if (!log.containsKey(user)) {
                log.put(user, new TreeMap<>());
                log.get(user).put(IP, duration);
            }else{
                if (!log.get(user).containsKey(IP)){
                    log.get(user).put(IP, duration);
                }else{
                    int currentDuration = log.get(user).get(IP);
                    log.get(user).put(IP, currentDuration + duration);
                }
            }
        }
        Map<String, Integer> durationsMap = new HashMap<>();
        for (Map.Entry<String, Map<String, Integer>> mapEntry : log.entrySet()) {
            String user = mapEntry.getKey();
            durationsMap.putIfAbsent(user, 0);
            for (Map.Entry<String, Integer> integerEntry : mapEntry.getValue().entrySet()) {
                durationsMap.put(user, durationsMap.get(user) + integerEntry.getValue());
            }
        }
        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : log.entrySet()) {
            System.out.printf("%s: ", stringMapEntry.getKey());
            System.out.printf("%d ", durationsMap.get(stringMapEntry.getKey()));
            List<String> IPs = stringMapEntry.getValue().keySet().stream().collect(Collectors.toList());
            System.out.println(IPs);

        }


    }
}
