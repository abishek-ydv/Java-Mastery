import java.util.Scanner;
public class Arrays{

    // main method.
    public static void main(String[] args){
        /* So today we are gonna learn Arrays in Java. so we are gonna learn ho to declare, initialize, dynamic initialization, assigning values, traversal, .length property, type of arrays etc. */
        
        // declaration of an array : datatype[] array_name or datatype array_name[] both works but mostly we use first one. 
        char[] characters; //just creating refernce no memory allocation.
        int num[]; // we just declared it. we haven't initialized it yet. initialization is assigning a initial value to it. currently it is empty. so we can initialize it by using new word. and assigning it a size. cause default array value is 0 so alloting it size will also initialize it.
        num = new int[1];
        int[] num2 = {1,2,3,4,5}; //static initialization in this we are declaring and ititialization at the same time. the size of the is 5. 
         
        //now initialization. 
        characters = new char[5];
        System.out.println(characters[0]); // this will return null character which is default value cause we have just assigned size to it not the elements. default values of int array is 0. similary String => null, boolean => false, float => 0.0, char => \\u0000 which is a null characters.

        // now changing/updating values in arrays
        num[0] = 4;
        System.out.println(num.length + " length of array");
        System.out.println(num[0] +" accessing element at 0 index."); //accessing element inside array. 

        // traversal using for loop
        for(int i = 0; i<num2.length; i++){
            System.out.println(num2[i]);
        }
        // traversal using for-each loop
        for(int ele : num2){
            System.out.println(ele);
        }

        // 2D Array: 
        /* int[][] twodarray = new int[2][2]; */

        // taking input from user
        Scanner sc = new Scanner(System.in);
        /* for(int i=0; i<twodarray.length; i++){
            for(int j=0; j<twodarray[i].length; j++){
                twodarray[i][j] = sc.nextInt();
            }
        } */

        //priniting twodarray;
        /* System.out.println("printing ele");
        for(int[] row : twodarray){
            for(int ele : row) {
                System.out.println(ele);
            }
        } */
        
        // similarly we can create 3d array and also multi-dimensional array. also we can create jagged arrays means the row inside multi-dimensional array can be of different length and different no of elements.
        
        /* System.out.println("input no of row in jagged array");
        int jrow = sc.nextInt();
        int [][] jagged = new int[jrow][];
        System.out.println("input length of rows in jagged array");
        for(int i = 0; i< jagged.length; i++){
            jagged[i] = new int[sc.nextInt()];
        }
        
        System.out.println("length of row");
        for(int i = 0; i< jagged.length; i++){
            System.out.println(jagged[i].length);;
        }
        
        System.out.println("input element");
        for(int i = 0; i < jagged.length; i++){
            for(int j = 0; j < jagged[i].length; j++) {
                jagged[i][j] = sc.nextInt();
            }
        }

        System.out.println("printing values");
        for(int[] row : jagged){
            System.out.println();
            for(int ele : row) {
                System.out.println(ele);
            }
        } */
        sc.close();
    }
}