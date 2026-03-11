import java.util.Arrays;
public class ArraysMethods {
    /* In this we are gonna learn Arrays method in Java and we will also learn what is diff. between shallow copy and deep copy. */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        int[] refCopy = arr; // this will only create a reference of arr into refcopy. when we make any changes in refCopy array it will reflect in the original arr array. 

        /* Arrays.toString() Method : this methods turns a array into a string. which is easy to showcase output. so we don't have to iterate each elements manually. */
        System.out.println("printing refCopy Array "+Arrays.toString(refCopy));
        System.out.println("printing arr Array "+Arrays.toString(arr));

        /* making changes to refcopy array. */
        refCopy[0] = 999;
        System.out.println("refcopy value at index 0 after updating is "+refCopy[0]+". arr value at index 0 after updating is "+arr[0]); // both will be 999. 

        /* So this is an issue. what if we want to keep both the array independent ? to solve this issue we can use clone method. */     
        /* arr.clone() */
        int[] arr2 = arr.clone();
        /* this will create a deep copy for 1D array except for objects (String array is always a deep copy). updating elements in this array won't make any changes in original array.*/
        arr2[2] = 69;
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr));
        
        /* We can also perform this with System.arrayCopy() - Syntax System.arrayCopy(sourceArray, startPosition, destinationArray, startDestinationPosition, numberOfElementsToCopy) - this is fastest then all other methods. */
        System.arraycopy(arr2, 1, arr, 0, 5);
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr));


        String[] strArray = new String[5];
        strArray[0] = "first";
        strArray[1] = "second";
        strArray[2] = "third";
        strArray[3] = "forth";
        strArray[4] = "fifth";
        /* strArray[5] - this will return an error cause we are trying to assign value to the index which do not exist in the array. */
        /* Now, we will see Array.copyOf() method.*/
        String[] str2 = Arrays.copyOf(strArray, 2); // this will enter empty elements for indexes which are not present in it.
        System.out.println(Arrays.toString(str2));
        System.out.println(str2.length);
        String[] str3 = Arrays.copyOfRange(strArray, 3,6); // this will not return indexoutofbound  instead it will insert a null value in array. null because it's an string array.
        System.out.println(Arrays.toString(str3));
        System.out.println(str3.length);
        /* Basically copyOf and copyOfRange are basically using System.arraycopy under the hood. but it is slower than that cause first it will create an array based on the length provided. and then it will copy using same System.arraycopy() method. clone also uses it but it don't create an array so that's why it's faster than copyOf and copyOfRange cause it copy entier array and not to from a particular index. */

        /* The shallow issue and the deep solution. : We have seen multiple ways to copy array so for and everthing looks fine from the top. everything is working with no issue. but as we move inside and discover n-D array things get complicated. These methods fail to create deep copy of of multi-dimensional array. They create reference to the original array. and changing values in copied array will reflect on original array. So now the question is what's the solution? How can we create deep copy on n-D arrays. And the Answer is Manual method or Custom methods. We have to manually copy each elemnts of old/Original array to new/Copied Array. */

        /* THE MANUAL METHOD */
        int[][] arr2d = {{1,2},{6,9}};
        int[][] arr2d2 = new int[2][2];
        for(int i = 0; i < arr2d.length; i++){
            for(int j = 0; j < arr2d[i].length; j++){
                arr2d2[i][j] = arr2d[i][j];
            }
        }

        /* To print n-D array as sting we can't use regular toString method. instead we have to use deepToString method. */

        System.out.println("Copy Array " + Arrays.deepToString(arr2d2));
        System.out.println("Original Array " + Arrays.deepToString(arr2d));

        /* let's check if these array are equal or not. means if they have exact length and exact elements in order or not. for that we will use equals() method. and nor n-D arrays we will use deepEquals() method. it will return boolean value. it will return true if values are equal and return and will return false if values are not equal */

        System.out.println(Arrays.deepEquals(arr2d, arr2d2));
        System.out.println(Arrays.equals(arr, arr2));
        System.out.println(Arrays.equals(arr2d, arr2d2)); // Why false? Even though the numbers are the same, arr1[0] and arr2[0] are two different array objects living at different addresses. because in this it is not checking values of these arrays but addresses cause it havn't reached at the bottom of the array it's just checking at the top of the array. 

        /* SOME OTHER METHODS. */

        int[] numArr = {3,5,4,7,9,1,8,2,6};

        /* Using sort() method we can sort the array. It uses quick sort with two pivot. it's a void method me don't need to explicitly save it in a variable as it's store in original array itself. and it do not works on n-D arrays.*/

        Arrays.sort(numArr);
        System.out.println(Arrays.toString(numArr));

        /* Now suppose you wan't to search and find the index of an element. so for that purpose you can use binarySearch() method this method only works on sorted array.  this method will return the index of the element. if there are multiple same elements as key elements then the output is unpredictable it will return any index of that element which ever came first. this will not work for n-D arrays.*/

        System.out.println(Arrays.binarySearch(numArr, 5));

        /* The ultimate Fill method. : so this method is used to fill an array with the a single element. it do not work on n-D array. */

        Arrays.fill(numArr, 07);
        System.out.println(Arrays.toString(numArr)); // all values updated to 7.

        /* Arrays.fill(arr2d, 07); this will not work.
        System.out.println(Arrays.deepToString(arr2d));  all values updated to 7. */

        /* so that's all for today one more mehtod left Arrays.toList() method which is use to convert standard array to array list but we will study it later when we will study arraylist. now we will solve dsa questions and we will learn some techniques like sliding windows, two pointers, etc. */
    }
}