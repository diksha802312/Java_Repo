package DSA.PriorityQueue;

import java.util.*;
import java.util.stream.Collectors;

public class Queue {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,1,1,4,6,6,2,2,2,2,2);
        getTopK(list, 3);
    }

    public static void getTopK(List<Integer> nums, int k){
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer num : nums){
            map.put(num, map.getOrDefault(num, 0)+ 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey()); // removes smallest first
        }

        Collections.reverse(result);
        System.out.println(result);

    }
}
