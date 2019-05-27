# 原题
给定两个字符串ransomNote和magazine，编写函数判断magazine中的字符是否可以完全包含ransomNote中的字符。

注意：可以假设字符串中只包含小写字母。

注意点：

  - 无

例子：

```
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
```

# 解题思路

利用Python的collections.Counter类统计字符个数，然后做差即可。

使用Java解题时可以用数组统计字母的个数。

```java
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--cnt[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
```
