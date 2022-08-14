class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 0)
            return 0;
        int max = -1, min = -1, ans = -1;
        int i;
        for(i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                continue;
            }
            max = nums[i];
            min = nums[i];
            ans = nums[i];
            break;
        }
        int j;
        for(j = i + 1;j < nums.length;j++){
            int ans2 = max*nums[j];
            int ans3 = min*nums[j];
            max = Math.max(Math.max(ans2,ans3),nums[j]);
            min = Math.min(Math.min(ans2,ans3),nums[j]);
            ans = Math.max(ans,max);
        }
        return ans;
    }
}