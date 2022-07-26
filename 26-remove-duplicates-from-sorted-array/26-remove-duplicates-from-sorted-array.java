class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 1;
        int k = 1;
        k = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == k){
                continue;
            }
            k = nums[i];
            nums[l] = k;
            l++;
        }
        return l;
    }
}