package com.shaurya._3slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(arr, k);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue((a, b) -> (Integer)b-(Integer)a);
        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        int[] arr1 = al.stream().mapToInt(i->i).toArray();
        Arrays.stream(arr1).forEach(ss-> System.out.println(ss));
        int result[] = new int[nums.length-k+1];
        int i=0, j=0, b=0;
        while(j<nums.length){
            maxQueue.offer(nums[j]);
            if(j-i+1<k) {
                j++;
            }else{
                result[b]=maxQueue.peek();
                maxQueue.remove(nums[i]);
                i++;b++;j++;
            }
        }
        Arrays.stream(result).forEach(s-> System.out.print(s+" "));
        return result;
    }
}
