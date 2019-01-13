# 原题

```
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
```

注意点：

  - 无

例子:

```
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
```

# 解题思路
## 哈希表法

最简单的做法，我们可以把位移一位后每个子串都存入哈希表中，如果哈希表中已经有这个子串，而且是第一次重复，则加入结果中。
如果已经遇到多次，则不加入结果中。如果哈希表没有这个子串，则把这个子串加入哈希表中。

### 代码

```java
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int index = 10; index <= s.length(); index++){
            // 从第10位开始作为结尾，位移一位，比较一次子串
            String substr = s.substring(index - 10, index);
            if(map.containsKey(substr)){
                // 如果是第一次遇到，则加入结果
                if(map.get(substr) == 1){
                    res.add(substr);
                }
                // 标记为已经遇到过一次了
                map.put(substr, 2);
            } else {
                // 如果不存在，则加入表中
                map.put(substr, 1);
            }
        }
        return res;
    }
}
```

### 复杂度
时间 O(N) 空间 O(N)

-----

## 编码法

实际上我们的哈希表可以不用存整个子串，因为我们知道子串只有10位，且每一位只可能有4种不同的字母，
那我们可以用4^10个数字来表示每种不同的序列，因为4^10=2^20<2^32所以我们可以用一个Integer来表示。
具体的编码方法是用每两位bit表示一个字符。

### 代码

```java
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int index = 10; index <= s.length(); index++){
            String substr = s.substring(index - 10, index);
            int code = encode(substr);
            if(map.containsKey(code)){
                if(map.get(code) == 1){
                    res.add(substr);
                }
                map.put(code, 2);
            } else {
                map.put(code, 1);
            }
        }
        return res;
    }
    
    private int encode(String str){
        int code = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            // 每两位表示一个字符
            code <<= 2;
            switch(c){
                case 'A': code += 0; break;
                case 'C': code += 1; break;
                case 'T': code += 2; break;
                case 'G': code += 3; break;
            }
        }
        return code;
    }
}
```

### 复杂度
时间 O(N) 空间 O(N)
