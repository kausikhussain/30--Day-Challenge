/*
Problem: Find Median from Data Stream
Platform: LeetCode
Topic: Heap / Design

Approach:
Use two priority queues (heaps): 
1. A Max-Heap to store the smaller half of the numbers.
2. A Min-Heap to store the larger half of the numbers.
Maintain the balance such that the Max-Heap size is either equal to the Min-Heap size, 
or greater by exactly 1. 
The median will be the top of the Max-Heap if sizes are unequal, 
otherwise it's the average of the tops of both heaps.

Time Complexity: O(log N) for addNum, O(1) for findMedian.
Space Complexity: O(N) to store all numbers in the data stream.
*/

import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> small; // Max-Heap
    private PriorityQueue<Integer> large; // Min-Heap

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        
        // Maintain balance
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}
