class Solution {
	public int countSubstr(String s, int k) {
		//  code here
		return countK(s, k) - countK(s, k - 1);
	}
	
	public int countK(String s, int k) {
		int left = 0;
		int distinct = 0;
		int count = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for (int right = 0; right < s.length(); right++) {
			
			char ch = s.charAt(right);
			
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			
			if (map.get(ch) == 1) {
				distinct++;
			}
			
		    while(distinct > k){
			    char leftChar = s.charAt(left);
			    
			    map.put(leftChar, map.get(leftChar) - 1);
			    
			    if(map.get(leftChar) == 0){
			        map.remove(leftChar);
			        distinct--;
			    }
			    left++;
			}
			
			count += right - left + 1;
		}
		return count;
	}
}
