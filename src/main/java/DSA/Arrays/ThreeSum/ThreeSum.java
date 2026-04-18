package DSA.Arrays.ThreeSum;


//question: 3Sum : Find triplets that add up to a zero
//
//Problem Statement: Given an array of N integers, your task is to find unique triplets that
//add up to give a sum of zero. In short, you need to return an array of
//all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i,
//and their sum is equal to zero.
//
//Example 1:
//Input: nums = [-1,0,1,2,-1,-4]
//
//Output: [[-1,-1,2],[-1,0,1]]

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int n, int[] arr) {
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(arr[i] + arr[j]);

                if (hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashSet.add(arr[j]);
            }
        }
        return new ArrayList<>(st);
    }
        }


