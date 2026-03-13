import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ArraySlidingWindow {

    public static int maxSubArraySumGFG(int[] arr, int k){
        int windowSum = 0;
        int maxSum = 0;
        for(int i = 0; i < k; i++){
            windowSum = windowSum += arr[i];
        }
        maxSum = windowSum;
        if(k == arr.length) return windowSum;
        for(int i = k; i < arr.length; i++){
            windowSum = windowSum + arr[i] - arr[i-k];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }

    public static int slidingWindowMaxSubarraySum(int[] arr, int k){
        int maxSum = 0;
        int windowSum = 0;
        for(int i = 0; i < arr.length; i++){
            windowSum += arr[i]; //in this we are adding window sum so this will execute and will create our first windo sum which we get at when i = k;
            if(i >= k) windowSum -= arr[i-k]; // so this will start removing element and will execute when  i == k or greater than k and then we get our current windowSum and i-k gives the first index of that window. 
            if(i >= k-1) maxSum = Math.max(maxSum, windowSum); // k-1 is the first complete window.
        }
        return maxSum;
    }

    public static List<Integer> firstNegIntGFG(int arr[], int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= arr.length-k; i++){
            int firstNegative = 0;
            for(int j = i; j < i + k; j++){
                if(arr[j] < 0) {
                    firstNegative = arr[j];
                    break;
                }
            }
            list.add(firstNegative);
        }
        return list;
    }

    public static ArrayList<Integer> countDistinctGFG(int arr[], int k) {
        ArrayList<Integer> distinctCountArr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
            if(i >= k){
                map.put(arr[i-k], map.get(arr[i-k])-1);
                if(map.get(arr[i-k]) == 0) map.remove(arr[i-k]);
            }
            if(i >= k-1){
                distinctCountArr.add(map.size());
            }
        }
        return distinctCountArr;
    }

    public static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> negativeList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        int pointer = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            if(arr[i] < 0){
                indexList.add(i);
            }
            if(pointer < indexList.size() && indexList.get(pointer) <= i-k){
                pointer++;
            }
            if(i >= k-1){
                if(pointer < indexList.size()){
                    negativeList.add(arr[indexList.get(pointer)]);
                } else{
                    negativeList.add(0);
                }
            }
        }
        return negativeList;
    }

    public static int longestSubarray(int arr[]) {
        int count = 0; 
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0)
                count = 0;
            else if(arr[i] >= 0)
                count++;
            max = Math.max(count, max);
        }
        return max;   
    }

    public static int smallestSubWithSum(int x, int[] arr) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while ( right < arr.length){
            sum += arr[right];
            System.out.println(String.format("Sum while increasing right %d", sum));
            while (sum >= x){
                result = Integer.min(result, right-left+1);
                System.out.println(String.format("Left %d Right %d Sum %d", left, right, right-left+1));
                sum -= arr[left];
                System.out.println(String.format("Sum after removing first element of window %d", sum));
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static int totalFruit904LC(int[] fruits) {
        int right = 0; 
        int left = 0;
        int result = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        while(right < fruits.length){
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);
            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            result = Math.max(result, right - left +1);
            right++;
        }
        return result;
    }

    public static int totalFruit(int[] fruits) {
        int right = 0;
        int left = 0;
        int firstFruit = -1;
        int secondFruit = -1;
        int lastIndexFirstFruit = 0;
        int lastIndexSecondFruit = 0;
        int currentFruit = 0;
        int result = 0;
        while(right < fruits.length){
            currentFruit = fruits[right];
            if(currentFruit == firstFruit) lastIndexFirstFruit = right;
            else if(currentFruit == secondFruit) lastIndexSecondFruit = right;
            else if(firstFruit == -1){
                firstFruit = currentFruit;
                lastIndexFirstFruit = right;
            } else if(secondFruit == -1){
                secondFruit = currentFruit;
                lastIndexSecondFruit = right;
            } else {
                if(lastIndexFirstFruit < lastIndexSecondFruit){
                    firstFruit = currentFruit;
                    left = lastIndexFirstFruit + 1;
                    lastIndexFirstFruit = right;
                } else {
                    secondFruit = currentFruit;
                    left = lastIndexSecondFruit + 1;
                    lastIndexSecondFruit = right;
                }
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArraySumGFG(new int[] {8819, 674, 8816, 7705, 5699, 5383, 6177, 2113, 1992}, 1));
        System.out.println(firstNegInt(new int[] {-8, 2, 3, -6, 10}, 2));
        System.out.println(smallestSubWithSum(51, new int[] {1, 4, 45, 6, 0, 19}));
        System.out.println(totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
    }
}
