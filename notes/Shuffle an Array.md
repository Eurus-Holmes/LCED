# 原题
定义两个函数，shuffle函数能把数组随机打乱，reset函数能返回初始数组。

注意点：

  - 无

例子：

```
// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
```

# 解题思路
### 库函数
直接调用python的random.shuffle就行了。
C++也有std::random_shuffle()函数。

注意都是原地打乱。

```python
import random
class Solution(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.nums = nums

    def reset(self):
        """
        Resets the array to its original configuration and return it.
        :rtype: List[int]
        """
        return self.nums

    def shuffle(self):
        """
        Returns a random shuffling of the array.
        :rtype: List[int]
        """
        nums_s = self.nums[:]
        random.shuffle(nums_s)
        return nums_s


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()
```

### Fisher–Yates 洗牌
新学习了Fisher–Yates shuffle 洗牌算法。

Fisher–Yates shuffle 的原始版本，最初描述在 1938 年的 Ronald Fisher 和 Frank Yates 写的书中，
书名为《Statistical tables for biological, agricultural and medical research》。
他们使用纸和笔去描述了这个算法，并使用了一个随机数表来提供随机数。它给出了 1 到 N 的数字的的随机排列，具体步骤如下：

```
写下从 1 到 N 的数字
取一个从 1 到剩下的数字（包括这个数字）的随机数 k
从低位开始，得到第 k个数字（这个数字还没有被取出），把它写在独立的一个列表的最后一位
重复第 2步，直到所有的数字都被取出
第 3 步写出的这个序列，现在就是原始数字的随机排列
```

已经证明如果第 2 步取出的数字是真随机的，那么最后得到的排序一定也是。

洗牌的过程可以看看这个文章，看一遍一定就懂！https://gaohaoyang.github.io/2016/10/16/shuffle-algorithm/

这个算法的一句话总结：依次遍历列表中的每一位，并将这一位与其后面的随机一位交换顺序。

```python
import random
class Solution(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.nums = nums

    def reset(self):
        """
        Resets the array to its original configuration and return it.
        :rtype: List[int]
        """
        return self.nums

    def shuffle(self):
        """
        Returns a random shuffling of the array.
        :rtype: List[int]
        """
        nums_s = self.nums[:]
        _len = len(self.nums)
        for i in xrange(_len):
            rand = random.randrange(i, _len)
            nums_s[i], nums_s[rand] = nums_s[rand], nums_s[i]
        return nums_s


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()
```
