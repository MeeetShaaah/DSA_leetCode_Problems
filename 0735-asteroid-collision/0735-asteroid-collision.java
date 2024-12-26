class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids){
            boolean collision = false;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                if(Math.abs(asteroid) > Math.abs(stack.peek())){
                    stack.pop();
                    continue;
                }else if(Math.abs(asteroid) == Math.abs(stack.peek())){
                    stack.pop();
                }

                collision = true;
                break;
            }

            if(collision == false){
                stack.push(asteroid);
            }
        }
        
        int[] result = new int[stack.size()];
            for(int i = result.length -1; i >= 0; i-- ){
                result[i] = stack.pop();
            }
        return result;
    }
}