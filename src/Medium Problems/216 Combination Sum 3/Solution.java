class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        helper(k, target, 1, result, arr);
        return result;
    }
    public void helper(int k, int target, int num, List<List<Integer>> result, List<Integer> arr){
        if(target==0 && k==0){
            result.add(new ArrayList<>(arr));
            return;
        }
        for(int i=num;i<10;i++){
            if(i>target || k<=0) break;
            arr.add(i);
            helper(k-1,target-i,i+1,result,arr);
            arr.remove(arr.size()-1);
        }
    }
}