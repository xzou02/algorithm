// largest difference between any a[i] and a[j] where i < j && a[i] < a[j]
// if no such number exists return -1

public class maximumdifference {
    static int maxdifference(int[] a) {
        int len = a.length;
        int max = Integer.MIN_VALUE;
        if (len == 1) return -1;
        else{
            int min = a[0];
            for (int i = 1; i < len; i++){
                if(a[i] < min){
                    min = a[i];
                }
                if(a[i] > min){
                    int diff = a[i] - min;
                    max = Math.max(diff,max);
                }
            }
        }
        if (max <= 0) return -1;
        return max;
    }


}
