import java.util.Arrays;

public class ArrayProblems {

    public static boolean arraySubset(int[] arr, int[] key){
        boolean isSubset = true;
        for(int i = 0; i < key.length; i++){
            int count = 0;
            for(int j = 0; j < arr.length; j++){
                if(key[i] == arr[j]){
                    count++;
                    break;
                }
            }
            if(count == 0) return false;
        }
        return isSubset;
    }

    /* The Sorted Way */
    public static boolean arraySubsetSorted (int[] arr, int[] key){
        boolean isSorted = true;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(key);
        System.out.println(Arrays.toString(key));
        
        int i = 0;
        int j = 0; 

        while(i < arr.length && j < key.length){
            System.out.println(String.format("i %d | j %d | arr[i] %d | key[j] %d ", i, j, arr[i], key[j]));
            if(key[j] == arr[i]){
                i++;
                j++;
                continue;
            } else if(key[j] < arr[i]) return false;
            else i++;
        }

        return isSorted;
    }
    
    public static int[] rotateArray (int[] arr, int d){
        int rotate = d%arr.length;
        while(rotate > 0){
            // int pointer = arr[0];
            int i = 0;
            // while(arr[arr.length-1] != pointer){
            while(i < arr.length-1){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                i++;
            }
            rotate--;
        }
        return arr;
    }

    public static int[] rotateArrayFor (int[] arr, int d){
        for(int i = 0; i < d; i++){
            for(int j = 0; j < arr.length -1 ; j++){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        return arr;
    }

    public static int[] reverseArray(int[] arr, int start, int end){
        for(int i = start; i <= (start+end)/2 ; i++){
            int temp = arr[i];
            arr[i] = arr[start+end-i];
            arr[start+end-i] = temp;
        }
        return arr;
    }
    
    /* Then O(n) way need reverse array for that.*/
    public static int[] reverseRotate (int[] arr, int n){
        n = n%arr.length;
        System.out.println(Arrays.toString(arr));
        reverseArray(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
        reverseArray(arr, n, arr.length-1);
        System.out.println(Arrays.toString(arr));
        reverseArray(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    /* Prefix sum of Array : sum of subArray from index 0 to given index. */
    public static int prefixSumArray(int[] arr, int n){
        int sum = 0;
        for(int i = 0; i <= n; i++){
            sum += arr[i];
        }
        return sum;
    }

    public static boolean equalSumGFG (int[] arr){
        int arrLength = arr.length;
        boolean isEqualSum = false;
        int[] sumArray = new int[arrLength];
        for(int i = 0; i < arr.length; i++){
            if(i==0) sumArray[0] = arr[0];
            else{
                sumArray[i] = sumArray[i-1] + arr[i];
            }
        }
        for(int i = 0; i < arrLength; i++){
            if(i == 0 || i == arrLength - 1) continue;
            else if(sumArray[i-1] == sumArray[arrLength-1] - sumArray[i]){
                return true;
            }
        }
        return isEqualSum;
    }

    public int maxProfitGFG(int[] prices) {
        int maxProfit = 0;
        int minBuyPrice = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minBuyPrice) minBuyPrice = prices[i]; //No need to worky of deals cause minBuyPrices will make sure only better deals ahead. previous numbers have no impact.
            if(maxProfit < (prices[i] - minBuyPrice)) maxProfit = prices[i] - minBuyPrice;
        }
        return maxProfit;
    }

    public int maxProfitGFG2(int[] prices) {
        int maxProfit = 0;
        int buyPrice = 0;
        int sellPrice = 0;
        for(int i = 0; i < prices.length; i++){
            buyPrice = prices[i];
            for(int j = i+1; j < prices.length; j++){
                sellPrice = prices[j];
                if(sellPrice > buyPrice){
                    int profit = sellPrice - buyPrice;
                    if(profit > maxProfit) maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static int[][] sumOfSquareMatrix(int[][] squareMatrixOne, int[][] squareMatrixTwo){
        int[][] sum = new int[squareMatrixOne.length][squareMatrixOne[0].length];
        for(int i = 0; i < squareMatrixOne.length; i++){
            for(int j = 0; j < squareMatrixOne[0].length; j++){
                sum[i][j] = squareMatrixOne[i][j] + squareMatrixTwo[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // System.out.println(arraySubset(new int[]{1,2,3,4,5,6}, new int[]{1,2,4,69,3}));
        // System.out.println(arraySubsetSorted(new int[]{1,2,3,4 ,5,6,7,8}, new int[]{1,2,4,3}));
        // System.out.println(Arrays.toString(rotateArray(new int[] {1,2,3,4,5}, 2))); 

        /* For counter clockwise : ((i+k)%n) | For clockwise : (i+(n-k))%n */        

        // System.out.println(Arrays.toString(rotateArrayFor(new int[] {1,2,3,4,5}, 2))); 
        // System.out.println(Arrays.toString(reverseRotate(new int[] {1,2,3,4,5}, 2))); 

        // int[] arr = {1,2,3,4,5};
        /* int start = 1;
        int end = 4;
        for(int i = start; i <= (start+end)/2 ; i++){
            int temp = arr[i];
            arr[i] = arr[start+end-i];
            arr[start+end-i] = temp;
        }
        System.out.println(Arrays.toString(arr)); */

        // System.out.println(prefixSumArray(arr, 4));

        // System.out.println(equalSumGFG(new int[] {1,2,1,2}));

        System.out.println(Arrays.deepToString(sumOfSquareMatrix(new int[][]{{1,2},{3,4}}, new int[][]{{4,3},{2,1}})));
    }
}
