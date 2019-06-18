# 原题
一只青蛙过河。河流分成x个单元，每一个单元可能会有石头。青蛙可以跳到石头上，但是不能跳入水中。

给定一列石头的位置（以单元数计），顺序递增，判断青蛙是否可以跳到最后一块石头上。初始时，青蛙站在第一块石头上并且假设只能向前跳1个单元。

如果青蛙上一次跳过k个单元，那么它下一次只能跳 k - 1, k, 或者 k + 1 个单元。注意青蛙只能向前跳。

注意点：

  - 石头的个数在[2, 1100)之间。

  - 每一个石头的位置都是一个非负整数 < 2^31。

  - 第一块石头的位置永远是0。

例子：

```
Example 1:

[0,1,3,5,6,8,12,17]

There are a total of 8 stones.
The first stone at the 0th unit, second stone at the 1st unit,
third stone at the 3rd unit, and so on...
The last stone at the 17th unit.

Return true. The frog can jump to the last stone by jumping 
1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
2 units to the 4th stone, then 3 units to the 6th stone, 
4 units to the 7th stone, and 5 units to the 8th stone.

Example 2:

[0,1,2,3,4,8,9,11]

Return false. There is no way to jump to the last stone as 
the gap between the 5th and 6th stone is too large.
```

# 解题思路
### 广度优先搜索（BFS）

利用元组(x, y)表示青蛙跳跃的状态：x表示位置, y表示上一跳的单元数。

初始将(0, 0)加入队列q，利用二维数组v记录元组(x, y)是否被访问过。

循环遍历队列q，根据队头状态扩展队列，直到队列为空。
