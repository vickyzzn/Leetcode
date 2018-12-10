package leetcodeSolution;

public class quickselect {
    public int quickselect(int[] n, int k) {
        if (n == null || n.length == 0) return 0;
        int a;
        a = quickselect(n, 0, n.length - 1, n.length - k + 1);
        return a;
    }

    public int quickselect(int[] n, int low, int high, int k) {
        if (n == null || n.length == 0) return 0;
        int i = low;
        int j = high;
        int p = n[low];
        while(i < j){
            while(i < j && n[j] >= p) j--;
            if(i < j) n[i++] = n[j];
            while(i < j && n[i] < p) i++;
            if(i < j) n[j--] = n[i];
        }
        n[i] = p;
        if(i == k - 1) return n[i];
        else if(i < k - 1) return quickselect(n, i + 1, high, k);
        else if( i > k - 1) return quickselect(n, low, i - 1, k);
        return 0;
    }

    public static void main(String[] args) {
        int[] n = {2,1,3,5};
        quickselect a = new quickselect();
        System.out.println(a.quickselect(n, 1));
    }
}
