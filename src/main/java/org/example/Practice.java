package org.example;

import java.util.Arrays;

public class Practice {
    public static int rob(int[] nums) {
        int res = 0;
        int n = nums.length;
        int maxRes= 0;
        for(int i= 0; i<n ; i++){
            res=0;
            for(int j= i+2; j<n ;j += 2){
                if(j-i==2) {
                    res = nums[i] + nums[j];
                }
                else
                    res += nums[j];
                maxRes= Math.max(maxRes, res);
            }
        }
        return maxRes;
    }
}
