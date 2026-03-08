public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int rotate = 99%arr.length;
        while(rotate > 0){
            int pointer = arr[0];
            int i = 0;
            while(arr[arr.length-1] != pointer){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                i++;
            }
            rotate--;
        }
        for(int i : arr){
            System.out.println(i);
        }
    }
}
