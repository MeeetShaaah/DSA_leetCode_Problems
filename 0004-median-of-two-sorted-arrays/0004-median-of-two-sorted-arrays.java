//Approach - 1(self), Basic Brute Force approach is simple, just run a normal while loop with 2 pointers, issue with this approach is that we are using extra space, so have to comeup with better approach.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                list.add(nums1[i]);
                i++;
            }else{
                list.add(nums2[j]);
                j++;
            }
        }

        while(i < nums1.length){
            list.add(nums1[i]);
            i++;
        }

        while(j < nums2.length){
            list.add(nums2[j]);
            j++;
        }

        int n = list.size();
        if(n % 2 == 1){
            return (double) list.get(n/2);
        }

        return ((double)list.get(n/2) + (double) list.get((n/2) - 1)) / 2.0;
    }
}
