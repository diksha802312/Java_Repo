package DSA.BinarySearch;

public class MedianOfTwoSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int indx1 = n/2;
        int indx2 = n/2-1;
        int elem1 = 0;
        int elem2 = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        double res = 0.0;
        while(i<n1 && j<n2){
            if(nums1[i]< nums2[j]){
                if(count == indx1) elem1 = nums1[i];
                if(count == indx2) elem2 = nums1[i];
                count++;
                i++;
            }
            else{
                if(count == indx1) elem1 = nums2[j];
                if(count == indx2) elem2 = nums2[j];
                count++;
                j++;
            }
        }

        while(i<n1){
            if(count == indx1) elem1 = nums1[i];
            if(count == indx2) elem2 = nums1[i];
            count++;
            i++;
        }

        while(j<n2){
            if(count == indx1) elem1 = nums2[j];
            if(count == indx2) elem2 = nums2[j];
            count++;
            j++;
        }
        System.out.println("elem1 " + elem1 + " " + "elem2 " + elem2);
        if(n%2 == 0){
            res = (double)(elem1+elem2)/2;
        }else{
            res = elem1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
