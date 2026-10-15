class Solution {
    public void reverseString(char[] s) {
        reverse(0, s.length - 1, s);
    }

    private void reverse(int l, int r, char[] ch){
       
        if(l >= r){
            return;
        }

        char temp = ch[l];
        ch[l] = ch[r];
        ch[r] = temp;

        reverse(l + 1, r - 1, ch);
    }
}