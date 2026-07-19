class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
                bucket[entry.getValue()].add(entry.getKey());
            } else {
                bucket[entry.getValue()].add(entry.getKey());
            }
        }

        int[] top = new int[k];

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int value : bucket[i]) {
                    if (k > 0) {
                        top[k-1] = value;
                        k--;
                    }
                }
            }
        }

        return top;
    }
}