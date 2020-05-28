class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null && nums2==null)
            return 0;
        if(nums1==null || nums1.length==0)
            return findMedian(nums2);
        if(nums2==null || nums2.length==0)
            return findMedian(nums1);
        //both are not empty
        //we will merge these two sorted arrays
        int[] merged = merge(nums1,nums2);
        return findMedian(merged);
    }
    
    public double findMedian(int[] arr) {
        if(arr==null || arr.length==0)
            return 0;
        int size=arr.length;
        if(size%2==0) {
            //no of elements are even
            int mid=size/2;
            double sum=arr[mid]+arr[mid-1];
            return sum/2;
        }
        else {
            //no of elements are odd
            int mid=size/2;
            return arr[mid];
        }
    }
    
    public int[] merge(int[] nums1,int[] nums2) {
        int[] result=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i]<nums2[j]) {
                result[k++]=nums1[i++];
            }
            else {
                result[k++]=nums2[j++];
            }
        }
        while(i<nums1.length) {
            result[k++]=nums1[i++];
        }
        while(j<nums2.length) {
            result[k++]=nums2[j++];
        }
        return result;
    }
}
