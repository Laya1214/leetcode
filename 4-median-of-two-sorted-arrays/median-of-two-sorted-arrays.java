class Solution {
    public static int[] merged(int[] arr1, int[] arr2){
        int n=arr1.length,m=arr2.length;
        int[] mergedarray=new int[n+m];
        int i=0,j=0,k=0;
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                mergedarray[k]=arr1[i];
                i++;
                k++;
            }
            else{
                mergedarray[k]=arr2[j];
                j++;
                k++;
            }
        }
        while(i<n){
            mergedarray[k]=arr1[i];
            i++;
            k++;
        }
        while(j<m){
            mergedarray[k]=arr2[j];
            j++;
            k++;
        }
        return mergedarray;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] merge=merged(nums1,nums2);
        int l=merge.length;
       
        
        if(l%2==0){
            return (merge[l/2-1]+merge[l/2])/2.0;
        }
        else{
            return (merge[l/2]);
        }
    }
}