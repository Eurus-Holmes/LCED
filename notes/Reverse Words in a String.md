# 原题
将一个字符串依照单词的力度进行反转。例如将"the sky is blue"转化为"blue is sky the"。

注意点：

  - 原始字符串中可能首位有空格，结果不要有这些空格
  - 原始字符串单词间可能有多个空格，结果单词间只需有一个空格

例子:

输入: s = "the sky is blue"

输出: "blue is sky the"

# 解题思路
用Python解决这个问题有些特殊，Python中的字符串是不可变的数据类型，而比较pythonic的写法是直接一行代码，先把字符串按空格分开，反转后用空格连接起来。
```python
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        return " ".join(s.strip().split()[::-1])
```

从算法层面讲，这道题希望做到原地完成字符串的反转。我们可以通过以下几步做到：
  - 将整个字符串直接反转
  - 遍历字符串单独将每个单词反转，注意反转的同时可以通过移位来除去不必要的空格

用Java的解法:
一个用了java的s.split(" ")，按空格分隔。

然后调用了系统函数：Collections.reverse(list);把list顺序调换了。

最后再把结果存成数组即可。
```java
public class Solution {
    public String reverseWords(String s) {
        if(s==null||s.length()==0)
            return s;
        String [] result = s.split(" ");
        if(result==null||result.length==0)
            return "";
            
        ArrayList<String> list = new ArrayList<String>();
        
        for(int i = 0; i<result.length;i++){
            if(!result[i].isEmpty())
                list.add(result[i]);
        }
        Collections.reverse(list);
        
        String ans = new String();
        for(int i = 0; i<list.size()-1;i++){
            ans += list.get(i)+" ";
        }
        ans +=list.get(list.size()-1);
        return ans;
    }
}
```
