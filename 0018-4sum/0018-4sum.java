class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // [-2,-1,0,0,1,2]

        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                long sum = 0;

                while(left < right){
                    sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];

                    if(sum == target){
                        set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left-1]){
                            left++;
                        }

                        while(left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return new ArrayList(set);
    }
}