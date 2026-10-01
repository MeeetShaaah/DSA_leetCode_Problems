class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(char ch : num.toCharArray()){
            while(k >0 && !stack.isEmpty() && stack.peek() > ch){
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuffer sb = new StringBuffer();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        sb.reverse();

        int i = 0;

        while(i < sb.length() && sb.charAt(i) == '0'){
            i++;
        }

        String result = sb.substring(i);

        return result.isEmpty() ? "0" : result;
    }
}