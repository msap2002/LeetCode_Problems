class Solution {
    public boolean isHappy(int n) {
        int sum = n;
        while(sum != 1){
            int dup = sum;
            sum = 0;
            while(dup > 0){
                sum = sum + ((dup % 10) * (dup % 10));
                dup = dup/10;
            }
            if((sum/10) == 0 && sum != 1 && sum != 7)
                return false;
        }
        return true;
    }
}