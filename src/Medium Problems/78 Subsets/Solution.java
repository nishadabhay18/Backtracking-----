class Solution {
    // TC-> O(2n×n) SC-> O(2n×n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> answer=new ArrayList<>();
        helper(nums,result,answer,0);
        return result;
    }
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> answer, int idx){
        if(idx==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<answer.size();i++) list.add(answer.get(i));
            result.add(list);
            return;
        }
        answer.add(nums[idx]);
        helper(nums,result,answer,idx+1);
        answer.remove(answer.size()-1);
        helper(nums,result,answer,idx+1);
    }
}