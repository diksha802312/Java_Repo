package DSA.Arrays.TrappingRainWater;

//Problem Statement: Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.
//
//Examples:
//
//Example 1:
//
//Input: height= [0,1,0,2,1,0,1,3,2,1,2,1]
//
//Output: 6
//
//Explanation: As seen from the diagram 1+1+2+1+1=6 unit of water can be trapped

public class TrappingRainWater {

    public static int trap(int arr[]){
        int n = arr.length;
        int lMax[] = new int[n];
        int rMax[] = new int[n];

        lMax[0] = arr[0];
        rMax[n-1] = arr[n-1];
        for(int i =1 ; i<=n-1 ; i++) {
            lMax[i] = Math.max(arr[i], lMax[i-1]);
        }

        for(int j = n-2 ; j>=0 ; j--){
            rMax[j] = Math.max(arr[j] , rMax[j+1]);
        }

        int res = 0;
        for(int i = 1 ; i<n-1 ; i++){
            res += Math.min(lMax[i], rMax[i]) - arr[i];
        }

        return res;
    }
}
