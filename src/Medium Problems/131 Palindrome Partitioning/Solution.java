class Solution {
    // TC-> O(2n×n^2) SC-> O(2n×n)
    public List<List<String>> partition(String str) {
        List<List<String>> result=new ArrayList<>();
        List<String> answer=new ArrayList<>();
        helper(str, result, answer);
        return result;
    }
    public void helper(String str, List<List<String>> result, List<String> answer){
        int n=str.length();
        if(n==0){
            result.add(new ArrayList<>(answer));
            return;
        }
        for(int i=0;i<n;i++){
            String part=str.substring(0,i+1);
            if(isPalindrome(part)){
                answer.add(part);
                helper(str.substring(i+1), result, answer);
                answer.remove(answer.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str){
        int n=str.length();
        int i=0, j=n-1;
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else return false;
        }
        return true;
    }
}