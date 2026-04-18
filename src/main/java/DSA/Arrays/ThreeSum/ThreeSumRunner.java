package DSA.Arrays.ThreeSum;

import java.util.List;

public class ThreeSumRunner {
    public static void main(String [] args){
   // int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    int[] arr = {-1,0,1,2,-1,-4};
    int n = arr.length;
    List<List<Integer>> res =  ThreeSum.threeSum(n, arr);
    for(List<Integer> list : res){
        System.out.println(list);
    }
    }
}
