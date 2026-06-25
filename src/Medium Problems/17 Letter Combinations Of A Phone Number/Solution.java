class Solution {
    // TC-> O(4^n) SC-> O(n)
    static HashMap<Integer, String> mp = new HashMap<>();
    static{
        mp.put(2, "abc");
        mp.put(3, "def");
        mp.put(4, "ghi");
        mp.put(5, "jkl");
        mp.put(6, "mno");
        mp.put(7, "pqrs");
        mp.put(8, "tuv");
        mp.put(9, "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        helper(digits, result, "", 0);
        return result;
    }
    public void helper(String digits, List<String> result, String str, int idx) {
        if(idx == digits.length()){
            result.add(str);
            return;
        }
        int digit = digits.charAt(idx) - '0';
        String letters = mp.getOrDefault(digit, "");
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            helper(digits, result, str + ch, idx + 1);
        }
    }
}