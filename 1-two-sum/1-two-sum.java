import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            int key = nums[i];
            if(map.containsKey(key)){
                int val = map.get(key);
                map.put(key,val + 1);
            }
            else
                map.put(key,1);
        }
        ArrayList<Integer>list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],map.get(nums[i]) - 1);
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) > 0){
                list.add(i);
            }
            map.put(nums[i],map.get(nums[i]) + 1);
        }
        int ans[] = new int[list.size()];
        for(int i = 0;i < ans.length;i++)
            ans[i] = list.get(i);
        return ans;
    }
}