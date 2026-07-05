class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int min = n/3 + 1;
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.get(num) == min){
                list.add(num);
            }
        }
        return list;
    }
}