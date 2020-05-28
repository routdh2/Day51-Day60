//Problem Statement: https://leetcode.com/problems/search-a-2d-matrix-ii/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        for(int i=0;i<matrix.length;i++) {
            if(binarySearch(matrix[i],target))
                return true;
        }
        return false;
    }
    public boolean binarySearch(int[] arr,int target) {
        if(arr==null || arr.length==0)
            return false;
        int left=0,right=arr.length-1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(arr[mid]==target)
                return true;
            else if(target>arr[mid])
                left=mid+1;
            else
                right=mid-1;
        }
        return false;
    }
}
