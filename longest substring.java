//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// 这种是按照遍历length,要求子函数求j长度以内是否重复，故ans更新为j-i;且子函数里面是i小于end-1,最后判断的是s(end-1)是否与前面的重复
// 加上else break 之后遍可以这样写

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j <= n; j++)
            {
                if (allUnique(s, i, j)) 
                    ans = Math.max(ans, j - i);
                else 
                    break;
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        int i;
        Set<Character> set=new HashSet<>();
        for(i=start;i<end-1;i++){
            Character ch=s.charAt(i);
            set.add(ch);
        }
        Character ch=s.charAt(i);
        if(set.contains(ch)) return false;
        return true;
    }
}


//other version(变体:按照数组实际的下标)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n-1; i++)
        {
            for (int j = i + 1; j <= n-1; j++)
            {
                if (allUnique(s, i, j)) 
                    ans = Math.max(ans, j - i+1);
                else 
                    break;
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        int i;
        Set<Character> set=new HashSet<>();
        for(i=start;i<end;i++){
            Character ch=s.charAt(i);
            set.add(ch);
        }
        Character ch=s.charAt(i);
        if(set.contains(ch)) return false;
        return true;
    }
}
