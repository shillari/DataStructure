package HashTable;

import BinarySearchTree.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        HashTable table = new HashTable();

//        System.out.println(table.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//        System.out.println(table.groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));
//        System.out.println(table.groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

//        System.out.println(Arrays.toString(table.twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(table.twoSum(new int[]{3, 2, 4}, 6)));
//        System.out.println(Arrays.toString(table.twoSum(new int[]{3, 3}, 6)));
//        System.out.println(Arrays.toString(table.twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
//        System.out.println(Arrays.toString(table.twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
//        System.out.println(Arrays.toString(table.twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
//        System.out.println(Arrays.toString(table.twoSum(new int[]{}, 0)));


//        List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
//        System.out.println(table.removeDuplicates(myList));

//        System.out.println(table.hasUniqueChars("abcdefg")); // should return true
//        System.out.println(table.hasUniqueChars("hello")); // should return false
//        System.out.println(table.hasUniqueChars("")); // should return true
//        System.out.println(table.hasUniqueChars("0123456789")); // should return true
//        System.out.println(table.hasUniqueChars("abacadaeaf")); // should return false

//        int[] arr1 = {1, 2, 3, 4, 5};
//        int[] arr2 = {2, 4, 6, 8, 10};
//        int target = 7;
//        List<int[]> pairs = table.findPairs(arr1, arr2, target);
//        for (int[] pair : pairs) {
//            System.out.println(Arrays.toString(pair));
//        }

//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int longest = table.longestConsecutiveSequence(nums);
//        System.out.println(longest);

        HashMap<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.putIfAbsent("a", "c");

        System.out.println(map);

        /**
        char[] a = {'h', 'c', 'b'};
        char[] b = {'h', 'c', 'b'};
        char[] c = Arrays.copyOf(a, a.length);
        HashMap<String, String> h = new HashMap<>();
        h.put(a.toString(), String.valueOf(a));
        h.put(b.toString(), "b");
        //h.put(c, "c");
        //Arrays.sort(c);
        //Arrays.sort(b);

        System.out.println(h.get(a.toString()));
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
         **/

    }
}
