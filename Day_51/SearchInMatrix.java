//Problem Statement: https://leetcode.com/problems/search-a-2d-matrix/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int[] index=new int[matrix.length];
        for(int i=0;i<matrix.length;i++) {
            index[i]=matrix[i][0];
        }
        int rowIndex=getIndex(index,target);
        if(rowIndex==-1)
            return false;
        return binarySearch(matrix[rowIndex],target);
    }
    
    public int getIndex(int[] arr,int target) {
        if(arr==null || arr.length==0)
            return -1;
        int left=0,right=arr.length-1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(arr[mid]==target)
                return mid;
            else if(target>arr[mid])
                left=mid+1;
            else
                right=mid-1;
        }
        if(left==0)
            return -1;
        return left-1;
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
