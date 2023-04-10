import java.io.*;

public class Algorithm3Sol {

    public static int binarySearch(int key, int[] arr, int l, int r){
        if( r >= l && l <= arr.length -1){
            int mid = l + (r-l) / 2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] > key){
                return binarySearch(key, arr, l, mid-1);
            }
            return binarySearch(key, arr,mid+1, r);
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 8, 4, 6};
        long start = System.currentTimeMillis();
        System.out.println(binarySearch(2,arr, 0, arr.length -1));
        long end = System.currentTimeMillis();
        System.out.println("Time is " +  (end - start) + "ms" );
    }
}
