class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0, 0, "", ans, n);
        return ans;
    }
    public void generate(int open, int close, String str, List<String> ans, int n) {
        if (open == n && close == n) {
            ans.add(str);
            return;
        }
        if(open < n) generate(open + 1, close, str + '(', ans, n);
        if(open > close) generate(open, close + 1, str + ')', ans, n);
    }
}