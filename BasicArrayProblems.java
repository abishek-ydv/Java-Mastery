import java.util.Arrays;
public class BasicArrayProblems{

    public int sumArray(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    public double meanArray(int[] arr){
        int sum = sumArray(arr);
        return sum/arr.length;
    }

    public int largestElementBF(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largest) largest = arr[i];
        }
        return largest;
    }

    public int largestElementSortedArr(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    public int[] reverseArray(int[] arr){
        for(int i = 0; i < arr.length/2; i++){
            if(i == arr.length-1-i){
                continue;
            } else {
                arr[i] = arr[i] ^ arr[arr.length-1-i];
                arr[arr.length-1-i] = arr[i] ^ arr[arr.length-1-i];
                arr[i] = arr[i] ^ arr[arr.length-1-i];
            }
        }
        return arr;
        //we can also use while loop but in that condition will change. in that we have to take to variable and have to check condition when second index is not larger than the first one or viceversa.
    }

    /* Removing Duplicate Elements.
    Ways : 
    1. Create a new array of same length as original and copy unique elements in new array. (It will take extra space.)
    2. Can Use hashmap & hashset (set always has unique value).
    3. Can Use ArrayList for dynamic sizing.
    4. we can use two pointers (two cases : 1st - Sorted 2nd - not sorted) in which we will search with one pointer for unique elements other to point at last unique element more efficient when array is sorted. 

    As of now we will focus on 1st and 4th way we will do 3 & 4 when we will learn arraylist, hashset and hashmap.
    */
    // Using 3 array 1. Orignal, 2. To Hold Unique 3. To Return Only Unique of Unique Size.
    public int[] uniqueArrayBF (int[] arr){
        int[] unique = new int[arr.length];
        int uniquePointer = 0;
        for(int i = 0; i < arr.length; i++){
            // System.out.println(uniquePointer);
            // System.out.println(String.format("%d loop", i));
            int count = 0;
            for(int j = 0; j < uniquePointer; j++){
                // System.out.println(Arrays.toString(unique));
                if(unique[j] == arr[i]){
                    count++;
                }
            }
            if(count == 0){ 
                unique[uniquePointer] = arr[i];
                uniquePointer++;
            }
        }
        int[] returnArray = new int[uniquePointer];
        System.arraycopy(unique, 0,returnArray, 0, uniquePointer );
        return returnArray;
    }

    //Using a single array.
    public int[] uniqueArrayBF2 (int[] arr){
        int uniquePointer = 0;
        for(int i = 0; i < arr.length; i++){
            // System.out.println(String.format("%d loop", i));
            int count = 0;
            for(int j = 0; j < uniquePointer; j++){
                // System.out.println(Arrays.toString(arr));
                if(arr[j] == arr[i]){
                    count++;
                }
            }
            if(count == 0){ 
                arr[uniquePointer] = arr[i];
                uniquePointer++;
            }
        }
        // int[] returnArray = new int[uniquePointer];
        // System.arraycopy(arr, 0,returnArray, 0, uniquePointer );
        if(uniquePointer != arr.length) arr[uniquePointer] = -1;
        return arr;
    }

    /* Why unique pointer is working fine without giving error on both the cases 1. for creating new array with uniquePointerSize 2. for marking -1 at the end of sorted array.
    1st Case: so it's running for 11 iterations. 0->10, 11th iteration it not used but it's updated. ; but since
    no of elements unique == uniquePointer it worked fine.
    2nd Case: so it's running fine, uniquePointer used for marking but it will cause issue when arr.length == uniquePointer so only update when it's not equal. */

    /* When Array is Sorted. */
    public int[] sortedUniqueArray (int[] arr){
        Arrays.sort(arr);
        int uniquePointer = 1;
        for(int i = 1; i< arr.length; i++){
            if(arr[i] != arr[i-1]){
                arr[uniquePointer] = arr[i];
                uniquePointer++;
            }
        }
        if(uniquePointer != arr.length){
            arr[uniquePointer] = -1;
        }
        return arr;
    }

    public boolean isSorted(int[] arr){
        boolean isSorted = true;
        for(int i = 0; i < arr.length - 1; i++){
            if(!(arr[i] <= arr[i+1])) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }

    /* BINARY QUESTIONS (0-1) */
    /* Maximum count of consecutive 1's */
    public int maxOneCount(int[] arr){
        int maxCount = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1) {
                count++;
                if(maxCount < count) maxCount = count;
            } else count = 0;
        }
        return maxCount;
    }
    
    /* Maximum count of consecutive bits */
    public int maxBitCount(int[] arr){
        int maxCount = 1;
        int count = 1;
        if(arr.length == 0) return 0;
        for(int i = 0; i < arr.length-1; i++){
            // System.out.println(String.format("%d loop", i));
            if(arr[i] == arr[i+1]) {
                count++;
                if(maxCount < count) maxCount = count;
            } else count = 1;
            // System.out.println(String.format("maxCount %d | count %d | curr ele %d", maxCount, count, arr[i]));
        }
        return maxCount;
    }

    public int secondLargest(int[] arr){
        System.out.println(Arrays.toString(arr));
        int secondLar = Integer.MIN_VALUE;
        int firstLar = arr[0];
        for(int i = 1; i < arr.length; i++){
            System.out.println(String.format("first : %d | second : %d | current : %d", firstLar, secondLar, arr[i]));
            if(arr[i] > firstLar){
                secondLar = firstLar;
                firstLar = arr[i];
            } else if(arr[i] > secondLar && arr[i] < firstLar){
                secondLar = arr[i];
            }
        }
        return secondLar;
    }
    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] jumbledArray = {1,0,5,2,3,3,6,9,8,2,1,2,5,7,4,4,4};
        BasicArrayProblems sa = new BasicArrayProblems();
        System.out.println(sa.sumArray(arr));
        System.out.println(sa.meanArray(arr));
        System.out.println(sa.largestElementBF(arr));
        System.out.println(sa.largestElementSortedArr(arr));
        System.out.println(Arrays.toString(sa.reverseArray(arr)));
        System.out.println(Arrays.toString(sa.reverseArray(arr)));
        System.out.println(Arrays.toString(sa.uniqueArrayBF(jumbledArray)));
        System.out.println(Arrays.toString(sa.uniqueArrayBF2(jumbledArray)));
        System.out.println(Arrays.toString(sa.sortedUniqueArray(jumbledArray)));

        int[] sorted = {1,2,3,4,4,5};
        System.out.println(sa.isSorted(sorted));

        int[] binArr = {1,0,1,1,1,0,0,1,1};
        System.out.println(sa.maxOneCount(binArr));
        
        int[] binArr2 = {1,0,1,1,1,0,0,0,0,1,1};
        System.out.println(sa.maxBitCount(binArr2));

        System.out.println(sa.secondLargest(arr));
    }
}

/* That's it for basic array problems so far so good. STAY FOCUSED, INCREASE SPEED, THINK CLEARLY BUILD CLEAR LOGICS.
VERY IMPORTANT NOTE : focus on edge cases & take care of edge cases even on normal questions. 
*/