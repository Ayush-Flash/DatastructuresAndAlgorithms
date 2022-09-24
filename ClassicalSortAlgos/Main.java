package ClassicalSortAlgos;
import java.util.*;
public class Main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void bubbleSort(int[] arr, int n) {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n - i - 1 ; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    public static void selectionSort(int[] arr, int n) {
        for(int i = 0 ; i < n ; i++) {
            int key = arr[i], min = i;
            for(int j = i + 1 ; j < n ; j++) {
                if(arr[j] < key) {
                    min = j;
                    key = arr[j];
                }
            }
            swap(arr, i, min);
        }
    }
    public static void insertionSort(int[] arr, int n) {
        for(int i = 1 ; i < n ; i++) {
            int j = i - 1, key = arr[i];
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static int lomutoPartition(int[] arr, int l, int h) {
        int pivot = arr[h], minEleIndex = l - 1;
        for(int i = l ; i < h ; i++) {
            if(arr[i] < pivot) {
                minEleIndex++;
                swap(arr, i, minEleIndex);
            }
        }
        arr[minEleIndex + 1] = pivot;
        return minEleIndex + 1;
    }
    public static int hoarsePartition(int[] arr, int l, int h) {
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

    public static void quickSort(int[] arr, int l, int h) {
        if(l < h) {
            int partition = hoarsePartition(arr, l, h);
            quickSort(arr, l, partition);
            quickSort(arr, partition + 1, h);
        }
    }
    public static void merge(int[] arr, int l, int h, int mid) {
        int n1 = mid - l + 1;
        int n2 = h - mid;
        int[] leftarr = new int[n1];
        int[] rightarr = new int[n2];
        for(int i = 0 ; i < n1 ; i++) {
            leftarr[i] = arr[l + i];
        }
        for(int j = 0 ; j < n2 ; j++) {
            rightarr[j] = arr[mid + j + 1];
        }
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if(leftarr[i] < rightarr[j]) {
                arr[k++] = leftarr[i++];
            } 
            if(rightarr[j] < leftarr[i]) {
                arr[k++] = rightarr[j++];
            }
        }
        while(i < n1) {
            arr[k++] = leftarr[i++];
        }
        while(j < n2) {
            arr[k++] = rightarr[j++];
        }
    }
    public static void mergeSort(int[] arr, int l, int h) {
        if(l < h) {
            int mid = l + (h - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, h);
            merge(arr, l, h, mid);
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++)
                arr[i] = sc.nextInt();
            //bubbleSort(arr, n);
            //selectionSort(arr, n);
            //insertionSort(arr, n);
            //quickSort(arr, 0, n - 1);
            mergeSort(arr, 0, n - 1);
            System.out.println(Arrays.toString(arr));
        }
    }
}