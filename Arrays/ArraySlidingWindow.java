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
            windowSum += arr[i];
            if(i >= k) windowSum -= arr[i-k];
            if(i >= k-1) maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArraySumGFG(new int[] {8819, 674, 8816, 7705, 5699, 5383, 6177, 2113, 1992}, 1));
    }
}
