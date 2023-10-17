package HashTable;

import java.util.*;

public class HashTable  {
    private final int size = 7;
    private final Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for(int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if(temp.key == key) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            if (dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    allKeys.add(temp.key);
                    temp = temp.next;
                }
            }
        }
        return allKeys;
    }

    public boolean itemInCommon(int[] array1, int[] array2) {

        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        for (int i : array1) {
            hashMap.put(i, true);
        }

        for(int i : array2) {
            if(hashMap.get(i) != null) return true;
        }

        return false;
    }

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> duplicates = new ArrayList<>();
        HashMap<Integer, Boolean> numsHM = new HashMap<>();

        for(int i : nums) {
            if(numsHM.get(i) == null)
                numsHM.put(i, false);
            else
                numsHM.put(i, true);
        }

        for(Integer i : numsHM.keySet()) {
            if(numsHM.get(i).booleanValue()) duplicates.add(i);
        }

        return duplicates;
    }

    public Character firstNonRepeatingChar(String word) {

        HashMap<Character, Integer> letter = new HashMap<>();
        char[] letters = word.toCharArray();

        for(char l : letters) {
            int i = letter.get(l) != null ? letter.get(l).intValue() + 1 : 1;
            letter.put(l, i);
        }

        for(char i : letters) {
            if(letter.get(i).intValue() == 1) return i;
        }

        return null;
    }

    public List<List<String>> groupAnagrams(String[] strings) {

        HashMap<String, List<String>> anagramGroup = new HashMap<>();

        for(String str : strings) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            if(anagramGroup.get(String.valueOf(chars)) != null) {
                anagramGroup.get(String.valueOf(chars)).add(str);
            } else {
                List<String> lst = new ArrayList();
                lst.add(str);
                anagramGroup.put(String.valueOf(chars), lst);
            }
        }

        return new ArrayList<>(anagramGroup.values());
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap();
        int[] sum = {};
        int count = 0;

        for(int i : nums) {
            map.put(i, count++);
        }

        for(int i = 0; i < nums.length; i++) {
            int cont = target - nums[i];
            if(map.containsKey(cont) && i != map.get(cont).intValue()) {
                sum = new int[]{i, map.get(cont).intValue()};
                return sum;
            }
        }

        return sum;
    }

    public List<Integer> removeDuplicates(List<Integer> myList) {

        if(myList == null) return null;

        Set<Integer> uniqueList = new HashSet<>(myList);
        return new ArrayList<>(uniqueList);
    }

    public boolean hasUniqueChars(String str) {

        if(str == null || str.isEmpty()) return true;

        char[] strChar = str.toCharArray();
        Set setChar = new HashSet<>();
        for(char c: strChar) {
            setChar.add(c);
        }

        return strChar.length == setChar.size();
    }

    public List<int[]> findPairs(int[] arr1, int[] arr2, int target) {

        Set<Integer> arr1Set = new HashSet();
        List<int[]> pairs = new ArrayList<>();
        for(int i : arr1) {
            arr1Set.add(i);
        }

        for(int i = 0; i < arr2.length; i++) {
            int comp = target - arr2[i];
            if(arr1Set.contains(comp)) {
                int[] pairsInt = {comp, arr2[i]};
                pairs.add(pairsInt);
            }
        }
        return pairs;
    }

    public int longestConsecutiveSequence(int[] nums) {

        int count = 1;
        int longestCount = 1;
        Arrays.sort(nums);
        Set numsSet = new HashSet();
        for (int i : nums) {
            numsSet.add(i);
        }

        int previousNumber = (int) numsSet.stream().findFirst().get();
        for(Object i : numsSet) {
            if((int) i == (int) numsSet.stream().findFirst().get()) continue;

            if((int) i == (previousNumber+1)) count++;
            else count = 1;

            if(count > longestCount) longestCount = count;

            previousNumber = (int) i;
        }

        return longestCount;
    }

    public class Node {
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
