# 原题
二维空间中有一组气球。对于每一个气球，输入其水平直径的起止点坐标。由于是水平的，不需要考虑y坐标，
因而用x坐标表示起止点即可。起点总是小于终点。最多10^4个气球。

一支箭从x轴的不同点竖直射出。某气球的起止点坐标为xstart和xend，当xstart ≤ x ≤ xend时，
该气球会被射中。射出的弓箭数目没有限制。弓箭可以保持无限移动。计算最少需要多少弓箭可以将所有气球射中。

注意点：

  - 无

例子：

```
Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
```

# 解题思路
### 贪心算法（Greedy Algorithm）

```
按照气球的起点排序

变量emin记录当前可以一箭命中的气球终点坐标的最小值，初始化为+∞

遍历排序后的气球起始点坐标s, e

若emin < s，说明当前气球无法用一支箭射中，则令最终结果ans + 1，令emin=+∞

更新emin = min(emin, e)
```
