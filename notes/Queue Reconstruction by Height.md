# 原题
给出了一个数组，数组的每个元素表示一个人的身高以及在一个队伍前面不比他矮的人的个数。现在要重新排列，使得数组是满足条件的。

注意点：

  - 无

例子：

```
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
```

# 解题思路

考虑如果先把个子高的排好序，那么在任何位置插入数据都不会对已经排好序的数组造成影响。
而，与此同时，我们已经知道了个子高的排序，那么当新的数据到的时候，我们要确定它的位置也很简单，因为现在的所有数据都比他高，
所以只要根据他的第二个数字确定他的位置即可。

先对已有的数组进行排序。按照高度降序排列，如果高度一样，按照k的值升序排列。
这样比如一开始[7，0] [7，1] [7，2]就会排好，然后比如说后面有一个[6，1]， 说明只有一个大于或等于它，又因为比6大的已经全部取出。
所以把它放在位置1，这样就变成[7，0] [6，1] [7，1] [7，2].然后比如又有一个[5，0].就放在位置0，以此类推。

即对于案例。首先排序成：

```
[[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
```

然后对于第二个数字进行插入对应位置：

```
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
```
