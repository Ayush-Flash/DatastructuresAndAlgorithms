package KthSmallestElement;
import java.util.Scanner;

/**
 * Main
 */


public class Main {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[l], i = l - 1, j = h + 1;
        while(true) {
            do {
                i++;
            } while(arr[i] < pivot);
            do {
                j--;
            } while(arr[j] > pivot);
            if(i >= j) return j;
            swap(arr, i, j);
        }
    }
    public static int findKthSmallestElement(int[] arr, int n, int k, int l, int h) {
        while(l <= h) {
            int p = partition(arr, l, h);
            if(p == k - 1) {
                return arr[p];
            } else if(p > k - 1) {
                h = p;
            } else if(p < k - 1) {
                l = p + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n]; 
            for(int i = 0 ; i < n ; i++)
                arr[i] = sc.nextInt();
            int k = sc.nextInt();
            int ans = findKthSmallestElement(arr, n, k, 0, n - 1);
            System.out.println(ans);
        }
    }
}