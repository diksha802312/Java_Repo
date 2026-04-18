package DSA.Recursion.Subsequence;

import java.util.ArrayList;
import java.util.List;

//printing subsequences with sum k
public class Subsequence {
    public static void main(String[] args) {
        int[] arr = {1,1,1, 3, 2};
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        System.out.println(findSubsequencesWithSumK(0, 5, 3, ds, arr, sum, res));

    }

    public static int findSubsequencesWithSumK(int index, int n, int k, List<Integer> ds, int[] arr, int sum, List<List<Integer>> res) {
        if(index == n){
            if(sum == k){
                res.add(new ArrayList<>(ds));
                return res.size();
            }
            return res.size();
        }

        ds.add(arr[index]);
        findSubsequencesWithSumK(index+1, n, k, ds, arr, sum + arr[index], res);
//        if(res.size()>0){
//            return res;
//        }
        ds.remove(ds.size()-1);
        findSubsequencesWithSumK(index+1, n, k, ds, arr, sum, res);
        return res.size();
    }
}
