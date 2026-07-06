class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums); // [-4,-1,-1,0,1,2]

        int n = nums.length;

        for (int i = 0; i < n ; i++) {
            Set<Integer> hashSet = new HashSet<>();

            for(int j = i+1; j < n; j++){
                int third = -(nums[i] + nums[j]);

                if(hashSet.contains(third)){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(list);
                    set.add(list);
                }
                hashSet.add(nums[j]);
            }
        }

        return new ArrayList<>(set);
    }
}