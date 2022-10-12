class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;
        int front[] = new int[n];
        int back[] = new int[n];
        for(int i = 0;i < n;i++){
            if(i != 0){
                front[i] = front[i - 1] + nums[i];
            }
            else{
                front[i] = nums[i];
            }
        }
        for(int i = n - 1;i >= 0;i--){
            if(i < n - 1){
                back[i] = back[i + 1] + nums[i];
            }
            else{
                back[i] = nums[i];
            }
        }
        for(int i = 0;i < n;i++){
            if(front[i] == back[i]){
                return i;
            }
        }
        return -1;
    }
}