# 原题
给定一个2维板，计算其中包含多少艘不同的战舰。战舰用字符'X'表示，空白槽位用'.'表示。你应该假设如下规则：

  - 给定的板子是有效的，只包含战舰和空白槽位。
  - 战舰只能水平或者竖直放置。
  - 战舰的尺寸可能不同。
  - 两艘战舰之间在水平方向或者竖直方向至少包含一个空间—不会存在相邻的战舰。


注意点：

  - 你的算法不应该修改board的值。

例子：

```
Example:

X..X
...X
...X

In the above board there are 2 battleships.

Invalid Example:

...X
XXXX
...X

This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
```

# 解题思路
### 遍历board

由于board中的战舰之间确保有'.'隔开，因此遍历board，若某单元格为'X'，只需判断其左边和上边的相邻单元格是否也是'X'。

如果左邻居或者上邻居单元格是'X'，则说明当前单元格是左边或者上边战舰的一部分；

否则，令计数器+1
