class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> answer=new ArrayList<>();
        HashSet<List<Integer>> set=new HashSet<>();
        helper(candidates, result, answer, target, 0, set);
        return result;
    }
    public void helper(int[] candidates, List<List<Integer>> result, List<Integer> answer, int target, int idx, HashSet<List<Integer>> set){
        if(idx==candidates.length || target<0) return;
        if(target==0){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<answer.size();i++) list.add(answer.get(i));
            if(!set.contains(list)){
                result.add(list);
                set.add(list);
            }
            return;
        }
        answer.add(candidates[idx]);
        helper(candidates,result,answer,target-candidates[idx],idx+1, set); // single inclusion
        helper(candidates,result,answer,target-candidates[idx],idx, set); // multiple inclusion
        answer.remove(answer.size()-1);
        helper(candidates,result,answer,target,idx+1, set);// single exclusion
    }
}