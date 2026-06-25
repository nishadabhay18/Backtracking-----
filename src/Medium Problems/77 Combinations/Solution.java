class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> answer=new ArrayList<>();
        backtrack(result, answer, n, k, 1);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> answer, int n, int k, int idx){
        if(answer.size()==k){
            result.add(new ArrayList<>(answer));
            return;
        }
        for(int i=idx;i<=n;i++){
            answer.add(i);
            backtrack(result, answer, n, k, i+1);
            answer.remove(answer.size()-1);
        }
    }
}