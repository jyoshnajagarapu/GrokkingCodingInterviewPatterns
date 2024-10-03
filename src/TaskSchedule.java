import java.util.*;

class TaskScheduler {
    public static int leastTime(char[] tasks, int n) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char t : tasks) {
            frequencies.put(t, frequencies.getOrDefault(t, 0) + 1);
        }

//        List<Map.Entry<Character, Integer>> sortedFrequencies = new ArrayList<>(frequencies.entrySet());
//        Collections.sort(sortedFrequencies, (lhs, rhs) -> lhs.getValue().compareTo(rhs.getValue()));
//
//
//        int maxFreq = sortedFrequencies.get(sortedFrequencies.size() - 1).getValue();
//        sortedFrequencies.remove(sortedFrequencies.size() - 1);
//
//        int idleTime = (maxFreq - 1) * n;
//
//        while (!sortedFrequencies.isEmpty() && idleTime > 0) {
//            idleTime -= Math.min(maxFreq - 1, sortedFrequencies.get(sortedFrequencies.size() - 1).getValue());
//            sortedFrequencies.remove(sortedFrequencies.size() - 1);
//        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> a : frequencies.entrySet()){
            list.add(a.getValue());
        }
        list.sort(Collections.reverseOrder());
        int maxFreq = list.get(0);
        int idleTime = (maxFreq - 1) * n;
        int i = 1;
        while(i < list.size() && idleTime > 0){
            idleTime  -= Math.min(list.get(i),maxFreq-1);
            i++;
        }
        
        idleTime = Math.max(0, idleTime);

        return tasks.length + idleTime;
    }

    // Driver code
    public static void main(String[] args) {
        char[][] allTasks = {
                {'A', 'A', 'B', 'B'},
                {'A', 'A', 'A', 'B', 'B', 'C', 'C'},
                {'S', 'I', 'V', 'U', 'W', 'D', 'U', 'X'},
                {'M', 'A', 'B', 'M', 'A', 'A', 'Y', 'B', 'M'},
                {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'}};

        int[] allNs = {2, 1, 0, 3, 3};

        for (int i = 0; i < allTasks.length; i++) {
            System.out.print((i + 1) + ".\tTasks: ");
            char[] tasks = allTasks[i];
            for(int j = 0; j < tasks.length; j++) {
                System.out.print(tasks[j]);
                if (j != tasks.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("\n\tn: " + allNs[i]);

            int minTime = leastTime(allTasks[i], allNs[i]);
            System.out.println("\tMinimum time required to execute the tasks: " + minTime);
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}