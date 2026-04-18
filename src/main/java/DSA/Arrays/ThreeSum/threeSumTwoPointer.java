package DSA.Arrays.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumTwoPointer {
    public static List<List<Integer>> threeSum(int n, int[] arr) {
        List<List<Integer>> res =  new ArrayList<>();
       Arrays.sort(arr);

        for(int i = 0; i< arr.length; i++) {
            int j = 1;
            int k = arr.length-1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0)
                    j++;
                else if(sum > 0)
                    k--;
                else {
                    res.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return res;
    }
}
