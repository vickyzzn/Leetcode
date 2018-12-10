package leetcodeSolution;

import java.util.Arrays;

public class quicksort {
    public int[] quicksort(int[] n){
        if(n == null || n.length == 0) return null;
        quicksort(n, 0, n.length - 1);
        return n;
    }
    public void quicksort(int[] n, int low, int high){
        if(n == null || n.length == 0) return;
        if(low < high){
            int pivot = partition(n, low, high);
            quicksort(n, low, pivot - 1);
            quicksort(n, pivot + 1, high);
        }
    }
    public int partition(int[] n, int low, int high){
        int start = n[low];
        while(low < high){
                while(n[high] >= start && low < high) high--;
                if(low < high){
                    n[low++] = n[high];
                }
                while(n[low] < start && low < high) low++;
                if(low < high){
                    n[high--] = n[low];
                }
            }
            n[low] = start;
            return low;
        }


    public static void main(String[] args) {
        quicksort a = new quicksort();
        int[] n = {1,4,7,3,2,8};
        a.quicksort(n);
        System.out.println(Arrays.toString(n));
    }

}

