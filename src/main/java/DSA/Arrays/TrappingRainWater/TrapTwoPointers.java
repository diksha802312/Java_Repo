package DSA.Arrays.TrappingRainWater;

public class TrapTwoPointers {

    public static int trap(int arr[]){
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int res=0;
        int leftMax= 0;
        int rightMax= 0;

        while(l<=r){
            if(arr[l] <= arr[r]){
                if(leftMax<= arr[l]){
                    leftMax = arr[l];
                }else{
                    res += leftMax-arr[l];
                }
                l++;
            }else{
                if(rightMax <= arr[r]){
                    rightMax= arr[r];
                }
                else{
                    res += rightMax-arr[r];
                }
                r--;
            }
        }
        return res;
    }
}
