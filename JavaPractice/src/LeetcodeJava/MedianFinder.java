package LeetcodeJava;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()){
            maxHeap.offer(num);
            return;
        }
        if (maxHeap.peek() >= num){
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if (minHeap.size()+1 < maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        double median=0;
        if (maxHeap.size() > minHeap.size()){
            median = maxHeap.peek();
        } else if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            median = (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return median;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        for (int i=1; i<10; i++){
            medianFinder.addNum(i);
            System.out.println(medianFinder.findMedian());
        }
    }
}
