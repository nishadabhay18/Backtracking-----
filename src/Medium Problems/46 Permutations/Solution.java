class Solution {
    // M-1 TC-> O(n! * n) SC-> O(n)
    public void helper(int[] nums, List<Integer> al, List<List<Integer>> ans, boolean[] isVisited){
        if(al.size()==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<al.size();i++){
                list.add(al.get(i));
            }
            ans.add(list);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(isVisited[i]==false){
                al.add(nums[i]);
                isVisited[i]=true;
                helper(nums,al,ans,isVisited);
                isVisited[i]=false;
                al.remove(al.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> al=new ArrayList<>();
        boolean[] isVisited=new boolean[n];
        helper(nums, al, ans, isVisited);
        return ans;
    }


    // M-2 TC-> O(n! * n) SC-> O(1)
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        helper(nums,res,0);
        return res;
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void helper(int[] nums, List<List<Integer>> res, int idx){
        int n=nums.length;
        if(idx==n-1){
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<n;i++) ans.add(nums[i]);
            res.add(ans);
            return;
        }
        for(int i=idx;i<n;i++){
            swap(nums,idx,i);
            helper(nums,res,idx+1);
            swap(nums,idx,i);
        }
    }
}