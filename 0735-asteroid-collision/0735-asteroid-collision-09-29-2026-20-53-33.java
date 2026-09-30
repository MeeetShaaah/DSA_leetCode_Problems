class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int current : asteroids){
            boolean alive = true;

            while(!stack.isEmpty() && current < 0 && stack.peek() > 0){
                if(-current > stack.peek()){
                    stack.pop();
                }else if(-current == stack.peek()){
                    stack.pop();
                    alive = false;
                    break;
                }else{
                    alive = false;
                    break;
                }
            }

            if(alive){
                stack.push(current);
            }
        }

        int[] ans = new int[stack.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = stack.get(i);
        }

        return ans;
    }
}