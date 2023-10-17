package Heap;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
        System.out.println("Test case 1:");
        System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
        System.out.println("Expected output: [1, 5, 5, 9, 9, 9, 9]");
        System.out.println("Actual output: " + streamMax(nums1));
        System.out.println();

        // Test case 2
        int[] nums2 = {10, 2, 5, 1, 0, 11, 6};
        System.out.println("Test case 2:");
        System.out.println("Input: [10, 2, 5, 1, 0, 11, 6]");
        System.out.println("Expected output: [10, 10, 10, 10, 10, 11, 11]");
        System.out.println("Actual output: " + streamMax(nums2));
        System.out.println();

        // Test case 3
        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println("Test case 3:");
        System.out.println("Input: [3, 3, 3, 3, 3]");
        System.out.println("Expected output: [3, 3, 3, 3, 3]");
        System.out.println("Actual output: " + streamMax(nums3));
        System.out.println();
    }

//    public static int findKthSmallest(int[] nums, int k) {
//
//        if(nums.length == 1) return nums[0];
//        Arrays.sort(nums);
//
//        return nums[k-1];
//    }

    public static int findKthSmallest(int[] nums, int k) {
        Heap maxHeap = new Heap();

        for (int num : nums) {
            maxHeap.insert(num);
            if (maxHeap.getHeap().size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap.remove();
    }

//    public static List<Integer> streamMax(int[] nums) {
//
//        if(nums == null || nums.length == 0) return new ArrayList<>();
//
//        List<Integer> streamMax = new ArrayList<>();
//        int previous = nums[0];
//        for(int num : nums) {
//            if(previous < num) {
//                previous = num;
//            }
//            streamMax.add(previous);
//        }
//
//        return streamMax;
//    }

    public static List<Integer> streamMax(int[] nums) {
        Heap maxHeap = new Heap();
        List<Integer> maxStream = new ArrayList<>();

        for (int num : nums) {
            maxHeap.insert(num);
            // The heap's root is always the maximum, so we add it to the result list
            maxStream.add(maxHeap.getHeap().get(0));
        }

        return maxStream;
    }
}
