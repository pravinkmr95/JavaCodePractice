package LeetcodeJava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {


    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num: nums){
            if (hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num)+1);
            } else {
                hashMap.put(num, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()){
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        int[] output = new int[priorityQueue.size()];
        int i=0;
        while (!priorityQueue.isEmpty()){
            output[i] = priorityQueue.poll().getKey();
            i++;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, 2)));

        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(new int[]{1}, 1)));
    }
}
