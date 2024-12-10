// Approch - 2, 

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >=0; i--){
            sb.append(words[i]);
            if (i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

//Approc - 1, This is my approch, TC and SC - O(n); but not the optimal one;
// class Solution {
//     public String reverseWords(String s) {

//         String reversed = new StringBuilder(s).reverse().toString();

//         char[] ch = reversed.trim().toCharArray();
//         StringBuilder sb = new StringBuilder();

//         Stack<Character> chStack = new Stack<>();

//         for (int i = 0; i < ch.length; i++){
//             if (ch[i] != ' '){
//                 chStack.push(ch[i]);
//             }else if(!chStack.isEmpty()){
//                 while (!chStack.isEmpty()){
//                     sb.append(chStack.pop());
//                 }
//                 sb.append(" ");
//             }
//         }

//         while(!chStack.isEmpty()){
//             sb.append(chStack.pop());
//         }
//         return sb.toString();
//     }
// }