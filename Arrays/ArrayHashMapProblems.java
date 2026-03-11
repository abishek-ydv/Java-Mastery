// import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
public class ArrayHashMapProblems {

    public int[][] countFrequency(int[] arr){
        /* Usual Way */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        System.out.println(map);

        /* OG Way of traversing a Map */
        int[][] frequencyArray = new int[map.size()][2];
        int row = 0;
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Integer> entry = it.next();
            frequencyArray[row][0] = entry.getKey();
            frequencyArray[row][1] = entry.getValue();
            row++;
        }
        
        /* Modern Way */
        /* Map<Integer,Integer> freqMap = new HashMap<>();
        for(int ele : arr){
            freqMap.merge(ele, 1, (oldValue,newValue) -> oldValue+newValue); // OR Integer::sum;
        }
        System.out.println(freqMap); */

        /* OG Way of frequency array solving */
        /* Map<Integer, Integer> hMap = new HashMap<>();
        for(int ele : arr){
            if(hMap.containsKey(ele)){
                hMap.put(ele, hMap.get(ele)+1);
            } else {
                hMap.put(ele, 1);
            }
        }
        System.out.println(hMap); */
        
        /* another way of traversing.*/
        /* int[][] frequencyArray2 = new int[freqMap.size()][2];
        int row2 = 0;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            frequencyArray2[row2][0] = entry.getKey();
            frequencyArray2[row2][1] = entry.getValue();
            row2++;
        } */
        return frequencyArray; 
    }
    
        public int firstNonRepeatingGFG(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int firstNonRepeating = 0;
        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) return entry.getKey();
        }
        
        return firstNonRepeating;
    }

    public List<Integer> frequencyCountGFG(int[] arr) {
        int n = arr.length;
        List<Integer> freqArr = new ArrayList<>(Collections.nCopies(n, 0));
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int ele : arr){
            freqMap.merge(ele, 1, Integer::sum);
        }
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            freqArr.set(entry.getKey() - 1, entry.getValue());
        }
        return freqArr;
        
    }

    static ArrayList<Integer> removeDuplicateGFG(int arr[]) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        /* Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Integer> entry = it.next();
            list.add(entry.getKey());
        } */
       /* Instead of using Iterator we can pas they keySet */
        return new ArrayList<>(map.keySet());
    }

    public int[] replaceWithRankGFG(int arr[], int N) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int[] arrx = arr.clone();
        Arrays.sort(arrx);
        int lastElement = -1;
        int ranker = 0;
        for(int ele : arrx){
            if(lastElement != ele){
                ranker++;
            }
            map.put(ele, ranker);
            lastElement = ele;
            System.out.println(ranker);
        }
        System.out.println(map);

        for(int i = 0; i < arr.length; i++){
                arr[i] = map.get(arr[i]);
        }
        return arr;
    }
    
    public static void main(String[] args){
        /* In this we are gonna solve array problems with the help of hashmap. like counting frequency of a number, etc. */
        ArrayHashMapProblems aHMP = new ArrayHashMapProblems();
        System.out.println(Arrays.deepToString(aHMP.countFrequency(new int[] {1,2,3,2,1,4,5,2,3,6,5,6,6,7})));
        System.out.println(aHMP.firstNonRepeatingGFG(new int[] {1,2,3,-1,-2,1,2,-1,-2,4}));
        System.out.println(Arrays.toString(aHMP.replaceWithRankGFG(new int[] {20, 15, 26, 2, 98, 6}, 6)));
    }
}