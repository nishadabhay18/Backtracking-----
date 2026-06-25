class Solution {
    // M-1 TC-> O(2n×n) SC-> O(2n×n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> answer=new ArrayList<>();
        HashSet<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
        helper(nums,result,answer,0,set);
        return result;
    }
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> answer, int idx, HashSet<List<Integer>> set){
        if(idx==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<answer.size();i++) list.add(answer.get(i));
            if(!set.contains(list)){
                set.add(list);
                result.add(list);
            }
            return;
        }
        answer.add(nums[idx]);
        helper(nums,result,answer,idx+1,set);
        answer.remove(answer.size()-1);
        helper(nums,result,answer,idx+1,set);
    }

    // M-2 TC-> O(2n) SC-> O(2n×n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> answer=new ArrayList<>();
        helper(nums,result,answer,0);
        return result;
    }
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> answer, int idx){
        int n=nums.length;
        if(idx==n){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<answer.size();i++) list.add(answer.get(i));
            result.add(list);
            return;
        }
        answer.add(nums[idx]);
        helper(nums,result,answer,idx+1);
        answer.remove(answer.size()-1);
        int i=idx+1;
        while(i<n && nums[i]==nums[i-1]) i++;
        helper(nums,result,answer,i);
    }
}