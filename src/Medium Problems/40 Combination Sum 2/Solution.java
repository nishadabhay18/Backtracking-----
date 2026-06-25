class Solution {
    // TC-> O(2^n * k) SC-> O(#combinations × k)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> answer=new ArrayList<>();
        helper(candidates, result, answer, target, 0);
        return result;
    }
    public void helper(int[] candidates, List<List<Integer>> result, List<Integer> answer, int target, int idx){
        int n=candidates.length;
        if(target==0){
            result.add(new ArrayList<>(answer));
            return;
        }
        if(idx>=n || target<0) return;
        answer.add(candidates[idx]);
        helper(candidates,result,answer,target-candidates[idx],idx+1);
        answer.remove(answer.size()-1);
        int i=idx+1;
        while(i<n && candidates[i]==candidates[idx]) i++;
        helper(candidates,result,answer,target,i);
    }
}