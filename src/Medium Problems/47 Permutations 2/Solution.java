class Solution {
    // TC-> O(n! * n) SC-> O(n! * n)
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        HashSet<List<Integer>> set=new HashSet<>();
        helper(nums,res,0,set);
        return res;
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void helper(int[] nums, List<List<Integer>> res, int idx, HashSet<List<Integer>> set){
        int n=nums.length;
        if(idx==n-1){
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<n;i++){
                ans.add(nums[i]);
            }
            if(!set.contains(ans)){
                res.add(ans);
                set.add(ans);
            }
            return;
        }
        for(int i=idx;i<n;i++){
            swap(nums,idx,i);
            helper(nums,res,idx+1,set);
            swap(nums,idx,i);
        }
    }
}