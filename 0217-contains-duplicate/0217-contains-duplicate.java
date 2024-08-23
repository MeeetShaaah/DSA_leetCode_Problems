class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int i : nums)
        {
            if(!unique.add(i))
            return true;
        }
        return false;
    }
}