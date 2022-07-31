class Solution {
    public boolean isPalindrome(int x) {
        int res = 0;
        int dup = x;
        while(x > 0){
            //int digit = x % 10;
            res = (res * 10) + x % 10;
            x = x / 10;
        }
        if(dup == res)
            return true;
        return false;
    }
}